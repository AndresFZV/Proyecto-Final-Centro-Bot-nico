package proyecto;

import static org.mockito.Mockito.*;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class PlantaTest {

    @org.junit.jupiter.api.Test
    public void testMostrarInformacionPlantas() {
        List<Planta> plantasRegistradas = new ArrayList<>();
        List<Botanicos> botanicosRegistrados = new ArrayList<>();

        JOptionPane mockOptionPane = mock(JOptionPane.class);

        Planta.mostrarInformacionPlantas(plantasRegistradas, botanicosRegistrados);
        
        verify(mockOptionPane, times(1));
        JOptionPane.showMessageDialog(any(), any());
    }
}
