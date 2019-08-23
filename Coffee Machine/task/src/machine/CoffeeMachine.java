package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        CupsMachine cupsMachine = new CupsMachine(1200,
                540,
                120,
                9,
                550);

        cupsMachine.itHas();
        Input input = Input.getInstance();
        switch (input.getString("Write action (buy, fill, take): ")) {
            case "buy":
                cupsMachine.buy(input.getInt("What do you want to buy? " +
                        "1 - espresso, " +
                        "2 - latte, " +
                        "3 - cappuccino: "));
                break;
            case "fill":
                cupsMachine.fill(
                        input.getInt("Write how many ml of water do you want to add: "),
                        input.getInt("Write how many ml of milk do you want to add: "),
                        input.getInt("Write how many grams of coffee beans do you want to add: "),
                        input.getInt("Write how many disposable cups of coffee do you want to add: ")
                        );
                break;
            case "take":
                cupsMachine.take();
                break;
        }
    }
}
