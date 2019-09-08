package com.mg.rname.util;

import java.io.File;

/** @Auth CarlLing @Date 2019/8/27 17:20 @Version 1.0 @Desc 批量删除指定目录下的目录和文件 */
public class DeleteFileUtil2 {

  public static void main(String[] args) {

    String path = "F:\\rename_image";
    //deleteFolder(path);

    deleteNullFolder(path);
  }

  public static void deleteFolder(String path) {
    File rootfile = new File(path);
    String[] type = rootfile.list();

    for (int i = 0; i < type.length; i++) {
      String oldPath = path + "\\" + type[i]; // 需要删除目录和目录下文件
      System.out.println(oldPath);
      File oldFile = new File(oldPath);
      File[] files = oldFile.listFiles();
        if (oldFile.isDirectory()) {
        System.out.println("----" + files);
        if (oldFile != null) {

          for (int j = 0; j < files.length; j++) {
            if (!files[j].isFile()) {
              deleteFolder(oldPath);
            } else {
              files[j].delete();
              System.out.println("文件删除成功");
            }
          }
        }else {
          //  oldFile.delete();
        }
         // oldFile.delete();
      } else {
        System.out.println("这不是类型目录下的文件，不处理");
      }

    }
  }

  public static void deleteNullFolder(String dirname){
      File f1 = new File(dirname);
      if (f1.isDirectory()) {
          System.out.println("Directory of " + dirname);
          String s[] = f1.list();
          for (int i = 0; i < s.length; i++) {
              File f = new File(dirname + "/" + s[i]);
              if (f.isDirectory()) {
                  f.delete();
                  System.out.println(s[i] + " is a directory");
              } else {
                  System.out.println(s[i] + " is a file");
              }
          }
      } else {
          System.out.println(dirname + " is not a directory");
      }
  }
}
