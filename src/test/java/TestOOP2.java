import cn.edu.scu.cmb.oop2.Account;
import cn.edu.scu.cmb.oop2.Client;
import org.junit.Assert;
import org.junit.Test;

public class TestOOP2 {


    /**
     * 有账号，密码正确，登录成功
     */
    @Test
    public void test() {

        Client client = new Client();

        Account account = client.register("user", "123");
        boolean res = client.login("user", "123");

        Assert.assertTrue(res);

    }

    /**
     * 有账号，密码失败，登录失败
     */
    @Test
    public void test2() {

        Client client = new Client();

        Account account = client.register("user", "123");
        boolean res = client.login("user", "1234");

        Assert.assertFalse(res);

    }

    /**
     * 无账号，登录失败
     */
    @Test
    public void test3() {

        Client client = new Client();

        boolean res = client.login("user", "1234");

        Assert.assertFalse(res);

    }

    /**
     * 有账号，忘记密码，修改密码
     */
    @Test
    public void test4() {

        Client client = new Client();

        Account account = client.register("user", "123");
        boolean res = client.modify("user", "1234", "12345");

        Assert.assertFalse(res);

    }



}
