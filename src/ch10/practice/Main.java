package ch10.practice;

public class Main {
    public static void main(String[] args) {
        // 바위
        Hand h1 = Hand.ROCK; // 상수 직접 이용
        System.out.println(h1.toString());

        // 가위
        Hand h2 = Hand.getHand(1); // get메서드로 얻어오기
        System.out.println(h2);

        // h1과 h2 중 누가 이기나 해보기
        if(h1.isStrongerThan(h2)) {
            System.out.println("h1이 h2보다 세다");
        } else if(h1.isWeakerThan(h2)) {
            System.out.println("h1이 h2보다 약하다");
        } else {
            System.out.println("무승부");
        }
    }
}
