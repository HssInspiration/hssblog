package algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 输入一个 int 型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是 0 。
 * <p>
 * 数据范围： 1≤n≤108 1 \le n \le 10^{8} \ 1≤n≤108
 * 输入描述：
 * <p>
 * 输入一个int型整数
 * 输出描述：
 * <p>
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 * 示例1
 * 输入：
 * <p>
 * 9876673
 * <p>
 * 输出：
 * <p>
 * 37689
 *
 * @author hss
 * @create 2022-02-23 20:23
 * @Desc
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 先反转再去重
        StringBuilder sb = new StringBuilder();
        sb.append(scanner.nextLine());
        sb.reverse();
        String[] strArr = sb.toString().split("");
        System.out.println(Arrays.stream(strArr).distinct().collect(Collectors.joining("")));
    }
}
