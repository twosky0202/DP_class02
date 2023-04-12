package ch10.practice;

public class Player {
    private String name = "";

    private Strategy strategy; // 현재 전략을 보관(부모타임으로 선언됨)

    private int wincount = 0;
    private int losecount = 0;
    private int gamecount = 0;

    // 이름과 전략을 받아서 플레이어를 만든다 
    public Player(String name, Strategy strategy) {
        this.name = name;
        this.strategy = strategy;
    }

    // 전략에 따라 다음 손을 결정한다
    public Hand nextHand() {
        return strategy.nextHand(); // 현재 전략 객체에게 위임
    }

    // 승리
    public void win() {
        strategy.study(true); // 현재 전략 객체에게 결과를 알려줌
        wincount++;
        gamecount++;
    }

    // 패배
    public void lose() {
        strategy.study(false);
        losecount++;
        gamecount++;
    }

    // 무승부 
    public void even() {
        gamecount++;
    }

    @Override
    public String toString() {
        return "["
            + name + ":"
            + gamecount + " games, "
            + wincount + " win, "
            + losecount + " lose"
            + "]";
    }

    // 전략 교체 메소드
    public void setStrategy(Strategy s){
        this.strategy = s;
    }
}
