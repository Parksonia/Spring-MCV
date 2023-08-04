package com.kopo.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kopo.domain.Sunglass;
import com.kopo.mapper.SunglassMapper;
//상속받는 구현체
@Repository
public class SunglassRepositoryImpl implements SunglassRepository {
	
	@Autowired
	private SunglassMapper mapper;

	private List<Sunglass> listOfSunglasses = new ArrayList<Sunglass>();

	
	
	public SunglassRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public WebtoonRepositoryImpl() { Webtoon webtoon1 = new
	 * Webtoon("재혼황후","img1.jpg"); //일반 생성자에 저장 webtoon1.setAuthor("히어리"); webtoon1.
	 * setDescription("동대제국의 완벽한 황후였던 나비에. ​황제인 남편이 정부를 황후로 만들려는 것을 알고 이혼을 택한다. 그리고 결심한다."
	 * ); webtoon1.setRanking("1위"); webtoon1.setReleaseDay("금요일");
	 * webtoon1.setPublisher(""); webtoon1.setGenre("로맨스");
	 * 
	 * 
	 * Webtoon webtoon2 = new Webtoon("외모지상주의","img2.jpg");
	 * webtoon2.setAuthor("박태준");
	 * webtoon2.setDescription("못생기고 뚱뚱하다고 괴롭힘을 당하며 루저 인생만 살아온 내가 잘생겨졌다는 이유로 인싸가 됐다"
	 * ); webtoon2.setRanking("2위"); webtoon2.setReleaseDay("금요일");
	 * webtoon2.setPublisher(""); webtoon2.setGenre("드라마");
	 * 
	 * 
	 * Webtoon webtoon3 = new Webtoon("광마회귀","img3.jpg"); webtoon3.setAuthor("JP");
	 * webtoon3.setDescription("무공에 미친 광마 이자하. 그는 마교 교주의 천옥을 훔쳐 쫓기던 중 벼랑에서 떨어지게 된다."
	 * ); webtoon3.setRanking("3위"); webtoon3.setReleaseDay("금요일");
	 * webtoon3.setPublisher(""); webtoon3.setGenre("무협");
	 * 
	 * Webtoon webtoon4 = new Webtoon("마루는강쥐","img4.jpg"); webtoon4.setAuthor("모죠");
	 * webtoon4.
	 * setDescription("우리 집 강아지 마루가 사람이 되었다, 그것도 5살 아이로! 강아지 + 어린아이의 무한 에너지와 호기심을 지닌 사고뭉치 강쥐 탄생! 마루야~! 또 어디가!!! 유쾌한 이웃들과 우당탕탕 즐거운 마루의 나날들"
	 * ); webtoon4.setRanking("4위"); webtoon4.setReleaseDay("화요일");
	 * webtoon4.setPublisher(""); webtoon4.setGenre("개그");
	 * 
	 * Webtoon webtoon5 = new Webtoon("미래의 골동품 가게","img5.jpg");
	 * webtoon5.setAuthor("구아진"); webtoon5.
	 * setDescription("남해의 먼 섬에 살고 있는 소녀, '미래'. 미래의 부모님이 바다에서 돌아오지 못한 그날부터, 모든 것들이 변하기 시작했다. 저주를 풀기 위한 단 한 가지의 방법. 소중한 것들을 지키기 위한 기묘한 소녀의 퇴마가 시작된다."
	 * ); webtoon5.setRanking("5위"); webtoon5.setReleaseDay("수요일");
	 * webtoon5.setPublisher(""); webtoon5.setGenre("스릴러");
	 * 
	 * Webtoon webtoon6 = new Webtoon("세기말 풋사과 보습학원","img6.jpg");
	 * webtoon6.setAuthor("순끼"); webtoon6.
	 * setDescription("어릴 때 알던 재수없던 놈이 더 재수없는 놈이 되어 돌아왔다! 중3 황미애의 옆 빌라에 어릴 때 잠깐 시골에서 봤던 김철이 이사 와 같은 학교 같은 반이 되고 '철이와 미애'라 놀림 받자 김철은 미애를 불쾌해하며 피한다. "
	 * ); webtoon6.setRanking("6위"); webtoon6.setReleaseDay("수요일");
	 * webtoon6.setPublisher(""); webtoon6.setGenre("로맨스");
	 * 
	 * //listOfWebtoons.add(webtoon1); //listOfWebtoons.add(webtoon2);
	 * //listOfWebtoons.add(webtoon3); //listOfWebtoons.add(webtoon4);
	 * //listOfWebtoons.add(webtoon5); //listOfWebtoons.add(webtoon6);
	 * 
	 * }
	 */
	@Override
	public List<Sunglass> getAllWebtoonList() {
		listOfSunglasses=mapper.getAll();
		return listOfSunglasses;
	}
	@Override
	public List<Sunglass> getWebtoonListByGenre(String genre) {

		List<Sunglass> webtoonsByGenre = new ArrayList<Sunglass>(); // 해당 장르만 리스트에 저장하기 위해 리스트 선언

		//전체 리스트만큼 for문 돌려서 찾기 (forEach 활용 가능)
		/*
		 * for(Webtoon webtoon :listOfWebtoons) { 
		 * }
		 */
		for(int i=0; i<listOfSunglasses.size(); i++) {
			Sunglass webtoon = listOfSunglasses.get(i);

			if(genre.equalsIgnoreCase(webtoon.getGender())) {
				webtoonsByGenre.add(webtoon);
			}
		}
		return webtoonsByGenre;
	}
	//author와 genre 활용
	@Override
	public Set<Sunglass> getWebtoonListByFilter(Map<String, List<String>>filter ) {  //value 다양할 수있으니 arraylist로 저장

		Set<Sunglass> webtoonsByAuthor = new HashSet<Sunglass>();
		Set<Sunglass> webtoonsByGenre = new HashSet<Sunglass>();
		Set<String> webtoonsByFilter  = filter.keySet(); //key값인 스트링을 저장

		/*for(String str: filter.get("author")) {
			System.out.println(filter);
		}->궁금해서 테스트 */

		if(webtoonsByFilter.contains("author")) {
			for(int j = 0; j < filter.get("author").size(); j++) { //[values,....]의 사이즈만큼
				String authorName = filter.get("author").get(j);
				for(int i = 0; i < listOfSunglasses.size(); i++) {
					Sunglass webtoon = listOfSunglasses.get(i);

					if(authorName.equalsIgnoreCase(webtoon.getGender())) {
						webtoonsByAuthor.add(webtoon);
					}

				}
			}
			if(webtoonsByFilter.contains("genre")) {
				for(int i = 0; i<filter.get("genre").size(); i++) {
					String genre = filter.get("genre").get(i);
					List<Sunglass> list = getWebtoonListByGenre(genre);
					webtoonsByGenre.addAll(list);

				}
			}
		}

		webtoonsByGenre.retainAll(webtoonsByAuthor); //webtoonsByAuthor와 공통적인 것만 webtoonsByGenre에 남도록 함 
		return webtoonsByGenre;
	}
	
	@Override
	public Sunglass getWebtoonByName(String name) {
		Sunglass webtoonInfo = null;  //초기화

		for(int i=0; i< listOfSunglasses.size(); i++) {
			Sunglass webtoon = listOfSunglasses.get(i);
			if(webtoon!=null && webtoon.getName()!=null && webtoon.getName().equals(name)) {
				webtoonInfo = webtoon;
				break;
			}
			if(webtoonInfo == null) {
				throw new IllegalArgumentException("해당 웹툰을 찾을 수 없습니다 : " + name);
			}
		}
		return webtoonInfo;
	}
	//form에서 전달받은 웹툰 데이터 리스트에 저장
	@Override
	public void setNewSunglass(Sunglass sunglass) {
		
		//webtoon.setImgPath(filename);
		mapper.insertNewItem(sunglass);
		//listOfSunglasses.add(sunglass);
		
	}
}

