package com.mg.rname.util;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/19 13:21
 * @Version 1.0
 * @Desc
 */
public class FindFileTest {
    public static void main(String args[]) {
        String dirname = "F:/image";
        queryFileName(dirname);
    }

    /**
     * 列出某目录下的所有目录和图片
     * @param dirname
     */
    private static void queryFileName(String dirname) {

        File f1 = new File(dirname);
        if (!f1.getName().equals("image") && !f1.getName().equals("主图") ) {
            System.out.println("------>" + f1.getName());
        }
        if (f1.isDirectory()) {
            System.out.println("*********************************");
            System.out.println("--> " + dirname);
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                String filename = dirname + "/" + s[i];
                File f = new File(filename);

                if (f.isDirectory()) {
                    System.out.println("目录："+s[i] );
                    queryFileName(filename);

                } else {
                    System.out.println("文件："+s[i] );

                }
            }
        } else {
            System.out.println(dirname + " is not a directory");
        }
    }
}
