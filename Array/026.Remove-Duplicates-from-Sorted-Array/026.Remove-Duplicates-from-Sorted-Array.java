package Array;
/**

解题思路：
解法： 双指针

首先注意数组是有序的，那么重复的元素一定会相邻。

要求删除重复元素，实际上就是将不重复的元素移到数组的左侧。

考虑用 2 个指针，一个在前记作 p，一个在后记作 q，算法流程如下：

        1.比较 p 和 q 位置的元素是否相等。

如果相等，q 后移 1 位
如果不相等，将 q 位置的元素复制到 p+1 位置上，p 后移一位，q 后移 1 位
重复上述过程，直到 q 等于数组长度。

返回 p + 1，即为新数组长度。

**/




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