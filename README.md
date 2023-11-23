# object-oriented-programming
Object Oriented Programming (OOP)

# Lab: 01
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
