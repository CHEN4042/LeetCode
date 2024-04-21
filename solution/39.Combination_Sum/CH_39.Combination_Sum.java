import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // 最终结果
    public List<List<Integer>> result = new ArrayList<>();
    // 路径：已经做出的选择
    public List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrack(candidates,0,target);



        return result;
    }
    // 使用回溯算法框架
    public void backtrack(int[] candidates, int start, int target) {
        // 触底，等于目标，添加答案到result
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        // 循环过程
        for (int i = start; i < candidates.length ; i++) {
            // 如果接下来的数字大于剩余的目标，说明没办法减干净
            if (candidates[i] > target){
                break;
            }
            // 临时list
            list.add(candidates[i]);
            // 迭代
            backtrack(candidates, i, target-candidates[i]);
            // 回溯，从最后一个子节点回到上一个子节点，并且遍历剩下的child
            list.remove(list.size()-1);
        }
    }

}