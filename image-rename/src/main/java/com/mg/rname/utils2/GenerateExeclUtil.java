package com.mg.rname.utils2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auth CarlLing
 * @Date 2019/11/26 11:40
 * @Version 1.0
 * @Desc    生成 execl 清单文件
 */
@Slf4j
public class GenerateExeclUtil {

    /**
     * 步骤一 ,根据指定目录下图片,生成去重复清单execl
     * @param args
     */
    public static void main(String[] args) {
        //硬盘中文件目录
        String dirName = "D:/query_img/before_image";

        //硬盘中图片spu类型名导出execl
        /*   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String dateStr = now.format(formatter);*/
        //String outputUrl = "D:/check_image/spu_type_img(" + dateStr + ").xlsx";

        //目录下源文件生成的清单
        String outputUrl = "D:/check_image/spu_type_img.xls";
        GenerateExeclUtil.generateExecl(dirName, outputUrl);
    }


    /**
     * 1.查询指定目录下图片类型文件,提取类型名 写入execl清单文档
     *
     * @param dirName
     */
    public static void generateExecl(String dirName,String outputUrl) {

        String sheetName = "spu待定图片类型清单";
        //表头
        String[] titlesArray = {"spu商品型号"};
        try {
            //查询目录下的图片类型名
            List<String> dirList = FindFileAllUtil.findFileDirName(dirName);
            List<String> spuList = new ArrayList<>();
            //截取图片型号名下划线"_"之前的名称
            for (String imgName : dirList) {
                String subStr = imgName.substring(0, imgName.indexOf("_"));
                //log.info("spu型号: {}", subStr);
                //System.out.println("spu型号: [" + subStr + "]");

                if (spuList.contains(subStr)) {
                    continue;
                } else {
                    spuList.add(subStr);
                }
            }
            //log.info("去重后类型数量: {}", spuList.size());
            System.out.println("去重后类型数量:---> [" + spuList.size() +"]");
            for (String subStr : spuList) {
                //log.info("spu型号去重复  : {}", subStr);
                System.out.println("spu型号去重复:-> [" + subStr + "]");
            }


            //生成execl文件
            ReadWriteExecl.writeExcel(outputUrl, sheetName, titlesArray, spuList);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //log.info("提取目录下图片类型名称完成......");
        System.out.println("提取目录下图片类型名称清单完成...");
    }
}
