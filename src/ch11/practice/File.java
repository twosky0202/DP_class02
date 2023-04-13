package ch11.practice;

// leaf node에 해당됨
public class File extends Entry {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    protected void printList(String prefix) { // prefix: 앞의 경로 이름
        System.out.println(prefix + "/" + this); // this: this.toString()
    }
}
