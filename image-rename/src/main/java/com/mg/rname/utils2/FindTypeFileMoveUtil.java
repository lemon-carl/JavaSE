package com.mg.rname.utils2;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.*;

/**
 * @Auth CarlLing
 * @Date 2019/8/23 15:59
 * @Version 1.0
 * @Desc copy 类型下 jpg文件到共同目录下
 */
@Slf4j
public class FindTypeFileMoveUtil {


  /*  public static void main(String[] args) throws IOException {
        String beforePath = "D:/query_img/before_image";
        String afterPath = "D:/query_img/after_image";
        List<String> typeNameList = Arrays.asList("ACP92143","ACP92144","ACP92145");
        FindTypeFileMoveUtil.findFileTypeDirMove(beforePath,afterPath,typeNameList);
    }*/


    /**
     * 3. 根据筛选的图片类型选出需要的图片移动
     *  copy 主图下jpg文件到类型目录下
     * @param beforePath
     * @param afterPath
     * @throws IOException
     */
    public static void findFileTypeDirMove(String beforePath, String afterPath, List<String> typeNameList) throws IOException {
        //创建流对象
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File rootfile = new File(beforePath);

            if (rootfile.isDirectory()) {
                String[] type = rootfile.list();
                for (int i = 0; i < type.length; i++) {
                    for (int k = 0; k < typeNameList.size(); k++) {
                        if (type[i].substring(0, type[i].indexOf("_")).equals(typeNameList.get(k))) {

                            log.info("source: {}",type[i]);
                            //System.out.println("source file: [" + type[i] + "]");

                            //需要复制的文件
                            String oldPath = beforePath + "/" + type[i];
                            //log.info("源文件:-->" + oldPath);
                            //System.out.println("源文件-->" + oldPath);

                            //复制后的文件
                            //String newPath = beforePath ;
                            String newPath = afterPath + "/" + type[i];

                            File oldFile = new File(oldPath);
                            File newFile = new File(newPath);

                            fis = new FileInputStream(oldFile);
                            fos = new FileOutputStream(newFile);

                            byte[] bytes = new byte[1024];
                            //读写数据
                            while (fis.read(bytes) != -1) {
                                //把读到的数据写入到Temp文件中
                                fos.write(bytes);
                                fos.flush();
                            }

                            log.info("----------------------------------");

                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (fis != null) {
                fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
        System.out.println("文件已复制成功！");
    }


}
