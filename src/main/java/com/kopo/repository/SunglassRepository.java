package com.kopo.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.controller.SunglassController;
import com.kopo.domain.Sunglass;


public interface SunglassRepository {


	List<Sunglass> getAllWebtoonList(); // 리스트형태로 반환하는 메서드 생성 
	
	List<Sunglass> getWebtoonListByGenre(String genre);
	
	Set<Sunglass> getWebtoonListByFilter(Map<String,List<String>>filter); // set으로 반환하는 이유 : 중복을 제거하여 저장하고 반환하기 위함  

	Sunglass getWebtoonByName(String name);
	
	void setNewSunglass(Sunglass sunglass);
	//void setNewWebtoon(Webtoon webtoon, String filename);
}
