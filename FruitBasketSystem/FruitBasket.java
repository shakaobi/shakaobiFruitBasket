
public class FruitBasket extends Gift {

	private boolean citrus;
   
    private static int nextId = 1;
    private static final double fruitPrice = 5.99;

    public FruitBasket(char size, boolean citrus) {
        super("FB" + nextId++, size);
        this.citrus = citrus;
        if (isCitrus()) {
            double price = getPrice();
            super.setPrice(Math.round((price + fruitPrice) * 100.0) / 100.0);
        }
    }
    public FruitBasket(char size) {
        this(size, false);
    }

    public FruitBasket(FruitBasket fb) {    // Copy Constructor
        this(fb.getSize(), fb.isCitrus());
    }

    public boolean isCitrus() {
        return citrus;
    }

    public void setCitrus(boolean citrus) {
        if (this.citrus == citrus) return;
        double price = getPrice();
        if (!isCitrus() && citrus) super.setPrice(Math.round((price + fruitPrice) * 100.0) / 100.0);
        else                       super.setPrice(Math.round((price - fruitPrice) * 100.0) / 100.0);
        this.citrus = citrus;
    }

    private int getNumberOfFruit() {
        if (getSize() == SMALL) return 6;
        if (getSize() == MEDIUM) return 9;
        return 15;
    }

    @Override
    public String toString() {
        return "FruitBasket [" +
                "numFruits=" + getNumberOfFruit() +
                " haveCitrus=" + isCitrus() +
                super.toString() +
                ']';
    }
}