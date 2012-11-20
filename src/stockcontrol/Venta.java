/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hugo
 */
public class Venta {
    String datos;
    int cantidad;
    double precioUnitario;
    double precioFinal;
    double ganancia;
    
    Venta(){}
    Venta(String datos,int cantidad, double precioUnitario, double precioFinal){
        this.datos=datos;
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
        this.precioFinal=precioFinal;
        if (cantidad>0) {
            this.ganancia=(precioFinal-precioUnitario)*cantidad;
        }else{this.ganancia=0;}
    }
    
    public void RealizarVenta(String producto, int cantidadVenta){
        Inventario in = new Inventario("datos.txt");
        Producto p = new Producto();
        int cantidadFinal;
        int pos;
        pos = in.BuscarProducto(producto);
        p = in.Consulta(pos);
        if(p.getcantidad()==0){
            in.ModificarCantidad(producto, p.getcantidad());
        }else if(p.getcantidad()>0){
            in.ModificarCantidad(producto, p.getcantidad()-cantidadVenta);
        }else{
            in.ModificarCantidad(producto, 0);
        }
        in.Guardar();
    }
    
    public void RealizarVenta(Producto p, String producto, int cantidadVendidos){
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
    
    public Producto RealizarVenta(Producto p, int cantidadMenos, double preciounitario, double preciofinal){
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
    
    public float MostrarGanancia(Producto p){
        Inventario in = new Inventario("datos.txt");
        Archivo arch = new Archivo("datos.txt");
        Producto new_producto = new Producto();
        float ganancia=0.00f;
        for (int i = 0; i < in.Tamanio(); i++) {
            String info;
            info=arch.Leer();
            if(!info.isEmpty()){
                do{
                    new_producto.setproducto(info.substring(0, info.indexOf("\t")));
                    info=info.substring(info.indexOf("\t")+1);
                    new_producto.setcantidad(Integer.parseInt(
                            info.substring(0, info.indexOf("\t"))));
                    info=info.substring(info.indexOf("\t")+1);
                    new_producto.setprecioUnitario(Double.parseDouble(
                            info.substring(0, info.indexOf("\t"))));
                    info=info.substring(info.indexOf("\t")+1);
                    new_producto.setprecioFinal(Double.parseDouble(
                            info.substring(0, info.indexOf("\n")==-1?
                            info.length():info.indexOf("\n"))));
                    info=info.substring(info.indexOf("\n")==-1?
                            info.length():info.indexOf("\n")+1);
                }while(info.length()>0);
            ganancia += new_producto.getprecioFinal()-new_producto.getprecioUnitario();
            }
        }
        return ganancia;
    }
    public double CorteDeCaja(Inventario in, Inventario inMod){
        Producto p = new Producto();
        Producto pMod = new Producto();
        int cantidadVendidos;
        double ganancia=0.00;
        for (int i = 0; i < in.Tamanio(); i++) {
            int pos = 0;
            int pos2; 
            p = in.Consulta(i);
            pos2 = inMod.BuscarProducto(p.getproducto());
            pMod = inMod.Consulta(pos2);
            cantidadVendidos = p.getcantidad()-pMod.getcantidad();
            ganancia = ganancia + (MostrarGanancia(p)*cantidadVendidos);
        }
        return ganancia;
    }
    
    
}
