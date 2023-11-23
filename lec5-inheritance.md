**Example 01**
```
class B {
    int b = 45;
    void m1() {
        System.out.println("m1 method");
    }
    void m2() {
        System.out.println("m2 method");
    }
}
class C extends B {
    int b = 5;
    void m1() {
        System.out.println("m1 method of B");
    }
    void m5() {
        m1();
        super.m1();
        System.out.println("m5 method" + " " + b + " " + super.b);
    }
}
class Example extends C{
    public static void  main(String args[]) {
        Example ob = new Example();
        ob.m5();
    }
}

/*
m1 method of B
m1 method
m5 method 5 45
*/
```
