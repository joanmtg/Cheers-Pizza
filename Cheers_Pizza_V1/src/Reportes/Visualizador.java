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
 * file: Visualizador.java
 * 
 */


package Reportes;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author invitado
 */
public class Visualizador extends JasperViewer implements WindowListener{

    
    private static Visualizador instancia;
    
    private Visualizador(JasperPrint jasperPrint, boolean isExitOnClose) {
        super(jasperPrint, isExitOnClose);
        addWindowListener(this);
        System.out.println("Reporte abierto");
    }
    
    public static Visualizador obtenerInstancia(JasperPrint print, boolean exitClose){
        
        if(instancia == null){
          instancia = new Visualizador(print, exitClose);
        }
        else{
            System.out.println("Este reporte ya ha sido abierto");
        }
        
        return instancia;
    }

    @Override
    public void windowOpened(WindowEvent e) {
       
    }

    @Override
    public void windowClosing(WindowEvent e) {
       
    }

    @Override
    public void windowClosed(WindowEvent e) {
        instancia = null;
    }

    @Override
    public void windowIconified(WindowEvent e) {
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
      
    }
    
}
