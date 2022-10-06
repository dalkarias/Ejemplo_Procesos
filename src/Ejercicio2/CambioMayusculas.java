package Ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// PROCESO HIJO
public class CambioMayusculas {
    public static void main (String[]args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lineas = br.readLine();

        String lineasRetocada = lineas.toUpperCase();

        System.out.println(lineasRetocada);

    }
}
