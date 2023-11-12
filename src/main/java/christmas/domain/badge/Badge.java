package christmas.domain.badge;

public class Badge {

    Badge() {}
    public static Badge makeBadge(int discountPrice) {
        if (isSantaBadge(discountPrice))
            return new SantaBadge();
        if (isTreeBadge(discountPrice))
            return new TreeBadge();
        if (isStarBadge(discountPrice))
            return new StarBadge();
        return new Badge();
    }

    private static boolean isSantaBadge(int discountPrice) {
        if (discountPrice >= 20000)
            return true;
        return false;
    }
    private static boolean isTreeBadge(int discountPrice) {
        if (discountPrice >= 10000 && discountPrice < 20000)
            return true;
        return false;
    }

    private static boolean isStarBadge(int discountPrice) {
        if (discountPrice >= 5000 && discountPrice < 10000)
            return true;
        return false;
    }
}
