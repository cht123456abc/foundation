import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test
{


    public static void main(String[] args)
    {

        final String listVarRegex = "List\\s+\\S+\\s+=\\s+(\\[[^\\]]*\\])";
        String content = "task wrapper(type: Wrapper) { \n" +
                "  gradleVersion = '2.14' \n" +
                "}\n" +
                "\n" +
                "apply plugin: \"eclipse\"\n" +
                "\n" +
                "// allprojects means this configuration \n" +
                "// will be inherited by the root project itself and subprojects \n" +
                "allprojects { \n" +
                "   // Artifact Id of the projct \n" +
                "   group 'org.whinedo.serverlessbook'\n" +
                "   // Version of the project \n" +
                "   version '1.0' \n" +
                "   // Gradle JAVA plugin needed for JAVA support \n" +
                "   apply plugin: 'java' \n" +
                "   // We will be using JAVA 8, then 1.8 \n" +
                "   sourceCompatibility = 1.8 \n" +
                "}\n" +
                "\n" +
                "allprojects {\n" +
                "  repositories {\n" +
                "     mavenCentral()\n" +
                "     jcenter()\n" +
                "     maven {\n" +
                "       url \"https://jitpack.io\"\n" +
                "     }\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "buildscript {\n" +
                "  repositories {\n" +
                "    mavenCentral()\n" +
                "    jcenter()\n" +
                "    maven {\n" +
                "       url \"https://jitpack.io\"\n" +
                "    }\n" +
                "  }\n" +
                "\n" +
                "  dependencies {\n" +
                "    classpath \"com.github.jengelman.gradle.plugins:shadow:1.2.3\"\n" +
                "    classpath \"jp.classmethod.aws:gradle-aws-plugin:0.+\"\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "allprojects {\n" +
                "  dependencies {\n" +
                "    testCompile group: 'junit', name: 'junit', version: '4.11'\n" +
                "      compile 'junit:junit:4.12'\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "allprojects {\n" +
                "  apply plugin: \"jp.classmethod.aws\"\n" +
                "  aws {\n" +
                "    region = \"us-east-2\"\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "def deploymentBucketName = \"whinedo-serverless-book-${aws.region}\"\n" +
                "def deploymentTime = new java.text.SimpleDateFormat(\"yyyyMMddHHmmss\").format(new Date());\n" +
                "\n" +
                "allprojects {\n" +
                "    apply plugin: \"jp.classmethod.aws.s3\"\n" +
                "    task createDeploymentBucket(type: jp.classmethod.aws.gradle.s3.CreateBucketTask) {\n" +
                "        bucketName deploymentBucketName\n" +
                "        ifNotExists true\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "configure(subprojects.findAll()) {\n" +
                "  if (it.name.startsWith(\"lambda-\")) {\n" +
                "    dependencies {\n" +
                "      compile project(':lambda')\n" +
                "    }\n" +
                "\n" +
                "  apply plugin: \"com.github.johnrengelman.shadow\"\n" +
                "     build.finalizedBy shadowJar\n" +
                "\n" +
                "    def producedJarFilePath = it.tasks.shadowJar.archivePath\n" +
                "    def s3Key = \"artifacts/${it.name}/${it.version}/${deploymentTime}.jar\"\n" +
                "\n" +
                "    task uploadArtifactsToS3(type: jp.classmethod.aws.gradle.s3.AmazonS3FileUploadTask,\n" +
                "            dependsOn: [build, createDeploymentBucket]) {\n" +
                "        bucketName deploymentBucketName\n" +
                "        file producedJarFilePath\n" +
                "        key s3Key\n" +
                "    }\n" +
                "\n" +
                "  }\n" +
                "}";

        // 分别解析subprojects和allprojects中的依赖
        int length = content.length();
        int start = 0;
        int end = 0;
        Pattern pattern = Pattern.compile("(allprojects|subprojects)\\s+\\{");
        Matcher matcher = pattern.matcher(content);
        String[] split = pattern.split(content);
        Arrays.stream(split).forEach(System.out::println);
        while (matcher.find())
        {
            start = matcher.start();
            System.out.println(matcher.group());
            System.out.println(start);
        }




            /*List<String> listVars = MatchUtil.multipleMatch(content, listVarRegex);

            for (String var : listVars)
            {
                String variateName = MatchUtil.matchColumn(var, "List\\s+(\\S+)\\s*=");
                Pattern p = Pattern.compile("(\\d+)\\s+\"(\\S+)\"");
                Matcher matcher = p.matcher(var);
                int number = 0;
                String depStr = "";
                List<String> depStrList = new LinkedList<>();
                while (matcher.find())
                {
                    number = Integer.parseInt(matcher.group(1));
                    depStr = matcher.group(2);
                    depStrList.add(depStr + ":" + number);
                }
                System.out.println(depStrList);


                String regex = "compile.*" + variateName;
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher1 = pattern.matcher(content);
                System.out.println(matcher1.find());

            }*/
    }
}
