package ch22.Sample.drawer;

import ch22.Sample.command.Command;
import java.awt.Point;

// 그림 그리기 명령
public class DrawCommand implements Command {
    // 그리는 대상(객체) 저장
    protected Drawable drawable; // Receiver

    // 그리는 위치
    private Point position; // Point 클래스 : X좌표, Y좌표

    // 모양
    private String shape;

    // 생성자
    public DrawCommand(Drawable drawable, Point position) {
        this.drawable = drawable;
        this.position = position;
    }

    // 실행
    @Override
    public void execute() {
        drawable.draw(position.x, position.y); // 실제 그리는 일을 함
        // drawable.draw(position.x, position.y, shape); 모양에 대한 정보 지니게 할 수도
    }
}
