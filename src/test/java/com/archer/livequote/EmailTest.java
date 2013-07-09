package com.archer.livequote;

import com.archer.livequote.email.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/ApplicationContext.xml"})
public class EmailTest {
    @Autowired
    private EmailService es;


    @Test
    public void testWelcome() {
        es.sendEmail("1", new String[]{"jinglong.yang@gmail.com"});
    }

    @Test
    public void testNewQuote() {
        es.sendEmail("2", new String[]{"yuzhao86@gmail.com", "nanzhao136@gmail.com"});
    }
}
