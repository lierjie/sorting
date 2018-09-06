/**
  * This is a test class of In-Place Heap Sort based on array.
  * This achieves the sorting from smallest to the largest.
  * This can achieve the shorting from the largest to the smallest by changing "-1" to "1" at both "line 1" and "line 2".
  **/
  import java.io.*;
  
  public class TestOfHeapSort {
	  public static void main(String [] args) {
		  int len = 0;
		  try {
			  String input = InputHelper.getInput("please input the number of your Doubles:");
			  len = Integer.parseInt(input);
		  } catch (Exception e){
			  e.printStackTrace();
		  }
		  Double [] m = new Double[len];
		  for (int i = 0; i < len; i++) {
			  m[i] = new Double(Math.random() * 100);
		  }
		  System.out.println(" ");
		  System.out.println("Before InsertionSort, the Doubles are:");
		  for (int i = 0; i < len; i++) {
			  System.out.println(m[i]);
		  }
		  heapSort(m);
		  System.out.println(" ");
		  System.out.println("After InsertionSort, the Doubles are:");
		  for (int i = 0; i < len; i++) {
			  System.out.println(m[i]);
		  }
		  
	  }
	  
	  private static void heapSort(Comparable [] a) {
		  int len = a.length;
		  for (int i = len - 1; i >= 1; i--) {
			  buildMaxHeap(a, i);
			  swap(a, 0, i);
		  }
		  
	  }
	  
	  private static void buildMaxHeap(Comparable [] data, int lastIndex) {
		  for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			  int k = i;
			  while (2 * k + 1 <= lastIndex) {
				  int biggerIndex = 2 * k + 1;
				  if (biggerIndex < lastIndex) {
					  if ((data[biggerIndex]).compareTo(data[biggerIndex + 1]) == -1) { // line 1
						  biggerIndex++;
					  }
				  }
				  if ((data[k]).compareTo(data[biggerIndex]) == -1) {  // line 2
					  swap(data, k, biggerIndex);
					  k = biggerIndex;
				  } else {
					  break;
				  }
			  }
		  }
	  }
	  
	  
	  private static void swap(Comparable [] a, int i, int j) {
		  Comparable temp = a[i];
		  a[i] = a[j];
		  a[j] = temp;
	  }
  }
  
  
  class InputHelper {
	  public static String getInput(String mes) throws IOException{
	  System.out.println(mes);
	  BufferedReader keybd = new BufferedReader(new InputStreamReader(System.in));
	  String input = keybd.readLine();
	  return input;
	  }
  }