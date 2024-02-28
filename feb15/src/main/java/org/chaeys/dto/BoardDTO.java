package org.chaeys.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int board_no, board_count, comment;
	private String board_title, board_content, mname, mid, board_date, board_ip;
	//board_write -> mname, mid 로 변경
	//게시판, 톺아보기, 글삭제... 변경해야 한다.
}
