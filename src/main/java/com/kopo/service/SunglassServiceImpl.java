package com.kopo.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kopo.domain.Sunglass;
import com.kopo.repository.SunglassRepository;


//interface로부터 상속받은 구현체
//service 의 역할 == getter setter의 역할과 같다

@Service
public class SunglassServiceImpl implements SunglassService {

	@Autowired //==getter,setter
	private SunglassRepository webtoonRepository;

	@Override
	public List<Sunglass> getAllWebtoonList() {

		return webtoonRepository.getAllWebtoonList();
	}

	@Override
	public List<Sunglass> getWebtoonListByGenre(String genre) {

		List<Sunglass> webtoonByGenre =  webtoonRepository.getWebtoonListByGenre(genre);

		return webtoonByGenre;
	}

	@Override
	public Set<Sunglass> getWebtoonListByFilter(Map<String, List<String>> filter) {
		
		Set<Sunglass> webtoonByFilter =webtoonRepository.getWebtoonListByFilter(filter);
		
		return webtoonByFilter;
	}

	@Override
	public Sunglass getWebtoonByName(String name) {
	
		Sunglass webtoonByName =webtoonRepository.getWebtoonByName(name);
		return webtoonByName;
	}

	@Override
	public void setNewSunglass(Sunglass sunglass) {
		
		//webtoonRepository.setNewWebtoon(webtoon,filename);
		
		webtoonRepository.setNewSunglass(sunglass);
		
	}

}
