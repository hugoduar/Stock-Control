/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Inventario{
    private String info;
    private Producto new_producto=new Producto();
    private Archivo archivo;
    private ArrayList<Producto> inv = new ArrayList();
    
    public Inventario(String archivo){
        this.archivo= new Archivo(archivo);
        this.info = this.archivo.Leer();
        if(!info.isEmpty()){
            do{
                new_producto.setproducto(info.substring(0, info.indexOf(";")));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setcantidad(Integer.parseInt(
                         info.substring(0, info.indexOf(";"))));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setprecioUnitario(Double.parseDouble(
                         info.substring(0, info.indexOf(";"))));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setprecioFinal(Double.parseDouble(
                        info.substring(0, info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n"))));
                info=info.substring(info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n")+1);
                inv.add(new Producto(new_producto.getproducto(),
                        new_producto.getcantidad(), new_producto.getprecioUnitario(), new_producto.getprecioFinal()));
            }while(info.length()>0);
        }
    }
    
    public int BuscaProducto(Producto producto){
        return inv.isEmpty()?-1:inv.indexOf(producto);
    }
    
    
    public int BuscarProducto(String producto){
        boolean ban=false;
        int pos = 0;
        for(int cont=0; cont!=inv.size(); cont++){
            if (inv.get(cont).getproducto().toUpperCase().equals(producto.toUpperCase())){
                ban=true;
                pos=cont;
            }
            System.out.println("#"+inv.get(cont).getproducto().toUpperCase()+"#");
        }
        return ban?pos:-1;
    }
    
    public Producto Consulta(int pos){
        return pos>=0 && pos<inv.size()?inv.get(pos):null;
    }
    
    public boolean Baja(Producto producto){
        return inv.remove(producto);
    }
    
    public boolean Baja(int pos){
        new_producto=inv.get(pos);
        return Baja(new_producto);
    }
    
    public Producto ModificarCantidad(String producto, int Cantidad){
        Producto mod = new Producto();
        int pos = BuscarProducto(producto);
        mod = Consulta(pos);
        mod.setcantidad(Cantidad);
        Baja(pos);
        inv.add(mod);
        Guardar();
        return mod;
    } 
    
    public boolean Alta(Producto producto){
        return inv.add(producto);
    }
    
    public boolean Alta(String producto, int Cantidad, double CostoUnitario, double PrecioVenta){
        return inv.add(new Producto(producto,Cantidad,CostoUnitario,PrecioVenta));
    }
    
    
    public boolean ModificarCampo(Producto producto, Producto mod){
        inv.remove(producto);
        return inv.add(mod);
    }
    
    public int Tamanio(){
        return inv.size();
    }
    
    public boolean Guardar(){
         String cambios = "";
         for (int cont=0; cont!=inv.size();cont++){
             cambios=cambios+Consulta(cont).toString()+"\n";
         }
         return archivo.Escribir(cambios, false);
    }
    public void BorrarTodo(){
        for (int i = 0; i < inv.size(); i++) {
            Baja(i);
        }
        Guardar();
    }
}
