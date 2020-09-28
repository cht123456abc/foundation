import cn.edu.scu.utils.MatchUtil;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestSbt {


    @Test
    public void testModuleNameAndVersion() {
        String content = "version := \"1.0\"";


    }

    @Test
    public void test10() {
        String content = "1name := \"sbt-basic\"\n" +
                "2\n" +
                "3version := \"1.0\"\n" +
                "4\n" +
                "5scalaVersion := \"2.11.8\"\n" +
                "6val derby = \"org.apache.derby\" % \"derby\" % \"10.4.1.3\"\n" +
                "7libraryDependencies += \"org.mindrot\" % \"jbcrypt\" % \"0.3m\"\n" +
                "8\n" +
                "988libraryDependencies += \"net.liftweb\" %% \"lift-webkit\" % \"3.0-M4\"\n" +
                "10ibraryDependencies += \"org.apache.derby\" % \"derby\" % \"10.4.1.3\" % \"test\"\n";

        Pattern pattern1 = Pattern.compile("(\\d+).*?=\\s*\"(\\S+)(?=\")\"\\s*%{1,2}\\s*\"(\\S+)(?=\")\"\\s*%\\s*\"(\\S+)(?=\")\"(?!\\s*%)");
        Matcher matcher1 = pattern1.matcher(content);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));
            System.out.println(matcher1.group(3));
            System.out.println(matcher1.group(4));
            System.out.println("++++++++++");

        }
    }

    @Test
    public void test10_1() {
        String content = "name := \"CookIM\"\n" +
                "\n" +
                "version := \"0.2.4-SNAPSHOT\"\n" +
                "\n" +
                "scalaVersion := \"2.11.8\"\n" +
                "\n" +
                "scalacOptions := Seq(\"-unchecked\", \"-deprecation\", \"-encoding\", \"utf8\")\n" +
                "\n" +
                "libraryDependencies ++= {\n" +
                "  val akkaV = \"2.5.2\"\n" +
                "  val akkaHttpV = \"10.0.7\"\n" +
                "  val reactivemongoV = \"0.12.3\"\n" +
                "  Seq(\n" +
                "    \"com.typesafe.akka\" %% \"akka-actor\"  % akkaV,\n" +
                "    // \"com.typesafe.akka\" %% \"akka-remote\" % akkaV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-cluster\" % akkaV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-cluster-tools\" % akkaV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-testkit\" % akkaV % Test,\n" +
                "    \"com.typesafe.akka\" %% \"akka-stream\" % akkaV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-stream-testkit\" % akkaV % Test,\n" +
                "    // \"com.typesafe.akka\" %% \"akka-http-core\" % akkaHttpV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-http\" % akkaHttpV,\n" +
                "    \"com.typesafe.akka\" %% \"akka-http-testkit\" % akkaHttpV % Test,\n" +
                "//     \"org.scalactic\" %% \"scalactic\" % \"3.0.1\",\n" +
                "//     \"org.scalatest\" %% \"scalatest\" % \"3.0.1\" % \"test\",\n" +
                "    \"com.typesafe.play\" %% \"play-json\" % \"2.5.15\",\n" +
                "    \"org.slf4j\" % \"slf4j-simple\" % \"1.7.25\",\n" +
                "    \"com.sksamuel.scrimage\" %% \"scrimage-core\" % \"2.1.8\",\n" +
                "    \"com.sksamuel.scrimage\" %% \"scrimage-io-extra\" % \"2.1.8\",\n" +
                "    \"com.esotericsoftware\" % \"kryo\" % \"4.0.0\",\n" +
                "    \"com.github.romix.akka\" %% \"akka-kryo-serialization\" % \"0.5.0\",\n" +
                "    \"commons-cli\" % \"commons-cli\" % \"1.4\",\n" +
                "    \"io.jsonwebtoken\" % \"jjwt\" % \"0.7.0\",\n" +
                "    \"org.reactivemongo\" %% \"reactivemongo\" % reactivemongoV,\n" +
                "    \"org.reactivemongo\" %% \"reactivemongo-play-json\" % reactivemongoV\n";

        content = MatchUtil.addLineNumber(content);

        Pattern pattern1 = Pattern.compile("val\\s*(\\S+)\\s*=\\s*\"(\\S+)(?:\")");
        Matcher matcher1 = pattern1.matcher(content);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
            System.out.println(matcher1.group(1));
            System.out.println(matcher1.group(2));
        }


//        Pattern pattern1 = Pattern.compile("(\\d+)\\s*\"(\\S+)(?=\")\"\\s*%{1,2}\\s*\"(\\S+)(?=\")\"\\s*%\\s*(\\S+?)(?:,)\\s*(?!\\s*%)");
//        Matcher matcher1 = pattern1.matcher(content);
//        while (matcher1.find()) {
//            System.out.println(matcher1.group());
//            System.out.println(matcher1.group(1));
//            System.out.println(matcher1.group(2));
//            System.out.println(matcher1.group(3));
//            System.out.println(matcher1.group(4));
//            System.out.println("+++++++++++++++++++++++++++");
//        }
    }




    @Test
    public void test11() {

        String content = "name := \"version-ranges\"\n" +
                "\n" +
                "version := \"1.0\"\n" +
                "\n" +
                "scalaVersion := \"2.11.8\"\n" +
                "\n" +
                "libraryDependencies += \"org.keycloak\" % \"keycloak-saml-core\" % \"[2.0.0,)\"\n" +
                "\n" +
                "libraryDependencies += \"net.liftweb\" %% \"lift-webkit\" % \"latest.integration\"";

        System.out.println(isVersionRange("[2.0.0,)"));
        System.out.println(isVersionRange("latest.integration"));
        System.out.println(isVersionRange("2.0.0"));

        String version = "[2.0.0,)";
//        version = "latest.integration";


    }

    private boolean isVersionRange(String version) {
        return Pattern.compile("[+)\\]]|latest.integration").matcher(version).find();
    }
}
