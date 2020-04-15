package edu.algs4;

/**
 * 基数排序
 * 原理：将待排序数据拆分成多个关键字进行排序，基数排序的实质是多关键字排序，将待排数据里的关键字拆分成多个排序关键字，
 * 第1个排序关键字，第2个排序关键字，......,第k个排序关键字,然后根据子关键字对待排序数据进行排序（必须借助于另一种排序方法，而且这种排序方法必须是稳定的）
 *
 * 具体操作：取得数组中的最大数，并取得位数；arr为原始数组，从最低位开始取每个位组成radix数组；对radix进行排序；
 * 换句话说，第一轮下来，数组按照个位有序，第二轮下来数组按照十位有序，依次类推，由于子关键字排序稳定所以最终的数组是有序的
 *
 * 时间复杂度， 都是：O(nxk)
 *
 * 空间复杂度， O(nxk)
 *
 * 稳定性，稳定
 */

public class RadixSort {
}