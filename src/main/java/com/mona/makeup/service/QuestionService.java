package com.mona.makeup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mona.makeup.dao.QuestionDao;
import com.mona.makeup.page.utils.Page;
import com.mona.makeup.page.utils.Result;
import com.mona.makeup.pojo.Question;

@Service
public class QuestionService extends BaseService {
	@Autowired
	private QuestionDao questionDao;
	//select question
	public Result<Question> selectQuestion(int curPage){
		Result<Question> result = new Result<>();
		Page page  = new Page();
		int count  = questionDao.countQuestion();
		page.setBeginIndex((curPage-1)*10);
		page.setCurrentPage(curPage);
		page.setPageSize(10);
		page.setTotalCount(count);
		page.setTotalPage((count%10==0)?(count/10):(count/10+1));
		List<Question> selectQuestion = questionDao.selectQuestion(page);
		result.setList(selectQuestion);
		result.setPage(page);
		return result;
	}
}
