package ch03.practice;

public class Main {
    public static void main(String[] args) {
        AbstractDisplay a;

        // AbstractDisplay c = new CharDisplay('a');
        a = new CharDisplay('a');
        a.open();
        a.print();
        a.close();

        a.display();

        // AbstractDisplay s = new StringDisplay("이하늘");
        a = new StringDisplay("이하늘");
        a.open();
        a.print();
        a.close();

        a.display();
    }
}
