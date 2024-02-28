package org.chaeys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.chaeys.dto.NoticeDTO;
import org.chaeys.service.NoticeService;
import org.chaeys.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class NoticeController {
	
	@Autowired
	private Util util;
	
	@Resource(name = "noticeService")
	private NoticeService noticeService;
	
	// 2024-02-27 요구사항 확인 psd
	@GetMapping("/notice")
	public String notice(Model model,@RequestParam(value="pageNo",required=false) String page) {
		int currentPage = 1;
		if(util.str2Int(page) > 0) {
			currentPage = util.str2Int(page);
		}
		int totalRecordCount = noticeService.totalRecordCount();
		
		//pagination
		PaginationInfo pagenationInfo = new PaginationInfo();
		pagenationInfo.setCurrentPageNo(currentPage);
		pagenationInfo.setPageSize(10);
		pagenationInfo.setRecordCountPerPage(10);
		pagenationInfo.setTotalRecordCount(totalRecordCount);
		
		List<NoticeDTO> list = noticeService.noticeList(pagenationInfo.getFirstRecordIndex());
		model.addAttribute("list", list);
		model.addAttribute("pagenationInfo", pagenationInfo);
		return "notice"; // ....../views/notice.jsp
	}

	// 공지 글쓰기 -> admin 관리자 화면에서
	@GetMapping("/admin/noticeWrite")
	public String noticeWrite() {
		return "admin/noticeWrite"; // ....../views/admin/noticeWrite.jsp
	}

	@PostMapping("/admin/noticeWrite")
	public String noticeWrite(NoticeDTO dto) {
		// System.out.println(dto.getNtitle());
		// System.out.println(dto.getNcontent());
		int result = noticeService.noticeWrite(dto);
		return "redirect:/notice";
	}

	// noticeDetail
	@GetMapping("/noticeDetail")
	public String noticeDetail(@RequestParam(value = "no", defaultValue = "0", required = true) int no, Model model) {

		System.out.println(no);
		if (no == 0) {
			return "redirect:/error";
		} else {
			NoticeDTO detail = noticeService.detail(no);
			System.out.println(detail.getNno());
			if (detail.getNno() == 0) {
				// 해당 번호의 공지사항이 없을 때 처리할 내용
				return "redirect:/error"; // 예를 들어, 에러 페이지로 리다이렉트
			} else {
				model.addAttribute("detail", detail);
				return "noticeDetail"; // 공지사항 상세 페이지로 이동
			}
		}
	}

	// noticeDel
	@GetMapping("/noticeDel{no}")
	public String noticeDel(@PathVariable("no") int no) {
		// System.out.println("@PathVariable : " + no);
		return "redirect:/notice";

	}

}
