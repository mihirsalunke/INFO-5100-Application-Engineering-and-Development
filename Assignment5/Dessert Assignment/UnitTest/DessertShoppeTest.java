import org.junit.Before;
import org.junit.Test;

import java.util.Vector;

import static org.junit.Assert.assertEquals;

public class DessertShoppeTest() {
    private DessertShoppe dessertShoppe;
    private static final String EXPECTED_CENTS = "1.01";

    public void init() {
        dessertShoppe = new DessertShoppe();
    }

    public void cents2dollarsAndCentsTest() {
        assertEquals(EXPECTED_CENTS, dessertShoppe.cents2dollarsAndCents(101));
    }
}