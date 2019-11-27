package com.mg.rname.utils2;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Auth CarlLing
 * @Date 2019/11/27 10:23
 * @Version 1.0
 * @Desc
 */
public class CompareExeclUtilTest {

    /**
     * 2.比较两个execl清单获取 特定 图片类型的名称导出到对应 路径下
     */
    @Test
    public void readProductExeclTest() {

        //产品资料清单 execl
        String execlFile = "D:/check_image/check_img.xls";
        //根据源目录下商品类型图名称 生成execl
        String generateFile = "D:/check_image/spu_type_img2.xls";
        //源图片文件路径
        String beforePath = "D:/query_img/before_image";
        //目标图片文件路径
        String afterPath = "D:/query_img/after_image";
        CompareExeclUtil.readProductExecl(execlFile, generateFile,beforePath,afterPath);
    }
}