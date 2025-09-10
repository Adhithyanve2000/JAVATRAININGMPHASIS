# &nbsp;       package ListAssignment;

import java.util.*;
import java.util.Scanner;

// Q1) Enter 10 numbers and display
class Listss {
    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter ten numbers:");
        for (int i = 0; i < 10; i++) {
            lis.add(sc.nextInt());
        }
        System.out.println("The numbers you entered are:");
        for (int num : lis) {
            System.out.println(num);
        }
        sc.close();
    }
}

// Q2) Remove even numbers from list
class Lists1 {
    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 numbers:");
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextInt());
        }
        for (int i = lis.size() - 1; i >= 0; i--) {
            if (lis.get(i) % 2 == 0) {
                lis.remove(i);
            }
        }
        System.out.println("List after removing even numbers: " + lis);
        sc.close();
    }
}

// Q3) Find smallest and largest number
class List2 {
    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 numbers to find smallest and largest:");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextInt());
        }
        for (int num : lis) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        System.out.println("Smallest number: " + min);
        System.out.println("Largest number: " + max);
        sc.close();
    }
}

// Q4) Reverse list using Collections and manually
class List3 {
    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 numbers:");
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextInt());
        }
        System.out.println("Original list: " + lis);

        Collections.reverse(lis);
        System.out.println("Reversed list using Collections: " + lis);

        Collections.reverse(lis);
        System.out.println("Reversed again using Collections: " + lis);

        // Manual reversal
        int l = 0, r = lis.size() - 1;
        while (l < r) {
            int temp = lis.get(l);
            lis.set(l, lis.get(r));
            lis.set(r, temp);
            l++;
            r--;
        }
        System.out.println("Manually reversed list: " + lis);
        sc.close();
    }
}

// Q5) Sort list ascending and descending
class List4 {
    public static void main(String[] args) {
        List<Integer> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 numbers to sort:");
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextInt());
        }
        Collections.sort(lis);
        System.out.println("Ascending: " + lis);
        Collections.sort(lis, (a, b) -> b - a);
        System.out.println("Descending: " + lis);
        sc.close();
    }
}

// Q6) Check if a specific string is present
class List5 {
    public static void main(String[] args) {
        String str = "baba";
        List<String> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 4 words:");
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextLine());
        }
        if (lis.contains(str)) {
            System.out.println(str + " is present in the list.");
        } else {
            System.out.println(str + " is not present in the list.");
        }
        sc.close();
    }
}

// Q7) Find duplicate entries in a list
class List6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> lis = new ArrayList<>();
        System.out.println("Enter 4 strings:");
        for (int i = 0; i < 4; i++) {
            lis.add(sc.nextLine());
        }
        List<String> unique = new ArrayList<>();
        List<String> duplicates = new ArrayList<>();
        for (String str : lis) {
            if (unique.contains(str)) {
                duplicates.add(str);
            } else {
                unique.add(str);
            }
        }
        System.out.println("Duplicate entries: " + duplicates);
        sc.close();
    }
}

// Q8) Convert array to list
class List7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[4];
        List<Integer> lis = new ArrayList<>();
        System.out.println("Enter 4 numbers to convert array to list:");
        for (int i = 0; i < 4; i++) {
            arr[i] = sc.nextInt();
        }
        for (int num : arr) {
            lis.add(num);
        }
        System.out.println("Converted list: " + lis);
        sc.close();
    }
}

// Q9) Merge two lists
class List8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> lis1 = new ArrayList<>();
        List<Integer> lis2 = new ArrayList<>();
        System.out.println("Enter 4 numbers for first list:");
        for (int i = 0; i < 4; i++) lis1.add(sc.nextInt());
        System.out.println("Enter 4 numbers for second list:");
        for (int i = 0; i < 4; i++) lis2.add(sc.nextInt());

        lis1.addAll(lis2);
        System.out.println("Merged list: " + lis1);
        sc.close();
    }
}

// Q10) Employee class and sorting by name
class Employee {
    public String name;
    public int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " (" + id + ")";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> lis = new ArrayList<>();
        System.out.println("Enter 4 employees:");
        for (int j = 0; j < 4; j++) {
            System.out.print("Enter name: ");
            String str = sc.nextLine();
            System.out.print("Enter ID: ");
            int i = sc.nextInt();
            lis.add(new Employee(str, i));
            sc.nextLine();
        }

        Collections.sort(lis, (a1, b1) -> a1.name.compareTo(b1.name));
        System.out.println("Sorted employee list by name: " + lis);
        sc.close();
    }
}
