import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("max");
        Movie m1 = new Movie("movie0", 1);
        Movie m2 = new Movie("movie1", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        customer.addRental(r1);
        customer.addRental(r2);
    }

    @Test
    void statement() {
        String expected = "Rental Record for max\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie0\t\t10\t30.0\n" +
                "\tmovie1\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        String result = customer.statement();
        Assertions.assertEquals(expected, result);
    }
}
