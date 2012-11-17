/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hugo
 */
public class Producto {
    String Genero;
    int Cantidad;
    double CostoUnitario;
    double PrecioVenta;
    
    public Producto(){
        this.Genero="";
        this.Cantidad=0;
        this.CostoUnitario=0.00;
        this.PrecioVenta=0.00;
    }
    public Producto(String genero, int cantidad, double costoUnitario, double precioVenta){
        this.Genero=genero;
        this.Cantidad=cantidad;
        this.CostoUnitario=costoUnitario;
        this.PrecioVenta=precioVenta;
    }
    
    public void setGenero(String genero){
        this.Genero=genero;
    }
    public void setCantidad(int cantidad){
        this.Cantidad=cantidad;
    }
    public void setCostoUnitario(double costoUnitario){
        this.CostoUnitario=costoUnitario;
    }
    public void setPrecioVenta(double precioVenta){
        this.PrecioVenta=precioVenta;
    }
    
    public String getGenero(){
        return Genero;
    }
    public int getCantidad(){
        return Cantidad;
    }
    public double getCostoUnitario(){
        return CostoUnitario;
    }
    public double getPrecioVenta(){
        return PrecioVenta;
    }
    
    public String toString(){
        return getGenero()+";"+Integer.toString(getCantidad())+";"+String.valueOf(getCostoUnitario())+";"+String.valueOf(getPrecioVenta());
    }
}
