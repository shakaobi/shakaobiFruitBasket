public class SweetsBasket extends Gift {
	
	private boolean nuts;

	private static int nextId = 1;

	public SweetsBasket(char size, boolean nuts) {
		super("SB" + nextId++, size);
		this.nuts = nuts;
	}

	public SweetsBasket(char size) {
		this(size, false);
	}

	public boolean isNuts() {
		return nuts;
	}

	public void setNuts(boolean nuts) {
		this.nuts = nuts;
	}

	@Override
	public String toString() {
		return "SweetsBasket [" +
				"haveNuts=" + nuts +
				super.toString() +
				']';
	}
}