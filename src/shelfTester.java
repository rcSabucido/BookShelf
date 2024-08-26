public class shelfTester {
    public static void main(String[] args) {
        Shelf shelf = new Shelf();
        long startTime = System.nanoTime();
        shelf.addBook(0, 0, 'A');
        shelf.addBook(0, 1, 'B');
        long endTime = System.nanoTime();
        System.out.println("Time taken for addBook: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();

        startTime = System.nanoTime();
        char book = shelf.getBook(0, 0);
        endTime = System.nanoTime();
        System.out.println("Time taken to get book " + book + ": " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();


        startTime = System.nanoTime();
        shelf.removeBook(0, 0);
        endTime = System.nanoTime();
        System.out.println("Time taken for removeBook by position: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();

        startTime = System.nanoTime();
        shelf.removeBookID('B');
        endTime = System.nanoTime();
        System.out.println("Time taken for removeBook ID: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();


        shelf.addBook(0, 0, 'A');
        shelf.addBook(0, 1, 'B');
        shelf.addBook(0, 2, 'C');
        shelf.addBook(0, 3, 'D');

        startTime = System.nanoTime();
        String pos = shelf.findBook('C');
        endTime = System.nanoTime();
        System.out.println("Time taken for findBook to find " + pos + " : " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();


        startTime = System.nanoTime();
        shelf.removeBookID('C');
        endTime = System.nanoTime();
        System.out.println("Time taken for removeBook ID: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();


        startTime = System.nanoTime();
        shelf.displayShelf();
        endTime = System.nanoTime();
        System.out.println("Time taken for displayShelf: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();


        startTime = System.nanoTime();
        shelf.saveToFile("bookshelf.csv");
        endTime = System.nanoTime();
        System.out.println("Time taken for saveToFile: " + (endTime - startTime) / 1000000 + " ms");
        System.out.println();

    }
}
