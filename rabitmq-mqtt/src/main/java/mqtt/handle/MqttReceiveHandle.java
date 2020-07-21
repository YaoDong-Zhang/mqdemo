package mqtt.handle;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
 
/**
 * mqtt客户端消息处理类
 * **/
@Slf4j
@Component
public class MqttReceiveHandle {
 
    //使用RabbitTemplate,这提供了接收/发送等等方法
    @Autowired
    private RabbitTemplate rabbitTemplate;
 
    public void handle(Message<?> message){
        log.info("主题：{}，QOS:{}，消息接收到的数据：{}", message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC), message.getHeaders().get(MqttHeaders.RECEIVED_QOS), message.getPayload());
        //发送到rabbit消息队列
        rabbitTemplate.convertAndSend("directExchange", "yihonWqm", (String) message.getPayload());
 
    }
}