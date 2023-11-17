package proyecto;

import javax.swing.JOptionPane;

public class RegistrarBotanicos {
    public RegistrarBotanicos() {
    }

    public Botanicos registrarBotanicos(){

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del botánico: ");
        String apellido = JOptionPane.showInputDialog("Ingrese el apellido del botánico: ");
        String licenciaBotanico = JOptionPane.showInputDialog("Ingrese la licencia (especialización) del botánico: ");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del botánico: ");
        String telefono = JOptionPane.showInputDialog("Ingrese el número telefónico del botánico: ");

        Botanicos botanicos = new Botanicos(nombre, apellido, licenciaBotanico, correo, telefono);
        JOptionPane.showMessageDialog(null, "¡Botánico contratado!.");
        return botanicos;
    }
    
}
