package com.SSU.ShkodinMax.client;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ConsoleInputHelper {
    public static GregorianCalendar enterDate() {
        Scanner in = new Scanner(System.in);
        do {
            try {
                String sd = in.nextLine();
                String[] dateArr = sd.split("\\.");
                GregorianCalendar date = new GregorianCalendar();
                date.set(Integer.parseInt(dateArr[2]),Integer.parseInt(dateArr[1]),Integer.parseInt(dateArr[0]));
                return date;
            } catch (Exception e) {
                System.out.println("Date is incorrect. Enter again:");
            }
        } while (true);
    }

    public static String enterString() {

        Scanner in = new Scanner(System.in);
        do {
            String value = in.next();

            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("String must not be empty. Enter again: ");
        } while (true);
    }
    public static boolean getConfirmationMessageResult() {
        System.out.println("Do you really want to do this? If yes, press ‘y’, if no, press ‘n’");

        Scanner in = new Scanner(System.in);
        char option = in.next().charAt(0);

        do {
            if (option == 'y')
                return true;
            else if (option == 'n')
                return false;
            else {
                System.out.print("Wrong value, try again: ");
                option = in.next().charAt(0);
            }
        } while(true);
    }
    public static int enterPositiveIntValue() {
        Scanner in = new Scanner(System.in);
        do {
            int value = in.nextInt();

            if (value > 0) {
                return value;
            }
            System.out.print("Value must be positive, enter again: ");
        } while (true);
    }
}
