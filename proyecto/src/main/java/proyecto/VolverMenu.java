package proyecto;

import javax.swing.*;

public class VolverMenu {
    public static void volverAlMenuPrincipal() {
        int confirmacion = JOptionPane.showConfirmDialog(
                null,
                "¿Está seguro que desea volver al menú principal?",
                "Confirmar",
                JOptionPane.YES_NO_OPTION
        );
        if (confirmacion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Volviendo al menú principal...");
        }
    }
}
