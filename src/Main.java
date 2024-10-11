import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ExchangeRateApi api = new ExchangeRateApi();
            Conversor converter = new Conversor();
            InformacionMoneda rates = api.getExchangeRates();

            System.out.println("Conversor de monedas soportadas: USD, ARS, BRL, COP, BOB");

            while (true) {
                System.out.println("\nSeleccione el tipo de conversión:");
                System.out.println("1. USD a ARS");
                System.out.println("2. ARS a USD");
                System.out.println("3. USD a BRL");
                System.out.println("4. BRL a USD");
                System.out.println("5. USD a COP");
                System.out.println("6. COP a USD");
                System.out.println("7. USD a BOB");
                System.out.println("-1. Salir");

                int opcion = scanner.nextInt();

                if (opcion == -1) {
                    break;
                }

                String deMoneda;
                String aMoneda;

                switch (opcion) {
                    case 1:
                        deMoneda = "USD";
                        aMoneda = "ARS";
                        break;
                    case 2:
                        deMoneda = "ARS";
                        aMoneda = "USD";
                        break;
                    case 3:
                        deMoneda = "USD";
                        aMoneda = "BRL";
                        break;
                    case 4:
                        deMoneda = "BRL";
                        aMoneda = "USD";
                        break;
                    case 5:
                        deMoneda = "USD";
                        aMoneda = "COP";
                        break;
                    case 6:
                        deMoneda = "COP";
                        aMoneda = "USD";
                        break;
                    case 7:
                        deMoneda = "USD";
                        aMoneda = "BOB";
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtalo de nuevo.");
                        continue;
                }

                System.out.print("Ingrese la cantidad a convertir: ");
                double amount = scanner.nextDouble();

                double result = converter.convertirMoneda(amount, rates.getRate(deMoneda), rates.getRate(aMoneda));
                System.out.println("Resultado: " + amount + " " + deMoneda + " son " + result + " " + aMoneda);
            }

            System.out.println("Has salido del conversor.");
        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener las tasas de cambio: " + e.getMessage());
        }
    }
}