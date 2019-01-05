package com.ysd.iep.rabbit.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * RabbitMQ配置类
 * 发布订阅模式 
 * 配置的交换机类型为 fanout
 */
@Component
public class FanoutConfig {

	// 邮件队列  的名称
	private String FANOUT_EMAIL_QUEUE = "new_fanout_eamil_queue";

	// 短信队列  的名称
	private String FANOUT_SMS_QUEUE = "new_fanout_sms_queue";
	// 对象队列  的名称
	private String FANOUT_USER_QUEUE = "new_fanout_user_queue";

	// Fanout类型的 交换机 的名称
	private String EXCHANGE_NAME = "fanoutExchange";

	// 1.定义邮件队列
	@Bean
	public Queue fanoutEmailQueue() {
		return new Queue(FANOUT_EMAIL_QUEUE);
	}
	// <bean id="fanoutEmailQueue" class="Queue"

	// 2.定义短信队列
	@Bean
	public Queue fanoutSmsQueue() {
		return new Queue(FANOUT_SMS_QUEUE);
	}
	// 2.定义对象队列
	@Bean
	public Queue fanoutUserQueue() {
		return new Queue(FANOUT_USER_QUEUE);
	}

	// 3.定义Fanout交换机
	@Bean
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange(EXCHANGE_NAME);
	}

	
	// 3.邮件队列和交换机进行绑定 参数名称和定义队列和交换机方法名称一致
	/**
	 * 把 Fanout交换机 与 短信队列 绑定
	 * @param fanoutEmailQueue 必须与定义定义 短信队列 方法名称一致
	 * @param fanoutExchange 必须与定义定义 定义Fanout交换机 方法名称一致
	 * @return
	 */
	@Bean
    Binding bindingExchangeEamil(Queue fanoutEmailQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutEmailQueue).to(fanoutExchange);
	}
	/**
	 * 把 Fanout交换机 与 短信队列 绑定
	 * @param fanoutUserQueue 必须与定义定义 短信队列 方法名称一致
	 * @param fanoutExchange 必须与定义定义 定义Fanout交换机 方法名称一致
	 * @return
	 */
	@Bean
    Binding bindingExchangeUser(Queue fanoutUserQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutUserQueue).to(fanoutExchange);
	}
	
	/**
	 * 把 Fanout交换机 与 邮件队列 绑定
	 * @param fanoutSmsQueue 必须与定义定义 短信队列 方法名称一致
	 * @param fanoutExchange 必须与定义定义 定义Fanout交换机 方法名称一致
	 * @return
	 */
	@Bean
    Binding bindingExchangeSms(Queue fanoutSmsQueue, FanoutExchange fanoutExchange) {
		return BindingBuilder.bind(fanoutSmsQueue).to(fanoutExchange);
	}
	@Bean
	public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
		RabbitTemplate template = new RabbitTemplate(connectionFactory);
		template.setMessageConverter(new Jackson2JsonMessageConverter());
		return template;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setMessageConverter(new Jackson2JsonMessageConverter());
		return factory;
	}
}

