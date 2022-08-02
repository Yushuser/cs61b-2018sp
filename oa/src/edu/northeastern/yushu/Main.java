package edu.northeastern.yushu;

import java.util.*;

public class Main {
    // user system
    public static List<String> implementAPI(List<String> logs) {
        HashMap<String, String> register = new HashMap<>();
        HashMap<String, String> login = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String log : logs) {
            String[] split = log.split(" ");
            if (split[0].equals("register")) {
                // Do register
                // 1.Username already exists
                if (register.containsKey(split[1])) {
                    res.add("Username already exists");
                }
                // 2.Username not exists
                else {
                    register.put(split[1], split[2]);
                    res.add("Registered successfully");
                }
            } else if (split[0].equals("login")) {
                // Do login
                // 1. registered users
                if (register.containsKey(split[1])) {
                    // 1.1 already logged in
                    if (login.containsKey(split[1])) {
                        res.add("Login Unsuccessfully");
                    }
                    // 1.2 logging in
                    else {
                        // correct password
                        if (register.get(split[1]).equals(split[2])) {
                            login.put(split[1], split[2]);
                            res.add("Logged in Successfully");
                        }// incorrect password
                        else {
                            res.add("Login Unsuccessfully");
                        }
                    }
                }// 2 not registered
                else {
                    res.add("Login Unsuccessfully");
                }
            } else if (split[0].equals("logout")) {
                // Do log out
                if (register.containsKey(split[1])) {
                    if (login.containsKey(split[1])) {
                        login.remove(split[1]);
                        res.add("Logged Out Successfully");
                    } else {
                        res.add("Logged out unsuccessfully");
                    }
                } else {
                    res.add("Logout Unsuccessfully");
                }
            }
        }
        return res;
    }
    public static int countMaxOperations (String s, String t) {
        // to find out how many t can be formed from letters in s
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();
        // occurrences for each character in s and t
        for (char ch : s.toCharArray()) {
            mapS.put(ch, mapS.getOrDefault(ch,0) + 1);
        }
        for (char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        // traverse each character in t
        for (char ch : t.toCharArray()) {
            int count = mapS.getOrDefault(ch, 0) / mapT.get(ch);
            res = Math.min(count, res);
        }
        return res;
    }
    public static int maxGreyNess(String[] grid) {
        int[] prefRow = new int[grid.length];
        int[] prefCol = new int[grid[0].length()];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == '1') {
                    prefRow[i] += 1;
                    prefCol[j] += 1;
                } else {
                    prefRow[i] -= 1;
                    prefCol[j] -= 1;
                }
            }
        }
        int maxRow = Integer.MIN_VALUE;
        int maxCol = Integer.MIN_VALUE;
        for (int r : prefRow) {
            maxRow = Math.max(maxRow, r);
        }
        for (int c : prefCol) {
            maxCol = Math.max(maxCol, c);
        }
        return maxRow + maxCol;
    }
    public static long shipmentImbalance(int[] weights) {
        int n = weights.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int min = weights[i], max = weights[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min, weights[j]);
                max = Math.max(max, weights[j]);
                res += max - min;
            }
        }
        return res;
    }
    public static long findMinHealth (List<Integer> power, int armor) {
        // find maximum value in power where we can apply armor
        int max = power.get(0);
        for (int i = 1; i < power.size(); i++) {
            max = Math.max(max, power.get(i));
        }
        long sum = 0;
        for (int i = 0; i < power.size(); i++) {
            sum += power.get(i);
        }
        return sum + 1 - Math.min(max, armor);
    }
    public static long getMinCost(int[] parcels, int k) {
        int count = k - parcels.length;
        Set<Integer> set = new TreeSet<>();
        for (int parcel : parcels) {
            set.add(parcel);
        }
        set.add(0);
        set.add(Integer.MAX_VALUE);
        long res = 0;
        int starNum = 0;
        for (int num : set) {
            int diff = num - starNum;
            if (diff > 1 && count > 0) {
                long range = Math.min(diff - 1, count);
                res += (starNum + 1 + starNum + range) * range / 2;
                count -= range;
            }
            starNum = num;
        }
        return  res;
    }
    public  static int minGroups(int[] awards, int k) {
        Arrays.sort(awards);
        int count = 1;
        int curMin = awards[0];
        for (int i = 1; i < awards.length; i++) {
            if (Math.abs(awards[i] - curMin) <= k) {
                continue;
            } else {
                count++;
                curMin = awards[i];
            }
        }
        return count;
    }
    public static int riverControl(String[] cmds, int n) {
        // move in a n * n matrix
        int row = 0, col = 0;
        for (String cmd : cmds) {
            if (cmd.equals("UP") && row > 0) {
                row --;
            }
            if (cmd.equals("DOWN") && row < n - 1) {
                row++;
            }
            if (cmd.equals("LEFT") && col > 0) {
                col--;
            }
            if (cmd.equals("Right") && col < n - 1) {
                col++;
            }
        }
        return row * n + col;
    }
    public static long getMax(int[] changes) {
        int n = changes.length;
        long[] prefix = new long[n];
        prefix[0] = (long) changes[0];
        // prefix[i] : sum of changes[0...i]
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + (long)changes[i];
        }
        long maxAggre = Math.max(prefix[0], prefix[n - 1]);
        for (int i = 1; i < n; i++) {
            long temp = Math.max(prefix[i], prefix[n - 1] - prefix[i - 1]);
            maxAggre = Math.max(maxAggre, temp);
        }
        return maxAggre;
    }
    // earliest month
    public static int findEarliestMonth(int[] stockP) {
        int n = stockP.length;
        long[] prefix = new long[n];
        prefix[0] = stockP[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stockP[i];
        }
        long mindiff = Integer.MAX_VALUE;
        int monthIdx = 0;
        for (int i = 0; i < n - 1; i++) {
            long leftAvg = prefix[i] / (long)(i + 1);
            long rightAvg = (prefix[n - 1] - prefix[i]) / (long) (n - 1 - i);
            long diff = Math.abs(leftAvg - rightAvg);
            if (diff < mindiff) {
                mindiff = diff;
                monthIdx = i;
            }
        }
        return monthIdx + 1;
    }
    public static void main(String[] args) {
        // 9 keypad
        MinKeypadClickCount obj = new MinKeypadClickCount();
        System.out.println(obj.minimumKeypresses("zoo"));
        // search world
        SearchWorld sw = new SearchWorld();
        int res = sw.searchWord("abcdefg", "amazon");
        System.out.println(res);
        // move locations
        MoveLocations ml = new MoveLocations();
        int[] arr = ml.findDataLocations(new int[]{1, 7, 6, 8}, new int[]{1, 7, 2}, new int[]{2, 9, 5});
        for (int loc : arr) {
            System.out.println(loc);
        }
        // user system
        List<String> logs = new ArrayList<>();
        logs.add("register david david123");
        logs.add("register adam 1Adam1");
        logs.add("login david david123");
        logs.add("login adam 1adm1");
        logs.add("logout david");
        List<String> st = implementAPI(logs);
        for (String out : st) {
            System.out.println(out);
        }
        // Max count operations
        int count = countMaxOperations("abacbc", "bca");
        System.out.println(count);
        // Max Greyness
        int grey = maxGreyNess(new String[]{"1101", "0101", "1010"});
        System.out.println(grey);
        // shipment
        long ship = shipmentImbalance(new int[]{1, 2, 3});
        System.out.println(ship);
        // fins min health
        List<Integer> power = new ArrayList<>();
        power.add(1);
        power.add(2);
        power.add(6);
        power.add(7);
        long mh = findMinHealth(power, 5);
        System.out.println(mh);
        // min cost
        long cost = getMinCost(new int[]{2, 3, 6, 10, 11}, 9);
        System.out.println(cost);
        // movies award
        int movie = minGroups(new int[]{1, 5, 4, 6, 8, 9, 2}, 3);
        System.out.println(movie);
        // river control
        System.out.println(riverControl(new String[]{"RIGHT", "DOWN", "LEFT", "LEFT", "DOWN"}, 4));
        // max aggregate temperature
        long temp1 = getMax(new int[]{6, -2, 5});
        System.out.println(temp1);
        long temp2 = getMax(new int[]{-1, 2, 3});
        System.out.println(temp2);
        // earliest month
        int em = findEarliestMonth(new int[]{1, 3, 2, 3});
        System.out.println(em);
    }
}
// 9 keypad
class MinKeypadClickCount {
    public int minimumKeypresses(String s) {
        // to get occurrences of each letter in s
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        // result
        int result = 0;
        // Max Heap
        PriorityQueue<Character> queue = new PriorityQueue<>((Character a, Character b) -> freq.get(b) - freq.get(a));
        for (char ch : freq.keySet()) {
            queue.add(ch);
        }
        // queue popping
        // count : number of unique letters
        int count = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            result += (count / 9 + 1) * freq.get(ch);
            count++;
        }
        return result;
    }

    // max stock price
    public long maxSumOfStock(int[] stockPrice, int k) {
        long res = 0;
        HashSet<Integer> numInWindow = new HashSet<>();
        int left = 0, right = 0;
        // sliding window
        // search interval[left, right]
        while (right < stockPrice.length) {
            // stockPrice[right] is already in the window
            // remove stockPrice[left] from numInWindow
            while (numInWindow.contains((stockPrice[right]))) {
                numInWindow.remove(stockPrice[left]);
                left++;
            }
            numInWindow.add(stockPrice[right]);
            right++;
            while (right - left == k) {
                int curSum = 0;
                for (int i = left; i < right; i++) {
                    curSum += stockPrice[i];
                }
                res = Math.max(res, curSum);
                left++;
            }
        }
        if (res == 0) {
            return -1;
        }
        return res;
    }
}
    // search world
    class SearchWorld {
        public int searchWord(String searchWord, String resultWord) {
            int p1 = 0, p2 = 0;
            while (p1 < searchWord.length() && p2 < resultWord.length()) {
                if (searchWord.charAt(p1) == resultWord.charAt(p2)) {
                    p1++;
                    p2++;
                } else {
                    p1++;
                }
            }
            // when resultWord is actually subsequence of searchWord,
            // resultWord.length() - p2 = 0 which means no more letters need to be added
            return resultWord.length() - p2;
        }
    }
    class MoveLocations {
    public int[] findDataLocations(int[] locations, int[] movedFrom, int[] movedTo) {
        Set<Integer> resSet = new HashSet<>();
        for (int l : locations) {
            resSet.add(l);
        }
        // moveFrom and moveTo operation
        for (int i = 0; i < movedFrom.length; i++) {
            resSet.remove(movedFrom[i]);
            resSet.add(movedTo[i]);
        }
        // final result
        int[] newLoc = new int[resSet.size()];
        int i = 0;
        for (int loc : resSet) {
            newLoc[i] = loc;
            i++;
        }
        Arrays.sort(newLoc);
        return newLoc;
    }
}


