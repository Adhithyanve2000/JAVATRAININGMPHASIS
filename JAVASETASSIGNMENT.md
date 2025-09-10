## &nbsp;                                 JAVASETASSIGNMENT



// ================================================
// Q.1) Input 10 elements into a HashSet and print
// ================================================

package set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pro1 {
    public static void main(String args[]) {
        Set<String> names = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 10 elements for the set:");
        for (int i = 0; i < 10; i++) {
            names.add(sc.nextLine());
        }

        System.out.println("Set elements: " + names);
        sc.close();
    }
}

// ================================================
// Q.2) Remove duplicates while preserving order
// ================================================

package set;

import java.util.*;

public class Pro2 {
    public static void main(String args[]) {
        Set<String> names = new HashSet<>();
        List<String> lis = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 3 elements for the list:");
        for (int i = 0; i < 3; i++) {
            lis.add(sc.nextLine());
        }

        // Remove duplicates manually
        for (int i = lis.size() - 1; i >= 0; i--) {
            if (names.contains(lis.get(i))) {
                lis.remove(i);
            } else {
                names.add(lis.get(i));
            }
        }

        System.out.println("List after removing duplicates: " + lis);
        sc.close();
    }
}

// ================================================
// Q.3) Compare two sets for equality
// ================================================

package set;

import java.util.*;

public class Pro3 {
    public static void main(String args[]) {
        Set<String> names = new HashSet<>();
        Set<String> names1 = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter 3 elements for the first set:");
        for (int i = 0; i < 3; i++) {
            names.add(sc.nextLine());
        }

        System.out.println("Please enter 3 elements for the second set:");
        for (int i = 0; i < 3; i++) {
            names1.add(sc.nextLine());
        }

        if (names.equals(names1)) {
            System.out.println("The sets are equal.");
        } else {
            System.out.println("The sets are not equal.");
        }

        sc.close();
    }
}

// ================================================
// Q.4) Intersection of two sets
// ================================================

package set;

import java.util.*;

public class Pro5 {
    public static void main(String[] args) {
        Set<String> names = new HashSet<>(Arrays.asList("Adi", "Pras", "jackie"));
        Set<String> names1 = new HashSet<>(Arrays.asList("Adi", "dishku", "lady"));

        Set<String> intersection = new HashSet<>(names);
        intersection.retainAll(names1);

        System.out.println("Common elements: " + intersection);
    }
}

// ================================================
// Q.5) Union, Difference, Symmetric Difference
// ================================================

package set;

import java.util.*;

public class Pro4 {
    public static void main(String args[]) {
        Set<String> names = new HashSet<>();
        Set<String> names1 = new HashSet<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 3 elements for the first set:");
        for (int i = 0; i < 3; i++) names.add(sc.nextLine());

        System.out.println("Enter 3 elements for the second set:");
        for (int i = 0; i < 3; i++) names1.add(sc.nextLine());

        // Union
        Set<String> union = new HashSet<>(names);
        union.addAll(names1);
        System.out.println("Union: " + union);

        // Difference
        Set<String> diffA = new HashSet<>(names);
        diffA.removeAll(names1);
        System.out.println("A - B: " + diffA);

        Set<String> diffB = new HashSet<>(names1);
        diffB.removeAll(names);
        System.out.println("B - A: " + diffB);

        // Symmetric Difference
        Set<String> symDiff = new HashSet<>(names);
        symDiff.addAll(names1);
        Set<String> tmp = new HashSet<>(names);
        tmp.retainAll(names1);
        symDiff.removeAll(tmp);
        System.out.println("Symmetric Difference: " + symDiff);

        sc.close();
    }
}

// ================================================
// Q.6) Custom object in HashSet with equals() & hashCode()
// ================================================

package set;

import java.util.*;

public class Pro6 {
    public static void main(String[] args) {
        Set<Book> bSet = new HashSet<>();

        bSet.add(new Book(1, "Harry P"));
        bSet.add(new Book(2, "Interfaces"));
        bSet.add(new Book(1, "Java"));

        Book b2 = new Book(1, "Java");

        for (Book b : bSet) {
            if (b.equals(b2)) {
                System.out.println("This is equal: " + b);
            }
        }

        System.out.println("Hashcode of b2: " + b2.hashCode());

        for (Book b : bSet) {
            System.out.println(b);
        }
    }
}

class Book {
    int id;
    String title;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public boolean equals(Object b) {
        if (this == b) return true;
        if (!(b instanceof Book)) return false;
        Book book = (Book) b;
        return id == book.id && title.equals(book.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

    @Override
    public String toString() {
        return "Book{id=" + id + ", title='" + title + "'}";
    }
}

// ================================================
// Q.7) Custom containsAll function
// ================================================

package set;

import java.util.*;

public class Pro7 {
    private Set<String> set;

    public Pro7(Set<String> set) {
        this.set = set;
    }

    public boolean consAll(Set<String> s) {
        for (String str : s) {
            if (!this.set.contains(str)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("bosch", "ban"));
        Set<String> set2 = new HashSet<>(Arrays.asList("ban", "bosch"));

        Pro7 setobj = new Pro7(set1);

        System.out.println("Using built-in containsAll: " + set1.containsAll(set2));
        System.out.println("Using custom containsAll: " + setobj.consAll(set2));
    }
}

// ================================================
// Q.8) Convert Set to List and List to Set
// ================================================

package set;

import java.util.*;

public class Pro9 {
    public static void main(String args[]) {
        HashSet<String> set = new HashSet<>(Arrays.asList("Apple", "Banana", "Cherry"));
        List<String> lis = new ArrayList<>(set);
        System.out.println("List from Set: " + lis);

        List<String> list = new ArrayList<>(Arrays.asList("Dog", "Cat", "Dog"));
        HashSet<String> set1 = new HashSet<>(list);
        System.out.println("Set from List: " + set1);

        lis.clear();
        lis.addAll(set);
        System.out.println("List from Set using addAll: " + lis);

        set1.clear();
        set1.addAll(list);
        System.out.println("Set from List using addAll: " + set1);
    }
}

// ================================================
// Q.9) Remove element from Set
// ================================================

package set;

import java.util.*;

public class Pro10 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Set<String> set = new HashSet<>(Arrays.asList("asas", "deep", "leo", "arjun", "comon"));

        System.out.print("Enter element to remove: ");
        String element = sc.nextLine();

        if (set.remove(element)) {
            System.out.println(element + " removed. Updated Set: " + set);
        } else {
            System.out.println(element + " not found in Set.");
        }
        sc.close();
    }
}

// ================================================
// Q.10) Count occurrences of each element in List using Set
// ================================================

package set;

import java.util.*;

public class Pro8 {
    public static void main(String args[]) {
        List<String> lis = new ArrayList<>(Arrays.asList("sdd", "ssas", "sdd", "sddsd", "sasa", "ssas"));
        Set<String> s = new HashSet<>(lis);

        for (String ele : s) {
            int cou = 0;
            for (String word : lis) {
                if (word.equals(ele)) cou++;
            }
            System.out.println("The word '" + ele + "' appears " + cou + " times");
        }
    }
}
