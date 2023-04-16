package hw.ch10;

import java.util.Comparator;

public class Student implements Comparator<Student> {
    private String name;
    private String id;
    private int height;

    public Student(String name, String id, int height) {
        this.name = name;
        this.id = id;
        this.height = height;
    }

    public int compareTo(Student s) {
        if (this.height > s.height) {
            return 1;
        } else if (this.height < s.height) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int compare(Student s1, Student s2) {
        return s1.compareTo(s2);
    }

    @Override
    public String toString() {
        return "(이름: " + name + " 학번: " + id + " 키: " + height + ")";
    }
}