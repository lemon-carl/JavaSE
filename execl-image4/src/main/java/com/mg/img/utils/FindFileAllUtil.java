package com.mg.img.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;

/**
 * @Auth CarlLing
 * @Date 2019/8/19 13:21
 * @Version 1.0
 * @Desc 列出某目录下的所有目录和图片
 */
@Slf4j
public class FindFileAllUtil {


    /**
     * 查看目录图片名下以及所有目录名存入list中
     *
     * @return
     */
    public static ArrayList<String> findFileDirName(String dirname) {
        ArrayList<String> dirList = new ArrayList<>();
        File f1 = new File(dirname);
        int num = 1;
        int sum = 0;

        if (f1.isDirectory()) {
            //log.info("文件夹路径：--> {}", dirname);
            System.out.println("文件夹路径：--> [" + dirname + "]");
            String s[] = f1.list();
            for (int i = 0; i < s.length; i++) {
                dirList.add(s[i]);
                //log.info("目录： " + s[i]);
                //System.out.println("目录： " + s[i]);
            }
        } else {
            log.info(dirname + "is not a directory");
            //System.out.println(dirname + "is not a directory");
        }

        for (String filename : dirList) {
            //log.info("目录： "+ filename);
            //System.out.println("目录: [ "+ filename + "]");
            sum = num++;
        }
        log.info("总计类型文件：{}", sum);
        //System.out.println("总计类型文件数：[" + sum + "]");
        return dirList;
    }
}
