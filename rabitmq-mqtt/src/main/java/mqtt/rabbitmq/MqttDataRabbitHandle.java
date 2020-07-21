package mqtt.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
 
 
@Slf4j
@Component
@RabbitListener(queues = "topic.mqtt.data.yihon.wq.m")
public class MqttDataRabbitHandle {

    @RabbitHandler
    public void process(String message) {
        log.info("MqttDataRabbitHandle消费者收到消息  : " + message);
    }
}