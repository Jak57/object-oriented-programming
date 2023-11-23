**Example 01**
```
class Parent {
    int a = 100;
    void m1() {
        System.out.println("parent m1");
    }
}
class Child extends Parent {
    int b = 50;
    void m1() {
        System.out.println("child m1");
    }
}
class Employee {
    public static void main(String args[]) {
        Parent p1 = new Parent();
        p1.m1();
        Parent p2 = new Child();
        p2.m1();
        Child p3 = new Child();
        p3.m1();
    }
}

/*
parent m1
child m1
child m1
*/
```

**Example 02**
```
class Parent {
    int a = 100;
    void m1() {
        System.out.println("parent m1");
    }
}
class Child extends Parent {
    int a = 50;
    void m1() {
        System.out.println("child m1");
    }
}
public class CSE18 {
    public static void main(String args[]) {
        Child c = new Child();
        c.a = 3500;
        Parent p1 = c;
        System.out.println(p1.a);
        Parent p2 = new Parent();
        System.out.println(p2.a);
    }
}

/*
100
100
*/
```

**Example 03**
```
class AB {
    private int a;
    private void m1() {
        System.out.println("m1 method");
    }
    void m2() {
        System.out.println("m2 method");
    }
}
class CSE18 extends AB {
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m2();
        // ob.m1(); // inaccessible
    }
}

/*
m2 method
*/
```
**Example 04**
```
class AB {
    int a = 500;
    void m2() {
        System.out.println("m1 method - AB");    
    }
}
public class CSE18 extends AB {
    protected void m2() { // visibility >= 
        System.out.println("m1 method - CSE18");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m2();
    }
}

/*
m1 method - CSE18
*/
```
