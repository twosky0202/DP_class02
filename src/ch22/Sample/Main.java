package ch22.Sample;

import ch22.Sample.command.*;
import ch22.Sample.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// 마우스 이벤트 처리, 윈도우(최소화, 최대화, 닫기) 이벤트 처리
public class Main extends JFrame implements MouseMotionListener, WindowListener {
    // public class Main extends JFrame, WindowAdapter implements
    // MouseMotionListener { -> 다중 상속
    // 그리기 이력. window가 history를 관리
    private MacroCommand history = new MacroCommand();
    // 그리는 영역. canvas와 window가 history를 공유하고 있다. -> DrawCanvas도 history 관리 가능
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 삭제 버튼
    private JButton clearButton = new JButton("clear");

    // 생성자
    public Main(String title) {
        super(title);

        // 리스너 등록
        this.addWindowListener(this);

        // (1) 리스너 클래스를 만들어서 등록
        // canvas.addMouseMotionListener(this);

        // (2) 익명의 내부 클래스를 이용해서 등록
        // canvas.addMouseMotionListener(new MouseMotionListener() {
        // @Override
        // public void mouseMoved(MouseEvent e) {
        // }

        // @Override
        // public void mouseDragged(MouseEvent e) {
        // Command cmd = new DrawCommand(canvas, e.getPoint());
        // // Command cmd = new DrawCommand(canvas, e.getPoint(), 현재 시간 등);
        // // System.out.println("마우스 이벤트: x 좌표 : " + e.getPoint().getX());
        // // System.out.println("마우스 이벤트: y 좌표 : " + e.getPoint().getY());
        // history.append(cmd);
        // cmd.execute();
        // }
        // });

        // (3) 익명의 내부 클래스의 어댑터를 이용해서 등록
        canvas.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                Command cmd = new DrawCommand(canvas, e.getPoint());
                // Command cmd = new DrawCommand(canvas, e.getPoint(), 현재 시간 등);
                // System.out.println("마우스 이벤트: x 좌표 : " + e.getPoint().getX());
                // System.out.println("마우스 이벤트: y 좌표 : " + e.getPoint().getY());
                history.append(cmd);
                cmd.execute();
            }
        });

        // ActionListener는 functional interface이다.(actionPerformed 한개만 선언되어 있음)
        // functional interface 들어갈 자리에 람다식을 넣을 수 있다.
        clearButton.addActionListener(e -> {
            history.clear(); // execute 호출
            canvas.repaint(); // canvas를 다시 그려라 -> 1) canvas의 내용이 지워짐 2) paint()가 자동으로 호출됨
        });

        // GUI 컴포넌트 추가
        Box buttonBox = new Box(BoxLayout.X_AXIS); // 가로 배치
        buttonBox.add(clearButton);

        Box mainBox = new Box(BoxLayout.Y_AXIS); // 세로 배치
        mainBox.add(buttonBox);
        mainBox.add(canvas);

        getContentPane().add(mainBox); // Jframe에 내부적으로 존재하는 창. ContentPane을 얻는다.

        pack();
        setVisible(true);
    }

    // MouseMotionListener용
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        // Command cmd = new DrawCommand(canvas, e.getPoint(), 현재 시간 등);
        // System.out.println("마우스 이벤트: x 좌표 : " + e.getPoint().getX());
        // System.out.println("마우스 이벤트: y 좌표 : " + e.getPoint().getY());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    @Override
    public void windowClosing(WindowEvent e) { // X -> 종료될 때
        System.out.println("프로그램이 종료됩니다.");
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e) { // 창에 focus
    }

    @Override
    public void windowClosed(WindowEvent e) { // 종료된 후
    }

    @Override
    public void windowDeactivated(WindowEvent e) { // 창에 unfocus
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) { // 최소화
        System.out.println("최소화 되었습니다.");
    }

    @Override
    public void windowOpened(WindowEvent e) { // 창이 open되었을 때
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
