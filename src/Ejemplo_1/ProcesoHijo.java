package Ejemplo_1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class ProcesoHijo {
    public static void main(String[]args) throws InterruptedException, IOException {

        PrintWriter pw = new PrintWriter(new FileWriter("tonterias.txt"));
        pw.println("funciono");
        pw.close();
        TimeUnit.SECONDS.sleep(10);
    }
}
