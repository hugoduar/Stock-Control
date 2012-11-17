import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {
   private File f;   
   /**
    * Constructor de la clase Archivo.
    */
   public Archivo(){}
   /**
    * Constructor de la clase Archivo.
    * @param path Dirección del archivo.
    */
   public Archivo(String path){
       f = new File(path);
   }           
   /**
    * Muestra la información en consola del archivo.
    * @param path Dirección del archivo
    */
   public void Informacion(String path){
        f = new File(path);
        System.out.println("Nombre: "+f.getName());
        System.out.println("Ruta: "+f.getPath());
        if(f.exists()){
            System.out.println("El fichero existe");
            System.out.println((f.canRead()?"Si se puede leer":"No se puede leer"));
            System.out.println((f.canWrite()?"Si se puede escribir":"No se puede escribir"));
            System.out.println("La longuitud es: "+f.length()+" en bytes");          
        }else{
            System.out.println("El fichero no existe.");
        }
    }
    /**
     * Lee el contenido del archivo.
     * @return La información contenida en el archivo.
     */
    public String Leer(){
        FileReader fr;   
        char buffer[] = new char[100];
        try {
            fr = new FileReader(f);
            fr.read(buffer);
            fr.close();
        } catch (IOException ex) {
            buffer = null;
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String(buffer).trim();
    }
    /**
     * Escribe la información dada sobre el archivo en manipulación.
     * @param cadena Información a escribir.
     * @param sobreescribir false si se desea sobreescribir el fichero, 
     * true si se desea agregar información al fichero.
     * @return true si logro escribir, false si el proceso fallo.
     */
    public boolean Escribir(String cadena, boolean sobreescribir){
        FileWriter fw;
        try {
            fw = new FileWriter(f, sobreescribir);
            fw.write(cadena);
            fw.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }    
}
