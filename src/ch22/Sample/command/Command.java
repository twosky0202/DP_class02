package ch22.Sample.command;

// 명령을 표현하기 위한 인터페이스
public interface Command {
    // 무언가를 실행하는 메소드 -> 구체적인 것은 자식클래스가 결정
    public abstract void execute();
}
