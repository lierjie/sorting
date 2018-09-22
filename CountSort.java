/**
  * This achieves the Count Sort algorithms. BY liweijie 2018.09.25
  * ѡ�����򡢲������򡢶����򡢹鲢���򡢿�����������򷽷�������������ս���У�����Ԫ�صĴ�������������֮��ıȽϣ����ǰ���һ��������㷨��Ϊ�Ƚ�����
  * �������£��καȽ������㷨��Ҫ���� Omega��nlgn���αȽϡ���˶�����͹鲢�����ǽ������ŵıȽ������㷨�� �������򡢻��������
  * Ͱ������Ϊ�����ñȽ����򷽷�����˿��Դ������½硣
  * ����һ�����������е�һ��Ԫ��x��ֻҪ����֪������������б�xС��Ԫ�صĸ�������ô���ǾͿ���ֱ�Ӱ�x�ŵ���x+1����λ���ϡ�����Ǽ�������Ļ���˼��
  **/

import java.util.Arrays;

public class CountSort {
	public static void main(String[] args) {
		int [] a = {-1,-3,0,2,4,4,3,6,9};
		System.out.println("����ǰ���飺" + Arrays.toString(a));
		countSort(a);
		System.out.println("��������飺" + Arrays.toString(a));
	}
	
	public static void countSort(int [] arr){
		System.out.println();
		//Ѱ��������min��max
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i = 0; i <= arr.length - 1; i++){
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}
		System.out.println("Ԥ������Ϣ��" + "min��" + min + " " + "max��" + max);
		System.out.println();
		
		//ע����������max - min + 1
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
		
		//��ʼ����
		int [] copy = new int[arr.length];
		System.arraycopy(arr, 0, copy, 0, arr.length);
		
		//�Ӻ���ǰ���򣬱���Ԫ�����λ�ã���֤�㷨�ȶ��ԡ�
		for(int i = arr.length - 1; i >= 0; i--){
			arr[--countArr[copy[i] - min]] = copy[i];
		}
	}

}
