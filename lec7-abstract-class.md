**Example 01**
```
abstract class AB {
    abstract void m1(int a, int b);
    void m2() {
        System.out.println("m2 method");
    }
    abstract void m3(float c);
}
public class CSE18 extends AB {
    void m1(int a, int b) {
        System.out.println(a+b);
    }
    void m3(float c) {
        System.out.println(c);
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m1(5, 6);
        ob.m3(6);
        ob.m2();
    }
}

/*
11
6.0
m2 method
*/
```

**Example 02**
```
abstract class AB {
    abstract void m1();
    AB() {
        System.out.println("constructor of AB");
    }
    static {
        System.out.println("static block of AB");
    }
    {
        System.out.println("instance block of AB");
    }
}
abstract class B extends AB {
    B() {
        System.out.println("constructor of B");
    }
    static {
        System.out.println("static block of B");
    }
    {
        System.out.println("instance block of B");
    }
}
public class CSE18 extends B {
    void m1() {
        System.out.println("m1 method CSE18");
    }
    CSE18() {
        System.out.println("constructor of CSE18");
    }
    static {
        System.out.println("static block CSE18");
    }
    {
        System.out.println("instance block CSE18");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m1();
    }
}

/*
static block of AB
static block of B
static block CSE18
instance block of AB
constructor of AB
instance block of B
constructor of B
instance block CSE18
constructor of CSE18
m1 method CSE18
*/
```
