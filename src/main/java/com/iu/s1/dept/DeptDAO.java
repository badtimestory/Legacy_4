package com.iu.s1.dept;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.iu.s1.dept.DeptDAO.";
	
	public List<DeptDTO> list() throws Exception {
		
		return sqlSession.selectList(NAMESPACE+"list");
	}
	
}
