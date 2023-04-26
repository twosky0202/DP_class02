package ch12.Sample;

// 장식자를 나타냄
public abstract class Border extends Display {
    // 장식 대상
    protected Display display; // 이 장식틀이 감싸는 '내용물' 부모타입이면 자식을 모두 장식할 수 있다.

    protected Border(Display display) { // 인스턴스 생성 시 '내용물'을 인수로 지정. 추상클래스인데도 생성자가 존재 -> 장식 대상을 부모쪽에서 받아주기 위해
        this.display = display;
    }
}
