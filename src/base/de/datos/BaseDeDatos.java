package base.de.datos;

import java.util.Scanner;

public class BaseDeDatos {

    public static void main(String[] args) {
        //Creando arreglo de estudiantes
        Objeto datos[] = new Objeto[10];
        int opciones = 0;
        Scanner teclado = new Scanner(System.in);
        Scanner letras = new Scanner(System.in);
        while (opciones != 5) {
            System.out.println("----------Menu--------------");
            System.out.println("1.Nuevo nombre");
            System.out.println("2.Ver alumnos");
            System.out.println("3.Buscar alumno");
            System.out.println("4.Modificar alumno");
            System.out.println("5.Salir");
            System.out.println("Ingrese el numero de opcion");
            opciones = teclado.nextInt();
              System.out.println("----------------------------");
            if (opciones == 1) {
                System.out.println("Ingrese clave ");
                int clave = teclado.nextInt();
                System.out.println("Ingrese el  nombre");
                String nombre = letras.nextLine();
                System.out.println("Ingrese el grado");
                String grado = letras.nextLine();
                System.out.println(nuevoalumno(clave , nombre , grado , datos));
            }else if (opciones==2) {
                System.out.println(imprimirTodo(datos));
            }
            if (opciones==3) {
                System.out.println("Ingrese clave ");
                int clave = teclado.nextInt();
                System.out.println(buscarAlumno(clave , datos));
                
            }
            if (opciones==4) {
               System.out.println("Ingrese clave ");
                int clave = teclado.nextInt();  
                if (buscarAlumnoBoolean(clave,datos)) {
                     System.out.println("Ingrese el  nombre");
                String nombre = letras.nextLine();
                System.out.println("Ingrese el grado");
                String grado = letras.nextLine();
                    System.out.println(modificarDatos(clave,nombre,grado,datos));
                    
                }else{
                    System.out.println("La clave no existe");
                }
               
            }
        }

    }

    public static String nuevoalumno(int clave, String nombre, String grado, Objeto arreglo[]) {
        boolean lleno = true;
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                arreglo[i] = new Objeto(clave, nombre, grado);
                lleno = false;
                break;
            }else if(arreglo[i].getClave()==clave) {
                return "Ya existe la clave";
                
            }
        }
        if (!lleno) {
            return "Se guardo con exito";
        } else {
           return "Ya no hay espacio";
        }

    }
    public static String imprimirTodo(Objeto arreglo[]){
        String cadena="";
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                cadena=cadena+arreglo[i].getClave()+"|"+arreglo[i].getNombre()+"|"+arreglo[i].getGrado()+"\n";
            }
  
        }
        return cadena;
    }
    public static String buscarAlumno(int clave,Objeto arreglo[] ){
        for (int i = 0; i< arreglo.length ; i++) {
            if (arreglo [i] !=null && arreglo[i].getClave()==clave) {
                return"Los dato \n nombre: "+arreglo[i].getNombre()+" Grado "+arreglo[i].getGrado();
            }
        }
        return "No existe la clave ingresada";
    } 
    public static boolean buscarAlumnoBoolean(int clave,Objeto arreglo[] ){
        for (int i = 0; i< arreglo.length ; i++) {
            if (arreglo [i] !=null && arreglo[i].getClave()==clave) {
                return true;
            }
            }
        return false;
        }
    public static String modificarDatos(int clave, String nombre, String grado, Objeto arreglo[]){
        for (int i = 0; arreglo.length < 10; i++) {
          if (arreglo [i] !=null && arreglo[i].getClave()==clave) {
                arreglo[i].setNombre(nombre);
                arreglo[i].setGrado(grado);
                return "Se actualizo con exito";
                
            }   
        }
        return "";
    }
}
