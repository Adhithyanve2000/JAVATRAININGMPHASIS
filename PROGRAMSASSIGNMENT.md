// ================================================
// Q.1) Abstract Class Shape with Circle, Rectangle, Triangle
// ================================================

package Programsassign;

abstract class Shape {
    abstract float calculateArea();
}

class Circle extends Shape {
    private int rad;

    Circle(int rad) {
        this.rad = rad;
    }

    @Override
    public float calculateArea() {
        return 3.14f * rad * rad;
    }
}

class Rectangle extends Shape {
    private int width;
    private int length;

    Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    @Override
    public float calculateArea() {
        return width * length; // Correct formula (previously 3.14 * width * length was incorrect)
    }
}

class Triangle extends Shape {
    private int b;
    private int h;

    Triangle(int b, int h) {
        this.b = b;
        this.h = h;
    }

    @Override
    public float calculateArea() {
        return 0.5f * b * h;
    }
}

public class First {
    public static void main(String args[]) {
        Shape c = new Circle(2);
        System.out.println("Area of Circle: " + c.calculateArea());

        Shape r = new Rectangle(2, 3);
        System.out.println("Area of Rectangle: " + r.calculateArea());

        Shape t = new Triangle(2, 5);
        System.out.println("Area of Triangle: " + t.calculateArea());
    }
}

// ================================================
// Q.2) Polymorphism with Animal, Dog, Cat
// ================================================

package Programsassign;

class Animal {
    String makeSound() {
        return "some sound";
    }
}

class Dog extends Animal {
    @Override
    String makeSound() {
        return "bark";
    }
}

class Cat extends Animal {
    @Override
    String makeSound() {
        return "meow";
    }
}

public class Second {
    public static void main(String args[]) {
        Animal d = new Dog();
        Animal c = new Cat();

        System.out.println(d.makeSound());
        System.out.println(c.makeSound());
    }
}

// ================================================
// Q.3) Polymorphism with Sport classes
// ================================================

package Programsassign;

class Sport {
    String play() {
        return "Playing a sport";
    }
}

class Basketball extends Sport {
    @Override
    String play() {
        return "Playing Basketball";
    }
}

class Football extends Sport {
    @Override
    String play() {
        return "Playing Football";
    }
}

class Tennis extends Sport {
    @Override
    String play() {
        return "Playing Tennis";
    }
}

public class Third {
    public static void main(String args[]) {
        Sport s = new Sport();
        System.out.println(s.play());

        Sport b = new Basketball();
        System.out.println(b.play());

        Sport f = new Football();
        System.out.println(f.play());

        Sport t = new Tennis();
        System.out.println(t.play());
    }
}

// ================================================
// Q.4) Abstract Vehicle class with Car and Motorcycle
// ================================================

package Programsassign;

abstract class Vehicle {
    abstract String startEngine();
    abstract String stopEngine();
}

class Car extends Vehicle {
    @Override
    String startEngine() {
        return "Car engine started";
    }

    @Override
    String stopEngine() {
        return "Car engine stopped";
    }
}

class Motorcycle extends Vehicle {
    @Override
    String startEngine() {
        return "Motorcycle engine started";
    }

    @Override
    String stopEngine() {
        return "Motorcycle engine stopped";
    }
}

public class Fourth {
    public static void main(String args[]) {
        Vehicle car = new Car();
        Vehicle bike = new Motorcycle();

        System.out.println(car.startEngine());
        System.out.println(car.stopEngine());

        System.out.println(bike.startEngine());
        System.out.println(bike.stopEngine());
    }
}

// ================================================
// Q.5) BankAccount class with deposit and withdraw
// ================================================

package Programsassign;

class BankAccount {
    private int accnum;
    private float bal;

    public void setNum(int accnum) {
        this.accnum = accnum;
    }

    public int getNum() {
        return accnum;
    }

    public float getBal() {
        return bal;
    }

    public void deposit(double amount) {
        bal += amount;
    }

    public void withdraw(double amount) {
        bal -= amount;
    }

    public String display() {
        return "Account Number: " + accnum + "\nBalance: " + bal;
    }
}

public class Fifth {
    public static void main(String args[]) {
        BankAccount account = new BankAccount();

        account.setNum(234);
        account.deposit(23213);
        account.withdraw(343);

        System.out.println("Account Details:\n" + account.display());
    }
}

// ================================================
// Q.6) Counting instances of Person using static variable
// ================================================

package Programsassign;

class Person {
    public String name;
    public int age;
    public static int count;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        count++;
    }
}

public class Sixth {
    public static void main(String args[]) {
        Person p1 = new Person("pavi", 23);
        Person p2 = new Person("pasvi", 23);
        Person p3 = new Person("padvi", 27);
        Person p4 = new Person("pavai", 24);

        System.out.println("The count of Person instances created is " + Person.count);
    }
}
