package com.kopo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.kopo.domain.Sunglass;

public interface SunglassService {

	List<Sunglass>getAllWebtoonList(); //메서드를 생성하라는 인터페이스 만들기

	List<Sunglass> getWebtoonListByGenre(String genre);

	Set<Sunglass> getWebtoonListByFilter(Map<String, List<String>>filter);


	Sunglass getWebtoonByName(String name);
	
	void setNewSunglass(Sunglass sunglass);
	//void setNewWebtoon(Webtoon webtoon,String filename);
}
