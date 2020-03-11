[灯泡开关III](https://leetcode-cn.com/problems/bulb-switcher-iii/)

房间中有`n`枚灯泡，编号从`1`到`n`，自左向右排成一排。最初，所有的灯都是关着的。

在`k`时刻（`k`的取值范围是`0`到`n - 1`），我们打开`light[k]`这个灯。

灯的颜色要想`变成蓝色`就必须同时满足下面两个条件：

1.灯处于打开状态。
2.排在它之前（左侧）的所有灯也都处于打开状态。

请返回能够让`所有开着的`灯都`变成蓝色`的时刻`数目`。

示例 1：

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/03/08/sample_2_1725.png)

```
输入：light = [2,1,3,5,4]
输出：3
解释：所有开着的灯都变蓝的时刻分别是 1，2 和 4 。
```

示例 2：

```
输入：light = [3,2,4,1,5]
输出：2
解释：所有开着的灯都变蓝的时刻分别是 3 和 4（index-0）。
```

示例 3：

```
输入：light = [4,1,2,3]
输出：1
解释：所有开着的灯都变蓝的时刻是 3（index-0）。
第 4 个灯在时刻 3 变蓝。
```
示例 4：

```
输入：light = [2,1,4,3,6,5]
输出：3
```

示例 5：

```
输入：light = [1,2,3,4,5,6]
输出：6
```

提示：

1.`n == light.length`
2.`1 <= n <= 5 * 10^4`
3.`light`是`[1, 2, ..., n]`的一个排列。

[灯泡开关III-2种解法](https://leetcode-cn.com/problems/bulb-switcher-iii/solution/deng-pao-kai-guan-iii-2chong-jie-fa-by-617076674/)