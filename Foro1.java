package com.mycompany.foro1;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Foro1 {
    public static Map<String, String> alumnos = new HashMap<>();

    public static void main(String[] args) {
        Scanner rd = new Scanner(System.in);
        String carnet, nombre;
        
        alumnos.put("LA212616", "Alex Francisco Lovos Argueta");

        int opcion = 0;
        boolean salir = false;

        do {
            try {
                System.out.println("Bienvenido, ¿qué desea hacer?\n1. Buscar Alumno\n2. Ingresar Alumno\n3. Eliminar Alumno\n4. Mostrar todos los Alumnos\n5. Salir del programa");
                System.out.print("Ingrese el número de la opción deseada: ");
                opcion = rd.nextInt();
                //salir = true;
            } catch (Exception e) {
                System.out.println("Ingrese un número válido.");
                rd.nextLine(); // Limpiar el búfer
                
            }
            
            switch (opcion) {
                case 1:
                    rd.nextLine();
                    System.out.print("\nIngrese el carnet del Alumno que desea buscar: ");
                    carnet = rd.nextLine().toUpperCase();
                    buscar(carnet);
                    break;
                
                case 2:
                    rd.nextLine();
                    System.out.print("Ingresa el nombre completo del alumno: ");
                    nombre = rd.nextLine();
                    System.out.print("Ingresa el carnet que se desea asignar: ");
                    carnet = rd.nextLine().toUpperCase();
                    agregar(carnet, nombre);
                    
                    break;
                    
                case 3:
                    rd.nextLine();
                    System.out.print("\nIngrese el carnet del alumno que se desea eliminar: ");
                    carnet = rd.nextLine().toUpperCase();
                    eliminar(carnet);
                    break;
                    
                case 4:
                    rd.nextLine();
                    mostrar();
                    break;
                
                case 5:
                    rd.nextLine();
                    salir = true;
            }
        } while (salir == false);

        rd.close(); // Cerrar el Scanner al finalizar
    }
    
//funciones personalizadas
    public static void buscar(String carnet){
        String alumno = alumnos.get(carnet);
        if (alumno != null) {
            System.out.println(carnet + " es el alumno " + alumno);
        } else {
            System.out.println("Alumno no encontrado, no se puede mostrar");
        }
    }
    
    public static void agregar(String carnet, String nombre){
        alumnos.put(carnet, nombre);
        System.out.println("Alumno ingresado exitosamente");
    }
    
    public static void eliminar(String carnet){
        String alumno = alumnos.remove(carnet);
    if (alumno != null) {
        System.out.println("Alumno eliminado correctamente");
    } else {
        System.out.println("Alumno no encontrado, no se puede eliminar");
    }
    }
    
    public static void mostrar(){
        if(alumnos.size() == 0){
            System.out.println("No se encuentra ningun alumno registrado");
        }else {
            
            int maxLongitudCarnet = 0;
            int maxLongitudNombre = 0;
            for (Map.Entry<String, String> entry : alumnos.entrySet()) {
            maxLongitudCarnet = Math.max(maxLongitudCarnet, entry.getKey().length());
            maxLongitudNombre = Math.max(maxLongitudNombre, entry.getValue().length());
            }

            int anchoCarnet = Math.max(maxLongitudCarnet, "Carnet".length());
            int anchoNombre = Math.max(maxLongitudNombre, "Nombre".length());
            int anchoCuadro = anchoCarnet + anchoNombre + 5;
            
            System.out.println("Alumnos ingresados:");
            System.out.println("┌" + "─".repeat(anchoCuadro) + "┐");
            
            for (Map.Entry<String, String> entry : alumnos.entrySet()) {
                String carnet = entry.getKey();
                String nombre = entry.getValue();
                System.out.printf("│ %-" + anchoCarnet + "s │ %-" + anchoNombre + "s │%n", carnet, nombre);
            }
            System.out.println("└" + "─".repeat(anchoCuadro) + "┘");
        }
    }
}
