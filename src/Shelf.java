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

    public void addBook(int row, int column, char bookId) {
        if (isValidPosition(row, column)) {
            shelf.put(getKey(row, column), bookId);
            System.out.println(bookId + " has been added to the shelf!");
        } else {
            System.out.println("Invalid position");
        }
    }

    public char getBook(int row, int column) {
        char emptySlot = '-';
        if (isValidPosition(row, column)) {
            return shelf.getOrDefault(getKey(row, column), emptySlot);
        } else {
            System.out.println("Invalid position");
            return emptySlot;
        }
    }

    public void removeBook(int row, int column) {
        if (isValidPosition(row, column)) {
            shelf.remove(getKey(row, column));
            System.out.println("Book removed from the shelf at position " + getKey(row, column));
        } else {
            System.out.println("Invalid position");
        }
    }

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

    public String findBook(char bookId) {
        for (Map.Entry<String, Character> entry : shelf.entrySet()) {
            if (entry.getValue() == bookId) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void displayShelf() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(getBook(i, j) + " ");
            }
            System.out.println();
        }
    }

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

    private String getKey(int row, int column) {
        return row + "," + column;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }


}
