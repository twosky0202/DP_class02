package ch16.Sample;

public interface Colleague {
    // Mediator를 설정한다 
    public abstract void setMediator(Mediator mediator);

    // Mediator에서 활성(true)/비활성(false)을 지시한다(지시 받을 때)
    public abstract void setColleagueEnabled(boolean enabled);
}
