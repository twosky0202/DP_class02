package hw.ch16;

import java.awt.Color;
import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

public class ColleagueTextField extends TextField implements TextListener, Colleague {
    private Mediator mediator;

    public ColleagueTextField(String text, int columns) {
        super(text, columns); // TextField의 생성자
    }

    // Mediator를 설정한다
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
        // 활성/비활성에 맞게 배경색을 변경한다
        setBackground(enabled ? Color.white : Color.lightGray); // enabled가 true이면 white, false이면 lightGray
    }

    @Override
    public void textValueChanged(TextEvent e) { // TextListener가 하는 일
        // 문자열이 변화했으면 Mediator에 알린다
        mediator.colleagueChanged();
    }
}
