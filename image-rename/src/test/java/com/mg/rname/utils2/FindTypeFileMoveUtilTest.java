package com.mg.rname.utils2;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Auth CarlLing
 * @Date 2019/11/27 9:54
 * @Version 1.0
 * @Desc
 */
public class FindTypeFileMoveUtilTest {


    /**
     * 测试 模拟 从产品资料清单中获取的 spu商品类型
     */
    @Test
    public void findFileTypeDirMove() throws IOException {
        String beforePath = "D:/query_img/before_image";
        String afterPath = "D:/query_img/after_image";
        List<String> typeNameList = Arrays.asList("ACP92143","ACP92144","ACP92145");
        FindTypeFileMoveUtil.findFileTypeDirMove(beforePath,afterPath,typeNameList);

    }
}