package christmas.domain.calendar;

import java.util.Objects;

public enum DecemberCalendar {
    dayFirst(1, "금", false),
    daySecond(2, "토", false),
    dayThird(3, "일", true),
    dayFourth(4, "월", false),
    dayFifth(5, "화", false),
    daySixth(6, "수", false),
    daySeventh(7, "목", false),
    dayEighth(8, "금", false),
    dayNinth(9, "토", false),
    dayTenth(10, "일", true),
    dayELeventh(11, "월", false),
    dayTwelfth(12, "화", false),
    dayThirteenth(13, "수", false),
    dayFourteenth(14, "목", false),
    dayFifteenth(15, "금", false),
    daySixtennth(16, "토", false),
    daySeventeenth(17, "일", true),
    dayEighteenth(18, "월", false),
    dayNineteenth(19, "화", false),
    dayTwentieth(20, "수", false),
    dayTwentyFirst(21, "목", false),
    dayTwentySecond(22, "금", false),
    dayTwentyThird(23, "토", false),
    dayTwentyFourth(24, "일", true),
    dayTwentyFifth(25, "월", true),
    dayTwentySixth(26, "화", false),
    dayTwentySeventh(27, "수", false),
    dayTwentyEighth(28, "목", false),
    dayTwentyNinth(29, "금", false),
    dayThirtieth(30, "토", false),
    dayThirtyFirst(31, "일", false);

    private final Integer date;
    private final String day;
    private final boolean isStar;

    public Integer getDate() {
        return this.date;
    }

    public String getDay() {
        return this.day;
    }

    public boolean isStar() {
        return isStar;
    }

    public boolean getIsStar() {
        return this.isStar;
    }

    DecemberCalendar(Integer date, String day, boolean isStar) {
        this.date = date;
        this.day = day;
        this.isStar = isStar;
    }

    public static DecemberCalendar getDayInfo(Integer date) {
        for (DecemberCalendar dayInfo : DecemberCalendar.values()) {
            if (Objects.equals(dayInfo.getDate(), date)) {
                return dayInfo;
            }
        }
        throw new IllegalArgumentException();
    }
}
