package MessageChat;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;

@SpringBootApplication
@ComponentScan
@EnableJms
public class Application extends SpringBootServletInitializer {

	@Bean
	public ConnectionFactory connectionFactory(){

		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://localhost:61616");
		connectionFactory.setUserName("admin");
		connectionFactory.setPassword("admin");
		return connectionFactory;

	}

	@Bean
	public JmsTemplate jmsQueueTemplate(){
		return new JmsTemplate(connectionFactory());
	}

	@Bean(name = "jmsQueueListenerCF")
	public DefaultJmsListenerContainerFactory jmsQueueListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory =
				new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		//设置连接数
		factory.setConcurrency("3-10");
		//重连间隔时间
		factory.setRecoveryInterval(1000L);
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

	}

}
