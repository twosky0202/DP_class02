package ch21.Sample;

public class Main {
    public static void main(String[] args) {
        Printable p = new PrinterProxy("Alice");

        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");

        p.setPrinterName("Bob");
        System.out.println("이름은 현재 " + p.getPrinterName() + "입니다.");

        p.print("Hello, world."); // 실제로는 원본이 일을 함
    }
}
