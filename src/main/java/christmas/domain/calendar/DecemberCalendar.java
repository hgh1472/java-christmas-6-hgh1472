package christmas.domain.calendar;

import christmas.constants.EventConstant;
import java.util.Objects;

public enum DecemberCalendar {
    FIRST_DAY(1, "금", EventConstant.IS_NOT_STAR),
    SECOND_DAY(2, "토", EventConstant.IS_NOT_STAR),
    THIRD_DAY(3, "일", EventConstant.IS_STAR),
    FOURTH_DAY(4, "월", EventConstant.IS_NOT_STAR),
    FIFTH_DAY(5, "화", EventConstant.IS_NOT_STAR),
    SIXTH_DAY(6, "수", EventConstant.IS_NOT_STAR),
    SEVENTH_DAY(7, "목", EventConstant.IS_NOT_STAR),
    EIGHTH_DAY(8, "금", EventConstant.IS_NOT_STAR),
    NINTH_DAY(9, "토", EventConstant.IS_NOT_STAR),
    TENTH_DAY(10, "일", EventConstant.IS_STAR),
    ELEVENTH_DAY(11, "월", EventConstant.IS_NOT_STAR),
    TWELFTH_DAY(12, "화", EventConstant.IS_NOT_STAR),
    THIRTEENTH_DAY(13, "수", EventConstant.IS_NOT_STAR),
    FOURTEENTH_DAY(14, "목", EventConstant.IS_NOT_STAR),
    FIFTEENTH_DAY(15, "금", EventConstant.IS_NOT_STAR),
    SIXTEENTH_DAY(16, "토", EventConstant.IS_NOT_STAR),
    SEVENTEENTH_DAY(17, "일", EventConstant.IS_STAR),
    EIGHTEENTH_DAY(18, "월", EventConstant.IS_NOT_STAR),
    NINETEENTH_DAY(19, "화", EventConstant.IS_NOT_STAR),
    TWENTIETH_DAY(20, "수", EventConstant.IS_NOT_STAR),
    TWENTY_FIRST_DAY(21, "목", EventConstant.IS_NOT_STAR),
    TWENTY_SECOND_DAY(22, "금", EventConstant.IS_NOT_STAR),
    TWENTY_THIRD_DAY(23, "토", EventConstant.IS_NOT_STAR),
    TWENTY_FOURTH_DAY(24, "일", EventConstant.IS_STAR),
    TWENTY_FIFTH_DAY(25, "월", EventConstant.IS_STAR),
    TWENTY_SIXTH_DAY(26, "화", EventConstant.IS_NOT_STAR),
    TWENTY_SEVENTH_DAY(27, "수", EventConstant.IS_NOT_STAR),
    TWENTY_EIGHTH_DAY(28, "목", EventConstant.IS_NOT_STAR),
    TWENTY_NINTH_DAY(29, "금", EventConstant.IS_NOT_STAR),
    THIRTIETH_DAY(30, "토", EventConstant.IS_NOT_STAR),
    THIRTY_FIRST_DAY(31, "일", EventConstant.IS_NOT_STAR);

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
