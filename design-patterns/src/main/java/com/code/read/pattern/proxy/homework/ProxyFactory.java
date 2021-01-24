package com.code.read.pattern.proxy.homework;

import javassist.*;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Date : 2021/1/24 17:56
 * @author: CarlLing
 * @Version 1.0
 * @Desc :    动态代理工厂
 */
public class ProxyFactory {

    //javassist 工具类
    public static TestService createProxy() throws Exception {

        ClassPool classPool = new ClassPool(); // javassist --> ASM  --> 编辑jvm指令码
        //classloader
        classPool.appendSystemPath();
        //1.创建一个类
        CtClass ctClass = classPool.makeClass("TestServiceImpl");
        ctClass.addInterface(classPool.get(TestService.class.getName()));

        //2.创建一个方法
        CtMethod sayHello = CtNewMethod.make(CtClass.voidType, "sayHello",
                new CtClass[]{classPool.get(String.class.getName())},
                new CtClass[0], "{System.out.println(\"hello:\" + $1);}",
                ctClass);
        ctClass.addMethod(sayHello);
        //3.实例化这个对象
        Class aclass = classPool.toClass(ctClass);
        //强制转换
        return (TestService) aclass.newInstance();
    }

    public static <T> T createProxy2(Class<T> claInterface, String src) throws Exception {

        ClassPool classPool = new ClassPool(); // javassist --> ASM  --> 编辑jvm指令码
        //classloader
        classPool.appendSystemPath();
        //1.创建一个类
        CtClass ctClass = classPool.makeClass("TestServiceImpl");
        ctClass.addInterface(classPool.get(claInterface.getName()));

        //2.创建一个方法
        CtMethod sayHello = CtNewMethod.make(CtClass.voidType, "sayHello",
                new CtClass[]{classPool.get(String.class.getName())},
                new CtClass[0], src,
                ctClass);
        ctClass.addMethod(sayHello);
        //3.实例化这个对象
        Class aclass = classPool.toClass(ctClass);
        //强制转换
        return (T) aclass.newInstance();
    }

    //1.支持所有接口代理
    //2.按常规的方式传递实现
    static int count = 0;

    public static <T> T createProxy3(Class<T> cla, InvocationHandler handler) throws Exception {
        //1.创建一个类
        ClassPool classPool = new ClassPool();
        classPool.appendSystemPath();
        CtClass impl = classPool.makeClass("$proxy" + count++);
        impl.addInterface(classPool.get(cla.getName()));
        //2.添加属性 handler
        CtField field = CtField.make("public com.code.read.pattern.proxy.homework.ProxyFactory.InvocationHandler handler=null;", impl);

        impl.addField(field);
        String src = "return ($r)this.handler.invoke(\"%s\",$args);";
        String voidSrc = "this.handler.invoke(\"%s\",$args);";


        //2.创建这个接口下所有的方法实现
        for (Method method : cla.getMethods()) {
            CtClass returnType = classPool.get(method.getReturnType().getName());
            String name = method.getName();
            CtClass[] parameters = toCtClass(classPool, method.getParameterTypes());
            CtClass[] errors = toCtClass(classPool, method.getExceptionTypes());
            String srcImpl = "";
            if (method.getReturnType().equals(Void.class)) {
                srcImpl = voidSrc;
            } else {
                srcImpl = src;
            }
            CtMethod newMethod = CtNewMethod.make(returnType, name, parameters, errors, String.format(srcImpl, method.getName()), impl);

            impl.addMethod(newMethod);


        }
        //生成字节码
        //class 字节码
        byte[] bytes = impl.toBytecode();
        Files.write(Paths.get(System.getProperty("user.dir") + "/target/" + impl.getName() + ".class"), bytes);

        //类加载到当前 ClassLoader中
        Class aClass = classPool.toClass(impl);
        Object o = aClass.newInstance();
        aClass.getField("handler").set(o, handler);
        //3.实例化
        return (T) o;
    }

    private static CtClass[] toCtClass(ClassPool pool, Class[] classes) {
        return Arrays.stream(classes).map(c -> {
            try {
                return pool.get(c.getName());
            } catch (NotFoundException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList()).toArray(new CtClass[0]);
    }


    public static void main(String[] args) throws Exception {
     /*   TestService proxy = createProxy();
        proxy.sayHello("Lemon");*/

      /*  TestService proxy2 = createProxy2(TestService.class, "{System.out.println(\"hello:\" + $1);}");
        proxy2.sayHello("Lemon");*/

        TestService2 proxy3 = createProxy3(TestService2.class, new InvocationHandler() {
            @Override
            public Object invoke(String methodName, Object[] args) {
                if (methodName.equals("sayHello")) {
                    System.out.println("hello: " + args[0]);
                }
                if (methodName.equals("sayHello2")) {
                    System.out.println("hello: " + args[0] + args[1]);
                }
                return null;
            }
        });

        proxy3.sayHello2("Carl", 27);
    }

    public interface InvocationHandler {
        Object invoke(String methodName, Object args[]);
    }

    public class InvocationHandlerImpl implements InvocationHandler {
        public Object invoke(String methodName, Object[] args) {
            System.out.println("hello");
            return null;
        }
    }


    public interface TestService {
        String sayHello(String name);

        void sayHello2(String name);

        void sayHello3(String name, int i);

        void sayHelloN(String name);
    }

    public interface TestService2 {
        void sayHello(String name);

        void sayHello2(String name, int i);
    }


}
