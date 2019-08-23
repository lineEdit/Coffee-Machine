package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        CupsMachine cupsMachine = new CupsMachine(
                400,
                540,
                120,
                9,
                550);

        Input input = Input.getInstance();
        boolean run = true;
        while (run) {
            switch (input.getString("\nWrite action (buy, fill, take, remaining, exit): ")) {
                case "buy":
                    String str = input.getString("What do you want to buy? " +
                            "1 - espresso, " +
                            "2 - latte, " +
                            "3 - cappuccino, " +
                            "back - to main menu: ");
                    if (!str.equals("back")) {
                        cupsMachine.buy(Integer.parseInt(str));
                    }
                    break;
                case "fill":
                    cupsMachine.fill(
                            input.getInt("\nWrite how many ml of water do you want to add: "),
                            input.getInt("Write how many ml of milk do you want to add: "),
                            input.getInt("Write how many grams of coffee beans do you want to add: "),
                            input.getInt("Write how many disposable cups of coffee do you want to add: ")
                    );
                    System.out.println();
                    break;
                case "take":
                    cupsMachine.take();
                    break;
                case "remaining":
                    cupsMachine.remaining();
                    break;
                case "exit":
                    run = false;
                    break;
            }
        }
    }
}
