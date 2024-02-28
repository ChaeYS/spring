package org.chaeys.dao;

import java.util.List;

import org.chaeys.dto.NoticeDTO;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDAO extends AbstractDAO {

	public List<NoticeDTO> noticeList(int startpageNo) {
		return sqlSession.selectList("notice.noticeList", startpageNo);
	}

	public int noticeWrite(NoticeDTO dto) {
		return sqlSession.insert("notice.noticeWrite", dto);
	}

	public int noticeDel(int no) {
		return sqlSession.update("notice.noticeDelete", no);
	}
	
	public NoticeDTO detail(int no) {
		return sqlSession.selectOne("notice.noticeDetail", no);
	}

	public int noticeUpdate(NoticeDTO dto) {
		return sqlSession.update("notice.noticeUpdate", dto);
	}

	public int totalRecordCount() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("notice.totalRecordCount");
	}
}
