package LeetCode.Hot100.爬楼梯;

/**
 @Author NewTong
 @Date 2025/3/16 -10:55
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 2;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2] + 2;
        }
        return f[n];
    }
}
