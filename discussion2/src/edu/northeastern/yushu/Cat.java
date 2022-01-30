package edu.northeastern.yushu;

public class Cat {
    public String name;
    public static String noise;

    public Cat(String name, String noise) {
        this.name = name;
        this.noise = noise;
    }

    public void play() {
        System.out.println(noise + "   " + name);
    }

    public static void anger() {
        noise = noise.toUpperCase();
    }
    public static void calm(){
        noise=noise.toLowerCase();
    }
    static class Pokemon {
        public String name;
        public int level;

        public Pokemon(String name, int level) {
            this.name = name;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        //1.Pass-by-What
        Pokemon p = new Pokemon("Pikachu", 17);
        int level = 100;
        change(p, level);
        System.out.println("Name: " + p.name + ", Level: " + p.level);
        // 2.Static Methods and Variables
        Cat a=new Cat("Cream", "Miao");
        Cat b=new Cat("Tub","Meow");
        a.play();
        b.play();
        Cat.anger();;
        a.calm();
        a.play();
        b.play();
        //3.LinkedList
        StringList L = new StringList("eat", null);
        L = new StringList("shouldn't", L);
        L = new StringList("you", L);
        L = new StringList("sometimes", L);
        StringList M = L.tail;
        StringList R = new StringList("many", null);
        R = new StringList("potatoes", R);
        R.tail.tail = R;
        M.tail.tail.tail = R.tail;
        L.tail.tail = L.tail.tail.tail;
        L = M.tail;
    }
    //1.Pass-by-What
    public static void change(Pokemon poke, int level) {
        poke.level = level;
        level = 50;//是change method中的局部变量，对小精灵类或主方法中的其他同名变量没有任何影响。
        poke = new Pokemon("Gengar", 1);
    }
    static class StringList {
        String head;
        StringList tail;

        public StringList(String head, StringList tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    //4.1 Squaring a List
    //Implement square and squareMutative which are static methods that both take in an IntList L and return an IntList with its integer values all squared.
    //square does this non-mutatively with recursion by creating new IntLists while squareMutative uses a recursive approach to change the instance variables of the input IntList L.
    //实现square和squareMutative这两个静态方法，它们都接收一个IntList L并返回一个IntList，其整数值都是平方的。
    // square通过创建新的IntLists，以递归的方式完成这一工作，而squareMutative使用递归的方式来改变输入IntList L的实例变量。
    static class IntList {
        int first;
        IntList rest;
        public IntList(int first, IntList rest) {
            this.first = first;
            this.rest = rest;
        }
        public static IntList square(IntList L) {
            if (L == null) {
                return L;
            } else {
                IntList rest = square(L.rest);
                IntList M = new IntList(L.first * L.first, rest);
                return M;
            }
        }
        public static IntList squareMutative(IntList L) {
            IntList B = L;
            while (B != null) {
                B.first *= B.first;
                B = B.rest;
            }
            return L;
        }
        //4.2 implement square iteratively, and squareMutative recursively.现在，以迭代方式实现 square，以递归方式实现 squareMutative。
//        public static IntList square(IntList L) {
//            if (L == null) {
//                return L;
//            }
//            IntList B = L.rest;
//            IntList LSquared = new IntList(L.first * L.first, null);
//            IntList C = LSquared;
//            while (B != null) {
//                C.rest = new IntList(B.first * B.first, null);
//                B = B.rest;
//                C = C.rest;
//            }
//            return LSquared;
//        }
//
//        public static IntList squareMutative(IntList L) {
//            if (L == null) {
//                return L;
//            } else {
//                L.first = L.first * L.first;
//                squareMutative(L.rest);
//            }
//            return L;
//       }
    }
}
