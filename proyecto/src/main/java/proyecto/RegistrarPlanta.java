package proyecto;

import javax.swing.JOptionPane;

public class RegistrarPlanta {
    public Planta registrarPlanta() {
        // Utilizamos JOptionPane.showInputDialog() para obtener la entrada del usuario
        String nombrePlanta = JOptionPane.showInputDialog("Ingrese el nombre común de la planta:");
        String nombreCientifico = JOptionPane.showInputDialog("Ingrese el nombre científico de la planta:");
        String tipo = JOptionPane.showInputDialog("Ingrese el tipo de planta (suculenta, árbol, arbusto, etc.):");
        
        // Crear una nueva instancia de Planta utilizando el constructor principal
        Planta nuevaPlanta = new Planta(nombrePlanta, nombreCientifico, tipo);

        // Utilizamos JOptionPane.showMessageDialog() para mostrar un mensaje
        JOptionPane.showMessageDialog(null, "Planta registrada con éxito.");

        // Establecer los cuidados posteriormente
        Cuidados nuevosCuidados = new RegistrarCuidado().registrarCuidados();
        nuevaPlanta.setCuidados(nuevosCuidados);

        return nuevaPlanta;
    }
}


