package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int allSeats = rows * seats;
        int cash = 0;
        int ticket = 0;

        double percentage = 0;
        int currentIncome = 0;
        int totalIncome = 0;
        int firstHalf;
        int secHalf;
        int check = 0;
        int setNumber = 0;

        if (allSeats <= 60) {
            totalIncome = allSeats * 10;
        } else {
            if (rows % 2 != 0) {
                firstHalf = (rows - 1) / 2 * seats;
                secHalf = (((rows - 1) / 2) + 1) * seats;
                totalIncome = (firstHalf * 10) + (secHalf * 8);
            } else {
                firstHalf = (rows / 2) * seats;
                secHalf = (rows / 2) * seats;
                totalIncome = (firstHalf * 10) + (secHalf * 8);
            }
        }


        String[][] arr2 = new String[rows][seats];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                arr2[i][j] = "S";
            }
        }
        for (;;) {

            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");

            if (check == 1){
                setNumber = 2;
                check--;
            } else {
                setNumber = scanner.nextInt();
            }
            System.out.println();
            switch (setNumber){
                case 1:
                    System.out.println("Cinema:");
                    System.out.print("  ");
                    for (int i = 0; i < seats; i++) {
                        System.out.print(i + 1 + " ");
                    }
                    System.out.println();

                    for (int i = 0; i < rows; i++) {
                        System.out.print(i + 1 + " ");
                        for (int j = 0; j < seats; j++) {
                            System.out.print(arr2[i][j] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Enter a row number:");
                    int row = scanner.nextInt();
                    System.out.println("Enter a seat number in that row:");
                    int seat = scanner.nextInt();
                    if (row > rows || seat > seats) {
                        System.out.println("Wrong input !");
                        check++;
                        break;
                    }

                    if (arr2[row - 1][seat - 1] == "B") {
                        System.out.println("That ticket has already been purchased!\n");
                        check++;
                    } else {

                        arr2[row - 1][seat - 1] = "B";

                        if (allSeats <= 60) {
                            cash = 10;
                        } else if (rows % 2 == 0) {
                            if (row <= (rows / 2)) {
                                cash = 10;
                            } else {
                                cash = 8;
                            }
                        } else {
                            if (row <= ((rows - 1) / 2)) {
                                cash = 10;
                            } else {
                                cash = 8;
                            }
                        }
                        ticket++;
                        currentIncome += cash;
                        double doubleTicet = ticket;
                        double doubleAllSeats = allSeats;
                        percentage =  doubleTicet * 100.00  / doubleAllSeats;
                        System.out.println("Ticket price: $" + cash);
                    }


                    break;

                case 0:
                    break;

                case 3:

                    System.out.println("Number of purchased tickets: " + ticket);
                    System.out.println("Percentage: " + String.format("%.2f", percentage) + "%");
                    System.out.println("Current income: $" + currentIncome);
                    System.out.println("Total income: $" + totalIncome);
                    System.out.println(ticket + " " + allSeats);
                    break;
                default:
                    System.out.println("Wrong input!");
                    break;

            }
            System.out.println(ticket + " " + allSeats);
            if (setNumber == 0){
                break;
            }
        }
    }
}

