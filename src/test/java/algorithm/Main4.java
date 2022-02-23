package algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author hss
 * @create 2022-02-23 21:46
 * @Desc
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] nums = new int[sc.nextInt()];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(cal(nums, sc.nextInt()));
        }
    }

    private static String cal(int[] nums, int nextInt) {
        StringBuilder result = new StringBuilder();
        List<Integer> intNumList = Arrays.stream(nums).boxed().sorted().collect(Collectors.toList());
        for (Integer integer : intNumList) {
            result.append(integer).append(" ");
        }
        if (nextInt == 0) {
            return result.toString();
        } else {
            return result.reverse().toString();
        }
    }
}
