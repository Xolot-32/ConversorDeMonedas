import java.util.Scanner;
import java.util.List;
public class UserInterface {
    private CurrencyConversionService conversionService;
    private ConversionHistory history;
    private Scanner scanner;

    // Códigos ANSI para colores y estilos
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";

    public UserInterface(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
        this.scanner = new Scanner(System.in);
        this.history = new ConversionHistory();
    }

    public void start() {
        printWelcome();
        while (true) {
            showMenu();
            int option = getValidOption();
            switch (option) {
                case 0:
                    printGoodbye();
                    return;
                case 9:
                    showHistory();
                    break;
                default:
                    performConversion(option);
                    break;
            }
        }
    }

    private void printWelcome() {
        System.out.println(BOLD + BLUE + "╔════════════════════════════════════════╗");
        System.out.println("║   Bienvenido al Conversor de Moneda    ║");
        System.out.println("╚════════════════════════════════════════╝" + RESET);
    }

    private void showMenu() {
        System.out.println(BOLD + YELLOW + "\n   --- Opciones de Conversión ---" + RESET);
        System.out.println(GREEN + "1) Dólar >> Peso argentino");
        System.out.println("2) Peso argentino >> Dólar");
        System.out.println("3) Dólar >> Real brasileño");
        System.out.println("4) Real brasileño >> Dólar");
        System.out.println("5) Dólar >> Peso colombiano");
        System.out.println("6) Peso colombiano >> Dólar");
        System.out.println("7) Dólar >> Peso Mexicano");
        System.out.println("8) Peso Mexicano >> Dólar");
        System.out.println("9) Ver historial de conversiones");
        System.out.println(RED + "0) Salir" + RESET);

    }

    private int getValidOption() {
        while (true) {
            System.out.print(BOLD + "Elija una opción: " + RESET);
            try {
                int option = Integer.parseInt(scanner.nextLine());
                if (option >= 0 && option <= 9) {
                    return option;
                } else {
                    System.out.println(RED + "Opción no válida. Intente de nuevo." + RESET);
                }
            } catch (NumberFormatException e) {
                System.out.println(RED + "Por favor, ingrese un número válido." + RESET);
            }
        }
    }

    private void performConversion(int option) {
        System.out.print(BOLD + "Ingrese el valor a convertir: " + RESET);
        try {
            double amount = Double.parseDouble(scanner.nextLine());
            Currency fromCurrency, toCurrency;
            switch (option) {
                case 1: fromCurrency = Currency.USD; toCurrency = Currency.ARS; break;
                case 2: fromCurrency = Currency.ARS; toCurrency = Currency.USD; break;
                case 3: fromCurrency = Currency.USD; toCurrency = Currency.BRL; break;
                case 4: fromCurrency = Currency.BRL; toCurrency = Currency.USD; break;
                case 5: fromCurrency = Currency.USD; toCurrency = Currency.COP; break;
                case 6: fromCurrency = Currency.COP; toCurrency = Currency.USD; break;
                case 7: fromCurrency = Currency.USD; toCurrency = Currency.MXN; break;
                case 8: fromCurrency = Currency.MXN; toCurrency = Currency.USD; break;
                default: return;
            }

            double result = conversionService.convert(amount, fromCurrency, toCurrency);
            ConversionRecord record = new ConversionRecord(fromCurrency, toCurrency, amount, result);
            history.addRecord(record);
            System.out.printf(BOLD + GREEN + "Resultado: %.2f %s = %.2f %s%n" + RESET,
                    amount, fromCurrency, result, toCurrency);
        } catch (NumberFormatException e) {
            System.out.println(RED + "Por favor, ingrese un número válido." + RESET);
        }
    }
    private void showHistory() {
        List<ConversionRecord> records = history.getHistory();
        if (records.isEmpty()) {
            System.out.println(YELLOW + "No hay conversiones en el historial." + RESET);
        } else {
            System.out.println(BOLD + BLUE + "Historial de Conversiones:" + RESET);
            for (int i = records.size() - 1; i >= 0; i--) {
                System.out.println(GREEN + records.get(i) + RESET);
            }
        }
    }
    private void printGoodbye() {
        System.out.println(BOLD + BLUE + "\n╔═════════════════════════════════════════╗");
        System.out.println("║¡Gracias por usar el Conversor de Moneda!║");
        System.out.println("╚═════════════════════════════════════════╝" + RESET);
    }
}