package cn.edu.scu.test;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        String content = "buildscript {\n" +
                "    repositories {\n" +
                "        mavenLocal()\n" +
                "        maven { url \"http://xxx.xxx.xxx.xxx:8081/nexus/content/groups/public\" }\n" +
                "        //mavenCentral()\n" +
                "        //jcenter()\n" +
                "    }\n" +
                "    dependencies {\n" +
                "        classpath(\"org.springframework.boot:spring-boot-gradle-plugin:1.4.0.RELEASE\")\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "allprojects {\n" +
                "    apply plugin: 'idea'\n" +
                "    apply plugin: 'eclipse'\n" +
                "\n" +
                "    group = 'com.foo.bar'\n" +
                "    version = '1.0-SNAPSHOT'\n" +
                "    //archivesBaseName = 'project'\n" +
                "\n" +
                "    repositories {\n" +
                "        mavenLocal()\n" +
                "        maven { url \"http://xxx.xxx.xxx.xxx:8081/nexus/content/groups/public\" }\n" +
                "        //mavenCentral()\n" +
                "        //jcenter()\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "subprojects {\n" +
                "    apply plugin: 'java'\n" +
                "    apply plugin: \"spring-boot\"\n" +
                "\n" +
                "    sourceCompatibility = 1.8\n" +
                "    targetCompatibility = 1.8\n" +
                "\n" +
                "    dependencies {\n" +
                "        compile 'org.springframework.boot:spring-boot-starter'\n" +
                "        compile 'org.springframework.boot:spring-boot-configuration-processor'\n" +
                "        compile 'org.springframework.boot:spring-boot-devtools'\n" +
                "        testCompile 'org.springframework.boot:spring-boot-starter-test'\n" +
                "    }\n" +
                "\n" +
                "    test {\n" +
                "        exclude 'com/foo/bar/**'\n" +
                "    }\n" +
                "\n" +
                "    task listJars(description: 'Display all compile jars.') << {\n" +
                "        configurations.compile.each { File file -> println file.name }\n" +
                "    }\n" +
                "}\n" +
                "\n" +
                "task wrapper(type: Wrapper) {\n" +
                "    gradleVersion = '3.1'\n" +
                "}";

        content = convert(content);
        System.out.println(content);



    }

    private static String convert(String content){
        String[] lines = content.split("\n");
        for(int i = 0;i < lines.length;i++){
            lines[i] = i+1+lines[i];
        }
        return String.join("\n", lines);
    }
}
