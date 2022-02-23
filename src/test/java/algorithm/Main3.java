package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 描述
 * 输入n个整数，输出其中最小的k个整数并按升序输出
 * <p>
 * 本题有多组输入样例
 * <p>
 * 数据范围：1≤n≤1000 1 \le n \le 1000 \ 1≤n≤1000  ，输入的整数满足 1≤val≤10000 1 \le val \le 10000 \ 1≤val≤10000
 * 输入描述：
 * <p>
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * 输出描述：
 * <p>
 * 输出一个从小到大排序的整数数组
 * 示例1
 * 输入：
 * <p>
 * 5 2
 * 1 3 5 7 2
 * <p>
 * 输出：
 * <p>
 * 1 2
 *
 * @author hss
 * @create 2022-02-23 21:21
 * @Desc
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] nums = new int[sc.nextInt()];
            int subNum = sc.nextInt();
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(cal(nums, subNum));
        }
    }

    private static String cal(int[] nums, int subNum) {
        List<Integer> arrList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList()).subList(0, subNum);
        StringBuilder result = new StringBuilder();
        for (Integer integer : arrList) {
            result.append(integer).append(" ");
        }
        return result.toString();
    }
}
