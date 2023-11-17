package christmas.domain.menusheet;

public enum DrinkList {
    ZeroCoke("제로콜라", 3000),
    RedWine("레드와인", 60000),
    Champagne("샴페인", 25000);
    private final String name;
    private final Integer price;

    DrinkList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static DrinkList getDrink(String name) {
        for (DrinkList drink : DrinkList.values()) {
            if (drink.getMenuName().equals(name)) {
                return drink;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isDrink(String menuName) {
        for (DrinkList drink : DrinkList.values()) {
            if (drink.getMenuName().equals(menuName)) {
                return true;
            }
        }
        return false;
    }

    public String getMenuName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }
}
