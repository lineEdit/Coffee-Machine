package machine;

class Cups {
    int waterOneCups;
    int milkOneCups;
    int coffeeBeansOneCups;
    int haveWater;
    int havemilk;
    int haveCoffeeBeans;

    public Cups(int waterOneCups, int milkOneCups, int coffeeBeansOneCups) {
        this.waterOneCups = waterOneCups;
        this.milkOneCups = milkOneCups;
        this.coffeeBeansOneCups = coffeeBeansOneCups;
    }

    void setHave(int water, int milk, int coffeeBeans) {
        this.haveWater = water;
        this.havemilk = milk;
        this.haveCoffeeBeans = coffeeBeans;
    }

    private boolean getOneCups() {
        boolean enough = true;
        if (haveWater - waterOneCups >= 0) {
            haveWater -= waterOneCups;
        } else {
            enough = false;
        }
        if (havemilk - milkOneCups >= 0) {
            havemilk -= milkOneCups;
        } else {
            enough = false;
        }
        if (haveCoffeeBeans - coffeeBeansOneCups >= 0) {
            haveCoffeeBeans -= coffeeBeansOneCups;
        } else {
            enough = false;
        }
        return enough;
    }

    int getAllCups() {
        int cups = 0;
        while (getOneCups()) {
            cups++;
        }
        return cups;
    }
}

