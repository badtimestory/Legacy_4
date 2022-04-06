package com.iu.s1.board.notice.noticeReply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeReplyDAO {
	@Autowired
	private SqlSession sqlSession;
	// 사용할 맵퍼 선택
	private String NAMESPACE="com.iu.s1.board.notice.noticeReply.NoticeReplyDAO.";
	
	public int add(NoticeReplyDTO noticeReplyDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"add", noticeReplyDTO);
	}
	
	public List<NoticeReplyDTO> list(NoticeReplyDTO noticeReplyDTO) throws Exception{
		return sqlSession.selectList(NAMESPACE+"list", noticeReplyDTO); 
	}
	
	public int update(NoticeReplyDTO noticeReplyDTO) throws Exception {
		return sqlSession.update(NAMESPACE+"update", noticeReplyDTO);
	}
	
	public int delete(NoticeReplyDTO noticeReplyDTO) throws Exception {
		return sqlSession.delete(NAMESPACE+"delete", noticeReplyDTO);
	}

}