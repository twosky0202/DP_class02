package hw.ch22.command;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MacroCommand implements Command {
    // 명령의 배열
    private Deque<Command> commands = new ArrayDeque<>();
    private Deque<Command> commandsForRedo = new ArrayDeque<>();

    // 실행
    @Override
    public void execute() {
        Iterator<Command> descendingIterator = commands.descendingIterator();
        while (descendingIterator.hasNext()) {
            Command cmd = descendingIterator.next();
            cmd.execute();
        }
    }

    // 추가
    public void append(Command cmd) {
        if (cmd == this) {
            throw new IllegalArgumentException("infinite loop caused by append");
        }
        commands.push(cmd);
    }

    // 마지막 명령을 삭제
    public void undo() {
        if (!commands.isEmpty()) {
            Command undoCommand = commands.pop();
            commandsForRedo.push(undoCommand);
        }
    }

    public void redo() {
        if (!commandsForRedo.isEmpty()) {
            Command redoCommand = commandsForRedo.pop();
            commands.push(redoCommand);
        }
    }

    // 전부 삭제
    public void clear() {
        commands.clear();
    }
}
