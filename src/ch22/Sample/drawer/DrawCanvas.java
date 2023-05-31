package ch22.Sample.drawer;

import ch22.Sample.command.MacroCommand;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrawCanvas extends Canvas implements Drawable {
    // 그리는 색 -> 변수로 관리하여 수정에 용이하게 함
    private Color color = Color.red;
    // 그리는 점의 반지름 -> 변수로 관리하여 수정에 용이하게 함
    private int radius = 6;
    // 이력
    private MacroCommand history;

    // 생성자
    public DrawCanvas(int width, int height, MacroCommand history) {
        setSize(width, height);
        setBackground(Color.white);
        this.history = history;
    }

    // 이력 전체 다시 그리기
    @Override
    public void paint(Graphics g) {
        history.execute();
        // 모든 MacroCommand execute 호출 -> 자기가 가지고 있는 Command의 execute 호출
        // -> DrawCommand execute 호출 -> draw 메소드 호출
    }

    // 그리기
    @Override
    public void draw(int x, int y) {
        Graphics g = getGraphics(); // 그래픽스 객체 얻기
        g.setColor(color);
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // 원이 그려질 사각형 지정. 변수를 사용하지 않고 직접 값을 입력하는 것을 하드코딩이라고 함
    }
}
