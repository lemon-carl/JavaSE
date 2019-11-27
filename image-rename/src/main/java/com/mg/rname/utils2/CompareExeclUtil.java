package com.mg.rname.utils2;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.*;

/**
 * @Auth CarlLing
 * @Date 2019/11/26 14:01
 * @Version 1.0
 * @Desc
 */
@Slf4j
public class CompareExeclUtil {

    //步骤二,对比清单,提取需要图片
    public static void main(String[] args) {

        //产品资料清单 execl
        String execlFile = "D:/check_image/check_img.xls";
        //根据源目录下商品类型图名称 生成execl
        String generateFile = "D:/check_image/spu_type_img.xls";
        //源图片文件路径
        String beforePath = "D:/query_img/before_image";
        //目标图片文件路径
        String afterPath = "D:/query_img/after_image";
        readProductExecl(execlFile, generateFile,beforePath,afterPath);

    }

    /**
     * 2.根据产品资料库清单与生成图片清单表比较,筛选需要的商品类型图片清单
     * @param execlFile
     * @param generateFile
     */
    public static void readProductExecl(String execlFile, String generateFile, String beforePath, String afterPath) {

        try {
            File file = new File(execlFile);
            File file2 = new File(generateFile);
            log.info("正在读取型号名...");

            List<String> typeList = ReadWriteExecl.readColumn(file, 1); //读取第二列
            List<String> dirList = ReadWriteExecl.readColumn(file2, 0); //读取第一列

            Set<String> typeNameSet = new HashSet<>();

            log.info("系统产品资料清单读取完毕,数量: {}", typeList.size());
            for (int k = 0; k < typeList.size(); k++) {
                for (int v = 0; v < dirList.size(); v++) {
                    if (dirList.get(v).equals(typeList.get(k))) {
                        typeNameSet.add(dirList.get(v));
                        continue;
                    }
                }
            }

            log.info("--------根据清单图片类型名,比较源路径下清单，查路径对应类型文件----------");

            List<String> typeNameList = new ArrayList<>();
            Iterator<String> iterator = typeNameSet.iterator();
            while (iterator.hasNext()) {
                String noTypeName = iterator.next();
                log.info("[未导入系统中的类型]:----> {}", noTypeName);

                typeNameList.add(noTypeName);
            }

            //copy 移动需要的图片文件
            FindTypeFileMoveUtil.findFileTypeDirMove(beforePath, afterPath, typeNameList);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
