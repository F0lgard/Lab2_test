package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть римське число:");
        String roman = scanner.nextLine();

        try {
            int result = Converter.convertRomantoArabic(roman);
            System.out.println("Арабське число: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
