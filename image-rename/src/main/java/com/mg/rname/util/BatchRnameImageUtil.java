package com.mg.rname.util;

import java.io.File;

/**
 * @Auth CarlLing
 * @Date 2019/8/16 16:18
 * @Version 1.0
 * @Desc https://www.runoob.com/java/java-file.html
 */
public class BatchRnameImageUtil {

    public static void main(String args[]) {
        String path = "F:/rename_image/image";
        queryFileNameAndReName(path);
    }

    /**
     * Java实现图片批量命名处理
     * @param path
     */
    public static void queryFileNameAndReName(String path) {
        File f1 = new File(path);
        //定义循环中需要的变量
        String newName = "";
        String oldName = "";
        String subNum = "";
        File f3 = null;
        int index = 0;
        if (f1.isDirectory()) { //image
            System.out.println("---------------------------------");
            //System.out.println("目录路径 --> " + f1.getName());
            String[] s = f1.list();
            for (int i = 0; i < s.length; i++) {
                String filename = path + "/" + s[i];
                File f2 = new File(filename);

                if (f2.isDirectory()) {
                    //System.out.println("：" + s[i]);
                    System.out.println("目录路径:" + filename);
                    //递归循环处理目录同级文件和下一级的目录和文件
                    queryFileNameAndReName(filename);

                } else {
                    //System.out.println("文件：" + s[i]);
                    System.out.println("文件路径:" + filename);
                    oldName = s[i];
                    index = oldName.indexOf(".");
                    //int  lastindex = oldName.lastIndexOf(".");
                    //获取 "." 之前两位数
                    System.out.println("下标：" + index);
                    String lastStr = oldName.substring(oldName.indexOf(".")+1);
                    System.out.println("后缀名："+lastStr);
                    // System.out.println("44444:" + lastindex);
                    if (index == 0 || lastStr.equals("db") || lastStr.equals("DS_Store")) {
                        System.out.println("此文件为隐藏文件或后缀为db、DS_Store的文件，不处理");
                        continue;
                    } else {

                        String mainImage = f2.getParent().substring(f2.getParent().lastIndexOf("\\") + 1);

                        //如果名称是类型目录名，则直接赋值，如果是"主图",则获取主图的上一级的目录名
                        if (mainImage.equals("主图")) {
                            System.out.println("主图路径：" + f2.getParent());
                            String parentName = f2.getParent().substring(
                                    f2.getParent().lastIndexOf("\\", f2.getParent().lastIndexOf("\\") - 1) + 1);
                            parentName = parentName.substring(0, parentName.indexOf("\\"));
                            newName = parentName;
                            System.out.println(newName);


                            if (!oldName.contains("_")) {
                                subNum = oldName.substring(0, index);
                            } else {
                                //获取最后一个靠近 “.” 的下划线下标位置
                                int num_ = oldName.lastIndexOf("_");
                                System.out.println("下划线位置_:" + num_);
                                String number = oldName.substring(num_ + 1, index);
                                System.out.println("数字长度：" + number.length());
                                if (number.length() < 2) {
                                    subNum = number;
                                } else {
                                    subNum = oldName.substring(index - 2, index);
                                }
                            }

                            System.out.println("b: " + subNum);
                            //（型号_head_1、型号_head_2、型号_head_3、型号_head_4)
                            //截取十位数是否为0 ，为0的则截取个位数的值，再拼接新的文件名
                            String num = subNum.substring(0, 1);
                            if (Integer.parseInt(num) == 0) {
                                newName = newName + "_head_" + subNum.substring(1);
                            } else {
                                newName = newName + "_head_" + num;
                            }

                        } else {
                            System.out.println("非主图路径newName:--> " + f2.getParent());
                            newName = mainImage;

                            //截取下划线到图片后缀名"."之间的数字：例如 _01 、_1、 _11 三种情况的截取
                            int num_ = oldName.lastIndexOf("_");
                            System.out.println("下划线位置_:" + num_);
                            String number = oldName.substring(num_ + 1, index);
                            System.out.println("数字长度：" + number.length());
                            //两位数还是一位数 1、01、12、
                            if (number.length() < 2) {
                                subNum = number;
                            } else {
                                subNum = oldName.substring(index - 2, index);
                            }

                            System.out.println("a: " + subNum);
                            //截取十位数是否为0
                            String num = subNum.substring(0, 1);

                            //(型号_detail_1、型号_detail_12、)
                            if (Integer.parseInt(num) == 0) {
                                newName = newName + "_detail_" + subNum.substring(1);
                            } else {
                                newName = newName + "_detail_" + subNum;
                            }
                        }

                        f3 = new File(path + "/" + oldName);

                        newName += oldName.substring(index);
                        System.out.println("新文件名路径：" + path + "/" + newName);
                        f3.renameTo(new File(path + "/" + newName));

                    }
                }
            }

        } else {
            System.out.println(path + " is not a directory");
        }
    }

}
