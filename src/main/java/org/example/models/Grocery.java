package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {

    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;

        while (!quit) {
            System.out.println("0 - Exit");
            System.out.println("1 - Add Items");
            System.out.println("2 - Remove Items");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0 -> quit = true;
                case 1 -> {
                    System.out.print("Add items: ");
                    addItems(scanner.nextLine());
                }
                case 2 -> {
                    System.out.print("Remove items: ");
                    removeItems(scanner.nextLine());
                }
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String trimmed = item.trim();
            if (!checkItemIsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            groceryList.remove(item.trim());
        }
        printSorted();
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
    }
}
