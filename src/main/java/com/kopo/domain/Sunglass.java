package com.kopo.domain;
//퍼시스턴스계층..?
import org.springframework.web.multipart.MultipartFile;
public class Sunglass {

	
		private int id;
		private String name;
		private String price;
		private String description;
		private int stock;
		private String gender;
		private String color;
		private String imgPath;
		private MultipartFile imgFile;
		
		// 기본 생성자
		public Sunglass() { 
			super();
		
		}
	
		//일반 생성자
		public Sunglass(String name, String imgPath) {
			super();
			
			this.name = name;
			this.imgPath = imgPath;
	
		}

		//Getter Setter
		
		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public int getStock() {
			return stock;
		}

		public void setStock(int stock) {
			this.stock = stock;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String getImgPath() {
			return imgPath;
		}

		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}

		public MultipartFile getImgFile() {
			return imgFile;
		}

		public void setImgFile(MultipartFile imgFile) {
			this.imgFile = imgFile;
		}
}


