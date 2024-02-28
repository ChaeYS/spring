package org.chaeys.service;

import java.util.List; 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.chaeys.dao.BoardDAO;
import org.chaeys.dto.BoardDTO;
import org.chaeys.dto.CommentDTO;
import org.chaeys.dto.WriteDTO;
import org.chaeys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService extends AbstractService {
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	private Util util;
	
	public List<BoardDTO> boardList(int pageNo) {
		return boardDAO.boardList(pageNo);
	}

	public BoardDTO detail(int no) { //메소드 시그니쳐 : 수, 순서, 타입
		//2024-02-22 psd 요구사항 확인
		//로그인 했어? -> 읽음 수 올리기
		if(util.getSession().getAttribute("mid") != null) {
			//DTO 객체 만들기 = 번호 + 아이디
			BoardDTO dto = new BoardDTO();
			dto.setBoard_no(no);
			dto.setMid((String) util.getSession().getAttribute("mid"));
			//int result = boardDAO.alreadyRead(dto);
			//if(result == 0) { //이미 읽었는지 검사하기
				boardDAO.countUp(dto);
			//}
		}
		return boardDAO.detail(no);
	}
	
	public int write(WriteDTO dto) {
		//HttpServletRequest request = util.req();
		//HttpSession session = util.getSession();
		//엔터키 처리
		dto.setContent(dto.getContent().replaceAll("(\r\n|\r|\n|\n\r)", "<br>"));
		dto.setMid((String) util.getSession().getAttribute("mid"));
		dto.setIp(util.getIP());
		return boardDAO.write(dto);
	}

	public int commentWrite(CommentDTO comment) {
		// 댓글 내용 + 글번호 + mid
		comment.setMid((String) util.getSession().getAttribute("mid"));
		comment.setCip(util.getIP());
		return boardDAO.commentWrite(comment);
	}

	public List<CommentDTO> commentsList(int no) {
		return boardDAO.commentsList(no);
	}

	public int postDel(int no) { //글번호 + mid = 자신의 글만 삭제하게 하기 위해서
		WriteDTO dto = new WriteDTO();
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));
		
		return boardDAO.postDel(dto);
	}
	
	public int totalRecordCount() {
		return boardDAO.totalRecordCount();
	}
	
	public int deleteComment(int no, int cno) {
		CommentDTO dto = new CommentDTO();
		dto.setNo(cno);
		dto.setBoard_no(no);
		dto.setMid((String) util.getSession().getAttribute("mid"));
		
		return boardDAO.deleteComment(dto);
	}
	
	public int likeUp(CommentDTO dto) {
		return boardDAO.likeUp(dto);
	}

}
