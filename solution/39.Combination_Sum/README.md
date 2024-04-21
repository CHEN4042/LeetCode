## 代码框架
```java
void backtrack(选择列表，开始索引，目标值) {
    // 比如 target == 0
    if (满足结束条件) {
    // 临时路径：已经做出的选择
        result.add(临时路径);
        break;
    }
    // 循环
    for (int i = start; i < 选择列表.length ; i++) {
        // 比如是否完全减干净
        判断是否满足;
        // 满足判断加入临时路径
        临时路径.add(选择列表[i]);
        // 迭代
        // 开始索引看题目，如果可以重复就还是i，不然就化
        // 剩余目标也看题目
        backtrack(选择列表，开始索引，目标值 - 剩余目标);
        // list.remove(list.size()-1);
        撤销选择;
    }
}
