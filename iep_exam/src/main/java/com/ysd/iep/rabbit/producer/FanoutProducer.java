
package com.ysd.iep.rabbit.producer;

import com.ysd.iep.entity.parameter.ExamUltimately;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/**
 * 消息生产者
 * @author mashuai
 *
 */

@Component
public class FanoutProducer {
	@Autowired
	private AmqpTemplate amqpTemplate; //RabbitMQ配置好以后由Spring容器自动提供


/**
	 * 发送消息给消息队列
	 * queueName消息队列的名称 例如 "new_fanout_eamil_queue","new_fanout_sms_queue"
	 * 发送消息给消息队列
	 * 可直接发送给队列不传交换机参数
	 * 可直接发送给交换机不传队列参数
	 * queueName消息队列的名称 例如 "new_fanout_eamil_queue","new_fanout_sms_queue"
	 */

	public void sendTestLog(ExamUltimately examUltimately){
		String queueName="new_fanout_user_queue";
		if(queueName != null && !"".equals(queueName)) {
			// 发送消息
			//amqpTemplate.convertAndSend(queueName, users);//直接发送给队列
			String exchange = "fanoutExchange";
			amqpTemplate.convertAndSend(exchange,queueName,examUltimately);
		}else {
			// 发送消息
			String exchange = "fanoutExchange";
			amqpTemplate.convertAndSend(exchange, queueName, examUltimately);//发送给交换机,再按照路由键发送给对应路由键的队列
		}

	}
	//对象转化为字节码
	public  byte[] getBytesFromObject(Serializable obj) throws Exception {
		if (obj == null) {
			return null;
		}
		ByteArrayOutputStream bo = new ByteArrayOutputStream();
		ObjectOutputStream oo = new ObjectOutputStream(bo);
		oo.writeObject(obj);
		return bo.toByteArray();
	}

}
