package com.ly.consumer;

import com.ly.config.RabbitConfig;
import com.ly.entity.Book;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BookHandler {

    private static final Logger log = LoggerFactory.getLogger(BookHandler.class);
    @RabbitListener(queues = {RabbitConfig.DEFAULT_BOOK_QUEUE})
    public void listenerAutoAck(Book book, Message message, Channel channel){
        final long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try{
            log.info("[listenerAutoAck监听消息]-[{}]",book.toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch(IOException e){
            try{
                channel.basicRecover();
            }catch(IOException e1){
                e1.printStackTrace();
            }
        }
    }
    @RabbitListener(queues = {RabbitConfig.MANUAL_BOOK_QUEUE})
    public void listenerManualAck(Book book,Message message,Channel channel){
        try{
            log.info("[listenerAutoAck监听消息]-[{}]",book.toString());
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
        }catch(IOException e){

        }
    }
}
