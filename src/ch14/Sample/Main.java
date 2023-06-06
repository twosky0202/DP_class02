package ch14.Sample;

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 사슬 형성
        // alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        alice.setNext(fred).setNext(diana).setNext(charlie).setNext(bob).setNext(elmo); // 동적으로 처리자들의 순서를 바꿀 수 있음

        // 다양한 트러블 발생
        for (int i = 0; i < 500; i += 33) {
            alice.support(new Trouble(i)); // 맨 앞사람에게만 해결 요구
        }
    }
}
