
public class Main {


    public static void main(String[] args) {
        Interfaz ui = new Interfaz();
        ui.setVisible(true);
        
        /*Producto RockPop = new Producto();
        RockPop.Genero="Rock Pop";
        RockPop.Cantidad=1500;
        RockPop.CostoUnitario=200.00;
        RockPop.PrecioVenta=255.55;
        
        String rock;
        rock=RockPop.toString();
        System.out.println(rock);*/
        
        /*CargaProducto obj = new CargaProducto("datos.txt");
        Producto nuevo = new Producto();
        int opc;
        int aux;
        do{
            System.out.println("1.- Tamaño.");
            System.out.println("2.- Mostrar todo.");
            System.out.println("3.- Eliminar.");
            System.out.println("4.- Alta.");
            System.out.println("5.- Busqueda por genero.");
            System.out.println("6.- Guardar Cambios.");
            System.out.println("7.- Salir.");
            System.out.print("Teclee una opcion: ");
            opc = Leer.datoInt();
            switch (opc){
                case 1:
                    System.out.println("El número de registros es: "+
                            obj.Tamaño());
                break;
                case 2:
                    for (int cont=0; cont!=obj.Tamaño();cont++){
                        System.out.print("Registro "+cont+" :"+obj.Consulta(cont));
                    }                    
                break;
                case 3:
                    System.out.print("\nTeclee el elemento a eliminar: ");
                    System.out.print(obj.Baja(Leer.datoInt())?"Baja Exitosa":
                            "No se logro dar de baja");
                break;
                case 4:
                    System.out.print("\nTeclee el genero del disco: ");
                    nuevo.setGenero(Leer.dato());
                    System.out.print("\nTeclee la cantidad de discos: ");
                    nuevo.setCantidad(Leer.datoInt());
                    System.out.print("\nTeclee el costo unitario: ");
                    nuevo.setCostoUnitario(Leer.datoDouble());
                    System.out.print("\nTeclee el precio de venta: ");
                    nuevo.setPrecioVenta(Leer.datoDouble());
                    System.out.println(obj.Alta(nuevo)?"Alta Exitosa":
                            "No se logro dar de alta");
                break;
                case 5:
                    System.out.print("\nTeclee el nombre a buscar: ");
                    aux = obj.BuscarGenero(Leer.dato());
                    System.out.println(aux==-1?"Elemento no Encontrado":obj.Consulta(aux));
                break;
                case 6:                   
                    System.out.println(obj.Guardar()?"Guardado Exitoso":"Error al Guardar");
                default:
                break;
            }
            System.out.print("\n");
        }while(opc!=7);*/       
        
    }
}