/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos;
import com.sun.org.apache.xpath.internal.operations.Equals;
import utils.Leer;
/**
 *
 * @author USUARIO
 */
public class ejercicio {
    public static String[] nombre = new String[1000];
    
    public static double[] nota1 = new double[1000];
    public static double[] nota2 = new double[1000];
    public static double[] nota3 = new double[1000];
    public static double[] nota4 = new double[1000];
   
    public static double[] notapromedio = new double[1000];
    public static int posicion = -1;
    
    public static void agregar(){
        String r, continuar;
        
        do{
            posicion++;
            System.out.println("Agregar Alumno: ");
            System.out.print("Nombre: ");
        
            nombre[posicion] = Leer.cadena();
            System.out.print("nota1: ");
            nota1[posicion] = Leer.decimal();
            System.out.print("nota2: ");
            nota2[posicion] = Leer.decimal();    
            System.out.print("nota3: ");
            nota3[posicion] = Leer.decimal();
            System.out.print("nota4: ");
            nota4[posicion] = Leer.decimal();    
          
            continuar = Leer.cadena();
            
        }while(continuar.equalsIgnoreCase("S"));
        
    }
    public static void eliminar(){
        String continuar;
        do {
                listar();
                System.out.print("Ingrese el numero del alumno a eliminar: ");
                int numero = Leer.entero();
                numero--;
                for (int i = numero; i < posicion; i++) {
                    nombre[i] = nombre[i + 1];
                    nota1[i] = nota1[i + 1];
                    nota2[i] = nota2[i + 1];
                    nota3[i] = nota3[i + 1];
                    nota4[i] = nota4[i + 1];
                    notapromedio[i] = notapromedio[i + 1];
                }
                nombre[posicion] = "";
                nota1[posicion] = 0;
                nota2[posicion] = 0;
                nota3[posicion] = 0;
                nota4[posicion] = 0;
                notapromedio[posicion] = 0;
                posicion--;
                System.out.println("¿Deseas Eliminar otro [S/N]?");
                continuar = Leer.cadena();
      } while (continuar.equalsIgnoreCase("S"));
    }
    public static void editar(){
        String continuar;
        do {
                listar();
                System.out.println("Ingrese el numero del alumno a editar: ");
                int numero = Leer.entero();
                numero--;
                System.out.println("Resultado: "+nombre[numero]+"\tExamen 1: "+nota1[numero]+"\tExamen 2: "+nota2[numero]+"\tExamen 3: "+nota3[numero]+"\tExamen 4: "+nota4[numero]);
                System.out.print("Nuevo Nombre: ");
                nombre[numero] = Leer.cadena();
                System.out.print("Nueva nota 1: ");
                nota1[numero] = Leer.decimal();
                System.out.print("Nueva nota 2: ");
                nota2[numero] = Leer.decimal();
                System.out.print("Nueva nota 3 : ");
                nota3[numero] = Leer.decimal();
                System.out.print("Nueva nota4 : ");
                nota4[numero] = Leer.decimal();
               
                continuar = Leer.cadena();
      } while (continuar.equalsIgnoreCase("S"));

    }
    public static void listar(){
        for (int i=0; i<=posicion; i++){
            notapromedio[i] = nota1[i]*0.25 + nota2[i]*0.2 + nota3[i]*0.2 + nota4[i]*0.25;
        }
        System.out.println("Listado");
        System.out.println("Nº\tNombre\t\tnota1\tnota2\t\t\tnota3\t\t\t nota4\t\tnota final");
        for (int i=0; i<=posicion; i++){
            System.out.println((i+1)+"\t"+nombre[i]+"\t"+nota1[i]+"\t\t"+nota2[i]+"\t\t\t"+nota3[i]+"\t\t\t "+nota4[i]+"\t\t"+notapromedio[i]);
        }
    }
    public static void salir(){
        System.out.println("Gracias por su visita.");
    }
    public static void error(){
        System.out.println("Error, opción incorrecta.");
    }
    public static void menu(){
        System.out.println("Bienvenido al Sistema de notas de los alumnos\nMenú de opciones:"
                + "\n1. Agregar estudiante"
                + "\n2. Eliminar estudiante"
                + "\n3. Editar estudiante"
                + "\n4. Listar "
                + "\n5. Salir."
                + "\n Ingrese una opcion: ");
    }
    public static void inicio(){
        int op;
        do{
            menu();
            op = Leer.entero();
            switch(op){
                case 1: agregar();
                break;
                case 2: eliminar();
                break;
                case 3: editar();
                break;
                case 4: listar();
                break;
                case 5: salir();
                break;
                default: error();
            }
        }while(op!=5);
        
    }
    public static void main(String[] args) {
        inicio();
    }
}