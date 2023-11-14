package christmas.domain.badge;

import christmas.constants.BadgeConstant;

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
        return discountPrice >= BadgeConstant.SantaBadgeCost;
    }

    private static boolean isTreeBadge(int discountPrice) {
        return BadgeConstant.TreeBadgeCost <= discountPrice && discountPrice < BadgeConstant.SantaBadgeCost;
    }

    private static boolean isStarBadge(int discountPrice) {
        return BadgeConstant.StarBadgeCost <= discountPrice && discountPrice < BadgeConstant.SantaBadgeCost;
    }
}
