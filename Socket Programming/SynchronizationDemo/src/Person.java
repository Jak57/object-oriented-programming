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

