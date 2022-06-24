
import java.util.Scanner;

public class OrderSystem {

    Gift gift = null;
    Scanner keyboard;

    public static void main (String[] args) {
        new OrderSystem().go();
    }

    private void go() {
        keyboard = new Scanner(System.in);

        int num;
        while (true) {
            System.out.println("    Menu      				");
            System.out.println("1: Order a Gift Basket  ");
            System.out.println("2: Change Gift Basket   ");
            System.out.println("3: Display Gift     	");
            System.out.println("9: Exit program     	");
            System.out.print("Enter your selection: ");
            num = keyboard.nextInt();
            switch (num) {
                case 1:
                    orderGift();
                    break;
                case 2:
                    System.out.println();
                    changeGiftBasket();
                    break;
                case 3:
                    System.out.println();
                    displayGift();
                    break;
                case 9:
                    System.out.println();
                    System.out.println("Thank you for using the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
                    System.out.println();
                    break;
            }
        }
    }


    public void orderGift() {

        System.out.print("Do you want Fruit Basket (1) or Sweets Basket (2)? ");
        boolean invalid;
        int basket = 0;
        do {
            invalid = false;
            try {
                basket = keyboard.nextInt();
                if (basket != 1 && basket != 2) invalid = true;
            } catch (Exception e) {
                System.out.println("Invalid Entry!");
                invalid = true;
            }
        } while (invalid);

        char size = enterSize();

        if (basket == 1) {
            System.out.print("Do you want citrus fruits included? true/false: ");
            boolean citrus = enterTF();
            if (citrus)
                gift = new FruitBasket(size, true);
            else
                gift = new FruitBasket(size);
        } else {
            System.out.print("Do you want nuts included? true/false: ");
            boolean nuts = enterTF();
            if (nuts)
                gift = new SweetsBasket(size, true);
            else
                gift = new SweetsBasket(size);
        }
        System.out.println();
    }

    private char enterSize() {
        boolean invalid;
        char size;
        do {
            invalid = false;
            System.out.print("What size do you want: S, M, or L: ");
            String str = keyboard.next();
            size = str.toUpperCase().charAt(0);
            String validSizes = "SML";
            int fnd = validSizes.indexOf(size);
            if (fnd < 0)
                invalid = true;
        } while (invalid);
        return size;
    }

    private boolean enterTF() {
        boolean bool = false, invalid;
        do {
            invalid = false;
            String str = keyboard.next().toLowerCase();
            if (str.equals("true")) bool = true;
            else if (!str.equals("false")) {
                System.out.println("You must enter true or false.");
                invalid = true;
            }
        } while (invalid);
        return bool;
    }

    public void changeGiftBasket () {
        if (gift == null) {
            System.out.println("No gift has been ordered yet.");
            System.out.println();
            return;
        }

        System.out.printf("Current gift size is: %c ", gift.getSize());
        gift.setSize(enterSize());

        if (gift instanceof FruitBasket) {
            FruitBasket fruitBasket = (FruitBasket) gift;
            System.out.printf("Current basket citrus=%b Do you want citrus fruits included? true/false: ", fruitBasket.isCitrus());
            fruitBasket.setCitrus(enterTF());
            gift = fruitBasket;
        } else {
            SweetsBasket sweetsBasket = (SweetsBasket) gift;
            System.out.printf("Current basket nuts=%b Do you want nuts included? true/false: ", sweetsBasket.isNuts());
            sweetsBasket.setNuts(enterTF());
            gift = sweetsBasket;
        }
        System.out.println();
    }

    public void displayGift() {
        if (gift == null)
            System.out.println("No gift has been ordered yet.");
        else
            System.out.println(gift);
        System.out.println();
    }
}
