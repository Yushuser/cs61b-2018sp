package edu.northeastern.yushu;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        int size =27;
//        String name="fido";
//        Dog my=new Dog(name, size);
//        int x=size-5;
//        if (x<25){
//            my.bark(8);
//        }
//        while (x>3){
//            x-=1;
//            my.play();
//        }
//        int[] nums={2, 4, 6, 8};
//        System.out.println("Dog : "+name);
        int[] inputArray={3, 0, 4, 6, 3};
        int k=0;
        System.out.println(Arrays.toString(mystery2(inputArray)));
        System.out.println(fib(0));
    }

    public static int mystery(int[] inputArray, int k){//如果k大于或等于数组的长度或小于0，将抛出一个ArrayIndexOutOfBoundsException，虽然这个异常不是你不运行程序就能知道的。
        //变量x记录了到目前为止找到的最小的元素，变量answer记录了这个元素的索引。变量index记录了当前在数组中的位置。while循环从索引k+1开始逐个遍历数组中的元素，如果当前元素小于x，x和答案就会被更新。额外的。这是另一个函数。它接收一个整数数组，不返回任何东西。
        int x=inputArray[k];//3
        int answer=k;//0
        int index=k+1;//1
        while (index<inputArray.length){
            if (inputArray[index]<x){//0<3
                x=inputArray[index];//x=0
                answer=index;//answer=1
            }
            index=index+1;
        }
        return answer;
    }
    public static int[] mystery2(int[] inputArray){
        int index=0;
        while (index<inputArray.length){//0<5
            int target=mystery(inputArray, index);//调用方法mystery来寻找在索引处或之后出现的数组中最小的元素的索引
            int temp=inputArray[target];
            inputArray[target]=inputArray[index];
            inputArray[index]=temp;
            index=index+1;
        }
        return inputArray;
    }
    public static int fib(int n){
        // fib(N) is the Nth Fibonacci number, for N ≥ 0. fib(N) is tree recursive.
        if (n<=1){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }
    public static int fib2(int n, int k, int f0, int f1){
        // fib2(N, K, F0, F1) is the Nth Fibonacci number, assuming that F0 and F1 are the K − 1th and Kth Fibonacci numbers,
        // 1≤K≤N. Thus, fib2(N, 1, 0, 1) is simply the Nth * Fibonacci number.
        if (n==k){
            return f0;
        } else {
            return fib2(n, k+1, f1, f0+f1);
        }
    }
}
class Dog{
    String n;
    int i;
    int bark;
    String play;
    public Dog(String name, int size) {
        name=n;
        size=i;
    }
    public void bark(int i) {
        System.out.println("bark");
    }
    public void play() {
        System.out.println("play");
    }
}
