package codeGym1;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static String alfMin = "abcdefghijklmnopqrstuvwxyz";
    static String alfMay = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {


        System.out.println("Sistema de para cifrar y descifrar un archivo");
        System.out.println("/*/*/*/*/*/*/*/*/*/*/*/*/*/**/*/*/*/*/*/*/*/*/*");
        System.out.println();

        int opc1;
        do {
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Cifrar ");
            System.out.println("2. Descifrar");
            System.out.println("3. Descifrar por fuerza bruta ");
            System.out.println("4. Descifrar por estadística ");
            System.out.println("5. Salir ");
            opc1 = Integer.parseInt(teclado.next());

            switch (opc1) {
                case 1:
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        System.out.println("ingrese el texto ");
                        String text = reader.readLine();
                        System.out.println("texto ingresado: " + text);

                    }catch (IOException e){
                        e.getMessage();
                    }

                    System.out.println("Ingrese el valor de desplazamiento: ");
                    int desp = teclado.nextInt();

                    String textoCifrado = cifrar(desp, texto);
                    System.out.println("Texto cifrado: " + textoCifrado);
                    break;
                case 2:
                    System.out.println("Ingrese el texto cifrado: ");
                    textoCifrado = teclado.nextLine();

                    System.out.println("Ingrese el valor de desplazamiento: ");
                    int despl = teclado.nextInt();

                    String textoDescifrado = descifrar(textoCifrado, despl);
                    System.out.println("Texto descifrado: " + textoDescifrado);
                    break;
                case 3:
                    textoCifrado = " Krod Pzqgr";
                    System.out.println("texto cifrado: " + textoCifrado);
                    System.out.println("Descifrado por fuerza bruta: ");

                    for (int despla = 1; despla < 26; despla++){
                        textoCifrado = fuerzaBruta(textoCifrado, despla);
                        System.out.println("Desplazamiento " + despla + ":" + textoDescifrado);
                    }
                    break;
                case 4:
                    estadistica();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Número no reconocido");
            }
        } while (opc1 != 5);
        System.out.println("El programa ha finalizado");
    }


    public static String cifrar(String texto, int desp) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char  caracter = texto.charAt(i);
            if (Character.isLetter(caracter)){
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                caracter = (char) (base + (caracter - base + desp) % 26);
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }


    public static String descifrar(String textoCifrado, int despl) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < textoCifrado.length(); i++){
            char caracter = textoCifrado.charAt(i);
            if (Character.isLetter(caracter)){
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                caracter = (char) (base + (caracter - base - despl + 26) % 26);
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    public static String fuerzaBruta(String textoCifrado, int despla) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < textoCifrado.length(); i++){
            char caracter;
            caracter = textoCifrado(i);
            if ( Character.isLetter(caracter)){
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                caracter = (char) (base + (caracter - base - despla + 26) % 26);
            }
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    public static String estadistica() {
        System.out.println("Descifrar por análisis estadístico");
        return null;
    }

}


