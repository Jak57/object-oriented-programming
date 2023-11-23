# Methods
**Example 1**
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
class Student {

}

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
class Student {

}

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
