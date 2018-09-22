/**
  * This achieves the Count Sort algorithms. BY liweijie 2018.09.25
  * 选择排序、插入排序、堆排序、归并排序、快速排序等排序方法，在排序的最终结果中，各个元素的次序依赖于他们之间的比较，我们把这一类的排序算法称为比较排序。
  * 在最坏情况下，任何比较排序算法都要经过 Omega（nlgn）次比较。因此堆排序和归并排序都是渐近最优的比较排序算法。 计数排序、基数排序和
  * 桶排序因为不采用比较排序方法，因此可以打破其下界。
  * 对于一个输入数组中的一个元素x，只要我们知道了这个数组中比x小的元素的个数，那么我们就可以直接把x放到（x+1）的位置上。这就是计数排序的基本思想
  **/

import java.util.Arrays;

public class CountSort {
	public static void main(String[] args) {
		int [] a = {-1,-3,0,2,4,4,3,6,9};
		System.out.println("排序前数组：" + Arrays.toString(a));
		countSort(a);
		System.out.println("排序后数组：" + Arrays.toString(a));
	}
	
	public static void countSort(int [] arr){
		System.out.println();
		//寻找数组中min，max
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i = 0; i <= arr.length - 1; i++){
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		System.out.println("预处理信息：" + "min：" + min + " " + "max：" + max);
		System.out.println();
		
		//注意数量等于max - min + 1
		int countNumber = max - min + 1;
		int[] countArr = new int[countNumber];
		for(int i = 0; i <= arr.length - 1; i++){
			countArr[arr[i] - min]++;
		}
		System.out.println(Arrays.toString(countArr));
		for(int i = 1; i < countNumber; i++){
			countArr[i] = countArr[i] + countArr[i - 1];
		}
		System.out.println(Arrays.toString(countArr));
		System.out.println();
		
		//开始排序
		int [] copy = new int[arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);
		
		//从后往前排序，保持元素相对位置，保证算法稳定性。
		for(int i = arr.length - 1; i >= 0; i--){
			arr[--countArr[copy[i] - min]] = copy[i];
		}
	}

}
