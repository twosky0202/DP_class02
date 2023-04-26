package hw.ch11;

public abstract class Entry {
    public abstract String getName();

    public abstract int getSize();

    public abstract String getDate();

    public abstract int getCount();

    public abstract String getAuthor();

    public void printList() {
        printList("");
    }

    protected abstract void printList(String prefix);

    @Override
    public String toString() {
        return getName() + " (" + getSize() + ") [" + getDate() + "] [" + getCount() + "개] [" + getAuthor() + "]";
    }
}
