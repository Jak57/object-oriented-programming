public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person Jakir = new Person("Jakir", printer, 5);
        Person Arnob = new Person("Arnob", printer, 7);
        Person Takrim = new Person("Takrim", printer, 8);
    }
}

/*
// Synchronized method

class Printer {
    synchronized void printAssignment(String name, int pages) {
        System.out.println(name + " Printing started...");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " printed page " + i);
        }
        System.out.println(name + " Printing ended...");
    }
}

class Person implements  Runnable {
    String name;
    Printer printer;
    int pages;
    Thread t;

    Person(String name, Printer printer, int pages) {
        this.name = name;
        this.printer = printer;
        this.pages = pages;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        printer.printAssignment(name, pages);
    }
}

public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person Jakir = new Person("Jakir", printer, 5);
        Person Arnob = new Person("Arnob", printer, 7);
        Person Takrim = new Person("Takrim", printer, 8);
    }
}
*/

/*
// Synchronized block

class Printer {
    void printAssignment(String name, int pages) {
        System.out.println(name + " Printing started...");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " printed page " + i);
        }
        System.out.println(name + " Printing ended...");
    }
}

class Person implements  Runnable {
    String name;
    final Printer printer;  // final must be used to apply synchronized block
    int pages;
    Thread t;

    Person(String name, Printer printer, int pages) {
        this.name = name;
        this.printer = printer;
        this.pages = pages;
        t = new Thread(this, name);
        t.start();
    }

    @Override
    public void run() {
        synchronized(printer) { // synchronized keyword must be used along with the object
            printer.printAssignment(name, pages);
        }
    }
}

public class Synchronization {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Person Jakir = new Person("Jakir", printer, 5);
        Person Arnob = new Person("Arnob", printer, 7);
        Person Takrim = new Person("Takrim", printer, 8);
    }
}
 */
