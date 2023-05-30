package ch15.Sample.pagemaker;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

class Database { // 패키지 밖에서 이용할 수 없음
    // 객체 만들지 못함
    private Database() {
    }

    // 데이터베이스 이름에서 Properties를 얻는다
    public static Properties getProperties(String dbname) throws IOException {
        String filename = dbname + ".txt";

        Properties prop = new Properties(); // properties 객체를 만듦

        prop.load(new FileReader(filename)); // property의 내용이 로드

        return prop;
    }
}
