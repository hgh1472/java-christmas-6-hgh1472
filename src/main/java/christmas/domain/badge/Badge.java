package christmas.domain.badge;

import christmas.constants.BadgeConstants;

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
        return discountPrice >= BadgeConstants.SantaBadgeCost;
    }

    private static boolean isTreeBadge(int discountPrice) {
        return BadgeConstants.TreeBadgeCost <= discountPrice && discountPrice < BadgeConstants.SantaBadgeCost;
    }

    private static boolean isStarBadge(int discountPrice) {
        return BadgeConstants.StarBadgeCost <= discountPrice && discountPrice < BadgeConstants.SantaBadgeCost;
    }
}
