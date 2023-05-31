package hw.ch22.drawer;

import java.awt.Color;

import hw.ch22.command.Command;

// 색 지정
public class ColorCommand implements Command {
    // 그리기 대상
    protected Drawable drawable;
    // 그리기 색
    private Color color;

    // 생성자
    public ColorCommand(Drawable drawable, Color color) {
        this.drawable = drawable;
        this.color = color;
    }

    // 실행
    @Override
    public void execute() {
        drawable.setColor(color);
    }
}
