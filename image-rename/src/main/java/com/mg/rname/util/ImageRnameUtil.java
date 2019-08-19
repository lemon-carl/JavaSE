package com.mg.rname.util;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/16 15:29
 * @Version 1.0
 * @Desc 批量修改图片名称（Java批量修改多级目录下的图片名字）
 * https://blog.csdn.net/qq_33360506/article/details/64132857
 */
public class ImageRnameUtil {

    public static void main(String[] args) {
        File file = new File("F:/image"); //D:/001/
        String dirfile = file.getAbsolutePath();
        File[] files = file.listFiles();

        for (int k = 0; k < files.length; k++) {
            //D:/001/高兴/高兴1
            String fromName = files[k].getName();
            fromName = file + "\\" + fromName + "\\";
            File file1 = new File(fromName);
            String dirfile1 = file1.getAbsolutePath();

            System.out.println(dirfile1);

            if (file1.isDirectory()) {
                File[] files1 = file1.listFiles();//获取此目录下的文件列表
                //  System.out.println(files1.length+"ccc");

                for (int i = 0; i < files1.length; i++) {
                    String fromName1 = files1[i].getName();//D:/001/高兴/高兴1
                    fromName1 = file1 + "\\" + fromName1 + "\\";

                    File file2 = new File(fromName1);
                    String dirfile2 = file2.getAbsolutePath();

                    File[] files2 = file2.listFiles();//获取此目录下的文件列表
                    //  System.out.println("bbb"+files2.length);
                    for (int j = 0; j < files2.length; j++) {

                        String fromName2 = files2[j].getName();
                        int index;
                        index = fromName2.indexOf(".");
                        fromName2 = fromName2.substring(index + 1);//得到后缀名。截取_后面的String

                        if (i / 9 == 0) {
                            //System.out.println(i+"aaa");
                            if (j / 9 == 0) {
                                fromName2 = "0010" + (i + 1) + "00" + (j + 1) + "." + fromName2;
                            } else if (j / 99 == 0) {
                                fromName2 = "0010" + (i + 1) + "0" + (j + 1) + "." + fromName2;
                            } else {
                                fromName2 = "0010" + (i + 1) + (j + 1) + "." + fromName2;
                            }
                        } else {
                            if (j / 9 == 0) {
                                fromName2 = "001" + (i + 1) + "00" + (j + 1) + "." + fromName2;
                            } else if (j / 99 == 0) {
                                fromName2 = "001" + (i + 1) + "0" + (j + 1) + "." + fromName2;
                            } else {
                                fromName2 = "001" + (i + 1) + (j + 1) + "." + fromName2;
                            }
                        }
                        //fromName2="001"+j+"."+fromName2;
                        String toFileName = dirfile2 + "\\" + fromName2;
                        File tofile3 = new File(toFileName);
                        //files2[j].renameTo(tofile3);
                    }
                }

            }

        }


    }

}
