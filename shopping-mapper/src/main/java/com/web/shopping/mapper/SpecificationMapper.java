package com.web.shopping.mapper;

import com.web.shopping.pojo.Specification;
import com.web.shopping.pojo.SpecificationExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SpecificationMapper {
    int countByExample(SpecificationExample example);

    int deleteByExample(SpecificationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Specification record);

    int insertSelective(Specification record);

    List<Specification> selectByExample(SpecificationExample example);

    Specification selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    int updateByPrimaryKeySelective(Specification record);

    int updateByPrimaryKey(Specification record);
    
    //搜索栏的模糊搜索
	List<Specification> findSpecificationByName(@Param("specName") String specName);

	List<Map> selectOptionList();
	
	//
	Specification selectByName(@Param("specName") String specName);
	
}