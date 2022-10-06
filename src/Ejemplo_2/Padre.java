package Ejemplo_2;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Padre {
    private static int contador;
    private static Scanner scanner= new Scanner(System.in);

    public static void main(String[]args)  {
        System.out.println("cuantas lineas quieres mostrar");
        contador = scanner.nextInt();

        ProcessBuilder pb = new ProcessBuilder("java","src/Ejemplo_2/Hijo.java");

        pb.redirectErrorStream(true);//todos los string de errores se los diriges a este

        try {
            Process hijo = pb.start();// comienza el proceso
            // cojo la entrada estandar del hijo
            InputStream isHijo = hijo.getInputStream(); // ojo salida del hijo
            // crear un lector para la entrada
            InputStreamReader isrHijo = new InputStreamReader(isHijo, StandardCharsets.UTF_8);
            // crearé un buffer para linea a linea
            BufferedReader brHijo = new BufferedReader(isrHijo);// Lee los sout del hijo

            //----------    ESCRITURA   ----------------

            OutputStream outputStream = hijo.getOutputStream();// captura la entrada del hijo (scanner del hijo)

            PrintStream psHijo = new PrintStream(outputStream);//

            psHijo.println(contador);

            psHijo.flush();// INTRO

            String respuesta;

            while((respuesta = brHijo.readLine()) != null){
                System.out.println(respuesta);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
