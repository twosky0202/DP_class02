package hw.ch19;

public class NightMealState implements State {
    private static NightMealState singleton = new NightMealState();

    private NightMealState() {
    }

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (15 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        } else if (hour < 20 || 24 < hour) {
            context.changeState(NightState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("금고 사용(야식)");
        context.callSecurityCenter("비상：야식 금고 사용！");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("비상벨(야식)");
    }

    @Override
    public void doPhone(Context context) {
        context.recordLog("야식 통화 녹음");
    }

    @Override
    public String toString() {
        return "[야식]";
    }

    @Override
    public void doCCTV(Context context) {
        context.recordLog("CCTV : off");
    }
}
