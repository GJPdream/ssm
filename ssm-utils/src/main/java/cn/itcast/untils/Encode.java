package cn.itcast.untils;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Encode {
    /**
     * 给密码加密的
     */
    private static BCryptPasswordEncoder bCryptPasswordEncoder= new BCryptPasswordEncoder();

    public static String encode(String password)
    {
        return  bCryptPasswordEncoder.encode(password);
    }
@Test
    public void fun()
{
    String password="123456";
    String encode = encode(password);
    /*密码加密 123
    * $2a$10$EW.3wFdl8UpqQxVqvuZgVeTzk7xvwYIfmvnSBczpFLoXgzB6Pvgsi
    * $2a$10$NCK9y5pi4dJlw3dduGAUxuwooRvnfcNH4o1dRgWQ3iI4XGWuwPi4u
    * */
    System.out.println(encode);
}
}
