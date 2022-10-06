package Ejercicio2.ejercicioCalculadora;
// PROCESO PADRE

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Calculadora {
    private static int op1,op2;
    private final static String multiplicar="x";
    private final static String division="/";
    private final static String resta="-";
    private final static String suma="+";
    private static String operador=null;
    private static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            datos();
            switch (operador) {
                case "+":
                    ProcessBuilder pbSuma = new ProcessBuilder("java", "src/Ejercicio2/EjercicioCalculadora/Suma.java");
                    pbSuma.redirectErrorStream(true);
                    //________________LECTURA______________
                    Process suma = pbSuma.start();
                    InputStream isSuma = suma.getInputStream();
                    InputStreamReader isrSuma = new InputStreamReader(isSuma, StandardCharsets.UTF_8);
                    BufferedReader brSuma = new BufferedReader(isrSuma);
                    //______________ESCRITURA______________
                    OutputStream ops = suma.getOutputStream();
                    PrintStream psSuma = new PrintStream(ops);
                    psSuma.println(op1);
                    psSuma.flush();
                    psSuma.println(op2);
                    psSuma.flush();
                    break;

                case "-":
                    ProcessBuilder pbResta = new ProcessBuilder("java", "src/Ejercicio2/EjercicioCalculadora/Resta.java");
                    pbResta.redirectErrorStream(true);
                    break;
                case "x":
                    ProcessBuilder pbMultiplicacion = new ProcessBuilder("java", "src/Ejercicio2/EjercicioCalculadora/Multiplicacion.java");
                    pbMultiplicacion.redirectErrorStream(true);
                    break;
                case "/":
                    ProcessBuilder pbDivision = new ProcessBuilder("java", "src/Ejercicio2/EjercicioCalculadora/Division.java");
                    pbDivision.redirectErrorStream(true);
                    break;
                default:
                    System.out.println("Operador inexistente");
            }// fin SWITCH

        }catch (Exception e){
            System.out.println("ERROR");
        }
    }

    private static void datos() {
        System.out.println("Dime un numero?");
        op1 = leer.nextInt();
        System.out.println("Dime uno de estos 4 operadores (+,-,x,/)");
        operador = leer.nextLine();
        System.out.println("Dime otro numero?");
        op2 = leer.nextInt();
    }
}
