import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Shelf {
    private final HashMap<String, Character> shelf;
    private final int rows = 3;
    private final int columns = 3;

    public Shelf() {
        shelf = new HashMap<>();
    }

    public void addBook(int row, int column, char bookId) {
        if (isValidPosition(row, column)) {
            shelf.put(getKey(row, column), bookId);
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
        } else {
            System.out.println("Invalid position");
        }
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

    public void loadFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    int row = Integer.parseInt(parts[0]);
                    int column = Integer.parseInt(parts[1]);
                    char bookId = parts[2].charAt(0);
                    if (isValidPosition(row, column)) {
                        shelf.put(getKey(row, column), bookId);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    private String getKey(int row, int column) {
        return row + "," + column;
    }

    private boolean isValidPosition(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }


}
