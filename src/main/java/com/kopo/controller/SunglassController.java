package com.kopo.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kopo.domain.Sunglass;
import com.kopo.service.SunglassService;

//컨트롤러는 서비스계층과 연결되야함
@Controller
//@RequestMapping("/webtoons")
public class SunglassController {

	@Autowired //서비스계층과 연결
	private SunglassService sunglassService;
	
	
	@GetMapping("/sunglass")
	//@RequestMapping(value="/webtoons",method = RequestMethod.GET)
	public String requestWebtoonList(Model model) {
	List<Sunglass>list = sunglassService.getAllWebtoonList();
	
	model.addAttribute("webtoonList", list);
	
	return "sunglasses";
	
	}
	
	//경로 변수 활용
	@GetMapping("/{genre}")
	public String requestWebtoonByGenre(@PathVariable("genre")String webtoonGenre,Model model) {
		
		List<Sunglass> list= sunglassService.getWebtoonListByGenre(webtoonGenre);
		model.addAttribute("webtoonList", list);
		
		return "webtoons";
	}

	@GetMapping("/filter/{webtoonfilter}")
	
	public String requestWebtoonByFilter(@MatrixVariable(pathVar="webtoonfilter")Map<String,List<String>> webtoonfilter,Model model){
		
		Set<Sunglass> webtoonByFilter = sunglassService.getWebtoonListByFilter(webtoonfilter);
		model.addAttribute("webtoonList",webtoonByFilter );
		
		return "webtoons";
	}
	
	// http://localhost/test/home/exam13?id=1234
	@GetMapping("/webtoon")
	public String requestWebtoonName(@RequestParam("name")String webtoonName,Model model) {
		Sunglass webtoon = sunglassService.getWebtoonByName(webtoonName);
		model.addAttribute("webtoon", webtoon);
		return "webtoon";
	}

	@GetMapping("/admin/add")
	public String requestAddWebtoonForm(@ModelAttribute("NewSunglass")Sunglass webtoon) {
		
		return "addSunglass";
	}
	
	/*사진 팔일 받기 기존 방법
	 * @PostMapping("/admin/add") 
	 * public String submitForm(@ModelAttribute("NewSunglass")Sunglass webtoon,HttpServletRequestrequest,HttpSession session) { 
	 * UUID uuid = UUID.randomUUID(); //중복방지를 위한 uuid적용 
	 * String temp =webtoon.getImgFile().getOriginalFilename().replaceAll(" ","");
	 *  String filename = webtoon.getName()+uuid.toString()+"_"+temp;
	 * //MultipartFile 메서드-> getOriginalFileName() : 업로드파일의 이름 
	 * //String filename =webtoon.getName()+uuid.toString()+"_"+webtoon.getImgFile().getOriginalFilename(); //MultipartFile 메서드-> getOriginalFileName() : 업로드파일의
	 * 이름
	 * 
	 * try { webtoon.getImgFile().transferTo(new File(
	 * "C:\\SpringWorkspace\\WebtoonPage02\\src\\main\\webapp\\resources\\img\\"+
	 * filename)); //MultipartFile 메서드-> transferTo(File file) : 파일을 저장
	 * webtoon.setImgPath(filename);
	 * 
	 * }catch(Exception e) { e.printStackTrace(); }
	 * 
	 * webtoonService.setNewWebtoon(webtoon);
	 * //webtoonService.setNewWebtoon(webtoon, filename);
	 * 
	 * return "redirect:/addSunglass"; //파일 전송 성공 시 출력됨 }
	 * 
	 */
	
	//대표님 방법 
	@PostMapping("/admin/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Sunglass sunglass) {
		MultipartFile sunglassImg = sunglass.getImgFile();
		UUID uuid = UUID.randomUUID();
		String saveName = sunglassImg.getOriginalFilename().replaceAll(" ","")+uuid.toString();
		File saveFile = new File("C:\\upload", saveName);
		
		if(sunglassImg != null && !sunglassImg.isEmpty()) {
			try {
				sunglassImg.transferTo(saveFile);
				sunglass.setImgPath(saveName);
			}catch (Exception e) {
				throw new RuntimeException("이미지 업로드에 실패하였습니다.", e);
			}
		}
		
		sunglassService.setNewSunglass(sunglass);
		return "redirect:/admin/add"; 	
	}
	
	
}

/* path-> tomcat에 server.xml에 /controller로 저장해둠 */
/*<annotation-driven enable-matrix-variables="true"></annotation-driven>=>매트릭스 변수 이용하기 위해 추가해줘야함*/