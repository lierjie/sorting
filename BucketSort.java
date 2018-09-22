/** 
  * The achives Buket Sort algorithms. By liweijie. 2018.09.25
  * CS61B 2014spring 的课程中的桶排序可能有些问题。
  * 桶排序可用于最大最小值相差较大的情况，但要求数据较为均匀(比如随机过程产生的，此时时间代价为O(n))，否则可能导致数据都跑到一个桶里，导致桶排序效率不高。
  * 基本思想：把数组划分为一定数量的子桶（当数据均匀时，每个子桶内数据个数相似），每个子桶各自排序（可递归使用桶排序或者别的排序算法），最后合并。
  * 
  **/

import java.util.*;
public class BucketSort 
{
	public static void main(String[] args)  {
		int [] a = {-2, 1, 3, 4, 0, -1, -2, 0};
		bucketSort(a);
		System.out.println(Arrays.toString(a));
	}

    public static void bucketSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
    //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
    //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
    //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
		int j = 0;
        for(ArrayList<Integer> m : bucketArr){
            for(int i : m){
                arr[j++] = i;
            }
        }
    }
}
