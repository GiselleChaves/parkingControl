//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Scanner scanner = new Scanner(System.in);
    Estacionamento estacionamento = new Estacionamento();

    // Solicita ao usuário as informações de entrada
        System.out.println("Informe a data e hora de entrada (formato: yyyy-MM-ddTHH:mm): ");
    String entradaTexto = scanner.nextLine();
    LocalDateTime entrada = LocalDateTime.parse(entradaTexto);

        System.out.println("Informe a data e hora de saída (formato: yyyy-MM-ddTHH:mm): ");
    String saidaTexto = scanner.nextLine();
    LocalDateTime saida = LocalDateTime.parse(saidaTexto);

        System.out.println("O cliente é VIP? (true/false): ");
    boolean isVip = Boolean.parseBoolean(scanner.nextLine());

    // Calcula o valor da tarifa
    double tarifa = estacionamento.calcularTarifa(entrada, saida, isVip);

    // Exibe o valor da tarifa calculada
        System.out.println("Tarifa calculada: R$ " + tarifa);
}