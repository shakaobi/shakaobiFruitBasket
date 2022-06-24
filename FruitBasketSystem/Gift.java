public abstract class Gift {
    private final String id;
    private char size;
    private double price;

    public static char SMALL = 'S';
    public static char MEDIUM = 'M';
    public static char LARGE = 'L';
    private static final char[] sizes = new char[] {'S', 'M', 'L'};
    private static final double[] prices = new double[]{19.99, 29.99, 39.99};

    /**
     * Constructor
     * @param id The id number of basket
     * @param size The size of basket
     */

    public Gift(String id, char size) {
        this.id = id;
        this.size = size;
        this.price = prices[getPriceForSize(this.size)];
    }

    private int getPriceForSize(char size) {
        if (size == MEDIUM) return 1;
        if (size == LARGE)  return 2;
        return 0;
    }

    public String getId() {
        return id;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        if (this.size == size) return;
        this.price -= prices[getPriceForSize(this.size)];
        this.price += prices[getPriceForSize(size)];
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {this.price = price;}

    @Override
    public String toString() {
        return  " size=" + getSize() +
                " id=" + getId() +
                " price=" + getPrice();
    }
}