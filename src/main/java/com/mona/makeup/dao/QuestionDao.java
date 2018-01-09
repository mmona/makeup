package com.mona.makeup.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mona.makeup.page.utils.Page;
import com.mona.makeup.pojo.Question;

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
	
	
}
