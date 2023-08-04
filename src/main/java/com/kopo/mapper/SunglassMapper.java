package com.kopo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.kopo.domain.Sunglass;

@Mapper
public interface SunglassMapper {

	public List<Sunglass> getAll();
	
	@Insert("insert into sunglass(id,name,price,description,stock,gender,color,imgpath)values(id_seq.NEXTVAL,#{Sunglass.name},#{Sunglass.price},#{Sunglass.description},#{Sunglass.stock},#{Sunglass.gender},#{Sunglass.color},#{Sunglass.imgFile})")
	public void insertNewItem(@Param("Sunglass")Sunglass sunglass);
}
