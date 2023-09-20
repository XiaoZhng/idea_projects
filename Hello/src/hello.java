import java.util.Scanner;

public class hello {
   public static void main(String[] args){

       Scanner scanner = new Scanner(System.in);

       int[] arr = {2,45,53,6,3};
      MyTools mt = new MyTools();
      mt.Arr(arr);
      for(int i = 0; i < arr.length; i++){
          System.out.print(arr[i] + " ");
          //sout模板快捷键
          System.out.println();
          //fori模板快捷键
          for (int j = 0; j < ; j++) {
              
          }
      }
   }
}
//创建一个类MyTools，编写一个方法，可以完成对int数组冒泡排序的功能
class MyTools{
    String name;
    int age;


    public void Arr(int[] arr){
        int temp;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}