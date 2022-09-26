package directorio;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Directorio {

    private Cliente cliente;

    private Long telefono;

    private HashMap<Long,Cliente>directorio;

    public Directorio() {
        this.directorio = new HashMap();
    }

    public Directorio(Cliente cliente, Long telefono, HashMap<Long, Cliente> directorio) {
        this.cliente = cliente;
        this.telefono = telefono;
        this.directorio = directorio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public HashMap<Long, Cliente> getDirectorio() {
        return directorio;
    }

    public void setDirectorio(HashMap<Long, Cliente> directorio) {
        this.directorio = directorio;
    }
 
    public Cliente agregarCliente() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n"); 
        System.out.println("Ingrese los datos del cliente:");
        Cliente c1 = new Cliente();
        System.out.println("DNI:");
        c1.setDni(leer.nextLong());
        System.out.println("Ingrese nombre:");
        c1.setNombre(leer.next());
        System.out.println("Ingrese apellido:");
        c1.setApellido(leer.next());
        System.out.println("Ingrese Ciudad");
        c1.setCiudad(leer.next());
        System.out.println("Ingrese Direccion:");
        c1.setDireccion(leer.next());
        telefono = Math.round(Math.random()*1000)+1;
        directorio.put(telefono, c1);
        return c1;
    }

    public Cliente buscarCliente(Long telefono) {

        return directorio.get(telefono);
    }

    public Long buscarTelefono(String apellido) {
        
        for (Map.Entry<Long, Cliente> entry : directorio.entrySet()) {
            Long key = entry.getKey();
            Cliente value = entry.getValue();
            if (value.getApellido().equalsIgnoreCase(apellido)) {
                System.out.println("Telefono =" + telefono +" Apellido =" + apellido +" Nombre "+ value.getNombre());
                //return telefono;
            }else{
                System.out.println("No se encontro el apellido");
                telefono = null; 
                
            }
        }
        return telefono;
    }

    public HashMap buscarClientes(String ciudad) {
        for (Map.Entry<Long, Cliente> entry : directorio.entrySet()) {
            Long key = entry.getKey();
            Cliente value = entry.getValue();
            if (value.getCiudad().equalsIgnoreCase(ciudad)) {
                System.out.println("Directorio " + directorio);
                return directorio;
            }else{
                System.out.println("No se encontro coincidencia");
                directorio = null;  
            }
        }
        return directorio;
    }

    public void borrarClientes(Long telefono) {
        System.out.println("ak se mueve ");
        directorio.remove(telefono);
    }

    @Override
    public String toString() {
        return "Directorio{" + "cliente=" + cliente + ", telefono=" + telefono + ", directorio=" + directorio + '}';
    }
    
}
