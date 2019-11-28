package com.mg.img;

import com.mg.img.utils.CompareExeclUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ImgCompareApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImgCompareApplication.class, args);

        //产品资料清单 execl
        String execlFile = "D:/check_image/check_img.xls";
        //根据源目录下商品类型图名称 生成execl
        String generateFile = "D:/check_image/spu_type_img.xls";
        //源图片文件路径
        String beforePath = "D:/query_img/before_image";
        //目标图片文件路径
        String afterPath = "D:/query_img/after_image";
        CompareExeclUtil.readProductExecl(execlFile, generateFile,beforePath,afterPath);
    }

}
