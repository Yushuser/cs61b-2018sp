package edu.northeastern.yushu;

import static edu.northeastern.yushu.Shock.Foo.*;
import static edu.northeastern.yushu.Shock.Qmath.*;

public class Shock {
	   public static int bang;
	   public static Shock baby;
	   public Shock() {
           this.bang = 100;
       }
	   public Shock (int num) {
           this.bang = num;
           baby = starter();
           this.bang += num;
           }
	   public static Shock starter() {
           Shock gear = new Shock();
            return gear;
            }
	   public static void shrink(Shock statik) {
           statik.bang -= 1;
            }
	   public static void main(String[] args) {
           //1.static Shock
           Shock gear = new Shock(200);
           System.out.println(gear.bang);
           shrink(gear);
           shrink(starter());
           System.out.println(gear.bang);
           //2.Horse Scope
           Horse horse=new Horse("you've been" );
           Horse cult=new Horse("horsed");
           cult.same=cult;
           cult=cult.same(horse);
           System.out.println(horse.jimmy);
           System.out.println(cult.jimmy);
           //3.Ol Switcher 注意：a,b和x,y完全不一样
           Foo foobar=new Foo(10,20);
           Foo baz=new Foo(30,40);
           switcher(foobar,baz);//foobar.x:10 foobar.y:20 baz.x:30 baz.y: 40
           fliper(foobar,baz);//foobar.x:30 foobar.y:40 baz.x:10 baz.y: 20
           swaper(foobar,baz);//foobar.x:10 foobar.y:20 baz.x:10 baz.y: 20
           //4.Math
           int[] arr=new int[]{2,3,3,4};
           mulitplyBy3(arr);//2,3,3,4
           mulitplyBy2(arr);//4,6,6,8
           int a=6;
           int b=7;
           swap(a,b);//a=6,b=7
       }
    static class Foo {
        public int x;
        public int y;
        public Foo(int x,int y){
            this.x=x;
            this.y=y;
        }
        public static void switcher(Foo a, Foo b){
            Foo temp=a;
            a=b;
            b=temp;
        }
        public static void fliper(Foo a, Foo b){
            Foo temp=new Foo(a.x,a.y);
            a.x=b.x;
            a.y=b.y;
            b.x=temp.x;
            b.y=temp.y;
        }
        public static void swaper(Foo a, Foo b) {
            Foo temp = a;
            a.x = b.x;
            a.y = b.y;
            b.x = temp.x;
            b.y = temp.y;
        }
    }
    static class Horse{
           Horse same;
           String jimmy;
           public Horse(String lee){
               jimmy=lee;
           }
           public Horse same(Horse horse){
               if (same!=null){
                   Horse same=horse;
                   same.same=horse;
                   same=horse.same;
               }
               return same.same;
           }
       }
       static class Qmath{
           public static void mulitplyBy3(int[] A){
               for (int x: A){
                   x=x*3;
               }
           }
           public static void mulitplyBy2(int[] A){
               int[] B=A;
               for (int i=0;i<B.length;i+=1){
                   B[i]*=2;
               }
           }
           public static void swap(int A,int B){
               int t=B;
               B=A;
               A=t;
           }
       }
}
