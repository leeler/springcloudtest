package com.umpay;

import com.umpay.sender.AmqpSender;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootAmqpApplication.class)
@WebAppConfiguration


//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = SpringBootAmqpApplication.class)
class SpringBootAmqpApplicationTests {

    @Autowired
    AmqpSender amqpSender;

    @Test
    public void hello() throws Exception {
        amqpSender.send();
    }

}
