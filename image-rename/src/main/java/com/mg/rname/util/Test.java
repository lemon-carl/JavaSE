package com.mg.rname.util;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/16 15:52
 * @Version 1.0
 * @Desc Java实现图片批量命名处理
 * 问题描述：命名出来的都是四位数例如0001，0002，0003后面+.txt或者.jpg之类的
 * https://blog.csdn.net/qq_37745307/article/details/89950570
 */
public class Test {

    public static void main(String[] args) {
        String path = "F:/image/ABC939456/";
        imageRename(path);
    }

    private static void imageRename(String path) {
        //fs为存储文件的字符数组
        File file = new File(path);
        //定义循环中需要的变量
        String newName = "";
        String oldName = "";
        String subNum = "";
        String parentName = "";
        File f = null;
        int index = 0;

        String fileName = file.getName();
        String[] fs = file.list();
        System.out.println("文件："+fileName);

        for (int i = 0; i < fs.length; i++) {
            oldName = fs[i];
            String filename = path + "/" + fs[i];
            File f2 = new File(filename);
            if(!f2.isDirectory()) {
                index = oldName.lastIndexOf(".");
                //获取 "." 之前两位数
                subNum = oldName.substring(index-2,index);
                System.out.println("下标：" + index+" 后缀名点之前两位数："+subNum);
                //（型号_head_1、型号_head_2、型号_head_3、型号_head_4)
               String num =  subNum.substring(0,1);
               if( Integer.parseInt(num) == 0){
                   newName = fileName+"_detail_"+subNum.substring(1);
               } else{
                   newName = fileName+"_detail_"+subNum;
               }

                System.out.println(newName);
                //截取oldName中.txt
                newName += oldName.substring(index);
                f = new File(path + "/" + oldName);
                f.renameTo(new File(path + "/" + newName));
            }else {

            }
        }
        System.out.println("运行结束");
    }
}
