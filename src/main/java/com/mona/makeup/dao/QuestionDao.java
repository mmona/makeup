package com.mona.makeup.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mchange.v2.async.StrandedTaskReporting;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Question;
import com.mona.makeup.pojo.User;

@Repository
public class QuestionDao extends CommonDao {
	//count question
	public int countQuestion(){
		String sql="select count(*) from Question";
		List<Object> query = (List<Object>) this.query(sql);
		Number number = (Number) query.get(0);
		return number.intValue();
	}
	//select question
	public List<Question> selectQuestion(Page page ){
		String sql = "select q from Question q order by q.times desc";
		List<Question> query = (List<Question>) this.query(sql,  page.getBeginIndex(), page.getPageSize());
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
		
	}
	//select question by id
	public Question selectQuestionById(int id){
		String sql="select q from Question q where q.id=:id";
		Map<String,Object> params= new HashMap<>();
		params.put("id", id);
		List<Question> query = (List<Question>) this.query(sql,params);
		if(query!=null&&!query.isEmpty()){
			return query.get(0);
		}
		return null;
	}
	//delete　ｑｕｅｓｔｉｏｎ　ｂｙ　ｉｄ
	@Transactional
	public boolean deleteQuestion(int id){
		return this.delete(id, Question.class);
	}
	//add question
	@Transactional
	public boolean addQuestion(Question question){
		return this.save(question);
	}
	//selectQuestionByUser
	public List<Question> selectQuestionByUser(User user){
		String sql = "select q from Question q where q.users in(select r.users from Review r  where r.users=:users)  order by q.times desc";
		Map<String, Object> params = new HashMap<>();
		params.put("users", user);
		List<Question> query = this.query(sql, Question.class, params);
		if(query!=null&&!query.isEmpty()){
			return query;
		}
		return null;
	}
}
