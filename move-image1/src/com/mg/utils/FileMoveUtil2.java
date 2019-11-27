package com.mg.utils;

import java.io.*;

/**
 * @Auth CarlLing
 * @Date 2019/8/23 15:59
 * @Version 1.0
 * @Desc copy 类型下 jpg文件到共同目录下
 */
public class FileMoveUtil2 {


    public static void main(String[] args) throws IOException {
        System.out.println("-------------------------copy file start-------------------------");
        String path = "D:\\rename_image";
        findFileTypeDirMove(path);

    }

    /**
     * copy 主图下jpg文件到类型目录下
     *
     * @param path
     * @throws IOException
     */
    public static void findFileTypeDirMove(String path) throws IOException {
        //创建流对象
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File rootfile = new File(path);

            if (rootfile.isDirectory()) {
                String[] type = rootfile.list();
                for (int i = 0; i < type.length; i++) {
                    String oldPath = path + "\\" + type[i] ; //需要复制的文件
                    System.out.println("copy前文件路径-->"+oldPath);
                    String newPath = path ; //复制后的文件
                    System.out.println("copy后文件路径-->"+newPath);
                    File oldFile = new File(oldPath);
                    File newFile = new File(newPath);

                    String srcPath = oldFile.getAbsolutePath();//获得源路径
                    //String aimPath = newFile.getAbsolutePath();//获得目标路径
                    //图片过滤器
                    FilenameFilter filter = new FilenameFilter() {

                        @Override
                        public boolean accept(File dir, String name) {
                            return (name.endsWith(".jpg") || name.endsWith(".png"));//把以.jpg和.png结尾的文件过滤出来
                        }
                    };

                    //过滤出的文件
                    System.out.println("["+ srcPath + " ] 下的图片：");
                    File[] str = oldFile.listFiles(filter);
                    for (File img : str) {
                        System.out.println(img.getName());

                        fis = new FileInputStream(oldFile + "\\" + img.getName());
                        fos = new FileOutputStream(newFile + "\\" + img.getName());

                        //byte[] bytes = new byte[fis .available()];
                        byte[] bytes = new byte[1024];
                        int temp = 0;
                        //读写数据
                        while ((temp = fis.read(bytes)) != -1) {//读数据
                            //把读到的数据写入到Temp文件中
                            fos.write(bytes);
                            fos.flush();
                        }

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        System.out.println("-------------------------copy file success！-----------------------");
    }


}
