package edu.algs4;

/**
 * 希尔排序
 * 原理：使数组中的任意间隔为 h 的元素都是有序的
 *
 * 具体操作：选择一个递增的增量序列t1，t2，…，tk，tk=1；按增量序列个数k，对序列进行k 趟排序；每趟排序，
 * 根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子序列进行直接插入排序。
 * 仅增量因子为1时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 *
 * 时间复杂度， 具体取决于间隔 h，最好：O(nlogn)、最坏：O(n^2)、平均：无。希尔算法的性能与h有很大关系。
 * 只对特定的待排序记录序列，可以准确地估算关键词的比较次数和对象移动次数。
 * 想要弄清关键词比较次数和记录移动次数与h选择之间的关系，并给出完整的数学分析，至今仍然是数学难题。
 *
 * 空间复杂度， O(1)
 *
 * 稳定性，一次插入排序是稳定的，但在不同的插入排序过程中，相同的元素可能在各自的插入排序中移动，最后其稳定性就会被打乱，
 * shell排序每个不同的增量都是插入排序，有多次，实际上是分组插入排序（又叫缩小增量排序），所以是不稳定的。
 */

public class ShellSort {
}
