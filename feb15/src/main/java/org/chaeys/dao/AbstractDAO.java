package org.chaeys.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

//부모형태로 존재하게 하겠습니다. 
//@없습니다
//2024-02-26 psd

public class AbstractDAO {
	
	@Autowired
	SqlSession sqlSession;
	
}
