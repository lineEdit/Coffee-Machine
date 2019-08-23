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
        itHas();
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
        itHas();
    }

    private boolean getOneCups(int type) {
        Cups cups = getCoffee(type);
        boolean enough = true;
        if (water - cups.water >= 0) {
            water -= cups.water;
        } else {
            enough = false;
        }
        if (milk - cups.milk >= 0) {
            milk -= cups.milk;
        } else {
            enough = false;
        }
        if (coffeeBeans - cups.coffeeBeans >= 0) {
            coffeeBeans -= cups.coffeeBeans;
        } else {
            enough = false;
        }
        if (disposableCups - 1 >= 0) {
            disposableCups--;
        } else {
            enough = false;
        }
        return enough;
    }

//    int getAllCups(Cups cups) {
//        int cupsExist = 0;
//        while (getOneCups(cups)) {
//            cupsExist++;
//        }
//        return cupsExist;
//    }

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
//            System.out.println("Yes, I can make that amount of coffee");
            addMoney(type);
            itHas();
        } else {
            System.out.println("No, I can make cup of coffee");
        }
    }

    public int getDisposableCups() {
        return disposableCups;
    }

    public int getMoney() {
        return money;
    }

    public void itHas() {
        System.out.println("The coffee machine has:\n" +
                getWater() + " of water\n" +
                getMilk() + " of milk\n" +
                getCoffeeBeans() + " of coffee beans\n" +
                getDisposableCups() + " of disposable cups\n" +
                getMoney() + " of money");
    }
}

class Espresso extends Cups {

    public Espresso(int water, int milk, int coffeeBeans) {
        super(water, milk, coffeeBeans);
        this.water = 250;
        this.milk = 0;
        this.coffeeBeans = 16;
    }
}

class Latte extends Cups {

    public Latte(int water, int milk, int coffeeBeans) {
        super(water, milk, coffeeBeans);
        this.water = 350;
        this.milk = 75;
        this.coffeeBeans = 20;
    }
}

class Cappuccino extends Cups {

    public Cappuccino(int water, int milk, int coffeeBeans) {
        super(water, milk, coffeeBeans);
        this.water = 200;
        this.milk = 100;
        this.coffeeBeans = 12;
    }
}

//abstract class Cups {
//    int waterOneCups;
//    int milkOneCups;
//    int coffeeBeansOneCups;
//    int haveWater;
//    int havemilk;
//    int haveCoffeeBeans;
//
//    public Cups(int water, int milk, int coffeeBeans) {
//        this.waterOneCups = 0;
//        this.milkOneCups = 0;
//        this.coffeeBeansOneCups = 0;
//
//        this.haveWater = water;
//        this.havemilk = milk;
//        this.haveCoffeeBeans = coffeeBeans;
//    }
//
//    private boolean getOneCups() {
//        boolean enough = true;
//        if (haveWater - waterOneCups >= 0) {
//            haveWater -= waterOneCups;
//        } else {
//            enough = false;
//        }
//        if (havemilk - milkOneCups >= 0) {
//            havemilk -= milkOneCups;
//        } else {
//            enough = false;
//        }
//        if (haveCoffeeBeans - coffeeBeansOneCups >= 0) {
//            haveCoffeeBeans -= coffeeBeansOneCups;
//        } else {
//            enough = false;
//        }
//        return enough;
//    }
//
//    int getAllCups() {
//        int cups = 0;
//        while (getOneCups()) {
//            cups++;
//        }
//        return cups;
//    }
//}
//
//class Espresso extends Cups {
//
//    public Espresso(int water, int milk, int coffeeBeans) {
//        super(water, milk, coffeeBeans);
//        this.waterOneCups = 250;
//        this.milkOneCups = 0;
//        this.coffeeBeansOneCups = 16;
//    }
//}
//
//class Latte extends Cups {
//
//    public Latte(int water, int milk, int coffeeBeans) {
//        super(water, milk, coffeeBeans);
//        this.waterOneCups = 350;
//        this.milkOneCups = 75;
//        this.coffeeBeansOneCups = 20;
//    }
//}
//
//class Cappuccino extends Cups {
//
//    public Cappuccino(int water, int milk, int coffeeBeans) {
//        super(water, milk, coffeeBeans);
//        this.waterOneCups = 200;
//        this.milkOneCups = 100;
//        this.coffeeBeansOneCups = 12;
//    }
//}
