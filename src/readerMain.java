import java.util.Scanner;

public class readerMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Shelf shelf = new Shelf();
        String file = "bookshelf.csv";

        mainLoop: while (true) {
            System.out.println("Welcome to your bookshelf!");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search book");
            System.out.println("4. View shelf");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    char id = sc.next().charAt(0);
                    System.out.print("Enter row: ");
                    int row = sc.nextInt();
                    System.out.print("Enter column: ");
                    int column = sc.nextInt();
                    shelf.addBook(row, column, id);
                    shelf.saveToFile(file);
                    System.out.println("Current shelf:");
                    shelf.displayShelf();
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Remove by position or book id? (enter pos/id): ");
                    String option = sc.next();
                    if (option.equals("pos")) {
                        System.out.print("Enter row: ");
                        int posRow = sc.nextInt();
                        System.out.print("Enter column: ");
                        int posColumn = sc.nextInt();
                        shelf.removeBook(posRow, posColumn);
                        shelf.saveToFile(file);
                        System.out.println("Current shelf:");
                        shelf.displayShelf();
                        System.out.println();
                    } else if (option.equals("id")) {
                        System.out.print("Enter book id: ");
                        char bookId = sc.next().charAt(0);
                        shelf.removeBookID(bookId);
                        shelf.saveToFile(file);
                        System.out.println("Current shelf:");
                        shelf.displayShelf();
                        System.out.println();
                    } else {
                        System.out.println("Invalid choice, please try again.");
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.print("Find book by position or id? (enter pos/id): ");
                    String findOption = sc.next();
                    if (findOption.equals("pos")) {
                        System.out.print("Enter row: ");
                        int posRow = sc.nextInt();
                        System.out.print("Enter column: ");
                        int posColumn = sc.nextInt();
                        char bookId = shelf.getBook(posRow, posColumn);
                        if (bookId == '-') {
                            System.out.println("Book not found.");
                        } else {
                            System.out.println("Book " + bookId + " found.");
                        }
                    } else if (findOption.equals("id")) {
                        System.out.print("Enter book id: ");
                        char findBookId = sc.next().charAt(0);
                        String position = shelf.getBookId(findBookId);
                        if (position != null) {
                            System.out.println("Book " + findBookId + " found at position " + position);
                            System.out.println();
                        } else {
                            System.out.println("Book not found.");
                            System.out.println();
                        }
                    } else {
                        System.out.println("Wrong input, please try again.");
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Current shelf: ");
                    shelf.displayShelf();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("See you next time!");
                    break mainLoop;
            }
        }
    }
}
