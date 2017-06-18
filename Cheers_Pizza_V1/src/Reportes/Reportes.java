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

import Administracion.Factura;
import static Reportes.Reportes.lLogger;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
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
    
    public void reporteFactura(Factura factura, double cambio){
       JasperReport report = null;
       
       try
       {
            URL ruta = this.getClass().getResource("/Reportes/reporteFactura.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("numero_factura", factura.getNumero());
            parametros.put("numero_pedido", factura.getPedido().getNumero());
            parametros.put("cajero", factura.getCajero().getNombre()+" "+ factura.getCajero().getApellidos());
            parametros.put("idCliente", factura.getPedido().getCliente().getId());
            parametros.put("nomCliente", factura.getPedido().getCliente().getNombre());
            parametros.put("hora_pago", factura.getHoraPago().toString());
            parametros.put("descuento", factura.getDescuento());
            parametros.put("impuestos", factura.getImpuestos());
            parametros.put("propina", factura.getPropina());
            parametros.put("total", factura.getTotalPago());
            parametros.put("formas_pago", factura.getFacturaFormasPago());
            parametros.put("items", factura.getItemsFactura());
            parametros.put("cambio", cambio);
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       }
      
    }
    
    public void reporteTopMasVendidos(String codEmpleado, String nombreEmpleado, int mes, int anio){
       JasperReport report = null;
       Connection conectar;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");
           
            URL ruta = this.getClass().getResource("/Reportes/reporteItemsMasPedidos.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("nombreEmpleado", nombreEmpleado);
            parametros.put("codigoEmpleado", codEmpleado);            
            parametros.put("mes", mes); 
            parametros.put("anio", anio); 
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    public void reporteTopMenosVendidos(String codEmpleado, String nombreEmpleado){
       JasperReport report = null;
       Connection conectar;
       
       try
       {
           conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");
           
            URL ruta = this.getClass().getResource("/Reportes/reporteItemsMenosPedidos.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("nombreEmpleado", nombreEmpleado);
            parametros.put("codigoEmpleado", codEmpleado);            
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SQLException ex) {      
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void reporteTiempoPromedioAtencion(String codEmpleado, String nombreEmpleado){
       JasperReport report = null;
       Connection conectar;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");
           
            URL ruta = this.getClass().getResource("/Reportes/ReporteTiempoAtencion.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("nombreEmpleado", nombreEmpleado);
            parametros.put("codigoEmpleado", codEmpleado);            
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SQLException ex) {      
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void reporteIngresosDiariosSemana(String codEmpleado, String nombreEmpleado, int anio, int semana){
       JasperReport report = null;
       Connection conectar;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");
           
            URL ruta = this.getClass().getResource("/Reportes/ReporteIngresosSemana.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("nombreEmpleado", nombreEmpleado);
            parametros.put("codigoEmpleado", codEmpleado);
            parametros.put("numeroSemana", semana);
            parametros.put("anio", anio);  
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SQLException ex) {      
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void reporteIngresosDiariosMes(String idEmpleado, String nombreE, int anio, int mes){
       JasperReport report = null;
       Connection conectar;
       
       try
       {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");
           
            URL ruta = this.getClass().getResource("/Reportes/ReporteIngresosDiaMes.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");
            
            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);            
            parametros.put("mes", mes);
            parametros.put("anio", anio); 
            parametros.put("idEmpleado", idEmpleado);
            parametros.put("empleado", nombreE);
            
            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);
            
            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);
       
       }catch(JRException ex)
       {
           JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
       } catch (SQLException ex) {      
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
    public void reporteEmpleadoMes(String codEmpleado, String nombreEmpleado) {

        JasperReport report = null;
        Connection conectar;

        try {
            conectar = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cheers_bd", "wayne", "arkham");

            URL ruta = this.getClass().getResource("/Reportes/reporteEmpleadoDelMes.jasper");
            URL logo = this.getClass().getResource("/images/logo.png");

            report = (JasperReport) JRLoader.loadObject(ruta);
            Map parametros = new HashMap();
            parametros.put("logo", logo);
            parametros.put("nombreEmpleado", nombreEmpleado);
            parametros.put("codigoEmpleado", codEmpleado);

            JasperPrint contenido = JasperFillManager.fillReport(report, parametros, conectar);

            Visualizador visualizar = Visualizador.obtenerInstancia(contenido, false);
            visualizar.setZoomRatio(0.5F);
            visualizar.setVisible(true);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo generar el reporte " + ex, "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
