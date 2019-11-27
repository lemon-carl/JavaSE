package com.mg.utils;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/27 17:20
 * @Version 1.0
 * @Desc 批量删除指定目录下的目录和文件
 */
public class DeleteFileUtil2 {

    public static void main(String[] args) {
        System.out.println("-------------------------delete dir image start-----------------------");
        String path = "F:\\rename_image";
        //1.先删除类型目录下文件
        deleteFolder(path);

    }

    /**
     * 先批量删除类型目录下文件
     *
     * @param path
     */
    public static void deleteFolder(String path) {
        File rootfile = new File(path);
        String[] type = rootfile.list();

        for (int i = 0; i < type.length; i++) {
            String oldPath = path + "\\" + type[i]; // 需要删除目录和目录下文件
            System.out.println(oldPath);
            File oldFile = new File(oldPath);
            File[] files = oldFile.listFiles();
            if (oldFile.isDirectory()) {
                if (oldFile != null) {

                    for (int j = 0; j < files.length; j++) {
                        if (!files[j].isFile()) {
                            deleteFolder(oldPath);
                        } else {
                            files[j].delete();
                        }
                    }
                }
            }

        }
        System.out.println("-------------------------delete dir image success !-----------------------");
    }


}
