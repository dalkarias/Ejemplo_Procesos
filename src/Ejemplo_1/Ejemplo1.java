package Ejemplo_1;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Ejemplo1 {
    public static void main(String[]args)
    {
        // aplicacion que abra chrome con la pagina de progresa cargada

        // comandos -> array de strings
        // elemento 1 -> el progragama
        // siguientes cada uno de los argumentos a arrancar

        String[] comando = {"open","-a","Google Chrome","http://www.google.com"};
        String[] comando2 = {"open","/System/Applications"};
        String[] comando3 = {"open","System/Applications/Textedit.app"};


        String[] comando4 = {"java","src/Ejemplo_1/ProcesoHijo.java"};
        // -a -> para que habra la ventana y nos dirija a le web seleccionada
        // crear el proceso con el proccesbuilder

        ProcessBuilder pb = new ProcessBuilder(comando4); // abre un proceso

        // crear el proceso hijo


        try {
            Process procesoGoogle = pb.start();
            if(procesoGoogle.isAlive()) {
                TimeUnit.SECONDS.sleep(10);
                procesoGoogle.destroy();
            }
            TimeUnit.SECONDS.sleep(10);

        } catch (IOException e) {
            System.out.println("No funciona");
            //sthrow new RuntimeException(e);

        } catch(InterruptedException a){
            System.out.println("fallo de interrupcion");
        }
    }
}
