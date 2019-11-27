package com.mg.rname.utils2;

import org.junit.Test;

import static com.mg.rname.utils2.FindFileAllUtil.findFileDirName;
import static org.junit.Assert.*;

/**
 * @Auth CarlLing
 * @Date 2019/11/27 11:12
 * @Version 1.0
 * @Desc
 */
public class FindFileAllUtilTest {

    @Test
    public void queryFileNameTest() {
        String dirname = "D:/query_img";
        FindFileAllUtil.queryFileName(dirname);

    }

    @Test
    public void findFileDirNameTest() {
        String dirname = "D:/query_img";
        FindFileAllUtil.findFileDirName(dirname);
    }
}