package ch17.Sample;

// 관찰자
public interface Observer {
    public abstract void update(NumberGenerator generator); // 관찰자에게 알려줄 때 호출
}
