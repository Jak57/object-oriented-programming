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

**Example 02**
```
class AA {
    AA() {
        System.out.println("super 0-arg");
    }
    AA(int a) {
        System.out.println("super 1-arg");
    }
}
class B extends AA {
    B() {
        this(15);
        System.out.println("child 0-arg");
    }
    B(int a) {
        System.out.println("child 1-arg");
    }
    public static void main(String args[]) {
        new B();
    }
}

/*
super 0-arg
child 1-arg
child 0-arg
*/
```

**Example 03**
```
class AA {
    AA() {
        System.out.println("super 0-arg");
    }
    AA(int a) {
        System.out.println("super 1-arg");
    }
}
class B extends AA {
    B() {
        super(15);
        System.out.println("child 0-arg");
    }
    B(int a) {
        System.out.println("child 1-arg");
    }
    public static void main(String args[]) {
        new B();
    }
}

/*
super 1-arg
child 0-arg
*/
```

**Example 04**
```
class Parent {
    static {
        System.out.println("Parent static block");
    }
    {
        System.out.println("Parent instance block");
    }
    Parent() {
        System.out.println("Parent class constructor");
    }
}
class Child extends Parent {
    static {
        System.out.println("Child static block");
    }
    {
        System.out.println("Child instance block");
    }
    Child() {
        System.out.println("Child constructor");
    }
    public static void main(String args[]) {
    }
}

/*
Parent static block
Child static block
*/
```

**Example 05**
```
class Parent {
    static {
        System.out.println("Parent static block");
    }
    {
        System.out.println("Parent instance block");
    }
    Parent() {
        System.out.println("Parent class constructor");
    }
}
class Child extends Parent {
    static {
        System.out.println("Child static block");
    }
    {
        System.out.println("Child instance block");
    }
    Child() {
        System.out.println("Child constructor");
    }
    public static void main(String args[]) {
        new Child();
    }
}

/*
Parent static block
Child static block
Parent instance block
Parent class constructor
Child instance block
Child constructor
*/
```
