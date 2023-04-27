package ch16.Sample;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague {
    private Mediator mediator;

    public ColleagueButton(String caption) {
        super(caption); // Button의 생성자 호출. 부모에 caption을 전달
    }

    // Mediator를 설정한다
    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    // Mediator에서 활성/비활성을 지시한다
    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled); // Button으로부터 상속받은 메소드
    }
}
