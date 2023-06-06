package hw.ch14;

public class Main {
    public static void main(String[] args) {
        Support haneul = new PrimeNumberSupport("이하늘");
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        // 사슬 형성
        haneul.setNext(alice).setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);

        // 다양한 트러블 발생
        for (int i = 1; i <= 100; i += 1) {
            haneul.support(new Trouble(i)); // 맨 앞사람에게만 해결 요구
        }
    }
}
