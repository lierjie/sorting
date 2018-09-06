/**
  * This is a test class of In-Place Selection sort based on array.
  **/
  import java.io.*;
  
  public class TestOfSelectionSort {
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
		  selectionSort(m);
		  System.out.println(" ");
		  System.out.println("After InsertionSort, the Doubles are:");
		  for (int i = 0; i < len; i++) {
			  System.out.println(m[i]);
		  }
		  
	  }
	  
	  private static void selectionSort(Comparable [] a) {
		  int len = a.length;
		  int i, j, position;
		  Comparable temp;
		  for (i = 0; i < len; i++) {
			  temp = a[i];
			  position = i;
			  for (j = i + 1; j < len; j++) {
				  if ((a[j]).compareTo(temp) < 0) {
					  temp = a[j];
					  position = j;	  
			      }	  
			  }
			  a[position] = a[i];
			  a[i] = temp;
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