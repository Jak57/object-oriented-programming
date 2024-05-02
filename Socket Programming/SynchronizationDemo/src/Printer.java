class Printer {
    void printAssignment(String name, int pages) {
        System.out.println(name + " Printing started...");
        for (int i = 1; i <= 5; i++) {
            System.out.println(name + " printed page " + i);
        }
        System.out.println(name + " Printing ended...");
    }
}