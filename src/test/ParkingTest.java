import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions;

public class ParkingTest {

    @Test
    public void testVIPClientDiscount() {
        Parking parking = new Parking();
        LocalDateTime entry = LocalDateTime.of(2024, 10, 8, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2024, 10, 8, 10, 0);

        double fee = parking.calculateFee(entry, exit, true);
        assertEquals(2.95, fee); 

        exit = LocalDateTime.of(2024, 10, 8, 12, 0);
        fee = parking.calculateFee(entry, exit, true);
        assertEquals(7.40, fee); 

        exit = LocalDateTime.of(2024, 10, 9, 9, 0);
        fee = parking.calculateFee(entry, exit, true);
        assertEquals(25.00, fee); 
    }

    @Test
    public void testFreeParking() {
        Parking parking = new Parking();
        LocalDateTime entry = LocalDateTime.of(2024, 10, 8, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2024, 10, 8, 9, 10);

        double fee = parking.calculateFee(entry, exit, false);
        assertEquals(0.0, fee); 
    }

    @Test
    public void testFixedFeeFor1Hour() {
        Parking parking = new Parking();
        LocalDateTime entry = LocalDateTime.of(2024, 10, 8, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2024, 10, 8, 10, 0);

        double fee = parking.calculateFee(entry, exit, false);
        assertEquals(5.90, fee); 
    }

    @Test
    public void testAdditionalHourlyFee() {
        Parking parking = new Parking();
        LocalDateTime entry = LocalDateTime.of(2024, 10, 8, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2024, 10, 8, 11, 0);

        double fee = parking.calculateFee(entry, exit, false);
        assertEquals(8.40, fee); 
    }

    @Test
    public void testOvernightFee() {
        Parking parking = new Parking();
        LocalDateTime entry = LocalDateTime.of(2024, 10, 8, 9, 0);
        LocalDateTime exit = LocalDateTime.of(2024, 10, 9, 9, 0);
        
        double fee = parking.calculateFee(entry, exit, false);
        assertEquals(50.00, fee); 
    }
}
