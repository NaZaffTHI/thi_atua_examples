package de.thi.winfo.threads;

import java.util.Date;

public class WithoutThreads {
    public static void main(String[] args) {
        count();
        printDate();
    }

    private static void count() {
        int counter = 0;
        while (counter++ < 50) {
            System.out.println("Counting thread: " + counter);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Counting done!");
    }

    private static void printDate() {
        for (int i = 0; i < 10; i++) {
            System.out.println("DatePrinterThread (" + i + "): " + new Date());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Date printer done!");
    }
}
