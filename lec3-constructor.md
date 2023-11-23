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
