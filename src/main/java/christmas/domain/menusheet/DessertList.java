package christmas.domain.menusheet;

public enum DessertList {
    ChocoCake("초코케이크", 15000),
    Icecream("아이스크림", 5000);
    private final String name;
    private final Integer price;

    public String getMenuName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    DessertList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
