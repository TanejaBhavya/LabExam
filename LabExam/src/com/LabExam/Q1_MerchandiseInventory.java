
package com.LabExam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q1_MerchandiseInventory {
    public static void main(String[] args) {

        ArrayList<Merchandise> merchInventory = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("input.dat"))) {

            String row;

            while ((row = br.readLine()) != null) {

                String[] section = row.trim().split("\\s+");

                String code = section[0];
                int qty = Integer.parseInt(section[1]);
                double price = Double.parseDouble(section[2]);

                merchInventory.add(new Merchandise(code, qty, price));
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        Collections.sort(merchInventory, new Comparator<Merchandise>() {
            @Override
            public int compare(Merchandise m1, Merchandise m2) {
                return m1.getCode().compareTo(m2.getCode());
            }
        });

        System.out.println("Sorted by Item Code in Ascending:");
        for (Merchandise merch : merchInventory) {
            merch.print();
        }

        Collections.sort(merchInventory, new Comparator<Merchandise>() {
            @Override
            public int compare(Merchandise m1, Merchandise m2) {
                return Double.compare(m2.getPrice(), m1.getPrice());
            }
        });

        System.out.println("\nSorted by Price in Descending:");
        for (Merchandise merch : merchInventory) {
            merch.print();
        }
    }
}

