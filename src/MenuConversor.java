import java.io.IOException;

public class MenuConversor {
    public void gestionDeMoneda(int tipoCambio, double cantidad) throws IOException, InterruptedException {
        String monedaOrigen;
        String monedaDestino;
        switch (tipoCambio) {
            case 1:
                monedaOrigen = "USD";
                monedaDestino = "MXN";
                break;
            case 2:
                monedaOrigen = "EUR";
                monedaDestino = "MXN";
                break;
            case 3:
                monedaOrigen = "BRL";
                monedaDestino = "MXN";
                break;
            case 4:
                monedaOrigen = "ARS";
                monedaDestino = "MXN";
                break;
            case 5:
                monedaOrigen = "CLP";
                monedaDestino = "MXN";
                break;
            case 6:
                monedaOrigen = "MXN";
                monedaDestino = "BRL";
                break;
            case 7:
                monedaOrigen = "MXN";
                monedaDestino = "USD";
                break;
            case 8:
                monedaOrigen = "MXN";
                monedaDestino = "ARS";
                break;
            default:
                System.out.println("Opcion no valida, elija un tipo de cambio valido.");
                return;
        }

        ApiRequest api = new ApiRequest();
        ApiResponse respuesta = api.convertir(monedaOrigen);
        if (respuesta.result().equals("success")) {
            double resultado = (Double)respuesta.conversion_rates().get(monedaDestino) * cantidad;
            String fechaActualizacion = respuesta.time_last_update_utc();
            mostrarResultado(cantidad, monedaOrigen, resultado, monedaDestino, fechaActualizacion);
        } else {
            System.out.println("Hubo un problema, intentelo de nuevo mas tarde.");
        }

    }

    public static void mostrarResultado(double cantidad, String monedaOrigen, double resultado, String monedaDestino, String fechaActualizacion) {
        System.out.println("========================================");
        System.out.println("         Conversion de Moneda           ");
        System.out.println("----------------------------------------");
        System.out.printf("Cantidad ingresada: %.2f %s%n", cantidad, monedaOrigen);
        System.out.printf("Resultado: %.2f %s%n", resultado, monedaDestino);
        System.out.println("----------------------------------------");
        System.out.println("Ultima actualizacion de tasas: ");
        System.out.println(fechaActualizacion);
        System.out.println("========================================");
        System.out.println("Deseas hacer otra conversion?");
        System.out.println("1. Salir");
        System.out.println("2. Hacer otra conversion");
    }
}
