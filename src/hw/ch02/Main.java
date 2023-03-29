package hw.ch02;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("20210821 이하늘");
        
        FileIO f = new FileProperties(); // 어댑터 생성

        try {
            f.readFromFile("file.txt");

            f.setValue("Year", "2023");
            f.setValue("bornYear", "2003");
            f.setValue("StudentId", "20210821");
            f.setValue("Name", "LeeHaNeul");
            f.setValue("Location", "Seoul");

            f.writeToFile("LeeHaNeul.txt");
            System.out.println("LeeHaNeul.txt is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
