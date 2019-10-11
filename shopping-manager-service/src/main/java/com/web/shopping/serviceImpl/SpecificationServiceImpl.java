package com.web.shopping.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.shopping.mapper.SpecificationMapper;
import com.web.shopping.mapper.SpecificationOptionMapper;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Specification;
import com.web.shopping.pojo.SpecificationAndOption;
import com.web.shopping.pojo.SpecificationExample;
import com.web.shopping.pojo.SpecificationExample.Criteria;
import com.web.shopping.pojo.SpecificationOption;
import com.web.shopping.pojo.SpecificationOptionExample;
import com.web.shopping.service.SpecificationService;

/** 
* @ClassName: SpecificationServiceImpl 
* @Description:  Specification规格管理实现类
* @author dpk
* @date 2019-09-09 02:30:30 
*/

@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private SpecificationMapper specificationMapper;
	@Autowired
	private SpecificationOptionMapper specificationOptionMapper ;
	
	/**
	* @Description: 查找全部规格
	* @return List<Specification>
	* @author dpk
	* @date 2019-09-09 02:47:13 
	*/ 
	
	@Override
	public List<Specification> findAllSpecification() {
		return specificationMapper.selectByExample(null);
	}

	/** 
	* @Description: 按ID找规格
	* @param id
	* @return Specification
	* @author dpk
	* @date 2019-09-09 02:47:13 
	*/ 
	@Override
	public SpecificationAndOption findOne(Long id) {
		SpecificationAndOption spec = new SpecificationAndOption();
		// 根据规格ID查询规格对象
		Specification specification = specificationMapper.selectByPrimaryKey(id);
		spec.setSpecification(specification);
		
		// 根据规格的ID查询规格选项
		SpecificationOptionExample example = new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<SpecificationOption> list = specificationOptionMapper.selectByExample(example);
		spec.setSpecificationOptionList(list);
		
		return spec;
	}

	/** 
	* @Description: 分页
	* @param pageNo
	* @param pageSize
	* @return PageResult
	* @author dpk
	* @date 2019-09-09 02:47:13 
	*/ 
	
	@Override
	public PageResult findByPage(int pageNo, int pageSize,String specName) {
		PageResult pageResult = new PageResult();
		PageHelper.startPage(pageNo,pageSize);
		System.out.println("findSpecificationByPage===========SpecificationServiceImpl============="+specName);
		List<Specification> list = new ArrayList<>();
		if("".equals(specName) || null == specName ) {
			System.out.println("nulllllll===================specname");
			list = specificationMapper.selectByExample(null);
		}else {
			list = specificationMapper.findSpecificationByName(specName);
		}
		
		for(Specification b : list) {
			System.out.println(b.getId()+"-----》  "+b.getSpecName());
		}
		PageInfo pageInfo = new PageInfo<>(list);
		pageResult.setRows(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	/** 
	* @Description: 增加一个规格
	* @param specification 
	* @author dpk
	* @date 2019-09-09 02:54:52 
	*/ 
	@Override
	public void add(SpecificationAndOption spec) {
		// 保存规格
		specificationMapper.insert(spec.getSpecification());
		
		System.out.println("++++修改了insert方法，插入后ID也跟着插入+++++specificationMapper.insert(spec.getSpecification());+++++++"+spec.getSpecification().getId());
		
		// 保存规格选项
		for(SpecificationOption specificationOption: spec.getSpecificationOptionList()){
			// 设置规格的ID:
			specificationOption.setSpecId(spec.getSpecification().getId());
			
			specificationOptionMapper.insert(specificationOption);
		}
	}

	/** 
	* @Description: 更新规格
	* @param specification 
	* @author dpk
	* @date 2019-09-09 02:54:52 
	*/ 
	@Override
	public void update(SpecificationAndOption spec) {
		// 修改规格
		specificationMapper.updateByPrimaryKey(spec.getSpecification());
		System.out.println("##update######"+spec.getSpecification().getId()+"#####"+spec.getSpecification().getSpecName());
		// 先删除规格选项，再添加规格选项
		SpecificationOptionExample example = new SpecificationOptionExample();
		SpecificationOptionExample.Criteria criteria = example.createCriteria();
		criteria.andSpecIdEqualTo(spec.getSpecification().getId());
		specificationOptionMapper.deleteByExample(example);
		
		// 保存规格选项
		for(SpecificationOption specificationOption: spec.getSpecificationOptionList()){
			// 设置规格的ID:
			specificationOption.setSpecId(spec.getSpecification().getId());
			System.out.println("##########update###############"+spec.getSpecification().getId());
			specificationOptionMapper.insert(specificationOption);
		}
	}

	/** 
	* @Description: 删除规格
	* @param ids 
	* @author dpk
	* @date 2019-09-09 02:54:52 
	*/ 
	@Override
	public void delete(Long[] ids) {
		for(Long id : ids){
			// 删除规格
			specificationMapper.deleteByPrimaryKey(id);
			
			// 删除规格选项:
			SpecificationOptionExample example = new SpecificationOptionExample();
			SpecificationOptionExample.Criteria criteria = example.createCriteria();
			criteria.andSpecIdEqualTo(id);
			specificationOptionMapper.deleteByExample(example);
		}		
	}

	/** 
	* @Description: 模糊查询
	* @param specName
	* @return List<Specification>
	* @author dpk
	* @date 2019-09-09 04:01:15 
	*/ 
	@Override
	public PageResult findSpecificationByName(String specName) {
		PageResult pageResult = new PageResult();
		List<Specification> list = specificationMapper.findSpecificationByName(specName);
		PageInfo pageInfo = new PageInfo<>(list);
		pageResult.setRows(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	/** 
	* @Description: TODO(描述) 
	* @param specificationOption
	* @param pageNo
	* @param pageSize
	* @return 
	* @author dpk
	* @date 2019-09-10 08:10:33 
	*/ 
	@Override
	public PageResult findPage(Specification specification, int pageNo, int pageSize) {
		PageHelper.startPage(pageNo, pageSize);
		
		SpecificationExample example=new SpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
		}
		
		Page<Specification> page= (Page<Specification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	/** 
	* @Description: TODO(描述) 
	* @return 
	* @author dpk
	* @date 2019-09-10 08:10:33 
	*/ 
	@Override
	public List<Map> selectOptionList() {
		return specificationMapper.selectOptionList();
	}
	
}
