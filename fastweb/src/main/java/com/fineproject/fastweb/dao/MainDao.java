package com.fineproject.fastweb.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MainDao {
	Logger logger = LogManager.getLogger(MainDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	/**
	 * 커뮤 인기글(조회수 > 250 충족 게시글을 조회수 높은 순 -> 낮은 순으로 정렬)
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainBoardHot(Map<String, Object> pMap) {
		logger.info("mainBoardHot 호출");
		List<Map<String,Object>> bList = null;
		bList = sqlSessionTemplate.selectList("mainBoardHot", pMap);
		return bList;
	}

	/**
	 * 커뮤 신규글
	 * 
	 * @param pMap
	 * @return
	 */
	public List<Map<String, Object>> mainBoardNew(Map<String, Object> pMap) {
		logger.info("mainBoardNew 호출");
		List<Map<String,Object>> bList = null;
		bList = sqlSessionTemplate.selectList("mainBoardNew", pMap);
		return bList;
	}
}