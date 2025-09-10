// ================================================
// Q.1) Sort a list of words alphabetically
// ================================================
import java.util.*;
import java.util.stream.*;

class Prob1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "mango");
        List<String> sorted = words
                .stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sorted);
    }
}

// ================================================
// Q.2) Count words longer than 4 characters
// ================================================
package Stream;
import java.util.*;

class Prob2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("banana", "apple", "mango", "kiwi", "papaya");
        long count = words.stream()
                .filter(w -> w.length() > 4)
                .count();
        System.out.println("Number of words longer than 4 is " + count);
    }
}

// ================================================
// Q.3) Group employees by department
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob3 {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
            new Employee("John", "IT"),
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT")
        );

        Map<String, List<Employee>> grouped = emps
                .stream()
                .collect(Collectors.groupingBy(e -> e.dept));

        System.out.println("Employees grouped by dept are\n" + grouped);
    }
}

// ================================================
// Q.4) Calculate average salary of employees
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob4 {
    public static void main(String[] args) {
        List<Employee> emps = Arrays.asList(
            new Employee("John", 50000),
            new Employee("Alice", 60000)
        );

        Double avg = emps.stream().collect(Collectors.averagingDouble(e -> e.salary));
        System.out.println("The average salary is: " + avg);
    }
}

// ================================================
// Q.5) Join a list of strings with commas
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob5 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java","Python","C++");
        String result = list.stream().collect(Collectors.joining(","));
        System.out.println("The joined string is \n" + result);
    }
}

// ================================================
// Q.6) Find the highest paid employee
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob6 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John",70000),
            new Employee("Alice",95000)
        );

        Employee e = employees.stream()
                .max(Comparator.comparingDouble(emp -> emp.salary))
                .get();

        System.out.println("The highest paid employee is: " + e.name);
    }
}

// ================================================
// Q.7) Create a map of names and their lengths
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob7 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom","Elizabeth","Sam");
        Map<String,Integer> map = names.stream()
                .collect(Collectors.toMap(n -> n, String::length));

        System.out.println("Names and their lengths are: " + map);
    }
}

// ================================================
// Q.8) Convert all strings in a list to uppercase
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob8 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("java","python");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}

// ================================================
// Q.9) Print first 3 elements of a list
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob9 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(40,15,25,20,35,7);
        list.stream().limit(3).forEach(System.out::println);
    }
}

// ================================================
// Q.10) Multiply all elements of a list using reduce
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob10 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(40,15,25,20,35,7);
        int result = list.stream().reduce(1, (a,b) -> a*b);
        System.out.println(result);
    }
}

// ================================================
// Q.11) Count distinct words in a string (case-insensitive)
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob11 {
    public static void main(String[] args) {
        String input = "Java is great. JAVA is powerful.";
        long count = Arrays.stream(input.toLowerCase().split("\\W+"))
                .distinct()
                .count();

        System.out.println(count);
    }
}

// ================================================
// Q.13) Find the longest word in a list
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob13 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("cat","elephant","dog");
        String max = list.stream()
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.println(max);
    }
}

// ================================================
// Q.14) Count occurrences of each word in a string
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob14 {
    public static void main(String[] args) {
        String input = "apple banana apple orange banana apple";
        Map<String,Long> counts = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(counts);
    }
}

// ================================================
// Q.15) Convert names to uppercase and join with hyphens
// ================================================
package Stream;
import java.util.*;
import java.util.stream.*;

class Prob15 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("john","alice","mark");
        String result = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining("-"));

        System.out.println(result);
    }
}
