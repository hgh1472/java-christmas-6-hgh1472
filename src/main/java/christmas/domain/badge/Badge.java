package christmas.domain.badge;

import christmas.constants.BadgeCost;

public class Badge {

    public static Badge makeBadge(int discountPrice) {
        if (isStarBadge(discountPrice)) {
            return new StarBadge();
        }
        if (isTreeBadge(discountPrice)) {
            return new TreeBadge();
        }
        if (isSantaBadge(discountPrice)) {
            return new SantaBadge();
        }
        return new Badge();
    }

    private static boolean isSantaBadge(int discountPrice) {
        return discountPrice >= BadgeCost.SantaBadgeCost;
    }

    private static boolean isTreeBadge(int discountPrice) {
        return BadgeCost.TreeBadgeCost <= discountPrice && discountPrice < BadgeCost.SantaBadgeCost;
    }

    private static boolean isStarBadge(int discountPrice) {
        return BadgeCost.StarBadgeCost <= discountPrice && discountPrice < BadgeCost.TreeBadgeCost;
    }
}
