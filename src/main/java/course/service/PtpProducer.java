package course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class PtpProducer {

    @Autowired
    private JmsTemplate jmsQueueTemplate;

    /**
     * 发送消息自动转换成原始消息
     */
    public void convertAndSend(String text){
        jmsQueueTemplate.convertAndSend("ptp", text);
    }
}