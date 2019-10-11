package com.web.shopping.service;

import java.util.List;
import java.util.Map;

import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Specification;
import com.web.shopping.pojo.SpecificationAndOption;

/** 
* @ClassName: SpecificationService 
* @Description: Specification规格管理接口类
* @author dpk
* @date 2019-09-09 02:29:51 
*/

public interface SpecificationService {

	public List<Specification> findAllSpecification();
	
	public SpecificationAndOption findOne(Long id);
	
	public PageResult findByPage(int pageNo,int pageSize,String specName);
	
	public void add(SpecificationAndOption spec);
	
	public void update(SpecificationAndOption spec);
	
	public void delete(Long[] ids);
	
	public PageResult findSpecificationByName(String specName);
	
	public PageResult findPage(Specification specification, int pageNo,int pageSize);
	
	public List<Map> selectOptionList();
}
