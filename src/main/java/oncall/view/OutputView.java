package oncall.view;

public class OutputView {

    public void printErrorMsg(String msg) {
        System.out.println("[ERROR] " + msg);
    }

    public void printMonthAndWeek(int day, int month, String week) {
        System.out.print(month + "월 " + day + "일 " + week);
    }

}
