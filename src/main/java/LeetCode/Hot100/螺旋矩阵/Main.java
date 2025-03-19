package LeetCode.Hot100.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

/**
 @Author NewTong
 @Date 2025/3/19 -15:02
 @Description
 */
public class Main {
    public static void main(String[] args) {

    }


    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int l = 0,r = matrix[0].length-1,t = 0,d = matrix.length-1;
        while(true){
            for(int i = l;i <= r;i ++) ans.add(matrix[t][i]);
            t++;
            if(t > d) break;

            for(int i = t;i <= d;i ++) ans.add(matrix[i][r]);
            r--;
            if(l > r) break;

            for(int i = r;i >= l;i --) ans.add(matrix[d][i]);
            d--;
            if(t > d) break;

            for(int i = d;i >= t;i --) ans.add(matrix[i][l]);
            l++;
            if(l > r) break;
        }

        return ans;
    }

}
