package com.mg.rname.utils2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auth CarlLing
 * @Date 2019/11/27 10:38
 * @Version 1.0
 * @Desc
 */
public class GenerateExeclUtilTest {

    /**
     * 1.查询指定目录下图片类型文件,提取类型名 写入execl清单文档
     */
    @Test
    public void generateExeclTest() {
        //硬盘中文件目录
        String dirName = "D:/query_img/before_image";

        //硬盘中图片spu类型名导出execl
        /*   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String dateStr = now.format(formatter);*/
        //String outputUrl = "D:/check_image/spu_type_img(" + dateStr + ").xlsx";

        //目录下源文件生成的清单
        String outputUrl = "D:/check_image/spu_type_img5.xls";
        GenerateExeclUtil.generateExecl(dirName, outputUrl);
    }
}