import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FruitBasketTest {

    @Test
    @Order(1)
    void test1() {
        FruitBasket fruitBasket = new FruitBasket(Gift.SMALL, true);
        assertAll(
            () -> assertEquals("FB1", fruitBasket.getId()),
            () -> assertEquals(Gift.SMALL, fruitBasket.getSize()),
            () -> assertTrue(fruitBasket.isCitrus()),
            () -> assertEquals(25.98, fruitBasket.getPrice(), .0001),
            () -> assertEquals("FruitBasket [numFruits=6 haveCitrus=true size=S id=FB1 price=25.98]",
                fruitBasket.toString())
        );
        fruitBasket.setSize(Gift.MEDIUM);
        fruitBasket.setCitrus(false);
        assertEquals("FruitBasket [numFruits=9 haveCitrus=false size=M id=FB1 price=29.99]",
                fruitBasket.toString());
    }

    @Test
    @Order(2)
    void test2() {
        FruitBasket fruitBasket = new FruitBasket(Gift.MEDIUM);
        assertAll(
            () -> assertEquals("FB2", fruitBasket.getId()),
            () -> assertEquals(Gift.MEDIUM, fruitBasket.getSize()),
            () -> assertFalse(fruitBasket.isCitrus()),
            () -> assertEquals(29.99, fruitBasket.getPrice(), .0001),
            () -> assertEquals("FruitBasket [numFruits=9 haveCitrus=false size=M id=FB2 price=29.99]",
                fruitBasket.toString())
        );
        fruitBasket.setSize(Gift.LARGE);
        fruitBasket.setCitrus(true);
        assertEquals("FruitBasket [numFruits=15 haveCitrus=true size=L id=FB2 price=45.98]",
                fruitBasket.toString());
    }

    @Test
    @Order(3)
    void test3() {
        FruitBasket fruitBasket = new FruitBasket(Gift.LARGE, true);
        assertAll(
                () -> assertEquals("FB3", fruitBasket.getId()),
                () -> assertEquals(Gift.LARGE, fruitBasket.getSize()),
                () -> assertTrue(fruitBasket.isCitrus()),
                () -> assertEquals(45.98, fruitBasket.getPrice(), .0001),
                () -> assertEquals("FruitBasket [numFruits=15 haveCitrus=true size=L id=FB3 price=45.98]",
                    fruitBasket.toString())
        );
        fruitBasket.setSize(Gift.SMALL);
        fruitBasket.setCitrus(false);
        assertEquals("FruitBasket [numFruits=6 haveCitrus=false size=S id=FB3 price=19.99]",
                fruitBasket.toString());
    }
}