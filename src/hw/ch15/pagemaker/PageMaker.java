package hw.ch15.pagemaker;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class PageMaker {
    private PageMaker() {
    }

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title(username + "'s web page");
            writer.paragraph("Welcome to " + username + "'s web page!");
            writer.paragraph("Nice to meet you!");
            writer.mailto(mailaddr, username);
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) { // 이메일 주소 링크 페이지를 만듦
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link page");

            Properties mailprop = Database.getProperties("maildata"); // 프로퍼티를 얻어옴

            for (String mailaddr : mailprop.stringPropertyNames()) { // 프로퍼티 이름(키)을 얻어옴
                String username = mailprop.getProperty(mailaddr, "(unknown)");
                writer.mailto(mailaddr, username);
            }

            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeUrlPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter( // 한글 출력을 위해 인코딩 설정 바꿔주기
                    new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8));
            writer.title2("url page");
            writer.h1("이하늘의 URL Page");

            Properties urlprop = Database.getProperties("urldata"); // 프로퍼티를 얻어옴

            for (String urlname : urlprop.stringPropertyNames()) { // 프로퍼티 이름(키)을 얻어옴
                String url = urlprop.getProperty(urlname, "(unknown)");
                writer.link(url, urlname);
            }

            writer.close();
            System.out.println(filename + " is created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
