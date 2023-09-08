package codeGym1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
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
            //String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
            //String frase = teclado.nextLine();
            switch (opc1) {
                case 1:
                    cifrar();
                    break;
                case 2:
                    descifrar();
                    break;
                case 3:
                    fuerzaBruta();
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

    public static String cifrar() {
        System.out.println("Cifrar archivo ");
        System.out.println("Captura la ruta del archivo en claro : Archivo.txt" );
        try {
            String ruta = Main.class.getResource("Archivo.txt").getPath();
            FileInputStream fis = new FileInputStream(ruta);
            int valor;
            while ((valor = fis.read()) != -1){
                System.out.print((char)valor);
            }
        }catch (IOException e){
            System.out.println("Error ->> " + e.getMessage());
        }
       return null;
    }

    public static String descifrar() {
        System.out.println("operación de descifrar ");
        return null;
    }

    public static String fuerzaBruta() {
        System.out.println("Descifrar por fuerza bruta");
        return null;
    }

    public static String estadistica() {
        System.out.println("Descifrar por análisis estadístico");
        return null;
    }

}


