package ch18.A4.game;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Memento {
    private int money; // 소지금
    private List<String> fruits; // 과일

    // 소지금을 얻는다(narrow interface)
    public int getMoney() {
        return money;
    }

    // 생성자(wide interface)
    Memento(int money) {
        this.money = money;
        this.fruits = new ArrayList<>();
    }

    // 과일을 추가한다(wide interface)
    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    // 과일을 얻는다(wide interface)
    List<String> getFruits() {
        return new ArrayList<>(fruits);
    }

    // 파일에 저장
    public static boolean saveToFile(String filename, Memento memento) {
        StringBuilder sb = new StringBuilder(); // 내용이 바뀌는 String

        // 소지금
        sb.append(String.format("%d", memento.money)); // 정수를 String 형태로 저장
        sb.append("\n");

        // 과일
        for (String f : memento.getFruits()) {
            sb.append(f);
            sb.append("\n");
        }

        // 쓰기
        try {
            Files.writeString(Path.of(filename), sb, // 경로, 쓰고자 하는 내용, 옵션
                    StandardOpenOption.CREATE, // 파일이 존재하지 않으며 새로 생성
                    StandardOpenOption.TRUNCATE_EXISTING, // 파일이 이미 존재하면 쓰기 권한으로 열고, 길이는 0(파일의 기존 내용을 없앰)
                    StandardOpenOption.WRITE); // 쓰기 권한으로 파일을 오픈
        } catch (IOException e) {
            System.out.println(e.toString());
            return false;
        }
        return true;
    }

    // 파일로부터 생성
    public static Memento loadFromFile(String filename) {
        try {
            // 읽기
            List<String> lines = Files.readAllLines(Path.of(filename));
            if (lines.size() == 0) {
                System.out.println("Empty file");
                return null;
            }

            // 소지금
            int money = 0;
            try {
                money = Integer.parseInt(lines.get(0)); // String을 정수로 바꿔서
            } catch (NumberFormatException e) {
                System.out.println("Format error: " + e);
                return null;
            }

            // 생성
            Memento memento = new Memento(money);

            // 과일
            for (int i = 1; i < lines.size(); i++) {
                memento.addFruit(lines.get(i));
            }
            return memento;
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
