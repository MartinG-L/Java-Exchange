import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        MenuConversor menu = new MenuConversor();

        while(true) {
            System.out.println("\n==============================");
            System.out.println("       CONVERSOR DE MONEDAS       ");
            System.out.println("==============================");
            System.out.println("Elige el tipo de cambio:");
            System.out.println("1. USD (Dolar estadounidense) a MXN (Peso Mexicano)");
            System.out.println("2. EUR (Euro) a MXN (Peso Mexicano)");
            System.out.println("3. BRL (Real brasileño) a MXN (Peso Mexicano)");
            System.out.println("4. ARS (Peso Argentino) a MXN (Peso Mexicano)");
            System.out.println("5. CLP (Peso Colombiano) a MXN (Peso Mexicano)");
            System.out.println("6. MXN (Peso Mexicano) a BRL (Real brasileño)");
            System.out.println("7. MXN (Peso Mexicano) a USD (Dolar estadounidense)");
            System.out.println("8. MXN (Peso Mexicano) a ARS (Peso Argentino)");
            System.out.println("9. Salir");
            System.out.println("==============================");
            System.out.print("Selecciona una opcion: ");
            if (lectura.hasNextInt()) {
                int opcionMenu = lectura.nextInt();
                if (opcionMenu == 9) {
                    System.out.println("Gracias por usar el conversor. Hasta pronto!");
                    break;
                }

                if (opcionMenu >= 1 && opcionMenu <= 9) {
                    System.out.println("Elige la cantidad a convertir: ");
                    if (lectura.hasNextDouble()) {
                        double cantidadCambio = lectura.nextDouble();
                        menu.gestionDeMoneda(opcionMenu, cantidadCambio);
                        if (lectura.hasNextInt()) {
                            int nuevaConversion = lectura.nextInt();
                            if (nuevaConversion == 1) {
                                System.out.println("Gracias por usar el conversor. Hasta pronto!");
                                break;
                            }

                            if (nuevaConversion != 2) {
                                System.out.println("Opcion no valida. Regresando al menu principal...");
                            }
                        } else {
                            System.out.println("Numero no valido");
                            lectura.next();
                        }
                    } else {
                        System.out.println("Por favor ingresa un numero valido para la cantidad.");
                        lectura.next();
                    }
                } else {
                    System.out.println("Por favor selecciona una opcion válida del menú (1-9).");
                }
            } else {
                System.out.println("Ingresa un numero Valido");
                lectura.next();
            }
        }
    }
}