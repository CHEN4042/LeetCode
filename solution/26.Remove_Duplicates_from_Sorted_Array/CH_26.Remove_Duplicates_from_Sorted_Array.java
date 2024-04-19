
class Solution {
    public int removeDuplicates(int[] nums) {

        // 初始化指针，一个指向开头，一个指向下一个
        int point_head = 0;
        int point_next = 1;

        while (point_next < nums.length){
            // 如果第一个和第二个不一样，则修改，然后自增
            if(nums[point_head] != nums[point_next]){
                nums[point_head+1] = nums[point_next];
                point_head++;
            }

            point_next++;
        }

        return point_head+1;
    }
}