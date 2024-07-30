package com.fineproject.fastweb.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fineproject.fastweb.logic.MainLogic;
import com.google.gson.Gson;

@RestController
@RequestMapping("/main/*")
public class MainController {
	Logger logger = LogManager.getLogger(MainController.class);
	
	@Autowired
	private MainLogic mainLogic = null;

	/**
	 * 메인페이지 커뮤니티 인기글 / 커뮤니티 신규글 출력
	 * 
	 * @param pMap
	 * @return
	 */
	@GetMapping("mainList")
	public String mainList(@RequestParam Map<String, Object> pMap) {
		logger.info("mainList 호출");
		logger.info(pMap);
		String temp = null;
		List<Map<String, Object>> mList = null;
		mList = mainLogic.mainList(pMap);
		logger.info(mList);
		Gson g = new Gson();
		temp = g.toJson(mList);
		return temp;
	}
}