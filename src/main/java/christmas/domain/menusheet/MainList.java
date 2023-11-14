package christmas.domain.menusheet;

public enum MainList {
    TboneSteak("티본스테이크", 55000),
    BarbecueRib("바비큐립", 54000),
    SeafoodPasta("해산물파스타", 35000),
    ChristmasPasta("크리스마스파스타", 25000);
    private final String name;
    private final Integer price;

    MainList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static MainList getMain(String name) {
        for (MainList main : MainList.values()) {
            if (main.getMenuName().equals(name)) {
                return main;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isMain(String menuName) {
        for (MainList main : MainList.values()) {
            if (main.getMenuName().equals(menuName)) {
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
