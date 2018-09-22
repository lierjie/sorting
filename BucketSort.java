/** 
  * The achives Buket Sort algorithms. By liweijie. 2018.09.25
  * CS61B 2014spring �Ŀγ��е�Ͱ���������Щ���⡣
  * Ͱ��������������Сֵ���ϴ���������Ҫ�����ݽ�Ϊ����(����������̲����ģ���ʱʱ�����ΪO(n))��������ܵ������ݶ��ܵ�һ��Ͱ�����Ͱ����Ч�ʲ��ߡ�
  * ����˼�룺�����黮��Ϊһ����������Ͱ�������ݾ���ʱ��ÿ����Ͱ�����ݸ������ƣ���ÿ����Ͱ�������򣨿ɵݹ�ʹ��Ͱ������߱�������㷨�������ϲ���
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
    //Ͱ��
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }
    //��ÿ��Ԫ�ط���Ͱ
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
    //��ÿ��Ͱ��������
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
