package ch22.Sample.command;

import java.util.ArrayDeque;
import java.util.Deque;

// 여러개의 명령을 한데 모은 명령, Composite 패턴 사용
public class MacroCommand implements Command {
    // 명령의 배열. Deque : 양쪽 끝에 원소를 추가/삭제 할 수 있는 자료 구조체
    private Deque<Command> commands = new ArrayDeque<>(); // 컬렉션

    // 실행
    @Override
    public void execute() {
        for (Command cmd : commands) { // 내부적으로는 iterator()를 호출해서 동작함 => 스택의 top에서부터 꺼내옴
            cmd.execute();
        }
    }

    // 추가
    public void append(Command cmd) {
        if (cmd == this) { // 자기 자신을 추가하면 무한 반복이 된다. -> 예외 발생
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) { // 스택이 비어있는지 검사
            commands.pop(); // 비어있지 않으면 하나 꺼냄
        }
    }

    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
