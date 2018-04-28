package MessageChat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class PtpListener1 {

    @Autowired
    MessageService messageService;
    /**
     * 消息队列监听器
     * destination 队列地址
     * containerFactory 监听器容器工厂, 若存在2个以上的监听容器工厂,需进行指定
     */
    @JmsListener(destination = "ptp", containerFactory = "jmsQueueListenerCF")
    public void receive(String msg) throws UnsupportedEncodingException {

        messageService.AddMessage(msg);
    }
}