package christmas.domain.calendar;

import java.util.Objects;

public enum DecemberCalendar {
    FIRST_DAY(1, "금", false),
    SECOND_DAY(2, "토", false),
    THIRD_DAY(3, "일", true),
    FOURTH_DAY(4, "월", false),
    FIFTH_DAY(5, "화", false),
    SIXTH_DAY(6, "수", false),
    SEVENTH_DAY(7, "목", false),
    EIGHTH_DAY(8, "금", false),
    NINTH_DAY(9, "토", false),
    TENTH_DAY(10, "일", true),
    ELEVENTH_DAY(11, "월", false),
    TWELFTH_DAY(12, "화", false),
    THIRTEENTH_DAY(13, "수", false),
    FOURTEENTH_DAY(14, "목", false),
    FIFTEENTH_DAY(15, "금", false),
    SIXTEENTH_DAY(16, "토", false),
    SEVENTEENTH_DAY(17, "일", true),
    EIGHTEENTH_DAY(18, "월", false),
    NINETEENTH_DAY(19, "화", false),
    TWENTIETH_DAY(20, "수", false),
    TWENTY_FIRST_DAY(21, "목", false),
    TWENTY_SECOND_DAY(22, "금", false),
    TWENTY_THIRD_DAY(23, "토", false),
    TWENTY_FOURTH_DAY(24, "일", true),
    TWENTY_FIFTH_DAY(25, "월", true),
    TWENTY_SIXTH_DAY(26, "화", false),
    TWENTY_SEVENTH_DAY(27, "수", false),
    TWENTY_EIGHTH_DAY(28, "목", false),
    TWENTY_NINTH_DAY(29, "금", false),
    THIRTIETH_DAY(30, "토", false),
    THIRTY_FIRST_DAY(31, "일", false);

    private final Integer date;
    private final String dayOfTheWeek;
    private final boolean isStar;

    DecemberCalendar(Integer date, String dayOfTheWeek, boolean isStar) {
        this.date = date;
        this.dayOfTheWeek = dayOfTheWeek;
        this.isStar = isStar;
    }

    public static DecemberCalendar makeDayInfo(Integer date) {
        for (DecemberCalendar dayInfo : DecemberCalendar.values()) {
            if (Objects.equals(dayInfo.getDate(), date)) {
                return dayInfo;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isWeekday() {
        return dayOfTheWeek.equals("일") || dayOfTheWeek.equals("월") || dayOfTheWeek.equals("화")
                || dayOfTheWeek.equals("수") || dayOfTheWeek.equals("목");
    }

    public boolean isWeekend() {
        return dayOfTheWeek.equals("금") || dayOfTheWeek.equals("토");
    }

    public Integer getDate() {
        return this.date;
    }

    public String getDayOfTheWeek() {
        return this.dayOfTheWeek;
    }

    public boolean isStar() {
        return isStar;
    }
}
