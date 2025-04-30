package de.thi.winfo.threads;

import java.util.Date;

/*
 * Aus: Inden, Michael: Der Weg zum Java-Profi. 3., aktualisierte und überarbeitete Auflage. dpunkt.verlag (2015)
 * S. 487-489
 * Implementierung von Runnable ist die bevorzugte Variante, da sie OO-technisch sauberer ist.
 * Keine Ableitung einer Utility-Klasse und Funktionalität ist als Einheit gekapselt.
 */
public class DatePrinterThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("DatePrinterThread (" + i + "): " + new Date());
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Date printer thread done!");
    }

}
