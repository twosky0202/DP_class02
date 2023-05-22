package ch19.Sample;

public interface State { // 새로운 상태를 추가하는 것은 간단. XXXState 클래스를 만들어 필요한 메소드를 구현하기만 하면 됨
    public abstract void doClock(Context context, int hour); // 시간 설정 -> 시간을 알려줌

    public abstract void doUse(Context context); // 금고 사용

    public abstract void doAlarm(Context context); // 비상벨

    public abstract void doPhone(Context context); // 일반 통화

    // 새로운 상태 의존 처리를 추가하는 것은 어려움. doYYY를 추가 하면 모든 상태 클래스들이 이 처리를 구현해야 한다.
}
