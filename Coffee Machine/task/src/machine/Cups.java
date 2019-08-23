package machine;

class Cups {
    protected int water;
    protected int milk;
    protected int coffeeBeans;

    public Cups(int water, int milk, int coffeeBeans) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public Cups get() {
        return this;
    }
}

class CupsMachine extends Cups{
    private int disposableCups;
    private int money;

    public CupsMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        super(water, milk, coffeeBeans);
        this.disposableCups = disposableCups;
        this.money = money;
    }

    public Cups getCoffee(int type) {
        switch (type) {
            case 1:
                return new Cups(250, 0, 16);
            case 2:
                return new Cups(350, 75, 20);
            case 3:
                return new Cups(200, 100, 12);
        }
        return null;
    }

    public void fill(int water, int milk, int coffeeBeans, int disposableCups) {
        this.water += water;
        this.milk += milk;
        this.coffeeBeans += coffeeBeans;
        this.disposableCups += disposableCups;
    }

    public void take() {
        System.out.println("\n\nI gave you $" + money);
        money = 0;
    }

    private boolean getOneCups(int type) {
        Cups cups = getCoffee(type);
        if (water - cups.water >= 0) {
            water -= cups.water;
        } else {
            System.out.println("Sorry, not enough water!");
            return false;
        }
        if (milk - cups.milk >= 0) {
            milk -= cups.milk;
        } else {
            System.out.println("Sorry, not enough milk!");
            return false;
        }
        if (coffeeBeans - cups.coffeeBeans >= 0) {
            coffeeBeans -= cups.coffeeBeans;
        } else {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        }
        if (disposableCups - 1 >= 0) {
            disposableCups--;
        } else {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }

    public void addMoney(int type) {
        switch (type) {
            case 1:
                money += 4;
                break;
            case 2:
                money += 7;
                break;
            case 3:
                money += 6;
                break;
        }
    }

    public void buy(int type) {
        if (getOneCups(type)) {
            System.out.println("I have enough resources, making you a coffee!");
            addMoney(type);
        }
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void remaining() {
        System.out.println("\nThe coffee machine has:\n" +
                getWater() + " of water\n" +
                getMilk() + " of milk\n" +
                getCoffeeBeans() + " of coffee beans\n" +
                getDisposableCups() + " of disposable cups\n$" +
                getMoney() + " of money");
    }
}