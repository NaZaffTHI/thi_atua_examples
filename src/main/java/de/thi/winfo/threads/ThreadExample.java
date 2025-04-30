package de.thi.winfo.threads;

/*
 * Aus: Inden, Michael: Der Weg zum Java-Profi. 3., aktualisierte und überarbeitete Auflage. dpunkt.verlag (2015)
 * S. 487-489
 */
public class ThreadExample {

    public static void main(String[] args) {

        final Thread derivedThread = new CountingThread();
        derivedThread.start();

        final Thread threadWithRunnable = new Thread(new DatePrinterThread());
        threadWithRunnable.start();

        System.out.println("ThreadExample main program done!");
    }

}
