// ================================================
// Q.1) Union of two HashSets
// ================================================

package setmap;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Prob1 {

    public static void main(String args[]) {
        Set<String> names = new HashSet<>();
        Set<String> names1 = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 3 words for the first set:");
        for (int i = 0; i < 3; i++) {
            names.add(sc.nextLine());
        }

        System.out.println("Please enter 3 words for the second set:");
        for (int i = 0; i < 3; i++) {
            names1.add(sc.nextLine());
        }

        Set<String> union = new HashSet<>(names);
        union.addAll(names1);

        System.out.println("Union: " + union);
        sc.close();
    }
}

// ================================================
// Q.2) PriorityQueue operations
// ================================================

package setmap;
import java.util.*;

public class Prob2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(2,3,5,0,1,6,7));

        System.out.println("Please enter an element:");
        pq.add(sc.nextInt());

        System.out.println("Removing an element:");
        pq.poll();

        System.out.println("Peeking: " + pq.peek());

        System.out.println("PriorityQueue elements:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
        sc.close();
    }
}

// ================================================
// Q.3) Deque operations (addFirst, addLast, removeFirst, removeLast)
// ================================================

package setmap;
import java.util.*;

public class Prob3 {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 numbers to add at first:");
        for (int i = 0; i < 3; i++) {
            dq.addFirst(sc.nextInt());
        }

        System.out.println("Enter 3 numbers to add at last:");
        for (int i = 0; i < 3; i++) {
            dq.addLast(sc.nextInt());
        }

        System.out.println("Deque: " + dq);

        System.out.println("Removed first: " + dq.removeFirst());
        System.out.println("Deque now: " + dq);

        System.out.println("Removed last: " + dq.removeLast());
        System.out.println("Deque now: " + dq);

        sc.close();
    }
}

// ================================================
// Q.4) Count words using HashMap
// ================================================

package setmap;
import java.util.*;

public class Prob4 {
    public static void main(String args[]) {
        String str = "This is a test. test is easy";
        Map<String, Integer> map = new HashMap<>();
        String[] words = str.split("\\s");

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

// ================================================
// Q.5) Count characters in a string using HashMap
// ================================================

package setmap;
import java.util.*;

public class Prob5 {
    public static void main(String args[]) {
        String str = "banana";
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}

// ================================================
// Q.6) Store user input pairs in a HashMap
// ================================================

package setmap;
import java.util.*;

public class Prob6 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        System.out.println("Enter a name and number pair (3 times):");
        for (int i = 0; i < 3; i++) {
            String s = sc.nextLine();
            int n = sc.nextInt();
            sc.nextLine();
            map.put(s, n);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        sc.close();
    }
}

// ================================================
// Q.7) Sort HashMap by values
// ================================================

package setmap;
import java.util.*;

public class Prob7 {
    public static void main(String args[]) {
        Map<String, Integer> map = new HashMap<>();
        map.put("biju", 10);
        map.put("Rajni", 1222220);
        map.put("bsdsa", 1023);
        map.put("Nag", 10000);

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (a, b) -> Integer.compare(a.getValue(), b.getValue()));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> ent : list) {
            sortedMap.put(ent.getKey(), ent.getValue());
        }

        System.out.println("Sorted Map is:");
        System.out.println(sortedMap);
    }
}

// ================================================
// Q.8) Group strings by length using Map<Integer, List<String>>
// ================================================

package setmap;
import java.util.*;

public class Prob8 {
    public static void main(String[] args) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> list = Arrays.asList("apple", "bat", "car", "orange");

        for (String item : list) {
            map.putIfAbsent(item.length(), new ArrayList<>());
            map.get(item.length()).add(item);
        }

        System.out.println("Grouped Map is:");
        System.out.println(map);
    }
}

// ================================================
// Q.9) Swap keys and values in a HashMap
// ================================================

package setmap;
import java.util.*;

public class Prob9 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "apple");
        map.put(2, "bat");
        map.put(3, "car");
        map.put(4, "orange");

        System.out.println("Original Map:");
        System.out.println(map);

        Map<String, Integer> map1 = new HashMap<>();
        for (Map.Entry<Integer, String> e : map.entrySet()) {
            map1.put(e.getValue(), e.getKey());
        }

        System.out.println("Map with keys and values swapped:");
        System.out.println(map1);
    }
}

// ================================================
// Q.10) Count occurrences of strings entered by user
// ================================================

package setmap;
import java.util.*;

public class Prob10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        System.out.println("Enter strings (type 'stop' to finish):");
        while (true) {
            String str = sc.nextLine();
            if (str.equalsIgnoreCase("stop")) {
                break;
            }
            list.add(str);
        }

        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println("List: " + list);
        System.out.println("Map: " + map);

        sc.close();
    }
}
