import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion=1, diasEntregaPrev, cantidad;
        String localizador, direccionEnvio, dniCliente, fechaEnvio, codProducto;
        double peso;
        ArrayList<Paquete> misPaquetes =  new ArrayList<>();

        do {
            System.out.println("1. Dar de alta paquete vacio");
            System.out.println("2. Añadir producto a un paquete");
            System.out.println("3. Eliminar producto de un paquete");
            System.out.println("4. Buscar producto dentro de paquete");
            System.out.println("5. Listar paquetes (Ver estado)");
            System.out.println("6. Listar los productos de un paquete");
            System.out.println("Cualquier otra tecla para salir");
            opcion = Integer.valueOf(input.nextLine());

            switch (opcion){
                case 0: 
                    System.out.println("Finalizando el programa");
                    break;

                case 1: 
                    System.out.println("Introduzca el localizador");
                    localizador = input.nextLine();
                    System.out.println("Introduzca la direccion de envio");
                    direccionEnvio = input.nextLine();
                    System.out.println("Introduzca el DNI del cliente");
                    dniCliente = input.nextLine();
                    System.out.println("Introduzca la fecha de envio(año-dia-mes)");
                    fechaEnvio = input.nextLine();
                    System.out.println("Introduzca los dias esperados para ser entregado");
                    diasEntregaPrev = Integer.valueOf(input.nextLine());


                    Paquete miPaquete = new Paquete(localizador, direccionEnvio, dniCliente, fechaEnvio, diasEntregaPrev, 1);
                    misPaquetes.add(miPaquete);
                    System.out.println("");

                    break;
                case 2:
                    System.out.println("Intoduzca el localizador de un paquete para añadir productos");
                    localizador = input.nextLine();

                    for (Paquete paq: misPaquetes){
                        if (localizador.equals(paq.getLocalizador())){
                            if (paq.getEstado() == 1 || paq.getEstado() == 2){
                                System.out.println("Introduca codigo del producto");
                                codProducto = input.nextLine();
                                System.out.println("Introduzca la fecha de envio");
                                fechaEnvio = input.nextLine();
                                System.out.println("Introduzca la cantidad de este producto que desea añadir");
                                cantidad = Integer.valueOf(input.nextLine());
                                System.out.println("Introduzca el peso por unidad del producto");
                                peso = Double.valueOf(input.nextLine());
    
                                paq.addProducto(codProducto, fechaEnvio, cantidad, peso);
                                paq.setEstado(2);
                                break;
                                
                                
                            } else {
                                System.out.println("El pedido ya esta entregado o enviado");
                                break;
                            }

                        } else {
                            System.out.println("No se ha encontrado ningun paquete con ese localizador");
                            break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("Intoduzca el localizador de un paquete para eliminar productos");
                    localizador = input.nextLine();

                    for (Paquete paquete: misPaquetes){
                        if (localizador.equals(paquete.getLocalizador())){
                            if (paquete.getEstado() == 1 || paquete.getEstado() == 2){
                                System.out.println("Introduzca el codigo del producto que desea eliminar");
                                codProducto = input.nextLine();
                                
                                if (paquete.eliminarProducto(codProducto)){
                                    System.out.println("Producto eliminado correctamente");

                                    if (paquete.misProductos.isEmpty()){
                                        paquete.setEstado(1);
                                    }
                                    break;
                                    
                                } else {
                                    System.out.println("No se ha podido eliminar el producto");
                                    break;
                                }

                            } else {
                                System.out.println("El pedido ya esta entregado o enviado");
                                break;
                            }

                        } else {
                            System.out.println("No se ha encontrado ningun paquete con ese localizador");
                            break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Intoduzca el localizador del paquete");
                    localizador = input.nextLine(); 
                    
                    for (Paquete paquete: misPaquetes){
                        if (localizador.equals(paquete.getLocalizador())){
                            System.out.println("Intoduzca el codigo del producto");
                            codProducto = input.nextLine();
                            
                            System.out.println(paquete.mostrarProducto(codProducto));
                            break;
                        }
                    }
                    
                    break;

                case 5:
                    for (Paquete paquete: misPaquetes){
                        System.out.println("Codigo Paquete: " + paquete.getLocalizador() + " Estado: " + paquete.getEstado());
                    }

                    break;
                case 6:
                    System.out.println("Intoduzca el localizador del paquete del que quiera ver los productos");
                    localizador = input.nextLine();
                    
                    for (Paquete paquete: misPaquetes){
                        if (localizador.equals(paquete.getLocalizador())){
                            for (Producto producto: paquete.misProductos){
                                System.out.println("Codigo Paquete: " + producto.getCodProducto() + " Cantidad: " + producto.getCantidad() + " Descripcion: " + producto.getDescripcion() + " Peso: " + producto.getPesoUnidad());
                            }
                        }
                    }

                    break;
                default:
                    System.out.println("Elija una opcion valida por favor");
            }
        } while (opcion != 0);

        input.close();
    }
}