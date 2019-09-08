package com.mg.rname.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auth CarlLing
 * @Date 2019/8/26 10:50
 * @Version 1.0
 * @Desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileTests {

    /**
     * 查询路径下目录和文件
     */
    @Test
    public void testFindFile() {
        String dirname = "F:/rename_image/image";
        FindFileAllUtil.queryFileName(dirname);
    }


    /**
     * 单个类型外图片批量命名（不包括主图下）
     */
    @Test
    public void testRenameOne() {
        String path = "F:/image/ABC12345/";
        RenameOneFileUtil.imageRename(path);
    }

    /**
     * java实现图片批量命名处理！！！！！！
     */
    @Test
    public void testBatchRname() {
        String path = "F:/rename_image/image";
        BatchRnameImageUtil.queryFileNameAndReName(path);
    }

    /**
     * 读取excel表格中特定的列
     */
    @Test
    public void testReadExecl() {
        //File file = new File("F:\\rename_image\\晨光办公必备 600 款（含重点 200 款) -OK(2).xls");
        File file = new File("F:\\rename_image\\type3.xls");
        try {
            System.out.println("正在读取型号名...");
            ReadWriteExecl.readColumn(file, 0);//读取第一列
            System.out.println("读取完毕");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入
     */
    @Test
    public void testWriteExecl() {
        //execl 文件类型
        String execlFile = "F:/rename_image/type3.xls";
        //硬盘中文件目录
        String dirname = "F:/rename_image/image";
        try {
            ArrayList<String> resultList = new ArrayList<>();
            File file = new File(execlFile);
            ArrayList<String> dirList = FindFileAllUtil.findFileDirName(dirname);

            System.out.println("正在读取型号名...");
            ArrayList<String> typeList = ReadWriteExecl.readColumn(file, 0);//读取第一列


            Set<String> set = new HashSet<String>();
            //TODO:情况一，execl清单有的类型，具体路径没有类型目录
            //获取集合2中相同的数据
            for (int k = 0; k < dirList.size(); k++) {
                for (int v = 0; v < typeList.size(); v++) {

                    if (dirList.get(k).equals(typeList.get(v))) {
                        //resultList.add(typeList.get(v)+":Y");
                        set.add(typeList.get(v));
                    } else {
                        //resultList.add(typeList.get(v)+":N");
                    }
                }
            }
            System.out.println("读取完毕");
            System.out.println("--------具体清单有的目录，路径下没有------------------------");
            //将集合2中和集合1相同的数据移除掉，剩下不相同的数据，这样得到集合和集合1不相同的数据
            for (String p : set) {
                typeList.remove(p);
            }
            for (String p : typeList) {
                System.out.println(p);
            }

            //TODO:情况二，具体路径有类型目录，execl清单没有的类型，
            //获取集合2中相同的数据
   /*         for (int k=0; k<typeList.size(); k++){
                for (int v = 0; v<dirList.size(); v++) {

                    if (typeList.get(k).equals(dirList.get(v))){
                        //resultList.add(typeList.get(v)+":Y");
                        set.add(dirList.get(v));
                    } else {
                        //resultList.add(typeList.get(v)+":N");
                    }
                }
            }
            System.out.println("读取完毕");
            System.out.println("--------具体目录有的类型，清单没有---------------------------");
            //将集合2中和集合1相同的数据移除掉，剩下不相同的数据，这样得到集合和集合1不相同的数据
            for (String p:set) {
                dirList.remove(p);
            }
            for (String p:dirList) {
                System.out.println(p);
            }*/


        /*    int num = 1;
            int sum = 0;
            for (String result : resultList) {
                System.out.println("第"+num + "行-->" + result);
                sum = num++;
            }
            System.out.println(sum);*/

            //String txtUrl = "F:\\rename_image\\type3.xls";
            //ArrayList<String> list1 = ExcelReadUtil.readBookName(txtUrl);
            //ArrayList<String> list2 = ExcelReadUtil.readFilePath(txtUrl);

            String[] titles = {"型号", "是否存在（Y\\N）"};
            //writeExcel("C:\\Users\\Administrator\\Desktop\\匹配.xls", "匹配", titles, list1, list2);
            //ReadWriteExecl.writeExcel("F:/rename_image/匹配.xls", "匹配", titles, typeList, resultList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * copy 主图下jpg文件到类型目录下
     */
    @Test
    public void testMoveFile() throws IOException {

        String path = "F:\\rename_image\\image";
        FileMoveUtil.findFileTypeDirMove(path);
    }

    /**
     * 批量删除指定目录下的目录和文件
     */
    @Test
    public void testDeleteFile(){
        String path = "F:\\rename_image\\image";
        DeleteFileUtil.deleteFolder(path);
    }
}
