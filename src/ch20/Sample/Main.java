package ch20.Sample;

public class Main {
    public static void main(String[] args) { // 명령형 인자
        BigChar b = new BigChar('1');
        b.print();

        if (args.length == 0) { // 명령형 인자가 없으면
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 1212123");
            System.exit(0);
        }

        BigString bs = new BigString(args[0]);
        bs.print();
    }
}
