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
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Interfaz2 ui =  new Interfaz2();
        ui.setVisible(true);
        //Interfaz ui = new Interfaz();
        //ui.setVisible(true);
        /*Producto RockPop = new Producto("Rock Pop", 1200, 150.00,255.00);
        Producto Reggaeton = new Producto("Reggaeton", 800, 100.00,150.00);
        Producto Salsa = new Producto("Salsa", 1500, 110.00,165.00);
        Producto Metal = new Producto("Metal", 2000, 120.00,180.00);
        Producto ReggaetonMod = new Producto("Reggaeton", 900, 100.00,150.00);
        Inventario in = new Inventario("datos.txt");
        
        in.Alta(RockPop);
        in.Alta(Reggaeton);
        in.Alta(Salsa);
        in.Alta(Metal);
        in.ModificarCampo(Reggaeton, ReggaetonMod);
        in.Baja(2);
        in.Guardar();*/
        /*Inventario in = new Inventario("datos.txt");
        
        Producto RockPop = new Producto("Rock Pop", 1200, 150.00,255.00);
        Producto Reggaeton = new Producto("Reggaeton", 800, 100.00,150.00);
        Producto Salsa = new Producto("Salsa", 1500, 110.00,165.00);
        Producto Metal = new Producto("Metal", 2000, 120.00,180.00);
        Producto Banda = new Producto("Banda", 1800, 110.00,165.00);
        Producto Balada = new Producto("Balada", 900, 105.00,157.50);
        Producto Psycho = new Producto("Psycho", 500, 180.00,270.00);
        Producto RockAlternativo = new Producto("Rock Alternativo", 800, 140.00,210.00);
        Producto Boleros = new Producto("Boleros", 300, 90.00,135.00);
        Producto Cumbia = new Producto("Cumbia", 700, 105.00,157.50);
        
        in.Alta(RockPop);
        in.Alta(Reggaeton);
        in.Alta(Salsa);
        in.Alta(Metal);
        in.Alta(Banda);
        in.Alta(Balada);
        in.Alta(Psycho);
        in.Alta(RockAlternativo);
        in.Alta(Boleros);
        in.Alta(Cumbia);
        in.Guardar();
        in.Guardar();*/
        
        
    }
}
