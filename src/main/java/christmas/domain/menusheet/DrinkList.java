package christmas.domain.menusheet;

public enum DrinkList {
    ZeroCoke("제로콜라", 3000),
    RedWine("레드와인", 60000),
    Champagne("샴페인", 25000);
    private final String name;
    private final Integer price;

    public String getMenuName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    DrinkList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
