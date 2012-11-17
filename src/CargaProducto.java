
import java.util.ArrayList;


/**
 * @author Noel Rosales Pérez
 * Esta clase manipula los elementos de la clase Alumnos
 */
public class CargaProducto {
    private String info;
    private Producto new_producto = new Producto();
    private Archivo archivo;
    private ArrayList<Producto> arreglo = new ArrayList<>();
    
    /**
     * Constructor de la clase, carga los alumnos que están
     * desde un archivo. txt
     * @param 
     * String archivo = Dirección de donde se encuentra el archivo.
     */
    public CargaProducto(String archivo){
        this.archivo= new Archivo(archivo);
        this.info = this.archivo.Leer();
        if(!info.isEmpty()){
            do{
                new_producto.setGenero(info.substring(0, info.indexOf(";")));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setCantidad(Integer.parseInt(
                         info.substring(0, info.indexOf(";"))));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setCostoUnitario(Double.parseDouble(
                         info.substring(0, info.indexOf(";"))));
                info=info.substring(info.indexOf(";")+1);
                new_producto.setPrecioVenta(Double.parseDouble(
                        info.substring(0, info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n"))));
                info=info.substring(info.indexOf("\n")==-1?
                        info.length():info.indexOf("\n")+1);
                arreglo.add(new Producto(new_producto.getGenero(),
                        new_producto.getCantidad(), new_producto.getCostoUnitario(), new_producto.getPrecioVenta()));
            }while(info.length()>0);
        }
    }
    /**
     * Metodo de Consulta por posición en el arreglo(ArrayList Producto).
     * @param pos Posición a consultar en el arreglo.
     * @return Regresa un elemento del timpo Producto si existe de lo contrario null
     */
    public Producto Consulta(int pos){
        return pos>=0 && pos<arreglo.size()?arreglo.get(pos):null;
    }
    /**
     * Metodo de busqueda por medio de un Objeto tipo Producto.
     * @param producto Objeto tipo Producto a buscar.
     * @return La posición del Producto en el arreglo si exite de lo contrario -1
     */
    public int BuscaProducto(Producto producto){
        return arreglo.isEmpty()?-1:arreglo.indexOf(producto);
    }
    /**
     * Metodo de busqueda en el Arreglo por Genero.
     * @param Genero Genero del producto a buscar.
     * @return La posición del Producto en el arreglo si exite de lo contrario -1
     */
    public int BuscarGenero(String Genero){
        boolean ban=false;
        int pos = 0;
        for(int cont=0; cont!=arreglo.size(); cont++){
            if (arreglo.get(cont).getGenero().toUpperCase().equals(Genero.toUpperCase())){
                ban=true;
                pos=cont;
            }
            System.out.println("#"+arreglo.get(cont).getGenero().toUpperCase()+"#");
        }
        return ban?pos:-1;
    }
    /**
     * Da de alta un producto dentro del arreglo.
     * @param producto Objeto de tipo Producto para dar de alta.
     * @return true si el objeto se logro dar de alta y 
     * false si no se logro dar de alta.
     */
    public boolean Alta(Producto producto){
        return arreglo.add(producto);
    }
    /**
     * Da de alta a un producto dentro del arreglo.
     * @param Genero Genero del Producto.
     * @param Cantidad Cantidad del Producto.
     * @param Boleta Boleta del Producto.
     * @return true si el objeto se logro dar de alta y 
     * false si no se logro dar de alta.
     */
    public boolean Alta(String Genero, int Cantidad, double CostoUnitario, double PrecioVenta){
        return arreglo.add(new Producto(Genero,Cantidad,CostoUnitario,PrecioVenta));
    }
    /**
     * Da de baja a un producto dentro del arreglo.
     * @param producto Objeto de tipo Producto para dar de baja
     * @return true si el objeto se logro dar de baja y 
     * false si no se logro dar de baja.
     */
    public boolean Baja(Producto producto){
        return arreglo.remove(producto);
    }
    /**
     * Da de baja a un producto dentro del arreglo.
     * @param pos Posición a dar de baja.
     * @return true si el objeto se logro dar de baja y 
     * false si no se logro dar de baja.
     */
    public boolean Baja(int pos){
        new_producto=arreglo.get(pos);
        return Baja(new_producto);
    }
    /**
     * Muestra el número de alumnos.
     * @return Numero de alumnos que se encuentran en el Arreglo.
     */
    public int Tamaño(){
        return arreglo.size();
    }
    /**
     * Guarda los cambios en el archivo.
     * @return true si los cambios fueron exitosos, false si hubo un error.
     */
    public boolean Guardar(){
         String cambios = "";
         for (int cont=0; cont!=Tamaño();cont++){
             cambios=cambios+Consulta(cont).toString();
         }
         return archivo.Escribir(cambios, false);
    }
    public boolean VenderDisco(int cantidad){
         
                
    }
}
