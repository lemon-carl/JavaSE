package com.mg.rname.util;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/27 17:20
 * @Version 1.0
 * @Desc 批量删除指定目录下的目录和文件
 */
public class DeleteFileUtil {

    public static void main(String[] args) {

        String path = "F:\\rename_image\\image";
        deleteFolder(path);
    }


    public static void deleteFolder(String path) {

        File rootfile = new File(path);
        String[] type = rootfile.list();
        for (int i = 0; i < type.length; i++) {
            String oldPath = path + "\\" + type[i] + "\\主图"; //需要复制的文件
            System.out.println(oldPath);
            File oldFile = new File(oldPath);

            File[] files = oldFile.listFiles();
            if (files != null) {
                for (File f : files) {

                    if (f.isDirectory()) {
                        deleteFolder(oldPath);
                    } else {
                        f.delete();
                        System.out.println("文件删除成功");
                    }
                }

            }
            oldFile.delete();
            System.out.println("目录删除成功");
        }
    }
}
