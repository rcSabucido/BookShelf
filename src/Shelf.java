import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Shelf {
    private final HashMap<String, Character> shelf;
    private final int rows = 6;
    private final int columns = 6;

    public Shelf() {
        shelf = new HashMap<>();
    }

    // add or update a book by taking the row, column, and bookId
    // adds it on our hashmap
    public void addBook(int row, int column, char bookId) {
        if (isValidPosition(row, column)) {
            shelf.put(getKey(row, column), bookId);
            System.out.println(bookId + " has been added to the shelf!");
        } else {
            System.out.println("Invalid position");
        }
    }

    // Read the book ID by taking row and column
    public char getBook(int row, int column) {
        char emptySlot = '-';
        if (isValidPosition(row, column)) {
            return shelf.getOrDefault(getKey(row, column), emptySlot);
        } else {
            System.out.println("Invalid position");
            return emptySlot;
        }
    }

    // find book by taking book id and iterating through every value of hashmap
    public String getBookId(char bookId) {
        for (Map.Entry<String, Character> entry : shelf.entrySet()) {
            if (entry.getValue() == bookId) {
                return entry.getKey();
            }
        }
        return null;
    }


    // Delete a book by taking row and column
    public void removeBook(int row, int column) {
        if (isValidPosition(row, column)) {
            shelf.remove(getKey(row, column));
            System.out.println("Book removed from the shelf at position " + getKey(row, column));
        } else {
            System.out.println("Invalid position");
        }
    }

    // Delete a book by taking book id and iterating through hashmap values
    public void removeBookID(char BookId) {
        String keyToRemove = null;
        for (Map.Entry<String, Character> entry : shelf.entrySet()) {
            if (entry.getValue() == BookId) {
                keyToRemove = entry.getKey();
            }
        }

        if (keyToRemove != null) {
            shelf.remove(keyToRemove);
            System.out.println("Book " + BookId + " removed from position " + keyToRemove);
        } else {
            System.out.println("Book " + BookId + " not found");
        }
    }

    // displays current state of shelf
    public void displayShelf() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(getBook(i, j) + " ");
            }
            System.out.println();
        }
    }

    // saves current state of shelf to csv file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Map.Entry<String, Character> entry : shelf.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // returns the string of our hashmap keys by combining both row and column into one string
    private String getKey(int row, int column) {
        return row + "," + column;
    }

    // checks if inputted position is in bounds of the shelf
    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }
}
