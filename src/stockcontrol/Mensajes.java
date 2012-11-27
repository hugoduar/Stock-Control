/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

import java.util.ArrayList;


/**
 *  @author Hugo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A59B1BB8-64F3-FCB9-FDB2-3580A8129E74]
// </editor-fold> 
public class Mensajes {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.52CF6D80-664E-F5B3-3258-DB34825F481F]
    // </editor-fold> 
    private String mensaje;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.935E52DC-BA7B-F3BB-2404-92F62969B9E9]
    // </editor-fold> 
    private Archivo archivo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B0626B0F-F9B7-5C90-6985-EAA6C52AEF5A]
    // </editor-fold> 
    private String fichero; 
    Mensajes (String path) {
        this.archivo = new Archivo(path);
        this.mensaje = archivo.Leer();
        
    } 
    Mensajes (String mensajetxt, String mensaje) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.36283E39-5F17-5183-0899-5674EAF85D9C]
    // </editor-fold> 
    public void EscribirMensaje (String mensaje) {
        archivo.BorrarTodo();
        archivo.Escribir(mensaje, true);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0728CA6E-C730-1A38-4112-283FE9C49278]
    // </editor-fold> 
    public String MostrarMensaje () {
        return archivo.Leer();
    }
}
