package christmas.domain.menusheet;

public enum DessertList {
    ChocoCake("초코케이크", 15000),
    Icecream("아이스크림", 5000);
    private final String name;
    private final Integer price;

    DessertList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static DessertList getDessert(String name) {
        for (DessertList dessert : DessertList.values()) {
            if (dessert.getMenuName().equals(name)) {
                return dessert;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isDessert(String menuName) {
        for (DessertList dessert : DessertList.values()) {
            if (dessert.getMenuName().equals(menuName)) {
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
