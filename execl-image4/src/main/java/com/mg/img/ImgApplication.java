package com.mg.img;

import com.mg.img.utils.GenerateExeclUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ImgApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImgApplication.class, args);

        //System.out.println("---------------开始生成图片类型名称清单-----------------------");
        log.info("---------------开始生成图片类型名称清单-----------------------");
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

}
