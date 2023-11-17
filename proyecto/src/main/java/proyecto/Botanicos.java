package proyecto;

import javax.swing.*;
import java.util.List;

public class Botanicos{

    private String nombre;
    private String apellido;
    private String licenciaBotanico;
    private String correo;
    private String telefono;

    public Botanicos(String nombre, String apellido, String licenciaBotanico, String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.licenciaBotanico = licenciaBotanico;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String getNombre(){
        return nombre;
    }

    public String getApellido(){
        return apellido;
    }

    public String getLicenciaBotanico(){
        return licenciaBotanico;
    }

    public String getCorreo(){
        return correo;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setLicenciaBotanico(String licenciaBotanico){
        this.licenciaBotanico = licenciaBotanico;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public static void mostrarInformacionBotanicos(List<Botanicos> botanicosRegistrados){
       if(!botanicosRegistrados.isEmpty()){
        StringBuilder infoBotanicos = new StringBuilder("\nInformación de los Botánicos contratados:\n");
        int contador = 1;
        for(Botanicos botanicos : botanicosRegistrados){
            infoBotanicos.append("Botánico #").append(contador).append("\n");
            infoBotanicos.append("Nombres del Botánico: ").append(botanicos.getNombre()).append("\n");
            infoBotanicos.append("Apellido del Botánico: ").append(botanicos.getApellido()).append("\n");
            infoBotanicos.append("Licencia del Botánico: ").append(botanicos.getLicenciaBotanico()).append("\n");
            infoBotanicos.append("Correo del Botánico: ").append(botanicos.getCorreo()).append("\n");
            infoBotanicos.append("Número telefónico del Botánico: ").append(botanicos.getTelefono()).append("\n");
            contador++;
        }
        JOptionPane.showMessageDialog(null, infoBotanicos.toString(), "Información de los Botánicos", JOptionPane.INFORMATION_MESSAGE);
       } else {
        JOptionPane.showMessageDialog(null, "No se han registrado botánicos", "Información de los Botánicos", JOptionPane.INFORMATION_MESSAGE);
       }
    }   
}