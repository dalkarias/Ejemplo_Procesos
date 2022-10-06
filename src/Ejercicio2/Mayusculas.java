package Ejercicio2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.SQLOutput;
import java.util.Scanner;

// PROCESO PADRE
public class Mayusculas {
    private static Scanner leer = new Scanner(System.in);
    private static String respuestaUsuario;
    public static void main(String[]args){

        ProcessBuilder pb = new ProcessBuilder("java","src/Ejercicio2/cambioMayusculas.java");

        pb.redirectErrorStream(true);

        try{
            System.out.println("Escribe una frase:");
            respuestaUsuario = leer.nextLine();

            Process cambioM = pb.start();
            //______________LECTURA________________

            InputStream isCambioM = cambioM.getInputStream();
            InputStreamReader isrCambioM = new InputStreamReader(isCambioM, StandardCharsets.UTF_8);
            BufferedReader brCambioM = new BufferedReader(isrCambioM);
            //______________ESCRITURA______________
            OutputStream ops = cambioM.getOutputStream();
            PrintStream psCambioM = new PrintStream(ops);
            psCambioM.println(respuestaUsuario);
            psCambioM.flush();

            //recibe la respuesta del hijo
            String respuesta;

            while((respuesta = brCambioM.readLine()) != null){
                // la muestra por pantalla
                System.out.println(respuesta);
            }


        }catch (Exception e){
            System.out.println("ERROR");
        }
    }
}
