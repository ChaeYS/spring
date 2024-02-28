package org.chaeys.service;

import java.util.List;

import org.chaeys.dao.NoticeDAO;
import org.chaeys.dto.NoticeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl extends AbstractService implements NoticeService {
	
	@Autowired
	private NoticeDAO noticeDAO;
	
	@Override
	public List<NoticeDTO> noticeList(int page) {
		return noticeDAO.noticeList(page);
	}

	@Override
	public NoticeDTO detail(int no) {
		return noticeDAO.detail(no);
	}

	@Override
	public int noticeWrite(NoticeDTO dto) {
		return noticeDAO.noticeWrite(dto);
	}

	@Override
	public int noticeDel(int no) {
		return noticeDAO.noticeDel(no);
	}

	@Override
	public int noticeUpdate(NoticeDTO dto) {
		return noticeDAO.noticeUpdate(dto);
	}

	@Override
	public int totalRecordCount() {
		// TODO Auto-generated method stub
		return noticeDAO.totalRecordCount();
	}


}
