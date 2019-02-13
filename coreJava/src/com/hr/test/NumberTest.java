package com.mmall.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auth CarlLing
 * @Date 2019/2/11 17:37
 * @Version 1.0
 * @Desc
 */
public class NumberTest {

  public static void main(String[] args) {
    //int [] num = {1,2,3,4,5,6,7,8,9};

      int count = 0;// 可能的个数
      Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
      for (int i = 0; i < a.length; i++) {

          for (int j = 0; j < a.length; j++) {

              for (int k = 0; k < a.length; k++) {

                  if (a[i] != a[j] && a[j] != a[k] && a[k] != a[i]) {

                      int add1 = 100 * a[i] + 10 * a[j] + a[k];// 从9个数中随机找出3个数组成3位
                      Integer[] b = GetNewArray(a, i, j, k);
                      for (int x = 0; x < b.length; x++) {

                          for (int y = 0; y < b.length; y++) {

                              for (int z = 0; z < b.length; z++) {

                                  if (b[x] != b[y] && b[y] != b[z] && b[z] != b[x]) {
                                      // 从这6个数中随机找出3个数组成三位数
                                      int add2 = 100 * b[x] + 10 * b[y] + b[z];
                                      // 将剩下的3个数字组成一个数组
                                      Integer[] c = GetNewArray(b, x, y, z);
                                      // 获得最后剩下的3个数字组成的所有三位数
                                      Integer[] lastNumber = GetAllThreeNumber(c);

                                      // 如果两数之和等于第三个数就输出
                                      for (int index = 0; index < lastNumber.length; index++) {
                                          if (add1 + add2 == lastNumber[index]) {
                                              count++;
                                              System.out.println(add1 + "+" + add2 + "=" + lastNumber[index]);
                                              break;
                                          }
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
          }
      }
      System.out.println("共有" + count + "种情形-因加法存在交换律，则实际有" + count / 2 + "种情形。");
  }

    /**
     * 获取出去 i,j,k之后的数组
     * @param a
     * @param i
     * @param j
     * @param k
     * @return
     */
    static Integer[] GetNewArray(Integer[] a, int i, int j, int k) {
        List<Integer> list = new ArrayList<Integer>();
        for (int temp = 0; temp < a.length; temp++) {
            if (temp != i && temp != j && temp != k) {
                list.add(a[temp]);
            }
        }
        Integer[] b = list.toArray(new Integer[list.size()]);
        return b;
    }

    static Integer[] GetAllThreeNumber(Integer[] c) {
        List<Integer> temp = new ArrayList<Integer>();
        if (c == null || c.length != 3) {
            return temp.toArray(new Integer[temp.size()]);
        }
        temp.add(100 * c[0] + 10 * c[1] + c[2]);
        temp.add(100 * c[0] + 10 * c[2] + c[1]);
        temp.add(100 * c[1] + 10 * c[0] + c[2]);
        temp.add(100 * c[1] + 10 * c[2] + c[0]);
        temp.add(100 * c[2] + 10 * c[0] + c[1]);
        temp.add(100 * c[2] + 10 * c[1] + c[0]);
        return temp.toArray(new Integer[temp.size()]);
    }


}
