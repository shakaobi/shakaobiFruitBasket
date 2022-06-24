import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SweetsBasketTest {

    @Test
    @Order(1)
    void test1() {
        SweetsBasket sweetsBasket = new SweetsBasket(Gift.SMALL, true);
        assertAll(
                () -> assertEquals("SB1", sweetsBasket.getId()),
                () -> assertEquals(Gift.SMALL, sweetsBasket.getSize()),
                () -> assertTrue(sweetsBasket.isNuts()),
                () -> assertEquals(19.99, sweetsBasket.getPrice(), .0001),
                () -> assertEquals("SweetsBasket [haveNuts=true size=S id=SB1 price=19.99]",
                        sweetsBasket.toString())
        );
        sweetsBasket.setSize(Gift.MEDIUM);
        sweetsBasket.setNuts(false);
        assertEquals("SweetsBasket [haveNuts=false size=M id=SB1 price=29.99]",
                sweetsBasket.toString());
    }

    @Test
    @Order(2)
    void test2() {
        SweetsBasket sweetsBasket = new SweetsBasket(Gift.MEDIUM);
        assertAll(
                () -> assertEquals("SB2", sweetsBasket.getId()),
                () -> assertEquals(Gift.MEDIUM, sweetsBasket.getSize()),
                () -> assertFalse(sweetsBasket.isNuts()),
                () -> assertEquals(29.99, sweetsBasket.getPrice(), .0001),
                () -> assertEquals("SweetsBasket [haveNuts=false size=M id=SB2 price=29.99]",
                        sweetsBasket.toString())
        );
        sweetsBasket.setSize(Gift.LARGE);
        sweetsBasket.setNuts(true);
        assertEquals("SweetsBasket [haveNuts=true size=L id=SB2 price=39.99]",
                sweetsBasket.toString());
    }

    @Test
    @Order(3)
    void test3() {
        SweetsBasket sweetsBasket = new SweetsBasket(Gift.LARGE, true);
        assertAll(
                () -> assertEquals("SB3", sweetsBasket.getId()),
                () -> assertEquals(Gift.LARGE, sweetsBasket.getSize()),
                () -> assertTrue(sweetsBasket.isNuts()),
                () -> assertEquals(39.99, sweetsBasket.getPrice(), .0001),
                () -> assertEquals("SweetsBasket [haveNuts=true size=L id=SB3 price=39.99]",
                        sweetsBasket.toString())
        );
        sweetsBasket.setSize(Gift.SMALL);
        sweetsBasket.setNuts(false);
        assertEquals("SweetsBasket [haveNuts=false size=S id=SB3 price=19.99]",
                sweetsBasket.toString());
    }
}