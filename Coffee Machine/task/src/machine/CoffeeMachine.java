package machine;

import java.util.Scanner;

//Write how many ml of water the coffee machine has: 300
//Write how many ml of milk the coffee machine has: 65
//Write how many grams of coffee beans the coffee machine has: 100
//Write how many cups of coffee you will need: 1

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has: ");
        int water = scanner.nextInt();
        System.out.print("Write how many ml of milk the coffee machine has: ");
        int milk = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeans = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need: ");
        int need = scanner.nextInt();

        Cups cups = new Cups(200, 50, 15);
        cups.setHave(water, milk, coffeeBeans);
        int haveCups = cups.getAllCups();
        if (haveCups == need) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (haveCups < need) {
            System.out.println("No, I can make only " + haveCups + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + (haveCups-1) + " more than that)");
        }
    }
}
