package org.fasttrackit.controler.utils;

import java.util.Scanner;

public class ScannerUtils {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int readNextSingleInt() {
        int integer = SCANNER.nextInt();
        SCANNER.nextLine();
        return integer;
    }


    public static String readNetSingleLine() {
        String value = SCANNER.next();
        SCANNER.nextLine();
        return  value;
    }
}
