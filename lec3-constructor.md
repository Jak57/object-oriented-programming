**Example 01**
```

class Example {
    Example() {
        System.out.println("Inside the constructor");
    }
    Example(int a, int b) {
        System.out.println(a+b);
    }
    void m1() {
        System.out.println("m1 method");
    }
    public static void  main(String args[]) {
        Example ob = new Example();
        Example ob1 = new Example(5, 8);
    }
}

/*
Inside the constructor
13
*/
```
**Example 02**
```

class Example {
    int id, batch;
    String name;
    Example() {
        id = 57;
        batch = 2018;
        name = "Jakir";
    }
    Example(int id_, int batch_, String name_) {
        id = id_;
        batch = batch_;
        name = name_;
    }
    void m1() {
        System.out.println(id + " " + batch + " " + name);
    }
    public static void  main(String args[]) {
        Example ob1 = new Example();
        ob1.m1();
        Example ob2 = new Example(24, 2018, "Arnob");
        ob2.m1();
    }
}

/*
57 2018 Jakir
24 2018 Arnob
*/
```

**Example 03**
```

class Example {
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
    public static void  main(String args[]) {
        new Example();
    }
}

/*
2-arg constructor
1-arg constructor
0-arg constructor
*/
```
