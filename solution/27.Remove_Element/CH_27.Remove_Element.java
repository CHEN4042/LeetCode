class Solution {
    public int removeElement(int[] nums, int val) {


        // 初始化指针，一个代表检索，一个代表最终位置
        int scan = 0;
        int result = 0;

        while (scan < nums.length){
            // 如果不一样，那就把scan放到result位置
            if(nums[scan] != val){
                nums[result] = nums[scan];
                result++;

            }
            scan++;

        }

        return result;
    }
}