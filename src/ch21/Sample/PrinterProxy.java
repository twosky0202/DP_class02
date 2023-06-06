package ch21.Sample;

// 대리인
public class PrinterProxy implements Printable {
    private String name; // 이름
    private Printer real; // '본인'

    // 생성자
    public PrinterProxy() {
        this.name = "No Name";
        this.real = null;
    }

    // 생성자(이름 지정)
    public PrinterProxy(String name) {
        this.name = name;
        this.real = null;
    }

    // 이름 설정
    @Override
    public synchronized void setPrinterName(String name) { // 멀티스레드
        if (real != null) { // 본인 객체가 생성되어 있다면
            // '본인'에게도 설정한다
            real.setPrinterName(name); // 대리인과 본인의 이름을 똑같이 맞춤
        }
        this.name = name;
    }

    // 이름 취득
    @Override
    public String getPrinterName() {
        return name;
    }

    // 표시
    @Override
    public void print(String string) { // 대리인이 하지 못하는 일
        realize(); // 본인을 생성함
        real.print(string); // 본인에게 위임
    }

    // 본인 생성
    private synchronized void realize() { // 멀티스레드
        if (real == null) {
            real = new Printer(name); // Printer라는 클래스 이름이 직접 하드코딩 되어 있음
        }
    }
}
