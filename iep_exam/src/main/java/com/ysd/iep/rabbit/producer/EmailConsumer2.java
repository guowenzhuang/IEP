package com.ysd.iep.rabbit.producer;

import com.ysd.iep.dao.ExamrubricDao;
import com.ysd.iep.dao.StudentexamlogDao;
import com.ysd.iep.entity.Examrubric;
import com.ysd.iep.entity.Studentexamlog;
import com.ysd.iep.entity.parameter.ExamUltimately;
import com.ysd.iep.entity.parameter.Result;
import com.ysd.iep.entity.parameter.RubricQuery;
import com.ysd.iep.util.UUIDUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
//监听邮件队列的消息
public class EmailConsumer2 {
	@Autowired
	ExamrubricDao examrubricdao;
	@Autowired
	StudentexamlogDao studentexamlogdao;
	/**
	 * 考试做题记录成绩记录表中
	 */
	/*@RabbitListener(queues = "new_fanout_user_queue", containerFactory="rabbitListenerContainerFactory")
	public void examend(@Payload ExamUltimately examUltimately) {
		String Ider = UUIDUtils.getUUID();

		Examrubric examrubricbig = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);


		if (examrubricbig.getRubricttype().equals("单选题") || examrubricbig.getRubricttype().equals("多选题")) {
			System.out.println("单选或者多选");
			*//**
			 * 根据考试题干id查询本条做题记录
			 *//*
			Studentexamlog studentexamloger = studentexamlogdao.selectlogforexamrubricid(examUltimately.getExamrubricId(), examUltimately.getStudentId(), examUltimately.getExamparperId());

			*//**
			 * 判断根据考试题干查询的考试记录是否为空
			 *//*
			if (studentexamloger == null) {


				try {
					String Id = UUIDUtils.getUUID();


					*//**
					 * (根据考试试卷id将试卷的所有试题查询出来,
					 *  从中单独取出来试题的题干中的答案id[answerId],
					 *  遍历该id集合,使之与学生所选的答案id比较.
					 *  在根据答案id的外键关系可以获取到考试试卷的id,
					 *  再根据考试试卷id,对试题进行加分.)
					 *//*
					RubricQuery rubricQuery = new RubricQuery();
					rubricQuery.setExamparper(examUltimately.getExamparperId());
					List<Examrubric> examrubricList = this.getExamrubricforparperid(rubricQuery);
					List<String> answerlist = new ArrayList<>();

					int score = 0;
					if (examrubricbig.getRubricttype().equals("单选题")) {

						Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
						if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
							score = examUltimately.getScore();
						} else {
							score = 0;
						}
					} else {
						System.out.println("多选题***************");
						Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
						String[] answerid = examrubric.getAnswerId().split(",");
						String[] answerider = examUltimately.getSelectanswerId().split(",");
						Arrays.sort(answerid);
						Arrays.sort(answerider);

						if (Arrays.equals(answerid, answerider)) {
							score = examUltimately.getScore();
						} else {
							score = 0;

						}
					}

					*//**
					 * 声明一个新下考试记录对象
					 *//*
					Studentexamlog studentexamlog = new Studentexamlog();
					studentexamlog.setId(Id);
					studentexamlog.setCourseId(examUltimately.getCourseid());
					studentexamlog.setExamrubricId(examUltimately.getExamrubricId());
					studentexamlog.setExamparperId(examUltimately.getExamparperId());
					studentexamlog.setSelectId(examUltimately.getSelectanswerId());
					studentexamlog.setStudentId(examUltimately.getStudentId());
					studentexamlog.setPerformance(score);
					studentexamlogdao.save(studentexamlog);

					*//**
					 * 判断是否存在试卷的成绩记录
					 *//*

					System.out.println("记录成功");
					//return new Result(true, "记录成功", null);

				} catch (Exception e) {
					e.printStackTrace();
					//return new Result(false, "记录失败", null);
					System.out.println("记录失败");
				}

			} else {
				*//**
				 * 记录中有这条做题记录的情况
				 * (1)先取出本条考试记录  studentexamlogerdsa
				 * (2)再将前端传来的所选的答案id
				 *
				 *//*
				System.out.println("记录表中步步为空**************");
				try {
					RubricQuery rubricQuery = new RubricQuery();
					rubricQuery.setExamparper(examUltimately.getExamparperId());
					List<Examrubric> examrubricList = this.getExamrubricforparperid(rubricQuery);

					List<String> answerid = new ArrayList<>();
					for (int k = 0; k < examrubricList.size(); k++) {
						String answer = examrubricList.get(k).getAnswerId();
						answerid.add(answer);
					}


					int score = 0;

					if (examrubricbig.getRubricttype().equals("单选题")) {


						Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
						if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
							score = examUltimately.getScore();
						} else {
							score = 0;

						}
					} else {
						System.out.println("修改多选题***************");
						Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
						String[] answeridsan = examrubric.getAnswerId().split(",");
						String[] answeridsi = examUltimately.getSelectanswerId().split(",");
						Arrays.sort(answeridsan);
						Arrays.sort(answeridsi);

						if (Arrays.equals(answeridsan, answeridsi)) {
							score = examUltimately.getScore();
						} else {
							score = 0;

						}
					}

					studentexamloger.setSelectId(examUltimately.getSelectanswerId());
					studentexamloger.setPerformance(score);
					studentexamlogdao.save(studentexamloger);

					System.out.println("修改记录成功");
					//return new Result(true, "修改记录成功", null);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("修改记录失败");
					//return new Result(false, "修改记录失败", null);
				}


			}
		} else {
			*//**
			 * 填空题,判断题的处理方式
			 *//*
			try {
				Integer score = 0;
				String Id = UUIDUtils.getUUID();
				Studentexamlog studentexamloger = studentexamlogdao.selectlogforexamrubricid(examUltimately.getExamrubricId(), examUltimately.getStudentId(), examUltimately.getExamparperId());
				if (studentexamloger == null) {

					Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
					if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
						score = examrubric.getScore();
					} else {
						score = 0;
					}
					Studentexamlog studentexamlog = new Studentexamlog();
					studentexamlog.setId(Id);
					studentexamlog.setCourseId(examUltimately.getCourseid());
					studentexamlog.setExamparperId(examUltimately.getExamparperId());
					studentexamlog.setExamrubricId(examUltimately.getExamrubricId());
					studentexamlog.setSelectId(examUltimately.getSelectanswerId());
					studentexamlog.setStudentId(examUltimately.getStudentId());
					studentexamlog.setPerformance(score);
					studentexamlogdao.save(studentexamlog);
				} else {

					Examrubric examrubric = examrubricdao.findById(examUltimately.getExamrubricId()).orElse(null);
					if (examrubric.getAnswerId().equals(examUltimately.getSelectanswerId())) {
						score = examrubric.getScore();
					} else {
						score = 0;
					}
					studentexamloger.setPerformance(score);
					studentexamloger.setSelectId(examUltimately.getSelectanswerId());
					studentexamlogdao.save(studentexamloger);
				}
				System.out.println("修改记录成功");
				//return new Result(true, "修改记录成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("修改记录失败");
				//return new Result(false, "修改记录失败", null);
			}
		}
		*//**
		 * 多条件查询(where条件拼接)
		 *
		 * @param rubricquery
		 * @return
		 *//*

	}*/
	public Specification<Examrubric> getWhereClause(final RubricQuery rubricquery) {
		return new Specification<Examrubric>() {

			@Override
			public Predicate toPredicate(Root<Examrubric> root, CriteriaQuery<?> query, CriteriaBuilder
					cb) {
				Predicate predicate = cb.conjunction();//动态SQL表达式
				List<Expression<Boolean>> exList = predicate.getExpressions();//动态SQL表达式集合


				if (rubricquery.getExamparper() != null && !"".equals(rubricquery.getExamparper())) {
					exList.add(cb.equal(root.get("examparper").get("id").as(String.class), rubricquery.getExamparper()));

				}

				if (rubricquery.getUserid() != null && !"".equals(rubricquery.getUserid())) {
					exList.add(cb.equal(root.get("trcherId").as(String.class), rubricquery.getUserid()));

				}

				if (rubricquery.getRubric() != null && !"".equals(rubricquery.getRubric())) {
					exList.add(cb.like(root.get("content"), "%" + rubricquery.getRubric() + "%"));

				}
				if (rubricquery.getType() != null && !"".equals(rubricquery.getType())) {
					exList.add(cb.equal(root.get("rubricttype").as(String.class), rubricquery.getType()));

				}

				return predicate;
			}
		};
	}
	/**
	 * 根据试卷id查询考试试题
	 */
	public List<Examrubric> getExamrubricforparperid(RubricQuery rubricquery) {
		return examrubricdao.findAll(this.getWhereClause(rubricquery));
	}
	/*@RabbitHandler
	public void process(Users users) {
		System.out.println("邮件消费者获取生产者消息msg:" + users);
	}*/
	/*@RabbitHandler
	public void process(Users user) {

		try {
			System.out.println(bytes);
			//字节码转化为对象
			Users boy1=(Users) this.ByteToObject(bytes);
			System.out.println(boy1);
			System.out.println("messages ："+boy1.toString());
			System.out.println(Thread.currentThread().getName()+"接收到来自topic.message队列的消息: "+boy1);


	}
	private Object ByteToObject(byte[] bytes) {
		Object obj = null;
		try {
			// bytearray to object
			ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
			ObjectInputStream oi = new ObjectInputStream(bi);

			obj = oi.readObject();
			bi.close();
			oi.close();
		} catch (Exception e) {
			System.out.println("translation" + e.getMessage());
			e.printStackTrace();
		}
		return obj;
	}*/

}
