package com.mg.utils;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/27 17:20
 * @Version 1.0
 * @Desc 批量删除指定目录下的目录和文件
 */
public class DeleteNullFileUtil3 {

    public static void main(String[] args) {
        System.out.println("-------------------------delete null dir start-----------------------");
        String path = "F:\\rename_image";
        // 2.再删除类型目录
        deleteNullFolder(path);
    }


    /**
     * 批量删除空文件的类型目录
     *
     * @param dirname
     */
    public static void deleteNullFolder(String dirname) {
        File f1 = new File(dirname);
        if (f1.isDirectory()) {
            System.out.println("Directory of { " + dirname +" }");
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                File f = new File(dirname + "/" + s[i]);
                if (f.isDirectory()) {
                    f.delete();
                    System.out.println("【 "+s[i] + "】 is a directory");
                } else {
                    System.out.println("【 "+s[i] + "】 is a file");
                }
            }
        } else {
            System.out.println("["+dirname + "] is not a directory");
        }

        System.out.println("-------------------------delete null dir success !-----------------------");

    }
}
