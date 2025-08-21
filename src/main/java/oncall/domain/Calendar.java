package oncall.domain;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private List<DayInfo> calendar;

    public Calendar(DayInfo start) {
        int endOfMonth = start.size();
        this.calendar = new ArrayList<>(endOfMonth);

        DayInfo cur = start;
        for (int i = 1; i <= endOfMonth; i++) {
            calendar.add(cur);
            cur = cur.next();
        }
    }

}
