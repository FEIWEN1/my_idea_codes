package com.wfei.daliy.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

/**
 * @author feiwen
 * @date 2018/11/20
 */
public class KafkaConsumer implements MessageListener<Integer,String> {

    @Override
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) {
        Object o = consumerRecord.value();
        System.out.println(String.valueOf(o));
    }
}
