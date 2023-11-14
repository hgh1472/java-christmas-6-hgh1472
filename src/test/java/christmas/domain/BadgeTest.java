package christmas.domain;


import static org.assertj.core.api.Assertions.assertThat;

import christmas.domain.badge.SantaBadge;
import christmas.domain.badge.StarBadge;
import christmas.domain.badge.TreeBadge;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BadgeTest {
    @DisplayName("산타배지_생성_테스트")
    @Test
    void makeSantaBadgeTest() {
        SantaBadge santaBadge = new SantaBadge();
        assertThat(santaBadge).isInstanceOf(SantaBadge.class);
    }

    @DisplayName("트리배지_생성_테스트")
    @Test
    void makeTreeBadgeTest() {
        TreeBadge treeBadge = new TreeBadge();
        assertThat(treeBadge).isInstanceOf(TreeBadge.class);
    }

    @DisplayName("별배지_생성_테스트")
    @Test
    void makeStarBadgeTest() {
        StarBadge starBadge = new StarBadge();
        assertThat(starBadge).isInstanceOf(StarBadge.class);
    }
}
