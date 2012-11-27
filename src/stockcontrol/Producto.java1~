
package stockcontrol;

import java.io.*;


public class Producto implements Serializable {
    String producto;
    int cantidad;
    double precioUnitario;
    double precioFinal;
    public Producto(){
    }
    public Producto(String producto, int cantidad, double precioUnitario, double precioFinal){
        this.producto=producto;
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
        this.precioFinal=precioFinal;
    }
    public void setproducto(String Producto){
        this.producto=Producto;
    }
    public String getproducto(){
        return this.producto;
    }
    public void setcantidad(int cantidad){
        this.cantidad=cantidad;
    }
    public int getcantidad(){
        return this.cantidad;
    }
    public void setprecioUnitario(double precioUnitario){
        this.precioUnitario=precioUnitario; 
    }
    public double getprecioUnitario(){
        return this.precioUnitario;
    }
    public void setprecioFinal(double precioFinal){
        this.precioFinal=precioFinal; 
    }
    public double getprecioFinal(){
        return this.precioFinal;
    }
    public String toString(){
        return getproducto()+";"+Integer.toString(getcantidad())+";"+String.valueOf(getprecioUnitario())+";"+String.valueOf(getprecioFinal());
    }
    public void serializar(String archivo) throws IOException {
	FileOutputStream fos = new FileOutputStream(archivo);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(this);
    }
    public Producto construir(String archivo)throws IOException, Exception {			
        FileInputStream fis = new FileInputStream(archivo);
	ObjectInputStream ois = new ObjectInputStream(fis);
	return (Producto)ois.readObject();		
			
    }
}
