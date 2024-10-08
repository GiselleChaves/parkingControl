import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Parking {
    private static final double FREE_PARKING_FEE = 0.0;
    private static final double FIXED_FEE_FOR_1H = 5.90;
    private static final double EXTRA_HOURLY_FEE = 2.50;
    private static final double OVERNIGHT_FEE = 50.00;
    private static final int FREE_MINUTES = 15;

    public double calculateFee(LocalDateTime entry, LocalDateTime exit, boolean isVIPClient) {
        long stayDurationInMinutes = ChronoUnit.MINUTES.between(entry, exit);

        // If free parking
        if (stayDurationInMinutes <= FREE_MINUTES) {
            return FREE_PARKING_FEE;
        }

        // If for up to 1 hour
        if (stayDurationInMinutes <= 60) {
            return applyDiscount(isVIPClient, FIXED_FEE_FOR_1H);
        }

        // Calculate additional hours
        long additionalHours = (stayDurationInMinutes - 60) / 60;

        // If overnight stay
        if (exit.getHour() < entry.getHour() || exit.isAfter(entry.withHour(8).plusDays(1))) {
            return applyDiscount(isVIPClient, OVERNIGHT_FEE);
        }

        double totalFee = FIXED_FEE_FOR_1H + (additionalHours * EXTRA_HOURLY_FEE);
        return applyDiscount(isVIPClient, totalFee);
    }

    private double applyDiscount(boolean isVIPClient, double fee) {
        if (isVIPClient) {
            return fee * 0.5; //for vips
        }
        return fee;
    }
}
