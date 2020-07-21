package mqtt.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
@Configuration
public class MqttDataRabbitConfig {
 
    //队列取名
    final static String YIHON_WQ_M = "topic.mqtt.data.yihon.wq.m";
 
 
    // 创建队列
    @Bean
    public Queue yihonWqmQueue() {
        return new Queue(MqttDataRabbitConfig.YIHON_WQ_M);
    }
 
    //Direct交换机 起名：directExchange
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }
 
    //绑定  将队列和交换机绑定, 并设置用于匹配键：directExchange
    @Bean
    Binding bindingYihonWqmMessage(Queue yihonWqmQueue, DirectExchange directExchange) {
        return BindingBuilder.bind(yihonWqmQueue).to(directExchange).with("yihonWqm");
    }
 
}