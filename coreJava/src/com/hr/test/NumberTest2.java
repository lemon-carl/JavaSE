package com.mmall.beans;

/**
 * @Auth CarlLing
 * @Date 2019/2/11 17:51
 * @Version 1.0
 * @Desc
 */
public class NumberTest2 {

  public static void main(String[] args) {
      int n = 0;
      for (int i = 123; i < 877; i++) {
          String str = Integer.toString(i);
          char[] arr1 = str.toCharArray();
          if (str.contains("0") || arr1[0] == arr1[1] || arr1[0] == arr1[2]
                  || arr1[1] == arr1[2]) {
              continue;
          }
          for (int j = 876; j > 123; j--) {
              String str2 = Integer.toString(j);
              char[] arr2 = str2.toCharArray();
              if (str2.contains("0")
                      || str2.contains(String.valueOf(arr1[0]))
                      || str2.contains(String.valueOf(arr1[1]))
                      || str2.contains(String.valueOf(arr1[2]))
                      || arr2[0] == arr2[1] || arr2[0] == arr2[2]
                      || arr2[1] == arr2[2]) {
                  continue;
              }
              int sum = i + j;
              String sumStr = Integer.toString(sum);
              char[] arr3 = sumStr.toCharArray();
              if (sum > 987 || sumStr.contains("0")
                      || sumStr.contains(String.valueOf(arr1[0]))
                      || sumStr.contains(String.valueOf(arr1[1]))
                      || sumStr.contains(String.valueOf(arr1[2]))
                      || sumStr.contains(String.valueOf(arr2[0]))
                      || sumStr.contains(String.valueOf(arr2[1]))
                      || sumStr.contains(String.valueOf(arr2[2]))
                      || arr3[0] == arr3[1] || arr3[0] == arr3[2]
                      || arr3[1] == arr3[2]) {
                  continue;
              }
              System.out.println("符合：" + i + "+" + j + "=" + sum);
              n++;
          }
      }
    System.out.println("满足要求:" + n + "个,加法存在交换律，则实际有" +(n/ 2) + "种情形");
  }
}
