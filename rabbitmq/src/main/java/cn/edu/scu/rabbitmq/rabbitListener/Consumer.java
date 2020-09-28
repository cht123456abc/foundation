package cn.edu.scu.rabbitmq.rabbitListener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queuesToDeclare = @Queue("zip_1"))
    public void receive(String msg) {
        try {
            handle(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void handle(String msg) {
        System.out.println(msg);
        try {
            throw new RuntimeException("错误");
        } catch (Exception e) {
            throw e;
        }
    }

}
