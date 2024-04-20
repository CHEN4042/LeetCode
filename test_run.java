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
        public static List<List<Integer>> combinationSum(int[] candidates, int target) {

            Arrays.sort(candidates);
            backtrack(candidates,0,target);



            return result;
        }
        // 使用回溯算法框架
        public static void backtrack(int[] candidates, int start, int target) {

            if (target == 0) {
                result.add(new ArrayList<Integer>(list));
                return;
            }
            for (int i = start; i < candidates.length ; i++) {
                if (candidates[i] > target){
                    break;
                }
                list.add(candidates[i]);
                backtrack(candidates, i, target-candidates[i]);
                list.remove(list.size()-1);
            }
        }

    }

    public static void main(String[] args) {
        Solution.combinationSum(new int[]{2, 3, 6, 7},7);
    }


}
