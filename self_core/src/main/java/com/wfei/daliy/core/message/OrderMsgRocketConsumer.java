package com.wfei.daliy.core.message;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.MessageListener;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;

import java.util.UUID;

/**
 * Created by feiwen on 2018/4/24.
 */
public class OrderMsgRocketConsumer {

    private DefaultMQPushConsumer consumer;
    private MessageListener listener;
    private String nameServer;
    private String groupName;
    private String topics;

    public OrderMsgRocketConsumer(DefaultMQPushConsumer consumer, MessageListener listener, String nameServer, String groupName, String topics) {
        this.consumer = consumer;
        this.listener = listener;
        this.nameServer = nameServer;
        this.groupName = groupName;
        this.topics = topics;
    }

    public void init() {
        consumer =new DefaultMQPushConsumer(groupName);
        consumer.setNamesrvAddr(nameServer);
        try {
            consumer.subscribe(topics,"*");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        consumer.setInstanceName(UUID.randomUUID().toString());
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.registerMessageListener((MessageListenerConcurrently)this.listener);
        try {
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
