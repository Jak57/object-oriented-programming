# Methods
**Example 01**
```
class Student {

}

class Example {
    static void m2(Student s) {
        System.out.println("m2 method");
    }

    void m3(int p, int q) {
        System.out.println(p+q);
    }
    public static void  main(String args[]) {
        Student s = new Student();
        Example ob = new Example();
        ob.m3(2, 3);
        Example.m2(s);
    }
}

/*
5
m2 method
*/
```

**Example 02**
```
class Example {
    int p = 100, q = 200;
    void m1(int a, int b) {
        System.out.println(a+b);
        p = 500;
        q = 600;
    }

    void m2() {
        System.out.println(p+q);
    }
    public static void  main(String args[]) {
        Example ob = new Example();
        ob.m1(2, 4);
        ob.m2();

        Example ob2 = new Example();
        ob2.m2();
    }
}

/*
6
1100
300
*/
```

**Example 03**
```
class Example {
    int a = 100, b = 200;
    void m1(int a, int b) {
        System.out.println(a+b);
        System.out.print(this.a+this.b);
    }

    public static void  main(String args[]) {
        Example ob = new Example();
        ob.m1(2, 4);
    }
}

/*
6
300
*/
```
**Example 04**
```
class Student {

}
class Example {
    int a = 15, b = 20;
    Student m1(Example e) {
        System.out.println("hello m1");
        return new Student();
    }
    public static void  main(String args[]) {
        Example ob1 = new Example();
        Example ob2 = new Example();
        Student ob3 = ob1.m1(ob2);
        System.out.println(ob3);
    }
}

/*
hello m1
Student@5ca881b5
*/
```
**Example 04**
```

class Example {
    int a = 15, b = 20;
    static int c = 5, d = 7;

    Example m1() {
        a = 1;
        b = 2;
        c = 3;
        d = 4;
        return new Example();
    }

    Example m2() {
        a = 10;
        b = 20;
        c = 30;
        d = 40;
        return this;
    }

    public static void  main(String args[]) {
        Example ob = new Example();
        Example ob2 = ob.m1();
        System.out.println(ob2.a + " " + ob2.b + " " + Example.c + " " + Example.d);
    
        Example ob3 = ob.m2();
        System.out.println(ob3.a + " " + ob3.b + " " + Example.c + " " + Example.d);
    }
}

/*
15 20 3 4
1 2 3 4
*/
```
