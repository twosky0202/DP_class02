package ch19.Sample;

public interface Context { // 상태 관리, 경비 센터 호출
    public abstract void setClock(int hour); // 시간 설정 -> 누군가 시간을 알려줄 때 호출하는 메소드(1초마다 호출됨)

    public abstract void changeState(State state); // 상태 변화(State : 부모 타입 -> 주간이 들어올 수도, 야간이 들어올 수도 있다.)

    public abstract void callSecurityCenter(String msg); // 경비 센터 경비원 호출

    public abstract void recordLog(String msg); // 경비 센터 기록
}
