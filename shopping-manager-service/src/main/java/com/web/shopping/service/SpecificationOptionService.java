package com.web.shopping.service;

import java.util.List;

import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.SpecificationOption;

/** 
* @ClassName: SpecificationOptionService 
* @Description: SpecificationOptionService
* @author dpk
* @date 2019-09-09 10:47:05 
*/

public interface SpecificationOptionService {
	
	public List<SpecificationOption> findAllSpecificationOption();

	public PageResult findPage(int pageNum,int pageSize);
	
	public void addSpecificationOption(SpecificationOption specificationOption);
	
	public void updateSpecificationOption(SpecificationOption specificationOption);
	
	public SpecificationOption findSpecificationOptionById(Long id);

	public void deleteSpecificationOption(Long [] ids);

	public PageResult findPage(SpecificationOption specificationOption, int pageNum,int pageSize);
	
}
