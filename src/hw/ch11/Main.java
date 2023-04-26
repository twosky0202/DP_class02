package hw.ch11;

public class Main {
    public static void main(String[] args) {
        System.out.println("20210821 이하늘");

        Directory MyDocuments = new Directory("MyDocuments", "20220401", "HaNeulLee");
        Directory MyData = new Directory("MyData", "20220401", "HaNeulLee");
        Directory MyPictures = new Directory("MyPictures", "20220401", "HaNeulLee");

        MyDocuments.add(new File("이하늘0.doc", "20220501", 1000, "HaNeulLee"));
        MyDocuments.add(MyData);

        MyData.add(new File("이하늘1.doc", "20220501", 2000, "HaNeulLee"));
        MyData.add(new File("이하늘2.java", "20220501", 3000, "HaNeulLee"));
        MyData.add(MyPictures);

        MyPictures.add(new File("이하늘3.gif", "20220501", 4000, "HaNeulLee"));
        MyPictures.add(new File("이하늘4.jpg", "20220501", 5000, "HaNeulLee"));
        MyPictures.add(new File("이하늘5.png", "20220501", 6000, "HaNeulLee"));

        MyDocuments.printList();
    }
}
