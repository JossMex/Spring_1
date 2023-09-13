package codeGym1;


import java.io.*;
import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException{

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
                    cifrarArchivo();
                    break;
                case 2:
                    descifrarArchivo();
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

    public static void cifrarArchivo(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el valor de desplazamiento");
            int desplazamiento = scanner.nextInt();

            File archivoEntrada = new File("Archivo.txt");
            File archivosalida = new File("archivo_cifrado.txt");

            FileReader fileReader = new FileReader(archivoEntrada);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(archivosalida);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                String lineaCifrada = cifrar(linea, desplazamiento);
                bufferedWriter.write(lineaCifrada);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void descifrarArchivo(){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el valor de desplazamiento utilizado para cifrar: ");
            int desplazamiento = scanner.nextInt();

            File archivoCifrado = new File("archivo_cifrado.txt");
            File archivoDescifrado = new File("archivo_descifrado.txt");

            FileReader fileReader = new FileReader(archivoCifrado);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(archivoDescifrado);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String linea;
            while ((linea = bufferedReader.readLine()) != null){
                String lineadescifrada = descifrar(linea, desplazamiento);
                bufferedWriter.write(lineadescifrada);
                bufferedWriter.newLine();
            }
            bufferedReader.close();
            bufferedWriter.close();
            System.out.println("Archivo descifrado exitosamente como archivo_descifrado.txt");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String cifrar(String texto, int desplazamiento) {
        StringBuilder resultado = new StringBuilder();
        for (char caracter : texto.toCharArray()) {
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                resultado.append((char) (((caracter - base + desplazamiento) % 26 ) + base));
            }else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
    public static String descifrar(String textoCifrado, int desplazamiento) {

        return cifrar(textoCifrado, -desplazamiento);
    }

    public static String fuerzaBruta() {

        return null;
    }

    public static String estadistica() {
        System.out.println("Descifrar por análisis estadístico");
        return null;
    }

}


