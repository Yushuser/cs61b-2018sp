package edu.northeastern.yushu;

public class Main {
    public static boolean isLeapYear(int year){
        if (year%400==0||year%4==0&&year%100!=0){
            return true;
        }else {
            return false;
        }
    }
    private static void checkLeap(int year){
        if (isLeapYear(year)){
            System.out.println("Leap Year : " + year);
        }else {
            System.out.println(year+"is not a Leap Year!");
        }
    }
    public static void main(String[] args) {
        //Hello Numbers
        int x=0;
        int y=0;
        while (x<10){
            System.out.println(y);
            x=x+1;
            y+=x;
        }
        //Leap Year
        //Must be provided an integer as a command line argument ARGS.必须提供一个整数作为命令行参数ARGS。
        if (args.length<1){
            System.out.println("Enter command line arguments.");
            System.out.println("e.g. java Year 2004");
        }
        for (int i=0;i<args.length;i++){
            try {
                int year=Integer.parseInt(args[i]);
                checkLeap(year);
            }catch (NumberFormatException e){
                System.out.println("Error : "+args[i]);
            }
        }
    }
}
