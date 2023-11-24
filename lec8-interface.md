**Example 01**
```

interface I1 {
    int EXIT = -1;
    void m1();
    void m2();
}
public class CSE18 implements I1{
    public void m1() {
        System.out.println("m1 method - CSE18");
    }
    public void m2() {
        System.out.println("m2 method - CSE18");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m1();
        ob.m2();
        I1 ob1 = ob;
        ob1.m1();
        ob1.m2();

    }
}

/*
m1 method - CSE18
m2 method - CSE18
m1 method - CSE18
m2 method - CSE18
*/
```

**Example 02 - Interface vs Inheritance**
```

interface I1 {
    void m1();
}
interface I2 extends I1 {
    void m2();
}
interface I3 {
    void m3();
}
interface I4 extends I2, I3 {
    void m4();
}
public class CSE18 implements I1, I3{
    public void m1() {
        System.out.println("m1 method");
    }
    public void m3() {
        System.out.println("m3 method");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m3();
        I1 ob1 = ob;
        ob1.m1();
    }
}

/*
m3 method
m1 method
*/
```

**Example 03: Interface variables**
```

interface I1 {
    int B = 10;
    void m1();
}
interface I2 {
    int B = 40;
    void m2();
}
public class CSE18 implements I1, I2{
    public void m1() {
        System.out.println("m1 method");
    }
    public void m2() {
        System.out.println("m2 method");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m1();
        ob.m2();
        System.out.println(I1.B + " " + I2.B);
    }
}

/*
m1 method
m2 method
10 40
*/
```
**Example 04: Adapter class**
```

interface I1 {
    void m1();
    void m2();
    void m3();
    void m4();
}
class X implements I1 {
    public void m1(){}
    public void m2(){}
    public void m3(){}
    public void m4(){}
}
public class CSE18 extends X{
    public void m1() {
        System.out.println("m1 method");
    }
    public void m4() {
        System.out.println("m4 method");
    }
    public static void main(String args[]) {
        CSE18 ob = new CSE18();
        ob.m1();
        ob.m4();
    }
}

/*
m1 method
m4 method
*/
```
