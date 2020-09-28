import cn.edu.scu.utils.MatchUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCargo {

    @Test
    public void test() {

        String content = "[lib]\n" +
                "name = \"emerald_vault\"\n" +
                "path = \"src/lib.rs\"\n" +
                "\n" +
                "[[bench]]\n" +
                "name = \"bench_crypto\"\n" +
                "harness = false\n" +
                "[dependencies.aes-ctr]\n" +
                "version = \"0.1\"\n" +
                "\n" +
                "[dependencies.base64]\n" +
                "version = \"0.11.0\"";
    }


    @Test
    public void testCargo() {
        String content = "1[package]\n" +
                "2name = \"app\"\n" +
                "3version = \"0.1.0\"\n" +
                "4authors = [\"Chris P <chrisp1877@gmail.com>\"]\n" +
                "5edition = \"2018\"\n" +
                "6\n" +
                "7# See more keys and their definitions at https://doc.rust-lang.org/cargo/reference/manifest.html\n" +
                "8\n" +
                "9[dependencies]\n" +
                "10clap=\"*\"\n" +
                "11#materials={path=\"../materials/\"}\n" +
                "12#dsp={path=\"../dsp/\"}\n" +
                "13nlp={path=\"../nlp/\"}\n" +
                "14tinytemplate = \"1.0\"\n" +
                "15tokio={version=\"*\", features=[\"full\"]}\n" +
                "16\n" +
                "17[[bin]]\n" +
                "18name=\"app\"\n" +
                "19path=\"./src/main.rs\"\n" +
                "20\n" +
                "21#isahc=\"*\"\n" +
                "22#slab=\"*l\"\n" +
                "23#abscissa_core = \"0.5.2\"";

//        String content = "[package]\n" +
//                "name = \"provewhen\"\n" +
//                "version = \"0.1.0\"\n" +
//                "authors = [\"James Munns <james.munns@gmail.com>\"]\n" +
//                "\n" +
//                "[dependencies]\n" +
//                "mvdb = \"0.2\"\n" +
//                "\n" +
//                "ring = \"0.11\"\n" +
//                "untrusted = \"0.5\"\n" +
//                "\n" +
//                "base64 = \"0.6\"\n" +
//                "\n" +
//                "serde = \"1.0\"\n" +
//                "serde_derive = \"1.0\"\n" +
//                "\n" +
//                "rocket = \"0.3.0\"\n" +
//                "rocket_codegen = \"0.3.0\"\n" +
//                "rocket_contrib = \"0.3.0\"\n" +
//                "\n" +
//                "error-chain = \"0.10\"\n" +
//                "lazy_static = \"0.2\"\n" +
//                "\n" +
//                "rand = \'0.3\'\n" +
//                "some-crate = { version = \'1.0\', registry = \"my-registry\"\n}" +
//                "\n" +
//                "some-crate = { version = \"1.0\", registry = \"my-registry\"\n}" +
//                "\n" +
//                "[dependencies.chrono]\n" +
//                "version = \"0.4\"\n" +
//                "features = [\"serde\"]";
//
//        content = MatchUtil.addLineNumber(content);

        // 找[dependencies]块
        Matcher dependencies_content_matcher = Pattern.compile("\\[dependencies\\][\\s\\S]*?(?=\n(\\d+)\\[)").matcher(content);
        String dependenciesContent = "";
        if (dependencies_content_matcher.find()) {
            dependenciesContent = dependencies_content_matcher.group();
            System.out.println(dependenciesContent);
        } else {
            // 没找到
        }

        // 找普通形式依赖
        Matcher dependency_matcher = Pattern.compile("(\\d+) *([^#{\\s]+?)\\s*=\\s*['\"](\\S+)(?=['\"])").matcher(dependenciesContent);
        while (dependency_matcher.find()) {
            System.out.println("================");
            System.out.println(dependency_matcher.group(1));
            System.out.println(dependency_matcher.group(2));
            System.out.println(dependency_matcher.group(3));
        }

        // 找some-crate = { version = "1.0", registry = "my-registry" } 类型依赖
        Matcher matcher = Pattern.compile("(\\d+) *(\\S+)\\s*=.*?(?:version)\\s*=\\s*['\"](\\S+)?(?:['\"])").matcher(dependenciesContent);
        while (matcher.find()) {
            System.out.println("================");
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }

    }

    @Test
    public void testCargoVersionRange() {

        String version = "1.1.1";

        Matcher matcher = Pattern.compile("[~*><=\\^]").matcher(version);
        System.out.println(matcher.find());
    }

    @Test
    public void testCargoRelations() {
        String content = "[package]\n" +
                "name = \"provewhen\"\n" +
                "version = \"0.1.0\"\n" +
                "authors = [\"James Munns <james.munns@gmail.com>\"]\n" +
                "\n" +
                "[dependencies]\n" +
                "mvdb = \"0.2\"\n" +
                "\n" +
                "ring = \"0.11\"\n" +
                "untrusted = \"0.5\"\n" +
                "\n" +
                "base64 = \"0.6\"\n" +
                "\n" +
                "serde = \"1.0\"\n" +
                "serde_derive = \"1.0\"\n" +
                "\n" +
                "rocket = \"0.3.0\"\n" +
                "rocket_codegen = \"0.3.0\"\n" +
                "rocket_contrib = \"0.3.0\"\n" +
                "\n" +
                "error-chain = \"0.10\"\n" +
                "lazy_static = \"0.2\"\n" +
                "\n" +
                "rand = \"0.3\"\n" +
                "\n" +
                "[dependencies.chrono]\n" +
                "version = \"0.4\"\n" +
                "features = [\"serde\"]";

        content = MatchUtil.addLineNumber(content);

        // 找模组名
        // 找[package]块
        Matcher matcher = Pattern.compile("\\[package][\\s\\S]*?(?=\n(\\d+)\\[)").matcher(content);
        String packageContent = "";
        while (matcher.find()) {
            System.out.println(matcher.group());
            packageContent = matcher.group();
        }

        // 找name
        Matcher matcher1 = Pattern.compile("name *= *['\"](\\S+)(?:['\"])").matcher(packageContent);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }

    }

    @Test
    public void testCargoSubModules() {
        String content = "[package]\n" +
                "name = \"alsacoin\"\n" +
                "version = \"0.1.0-alpha\"\n" +
                "authors = [\"chritchens <chritchens@gmail.com>\"]\n" +
                "edition = \"2018\"\n" +
                "license = \"MIT/Apache-2.0\"\n" +
                "repository = \"https://github.com/alsacoin/alsacoin\"\n" +
                "homepage = \"https://github.com/alsacoin/alsacoin\"\n" +
                "description = \"Rust client for the Alsacoin protocol\"\n" +
                "readme = \"README.md\"\n" +
                "categories = [\"cryptography\", \"cryptocurrency\", \"blockchain\"]\n" +
                "\n" +
                "[badges]\n" +
                "travis-ci = { repository = \"alsacoin/alsacoin\", branch = \"master\" }\n" +
                "\n" +
                "[workspace]\n" +
                "members = [\"crypto\", \"store\",  \"mining\", \"models\", \"protocol\",  \"network\", \"config\", \"cli\", \"log\"]\n" +
                "\n" +
                "[lib]\n" +
                "name = \"alsacoin\"\n" +
                "path = \"src/lib.rs\"\n" +
                "\n" +
                "[[bin]]\n" +
                "name = \"alsad\"\n" +
                "path = \"bin/alsad.rs\"\n" +
                "\n" +
                "[[bin]]\n" +
                "name = \"alsac\"\n" +
                "path = \"bin/alsac.rs\"\n" +
                "\n" +
                "[dependencies]\n" +
                "crypto = { path = \"crypto\" }\n" +
                "store = { path = \"store\" }\n" +
                "mining = { path = \"mining\" }\n" +
                "models = { path = \"models\" }\n" +
                "protocol = { path = \"protocol\" }\n" +
                "network = { path = \"network\" }\n" +
                "config = { path = \"config\" }\n" +
                "log = { path = \"log\" }\n" +
                "cli = { path = \"cli\" version}";


        content = MatchUtil.addLineNumber(content);

        // 找子模组名
        Matcher sub_module_matcher = Pattern.compile("\\d+ *(\\S+)? *= *\\{ *path").matcher(content);
        List<String> subModules = new ArrayList<>();
        while (sub_module_matcher.find())
        {
            System.out.println(sub_module_matcher.group());
            System.out.println(sub_module_matcher.group(1));
            subModules.add(sub_module_matcher.group(1));
        }

    }


}
