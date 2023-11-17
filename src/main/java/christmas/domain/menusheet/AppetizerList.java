package christmas.domain.menusheet;

public enum AppetizerList {
    MushroomSoup("양송이수프", 6000),
    Tapas("타파스", 5500),
    CaesarSalad("시저샐러드", 8000);
    private final String name;
    private final Integer price;

    AppetizerList(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static AppetizerList getAppetizer(String name) {
        for (AppetizerList appetizer : AppetizerList.values()) {
            if (appetizer.getMenuName().equals(name)) {
                return appetizer;
            }
        }
        throw new IllegalArgumentException();
    }

    public static boolean isAppetizer(String menuName) {
        for (AppetizerList appetizer : AppetizerList.values()) {
            if (appetizer.getMenuName().equals(menuName)) {
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
