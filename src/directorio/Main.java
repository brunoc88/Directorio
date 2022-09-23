
package directorio;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n"); 
        Directorio directorio = new Directorio();
        String seleccion = "";
        do {
            System.out.println("");
            System.out.println("Menu.");
            System.out.println("1.Agregar cliente");
            System.out.println("2.Buscar Cliente");
            System.out.println("3.Buscar Telefono");
            System.out.println("4.Buscar clientes");
            System.out.println("5.Borrar cliente");
            System.out.println("6.Salir");
            int option = leer.nextInt();
            switch (option) {
                case 1:
                    directorio.agregarCliente();
                    break;
                case 2:
                    System.out.println(directorio.toString());
                    System.out.println("Ingrese el telefono de la persona que desea buscar");
                    Long telbus=leer.nextLong();//guardamos la variable para que podamos verla en el else
                    if (directorio.buscarCliente(telbus)==null) {
                        System.out.println("El cliente no se encuentra en el directorio");
                    }else {
                        System.out.println(directorio.buscarCliente(telbus));
                    }
                    break;
                case 3:
                    System.out.println("Ingrese el apellido de la persona");
                    directorio.buscarTelefono(leer.next());
                    break;
                case 4:
                    System.out.println("Ingrese la ciudad de la persona");
                    directorio.buscarClientes(leer.next());
                    break;
                case 5:
                    System.out.println("ingrese el numero de telefono para borrar");
                    directorio.borrarClientes(leer.nextLong());
                    break;
                case 6:
                    System.out.println("Realmente desea salir(s/n)");
                    seleccion = leer.next();
            }
        } while (!seleccion.equalsIgnoreCase("s"));

    }
    
}
