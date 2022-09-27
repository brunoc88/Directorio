package directorio;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javax.swing.JOptionPane;

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
 
    public boolean agregarCliente(Cliente c1) {
        boolean flag = false;
        System.out.println(telefono);
        if (directorio.containsKey(telefono)) {
            JOptionPane.showMessageDialog(null,"no se pudo agregar");

            flag = true;
        } else {
            directorio.put(telefono, c1);
            JOptionPane.showMessageDialog(null,"Contacto agregado");
            flag = false;
        }
        return flag;
    }

    public void buscarCliente(Long telefono) {
        if (directorio.get(telefono)==null) {
            JOptionPane.showMessageDialog(null,"El cliente no se encuentra en el directorio");
        }else{
            JOptionPane.showMessageDialog(null,directorio.get(cliente));
        }
//  
    
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
