/**
 * Proyecto Desarrollo de Software II
 * Universidad del Valle
 * EISC
 *
 * Integrantes: 
 *
 * Jhonier Andrés Calero Rodas		1424599
 * Fabio Andrés Castañeda Duarte	1424386
 * Juan Pablo Moreno Muñoz		1423437
 * Joan Manuel Tovar Guzmán		1423124
 *
 * file: Reportes.java
 * 
 */


package Reportes;

import static Reportes.Reportes.lLogger;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author invitado
 */
public class Reportes {

    static final Logger lLogger = Logger.getLogger("net.sf.jasperreports");
        
    public Reportes() {
        // Para no ver mensajes de jasper en la consola
        lLogger.setLevel((Level)Level.OFF);
    }
    
    public void reportePrueba(){
        
       JasperReport report = null;
       
       try
       {
            URL ruta = this.getClass().getResource("/Reportes/prueba.jasper");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
}
