/**
  * This is a test class of In-Place Insertion Sort based on array.
  **/
  import java.io.*;
  
  public class TestOfInsertionSort {
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
		  insertionSort(m);
		  System.out.println(" ");
		  System.out.println("After InsertionSort, the Doubles are:");
		  for (int i = 0; i < len; i++) {
			  System.out.println(m[i]);
		  }
		  
	  }
	  
	  private static void insertionSort(Comparable [] a) {
		  int len = a.length;
		  int i, j;
		  Comparable temp;
		  for (i = 1; i < len; i++) {
			  temp = a[i];
			  j = i - 1;
			  while (j >= 0 && (a[j]).compareTo(temp) > 0) {
				  a[j + 1] = a[j];
				  j--;
			  }
			  a[j + 1] = temp;
		  }
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