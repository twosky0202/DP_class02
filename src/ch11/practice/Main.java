package ch11.practice;

public class Main {
    public static void main(String[] args) {

        Directory root = new Directory("root");

        Directory bin = new Directory("bin");
        Directory tmp = new Directory("tmp");
        Directory usr = new Directory("usr");

        // 컴파일러 입장에서는 변수의 타입이 실제 들어간 객체보다 중요함
        // ((Directory)root).add(bin);
        root.add(bin);
        root.add(tmp);
        root.add(usr);

        bin.add(new File("vi", 100));
        bin.add(new File("latex", 200));

        System.out.println(root.getSize());

        root.printList();
    }
}
