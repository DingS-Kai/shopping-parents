package com.web.shopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.shopping.mapper.SpecificationOptionMapper;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.SpecificationOption;
import com.web.shopping.pojo.SpecificationOptionExample;
import com.web.shopping.pojo.SpecificationOptionExample.Criteria;

/** 
* @ClassName: SpecificationOptionService 
* @Description: 规格选项
* @author dpk
* @date 2019-09-09 10:47:16 
*/

@Service
public class SpecificationOptionServiceImpl implements com.web.shopping.service.SpecificationOptionService {

	@Autowired
	private SpecificationOptionMapper specificationOptionMapper;
	
	/** 
	* @Description:查找全部SpecificationOption规格选项
	* @return 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public List<SpecificationOption> findAllSpecificationOption() {
		return specificationOptionMapper.selectByExample(null);
	}

	/** 
	* @Description: 分页查找 规格选项
	* @param pageNum
	* @param pageSize
	* @return 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public PageResult findPage(int pageNo, int pageSize) {
		PageResult pageResult = new PageResult();
		PageHelper.startPage(pageNo,pageSize);
		List<SpecificationOption> list = specificationOptionMapper.selectByExample(null);
		for(SpecificationOption b : list) {
			System.out.println(b.getId()+"-----》  "+b.getOptionName());
		}
		PageInfo pageInfo = new PageInfo<>(list);
		pageResult.setRows(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	/** 
	* @Description:  增加规格选项
	* @param specificationOption 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public void addSpecificationOption(SpecificationOption specificationOption) {
		specificationOptionMapper.insert(specificationOption);
	}

	/** 
	* @Description: 更新规格选项
	* @param specificationOption 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public void updateSpecificationOption(SpecificationOption specificationOption) {
		specificationOptionMapper.updateByPrimaryKey(specificationOption);
	}

	/** 
	* @Description: 按ID查找规格选项
	* @param id
	* @return 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public SpecificationOption findSpecificationOptionById(Long id) {
		return specificationOptionMapper.selectByPrimaryKey(id);
	}

	/** 
	* @Description: 删除规格选项
	* @param ids 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public void deleteSpecificationOption(Long[] ids) {
		for(Long id : ids ) {
			specificationOptionMapper.deleteByPrimaryKey(id);
		}
	}

	/** 
	* @Description: 分页查找规格选项
	* @param specificationOption
	* @param pageNum
	* @param pageSize
	* @return 
	* @author dpk
	* @date 2019-09-09 10:51:51 
	*/ 
	@Override
	public PageResult findPage(SpecificationOption specificationOption, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo,pageSize);
		
		System.out.println("findPage --specificationOption===========SpecificationOptionServiceImpl============="+specificationOption);
		
		SpecificationOptionExample example=new SpecificationOptionExample();
		Criteria criteria = example.createCriteria();
		if(specificationOption!=null){			
			if(specificationOption.getOptionName()!=null && specificationOption.getOptionName().length()>0){
					criteria.andOptionNameLike("%"+specificationOption.getOptionName()+"%");
			}
		}
		Page<SpecificationOption> page= (Page<SpecificationOption>)specificationOptionMapper.selectByExample(example);
		
		return new PageResult(page.getTotal(), page.getResult());
	}

}
