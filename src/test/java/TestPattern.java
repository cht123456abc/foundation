import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPattern {

    @Test
    public void test() {
        String src = ",19:2&8:2";
        Pattern pattern1 = Pattern.compile("(?<!\\d)9:2");
        Matcher matcher1 = pattern1.matcher(src);
        while (matcher1.find()) {
            System.out.println("第一个:" + matcher1.group());
        }

        String src2 = ",9:2&8:2";
        Pattern pattern2 = Pattern.compile("(?<!\\d)9:2");
        Matcher matcher2 = pattern2.matcher(src2);
        while (matcher2.find()) {
            System.out.println("第二个:" + matcher2.group());
        }




    }


}
