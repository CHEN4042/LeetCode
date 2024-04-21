import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test_run {


    static class Solution {
        // 最终结果
        public static List<List<Integer>> result = new ArrayList<>();
        // 路径：已经做出的选择
        public static List<Integer> list = new ArrayList<>();

        public static List<List<Integer>> combinationSum3(int k, int n) {


            backtrack(k,1,n);



            return result;
        }
        // 使用回溯算法框架
        public static void backtrack(int times, int start, int target) {
            if(times == 0) {
                if (target == 0) {
                    result.add(new ArrayList<Integer>(list));
                    return;
                }
                return;
            }

            for (int i = start; i <= 9 ; i++) {
                if (i > target){
                    break;
                }
                list.add(i);
                backtrack(times -1, i+1, target-i);
                list.remove(list.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Solution.combinationSum3(3,7));
    }


}
