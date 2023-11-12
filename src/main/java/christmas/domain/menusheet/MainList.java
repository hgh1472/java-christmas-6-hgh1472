package christmas.domain.menusheet;

public enum MainList {
    TboneSteak("티본스테이크", 55000),
    BarbecueRib("바비큐립", 54000),
    SeafoodPasta("해산물파스타", 35000),
    ChristmasPasta("크리스마스파스타", 25000);
    private final String name;
    private final Integer price;

    public String getMenuName() {
        return this.name;
    }

    public Integer getPrice() {
        return this.price;
    }

    MainList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }
}
