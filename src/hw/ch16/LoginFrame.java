package hw.ch16;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginFrame extends Frame implements ActionListener, Mediator {
    // ActionListener: 버튼을 눌렀을 때 동작하는 일을 하는 리스너
    private ColleagueCheckbox checkGuest;
    private ColleagueCheckbox checkLogin;
    private ColleagueCheckbox checkMember;

    private ColleagueTextField textUser;
    private ColleagueTextField textPass;
    private ColleagueTextField textSSN;

    private ColleagueButton buttonOk;
    private ColleagueButton buttonCancel;

    // Colleague를 생성하고 배치한 후에 표시한다
    public LoginFrame(String title) {
        super(title); // 없으면 인자 없는 부모 생성자 호출. 부모 생성자 호출은 항상 첫 줄에 하기.

        // 배경색을 설정한다
        setBackground(Color.lightGray);

        // 레이아웃 매니저를 사용해 5×3 그리드를 만든다
        setLayout(new GridLayout(5, 3));

        // Colleague를 생성한다
        createColleagues();

        // 배치한다
        add(checkGuest);
        add(checkLogin);
        add(checkMember);
        add(new Label("Username:"));
        add(textUser);
        add(new Label(""));
        add(new Label("Password:"));
        add(textPass);
        add(new Label(""));
        add(new Label("주민등록번호"));
        add(textSSN);
        add(new Label(""));
        add(buttonOk);
        add(buttonCancel);

        // 활성/비활성 초기 설정을 한다
        colleagueChanged();

        // 표시한다
        pack(); // 크기 조절
        setVisible(true);
    }

    // Colleague를 생성한다
    @Override
    public void createColleagues() {
        // CheckBox
        CheckboxGroup g = new CheckboxGroup();
        checkGuest = new ColleagueCheckbox("Guest", g, true);
        checkLogin = new ColleagueCheckbox("Login", g, false);
        checkMember = new ColleagueCheckbox("Member", g, false);

        // TextField
        textUser = new ColleagueTextField("", 10);
        textPass = new ColleagueTextField("", 10);
        textPass.setEchoChar('*');
        textSSN = new ColleagueTextField("", 13);

        // Button
        buttonOk = new ColleagueButton("OK");
        buttonCancel = new ColleagueButton("Cancel");

        // Mediator를 설정한다
        checkGuest.setMediator(this);
        checkLogin.setMediator(this);
        checkMember.setMediator(this);
        textUser.setMediator(this);
        textPass.setMediator(this);
        textSSN.setMediator(this);
        buttonOk.setMediator(this);
        buttonCancel.setMediator(this);

        // Listener 설정
        checkGuest.addItemListener(checkGuest);
        checkLogin.addItemListener(checkLogin);
        checkMember.addItemListener(checkMember);
        textUser.addTextListener(textUser);
        textPass.addTextListener(textPass);
        textSSN.addTextListener(textSSN);

        buttonOk.addActionListener(this);
        buttonCancel.addActionListener(this);
    }

    // Colleage의 상태가 바뀌면 호출된다
    @Override
    public void colleagueChanged() { // 이 안에서 colleague들에게 지시를 내린다.
        if (checkGuest.getState()) { // Guest 체크박스가 선택되었다면
            // 게스트 로그인
            textUser.setColleagueEnabled(false);
            textPass.setColleagueEnabled(false);
            textSSN.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(true);
        } else { // Login 또는 Member 체크박스가 선택되었다면
            textUser.setColleagueEnabled(true);
            userpassChanged();
        }
    }

    // textUser 또는 textPass의 변경이 있다
    // 각 Colleage의 활성/비활성을 판정한다
    private void userpassChanged() {
        if (textUser.getText().length() > 0) { // 문자열이 입력되어 있으면
            textPass.setColleagueEnabled(true);
            if (textPass.getText().length() > 0) {
                textSSN.setColleagueEnabled(true);
                userSSNChanged();
            } else { // 패스워드 칸에 문자열이 없으면
                textSSN.setColleagueEnabled(false);
                buttonOk.setColleagueEnabled(false);
            }
        } else { // 유저 네임 칸에 문자열이 없으면
            textPass.setColleagueEnabled(false);
            textSSN.setColleagueEnabled(false);
            buttonOk.setColleagueEnabled(false);
        }
    }

    private void userSSNChanged() {
        if (textSSN.getText().length() > 0) {
            if (Character.isDigit(textSSN.getText().charAt(textSSN.getText().length() - 1))) {
                if (textSSN.getText().length() == 13) {
                    buttonOk.setColleagueEnabled(true);
                } else {
                    buttonOk.setColleagueEnabled(false);
                }
            } else {
                buttonOk.setColleagueEnabled(false);
                JOptionPane.showMessageDialog(null, "문자를 입력하지 마세요.");
                textSSN.setText(textSSN.getText().substring(0, textSSN.getText().length() - 1));
                textSSN.setCaretPosition(textSSN.getText().length());
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        System.exit(0); // 프로그램 종료
    }
}
