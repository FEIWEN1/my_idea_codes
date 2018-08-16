package com.wfei.daliy.core.message;

import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;


/**
 * Created by feiwen on 2018/4/23.
 */
public class OrderMsgRocketProducer {
    private DefaultMQProducer orderMsgProducer;
    private String orderMsgTopic;

    /**
     * @param tag
     * @param msg
     * @return
     */
    public SendResult sendMsg(String tag, String msg) throws Exception {
        Message rocketMsg=new Message(orderMsgTopic, tag, msg.getBytes("UTF-8"));
        SendResult sendResult=orderMsgProducer.send(rocketMsg);
        if(sendResult!=null&&sendResult.getSendStatus()== SendStatus.SEND_OK){
            System.out.println("发送消息成功");
        }else{
            System.out.println("发送消息失败");
        }
        return sendResult;
    }

    public SendResult sendOrderMsg(String tag, String msg, Object primaryKey) {
        return null;
    }

    /**
     * 初始化
     *
     * @throws MQClientException
     */
    public void init() throws MQClientException {
        this.orderMsgProducer.start();
    }

    /**
     * 销毁
     */
    public void destory() {
        this.orderMsgProducer.shutdown();
    }

    public DefaultMQProducer getOrderMsgProducer() {
        return orderMsgProducer;
    }

    public void setOrderMsgProducer(DefaultMQProducer orderMsgProducer) {
        this.orderMsgProducer = orderMsgProducer;
    }

    public String getOrderMsgTopic() {
        return orderMsgTopic;
    }

    public void setOrderMsgTopic(String orderMsgTopic) {
        this.orderMsgTopic = orderMsgTopic;
    }
}
