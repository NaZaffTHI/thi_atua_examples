package de.thi.winfo.threads;

/*
 * Aus: Inden, Michael: Der Weg zum Java-Profi. 3., aktualisierte und überarbeitete Auflage. dpunkt.verlag (2015)
 * S. 487-489
 */
public class CountingThread extends Thread {

    @Override
    public void run() {
        int counter = 0;
        while (counter++ < 50) {
            System.out.println("Counting thread: " + counter);
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Counting thread done!");
    }
}
