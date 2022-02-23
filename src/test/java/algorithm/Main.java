package algorithm;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于 0.5 ,向上取整；小于 0.5 ，则向下取整。
 *
 * 数据范围：保证输入的数字在 32 位浮点数范围内
 * 输入描述：
 *
 * 输入一个正浮点数值
 * 输出描述：
 *
 * 输出该数值的近似整数值
 * 示例1
 * 输入：
 *
 * 5.5
 *
 * 输出：
 *
 * 6
 *
 * 说明：
 *
 * 0.5>=0.5，所以5.5需要向上取整为6
 *
 * 示例2
 * 输入：
 *
 * 2.499
 *
 * 输出：
 *
 * 2
 *
 * 说明：
 *
 * 0.499<0.5，2.499向下取整为2
 * @author hss
 * @create 2022-02-23 19:55
 * @Desc
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String value = sc.nextLine();
        System.out.println(Double.valueOf(Math.floor(Double.parseDouble(value) + 0.5)).intValue());
    }

    private static int cal(String value) {
        return Double.valueOf(Math.floor(Double.parseDouble(value) + 0.5)).intValue();
    }

    /*private static int cal(String[] valArr) {
        if (valArr.length == 0) {
            return 0;
        } else if (Integer.parseInt(valArr[1].split("")[0]) >= 5) {
            return Integer.parseInt(valArr[0]) + 1;
        } else {
            return Integer.parseInt(valArr[0]);
        }
    }*/
}
