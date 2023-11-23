**Instance block**
```

class Example {
    {
        System.out.println("Instance block 1");
    }
    Example() {
        this(20);
        System.out.println("0-arg constructor");
    }
    Example(int a) {
        this(10, 30);
        System.out.println("1-arg constructor");
    }
    Example(int a, int b) {
        System.out.println("2-arg constructor");
    }
    void m1() {
        System.out.println("m1 method");
    }
    {
        System.out.println("Instance block 2");
    }
    {
        m1();
        System.out.println("Instance block 3");
    }
    public static void  main(String args[]) {
        new Example();
        new Example(20);
    }
}

/*
Instance block 1
Instance block 2
m1 method       
Instance block 3
2-arg constructor
1-arg constructor
0-arg constructor
Instance block 1
Instance block 2
m1 method
Instance block 3
2-arg constructor
1-arg constructor
*/
```
**Static block 1**
```

class Example {
    int a, b;
    Example() {
        System.out.println("0-arg constructor");
    }
    {
        System.out.println("Instance block 1");
    }
    static {
        System.out.println("static block 1");
    }
    Example(int a) {
        System.out.println("1-arg constructor");
    }
    static {
        m1();
        System.out.println("static block 2");
    }
    static void m1() {
        System.out.println("m1 method");
    }
    {
        System.out.println("Instance block 2");
    }
    public static void  main(String args[]) {
        new Example();
        new Example();
        new Example(20);
    }
}

/*
static block 1
m1 method
static block 2
Instance block 1
Instance block 2
0-arg constructor
Instance block 1
Instance block 2
0-arg constructor
Instance block 1
Instance block 2
1-arg constructor
*/
```

**Static block 2**
```

class Example {
    int a, b;
    Example() {
        System.out.println("0-arg constructor");
    }
    {
        System.out.println("Instance block 1");
    }
    static {
        System.out.println("static block 1");
    }
    Example(int a) {
        System.out.println("1-arg constructor");
    }
    static {
        m1();
        System.out.println("static block 2");
    }
    static void m1() {
        System.out.println("m1 method");
    }
    {
        System.out.println("Instance block 2");
    }
    public static void  main(String args[]) {
    }
}

/*
static block 1
m1 method     
static block 2
*/
```

**Static block 3**
```

class Student {
    static int a = 15;
    static {
        System.out.println("Student class");
        System.out.println("Static block of student class");
    }
}

class Example {
    int a, b;
    Example() {
        System.out.println("0-arg constructor");
    }
    Example(int a) {
        System.out.println("1-arg constructor");
    }
    static {
        System.out.println("Static block");
    }
    {
        System.out.println("Instance block");
    }
    public static void  main(String args[]) {
        new Example();
        System.out.println(Student.a);
        new Example(25);
    }
}

/*
Static block
Instance block
0-arg constructor
Student class
Static block of student class
15
Instance block
1-arg constructor
*/
```

**Static block 4**
```

class Student {
    static int a = 15;
    static {
        System.out.println("Student class");
        System.out.println("Static block of student class");
    }
}

class Example {
    static int a, b;
    static {
        a = 15;
        b = 20;
    }
    static {
        System.out.println("Static block");
        System.out.println(a + " " + b);
    }
    {
        System.out.println("Instance block");
    }
    public static void  main(String args[]) {
        new Example();
        new Example();
        new Example();
    }
}

/*
Static block
15 20
Instance block
Instance block
Instance block
*/
```
