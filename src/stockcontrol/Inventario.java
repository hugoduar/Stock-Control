/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stockcontrol;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.4225323B-B193-2FC2-29E0-55F6A2A40A8F]
// </editor-fold> 
public class Inventario {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1BA7971D-A292-CA66-58DE-54F3D6732FD0]
    // </editor-fold> 
    private String info;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.A03DA5B3-0B6E-969B-D654-E1BE1201C71B]
    // </editor-fold> 
    private Producto new_producto = new Producto();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.1EE7E373-848A-E41B-1AE6-5EBC0CE20004]
    // </editor-fold> 
    private Archivo archivo;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4A0F3423-D590-1263-64E5-033EF631B93D]
    // </editor-fold> 
    private ArrayList<Producto> inv = new ArrayList();

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5ECD4785-9D0D-5DE1-A598-B7A892A77235]
    // </editor-fold> 
    public Inventario (String archivo) {
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.94441A47-4208-1006-C754-478EB5A61E74]
    // </editor-fold> 
    public int BuscaProducto (Producto producto) {
        return inv.isEmpty()?-1:inv.indexOf(producto);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.27C8602F-D896-3123-0E64-E865924CC4A4]
    // </editor-fold> 
    public int BuscarProducto (String producto) {
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

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DAFA4CE3-EB38-116F-EB2F-2535ED9F9B03]
    // </editor-fold> 
    public Producto Consulta (int pos) {
        return pos>=0 && pos<inv.size()?inv.get(pos):null;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DE9D01E3-B88D-D6A0-7553-0715F185A10E]
    // </editor-fold> 
    public boolean Baja (Producto producto) {
        return inv.remove(producto);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.666AE032-3B93-9BEA-70CF-8AB875B3D4D0]
    // </editor-fold> 
    public boolean Baja (int pos) {
        new_producto=inv.get(pos);
        return Baja(new_producto);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.89AF8A5A-F098-9DBA-2B3D-368424B1838D]
    // </editor-fold> 
    public Producto ModificarCantidad (String producto, int Cantidad) {
        Producto mod = new Producto();
        int pos = BuscarProducto(producto);
        mod = Consulta(pos);
        mod.setcantidad(Cantidad);
        Baja(pos);
        Guardar();
        inv.add(mod);
        Guardar();
        return mod;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AF1297A7-AD28-A0A4-F715-FC19BA35530D]
    // </editor-fold> 
    public boolean Alta (Producto producto) {
        return inv.add(producto);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.94E636E2-E21C-1D13-6AAF-EF564568B449]
    // </editor-fold> 
    public boolean Alta (String producto, int Cantidad, double CostoUnitario, double PrecioVenta) {
        return inv.add(new Producto(producto,Cantidad,CostoUnitario,PrecioVenta));
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.4E9D8D20-DAAF-DB08-C70A-65EE5C614D3E]
    // </editor-fold> 
    public boolean ModificarCampo (Producto producto, Producto mod) {
        inv.remove(producto);
        return inv.add(mod);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.04C8DA21-BB34-584A-F5F5-7688A5AC76EC]
    // </editor-fold> 
    public int Tamanio () {
        return inv.size();
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B75289BF-AFD4-9165-3094-61A330EC94D0]
    // </editor-fold> 
    public boolean Guardar () {
         String cambios = "";
         for (int cont=0; cont!=inv.size();cont++){
             cambios=cambios+Consulta(cont).toString()+"\n";
         }
         return archivo.Escribir(cambios, false);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.58FFBC32-F942-9E60-6122-9F214BF65D90]
    // </editor-fold> 
    public void BorrarTodo () {
        archivo.BorrarTodo();
    }
    public void AgregarStock(String genero , int cantidad){
        int pos;
        Producto p = new Producto();
        
        pos = BuscarProducto(genero);
        p = Consulta(pos);
        
        int cantidadFinal = p.getcantidad()+cantidad;
        
        ModificarCantidad(genero, cantidadFinal);
        
        
    }
}
