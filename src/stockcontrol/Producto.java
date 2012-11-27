
package stockcontrol;

import java.io.*;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.375911D9-A68D-9048-27B8-C9375E0B2F42]
// </editor-fold> 
public class Producto implements Serializable {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.CA641892-B741-1363-2A28-E1DAE3BF1571]
    // </editor-fold> 
    String producto;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.924095EC-88EE-A7BF-E38E-DAA4124AA863]
    // </editor-fold> 
    int cantidad;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.50335848-F70D-111D-A4C0-9F1D45F9B6E7]
    // </editor-fold> 
    double precioUnitario;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D5859200-341E-03EB-7334-6D134628677E]
    // </editor-fold> 
    double precioFinal;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.8096105E-C7FA-50DF-3357-A81AB1CA4D7B]
    // </editor-fold> 
    public Producto () {
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B239D9DD-1B79-423C-2CFE-D1024B950EAB]
    // </editor-fold> 
    public Producto (String producto, int cantidad, double precioUnitario, double precioFinal) {
        this.producto=producto;
        this.cantidad=cantidad;
        this.precioUnitario=precioUnitario;
        this.precioFinal=precioFinal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.034D0BD9-AA4E-9081-C4D0-EC8C23E3F80D]
    // </editor-fold> 
    public void setproducto (String Producto) {
        this.producto=Producto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.39665930-C4B8-4982-608A-5AF7C6E50898]
    // </editor-fold> 
    public String getproducto () {
        return this.producto;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.AFB4271D-622A-8C9F-B518-BEECFA9BA1DA]
    // </editor-fold> 
    public void setcantidad (int cantidad) {
        this.cantidad=cantidad;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.2EB5C3D5-CFFA-1C16-BA56-977890177181]
    // </editor-fold> 
    public int getcantidad () {
        return this.cantidad;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.D9C9115A-FF86-DA25-4E1A-DA1EDFCFC00D]
    // </editor-fold> 
    public void setprecioUnitario (double precioUnitario) {
        this.precioUnitario=precioUnitario; 
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.EF5CF0A9-BE4B-00F3-D52D-12CDDAE24096]
    // </editor-fold> 
    public double getprecioUnitario () {
        return this.precioUnitario;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B1EDD0FD-69C1-5704-C013-46309017E15C]
    // </editor-fold> 
    public void setprecioFinal (double precioFinal) {
        this.precioFinal=precioFinal; 
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B847C6B1-297E-F722-A922-E4F59B0E3092]
    // </editor-fold> 
    public double getprecioFinal () {
        return this.precioFinal;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.0DF08866-BA53-A2CE-2675-5353BBD40694]
    // </editor-fold> 
    public String toString () {
        return getproducto()+";"+Integer.toString(getcantidad())+";"+String.valueOf(getprecioUnitario())+";"+String.valueOf(getprecioFinal());
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.DBE6006B-B70C-A105-CFB2-F37F0D525FE5]
    // </editor-fold> 
    public void serializar (String archivo) throws java.io.IOException {
	FileOutputStream fos = new FileOutputStream(archivo);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(this);
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.5C6B4024-9B63-5C3A-8253-58A51AEEEA9B]
    // </editor-fold> 
    public Producto construir (String archivo) throws java.io.IOException, Exception {			
        FileInputStream fis = new FileInputStream(archivo);
	ObjectInputStream ois = new ObjectInputStream(fis);
	return (Producto)ois.readObject();		
			
    }
}
