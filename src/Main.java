import java.time.LocalDateTime;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Parking parking = new Parking();

        System.out.println("Informe a data e hora de entrada do automóvel (yyyy-MM-ddTHH:mm):");
        String entryRecord = in.nextLine();
        LocalDateTime entry = LocalDateTime.parse(entryRecord);

        System.out.println("Informe a data e hora de saída do automóvel (yyyy-MM-ddTHH:mm):");
        String checkoutRecord = in.nextLine();
        LocalDateTime checkout = LocalDateTime.parse(checkoutRecord);

        System.out.println("Cliente VIP? (true/false): ");
        boolean isVip = Boolean.parseBoolean(in.nextLine());

        double parkingFee = parking.calculateFee(entry, checkout, isVip);

        System.out.printf("A tarifa do estacionamento é de %.2f reais.", parkingFee);
    }
}