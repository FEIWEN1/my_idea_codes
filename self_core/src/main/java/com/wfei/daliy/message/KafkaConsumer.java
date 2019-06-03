package com.wfei.daliy.message;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.perf4j.StopWatch;
import org.perf4j.slf4j.Slf4JStopWatch;
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
    public static void main(String[] args) {
        StopWatch stopWatch=new Slf4JStopWatch("shell");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(stopWatch.stop("ll"));
//        System.out.println(stopWatch.getElapsedTime());
    }

}
