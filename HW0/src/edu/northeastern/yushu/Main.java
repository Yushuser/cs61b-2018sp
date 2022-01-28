package edu.northeastern.yushu;
import java.util.Arrays;

public class Main {
    // Exercise 1: draw triangle
    public static void drawTriangle(int n){
        for (int i=1;i<=n;i++){
            for (int k=0;k<=n-i;k++){
                System.out.print(" ");
            }
            for (int j=1;j<=2*i-1;j++){
                if (j==1||j==2*i-1||i==n){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    //Exercise 2 + 3:returns the maximum value of an int array
    public static int maxNum(int[] m){
        int max=m[0];
        int index=0;
        for (int i = 0; i < m.length; i++) {
            if (max < m[i]) {
                max = m[i];
                index = i;
            }
        }
        return max;
    }
    //Exercise 4:Break and Continue
    public static void windowPosSum(int[] a, int n) {
        for (int i=0;i<a.length;i++){
            if (a[i]<=0) {
                continue;
            }
            for (int j=i+1;j<=i+n;j++){
                if (j>=a.length){
                    break;
                }
                a[i]=a[i]+a[j];
            }
        }
    }
    public static void main(String[] args) {
	    // Exercise 1: draw triangle
        drawTriangle(10);
        //Exercise 2 + 3:returns the maximum value of an int array
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(maxNum(numbers));
        //Exercise 4:Break and Continue
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        System.out.println(Arrays.toString(a));
    }
}
