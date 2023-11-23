**Simple Program**
```
class Example {
    static int add(int a, int b) {
        return a+b;
    }

    int subtract(int a, int b) {
        return a-b;
    }
    public static void  main(String args[]) {
        System.out.println("This is a simple program");
        Example ob = new Example();
        System.out.println(Example.add(2, 3));
        System.out.println(ob.subtract(7, 9));
    }
}

/*
This is a simple program
5
-2
*/
```
**Default values of primitive types**
```
class Example {
    static int a;
    static boolean b;
    static char c;
    static float d;
    static double e;
    static short f;
    static long h;
    static byte i;

    public static void  main(String args[]) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
        System.out.println("d: " + d);
        System.out.println("e: " + e);
        System.out.println("f: " + f);
        System.out.println("h: " + h);
        System.out.println("i: " + i);
    }
}

/*
a: 0
b: false
c:
d: 0.0
e: 0.0
f: 0
h: 0
i: 0
 */
```
**Different ways of accessing static variables**
```
class Example {
    static int a = 7;
    public static void  main(String args[]) {
        Example ob = new Example();
        System.out.println("a: " + a);
        System.out.println("a: " + Example.a);
        System.out.println("a: " + ob.a);

    }
}

/*
a: 7
a: 7
a: 7
 */
```

**Instance vs Static**
```
class Example {
    int a = 17;
    static int b = 25;
    public static void  main(String args[]) {
        Example ob = new Example();
        System.out.println(ob.a);
        System.out.println(Example.b);
        
        ob.a = 19;
        Example.b = 20;
        System.out.println(ob.a);
        System.out.println(ob.b);

        Example ob1 = new Example();
        System.out.println(ob1.a);
        System.out.println(Example.b);
    }
}

/*
17
25
19
20
17
20
 */
```
**Increment or Decrement**
```
class Example {
    int a = 17;
    static int b = 25;

    static void m1() {
        int c = 5;
        int d = 7;
        System.out.println(c++);
        System.out.println(c);
        System.out.println(--d);
        System.out.println(d);
    }
    public static void  main(String args[]) {
        m1();
    }
}

/*
5
6
6
6
 */
```
