/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *  @author Hugo
 */
// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.E66BFC96-2F07-9DA8-618E-9A08DB17E978]
// </editor-fold> 
public class Venta {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C958E567-5174-018C-CC0D-E6997976C3B4]
    // </editor-fold> 
    String datos;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.7FF20BB6-642B-F00E-FC8E-DFEEEC79653E]
    // </editor-fold> 
    int cantidad;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2D3F0F55-9A96-A015-8EC7-490DC2DD31F5]
    // </editor-fold> 
    double precioUnitario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4591306A-4C6C-6D7D-2C84-262F5088DBBE]
    // </editor-fold> 
    double precioFinal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6F49BB3D-FB46-F2BC-E482-BF5E4EDE40D2]
    // </editor-fold> 
    double ganancia; 
    Venta () {} 
    Venta (String datos, int cantidad, double precioUnitario, double precioFinal) {
        this.datos=datos;
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
        this.precioFinal=precioFinal;
        if (cantidad>0) {
            this.ganancia=(precioFinal-precioUnitario)*cantidad;
        }else{this.ganancia=0;}
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.6E9BB5EA-20B8-AB97-17AE-9F7F1449203E]
    // </editor-fold> 
    public boolean RealizarVenta (String producto, int cantidadVenta) {
        Inventario in = new Inventario("datos.txt");
        Producto p = new Producto();
        int cantidadFinal;
        int pos;
        pos = in.BuscarProducto(producto);
        p = in.Consulta(pos);
        if(p.getcantidad()==0){
            in.ModificarCantidad(producto, p.getcantidad());
            in.Guardar();
            return false;
        }else if(p.getcantidad()<cantidadVenta){
            in.ModificarCantidad(producto, p.getcantidad());
            in.Guardar();
            return false;
        }else if(p.getcantidad()>0&&cantidadVenta>0){
            in.ModificarCantidad(producto, p.getcantidad()-cantidadVenta);
            in.Guardar();
            return true;
        }else{
            in.ModificarCantidad(producto, p.getcantidad());
            in.Guardar();
            return false;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.9423431E-0DE3-7F3A-3561-DB662CBF63B3]
    // </editor-fold> 
    public void RealizarVenta (Producto p, String producto, int cantidadVendidos) {
        Inventario in = new Inventario("datos.txt");
        try {
            p.serializar("datos.dat");
            
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int pos = in.BuscarProducto(producto);
        in.Baja(pos);
        Producto nuevo = new Producto();
        try {
            nuevo.construir("datos.dat");
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int cantidadFinal = nuevo.getcantidad() - cantidadVendidos;
        nuevo.setcantidad(cantidadFinal);
        in.Alta(nuevo);
        in.Guardar();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BAB229BD-12B2-81D4-5CCB-CE58CC6F50E7]
    // </editor-fold> 
    public Producto RealizarVenta (Producto p, int cantidadMenos, double preciounitario, double preciofinal) {
        Inventario in = new Inventario("datos.txt");
        int cantidadFinal;
        try {
            p.setprecioUnitario(preciounitario);
            p.setprecioFinal(preciofinal);
            p.serializar("datos.dat");
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
        in.Baja(p);
        Producto pMod = new Producto();
        try {
            pMod=pMod.construir("datos.dat");
        } catch (IOException ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(Venta.class.getName()).log(Level.SEVERE, null, ex);
        }

        cantidadFinal = pMod.getcantidad()-cantidadMenos;
        pMod.setcantidad(cantidadFinal);
        in.Alta(pMod);
        in.Guardar();
        return pMod;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.089A7A2F-830A-1F48-EF13-68CA33656B10]
    // </editor-fold> 
    public double MostrarGanancia (Producto p) {
        double ganancia = p.getprecioFinal()-p.getprecioUnitario();
        return ganancia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4FB4413E-E5AD-3ACC-439B-1C26324690FF]
    // </editor-fold> 
    public double MostrarGanancia (String genero) {
        Inventario in = new Inventario("datos.txt");
        Producto p = new Producto();
        int pos;
        pos = in.BuscarProducto(genero);
        p = in.Consulta(pos);
        double ganancia = p.getprecioFinal()-p.getprecioUnitario();
        return ganancia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.FE7EAC02-C3C3-0D7B-3B6B-D9C2CFE562C5]
    // </editor-fold> 
    public int CorteDeCajaVentas (String Genero) {
        Inventario in = new Inventario("datos.txt");
        Inventario inMod = new Inventario("datos2.txt");
        Producto p = new Producto();
        Producto pMod = new Producto();
        int ventas=0;
        int pos;
        pos = inMod.BuscarProducto(Genero);
        pMod = inMod.Consulta(pos);
        pos = in.BuscarProducto(Genero);
        p = in.Consulta(pos);
        ventas = pMod.getcantidad()-p.getcantidad();
        inMod.Baja(pos);
        inMod.Alta(p);
        return ventas;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C3F486CD-E2B8-4EFE-C4A7-10031930570C]
    // </editor-fold> 
    public double CorteDeCajaGanancias (String Genero) {
        Inventario inventarioS = new Inventario("datos.txt");
        Producto disco = new Producto();
        Producto discoCorte = new Producto();
        int ventas;
        double ganancia=0.0;
        ventas = CorteDeCajaVentas(Genero);
        int pos;
        pos = inventarioS.BuscarProducto(Genero);
        discoCorte = inventarioS.Consulta(pos);
        ganancia = MostrarGanancia(discoCorte)*ventas;
        return ganancia;
        
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8234AABB-31AB-7F43-04D0-F228BEAFF1CA]
    // </editor-fold> 
    public double CorteDeCaja () {
        Inventario inMod = new Inventario("datos.txt");
        Inventario in = new Inventario("datos2.txt");
        Producto p = new Producto();
        Producto pMod = new Producto();
        int pos;
        int cantidadVenta;
        double ganancia=0.0;
        
        for (int i = 0; i < in.Tamanio(); i++) {
            p = in.Consulta(i);
            pos = inMod.BuscarProducto(p.getproducto());
            pMod = inMod.Consulta(pos);
            cantidadVenta = p.getcantidad()-pMod.getcantidad();
            in.ModificarCantidad(p.getproducto(), pMod.getcantidad());
            ganancia += MostrarGanancia(p)*cantidadVenta;
            
        }
        in.Guardar();
        return ganancia;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.97857EF7-ACDE-827A-D7DE-0E5877134E91]
    // </editor-fold> 
    public void Devolucion (String producto, int cantidad) {
        Inventario in = new Inventario("datos.txt");
        Producto p = new Producto();
        int pos;
        pos = in.BuscarProducto(producto);
        p = in.Consulta(pos);
        in.ModificarCantidad(producto, p.getcantidad()+cantidad);
        in.Guardar();
    }
    
}
