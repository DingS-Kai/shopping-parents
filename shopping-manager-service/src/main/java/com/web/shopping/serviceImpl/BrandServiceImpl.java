package com.web.shopping.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.web.shopping.mapper.BrandMapper;
import com.web.shopping.pojo.Brand;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandMapper brandMapper;

	/** 
	* @Description: 查找所有品牌信息
	* @return 
	* @author dpk
	* @date 2019-09-06 10:29:29 
	*/ 
	
	@Override
	public List<Brand> findAllBrand() {
		return brandMapper.selectByExample(null);
	}

	/** 
	* @Description:根据ID找品牌
	* @return 
	* @author dpk
	* @date 2019-09-06 10:29:29 
	*/ 
	
	@Override
	public Brand findBrandById(Long id) {
		return brandMapper.selectByPrimaryKey(id);
	}

	/** 
	* @Description: 分页
	* @param pageNo
	* @param pageSize
	* @return 
	* @author dpk
	* @date 2019-09-06 03:11:19 
	*/ 
	
	@Override
	public PageResult findByPage(int pageNo, int pageSize) {
		PageResult pageResult = new PageResult();
		PageHelper.startPage(pageNo,pageSize);
		List<Brand> list = brandMapper.selectByExample(null);
		for(Brand b : list) {
			System.out.println(b.getId()+"-----》  "+b.getName()+"-----》  "+b.getFirstChar());
		}
		PageInfo pageInfo = new PageInfo<>(list);
		pageResult.setRows(list);
		pageResult.setTotal(pageInfo.getTotal());
		return pageResult;
	}

	/** 
	* @Description: 增加一个品牌
	* @param brand 
	* @author dpk
	* @date 2019-09-09 10:05:12 
	*/ 
	
	@Override
	public void addBrand(Brand brand) {
		brandMapper.insert(brand);
	}

	/** 
	* @Description: 更新品牌信息
	* @param brand 
	* @author dpk
	* @date 2019-09-09 10:05:12 
	*/ 
	
	@Override
	public void updateBrand(Brand brand) {
		brandMapper.updateByPrimaryKey(brand);
		
	}

	/** 
	* @Description: 删除品牌 
	* @param ids 
	* @author dpk
	* @date 2019-09-09 10:05:12 
	*/ 
	
	@Override
	public void deleteBrand(Long[] ids) {
		for(Long id : ids) {
			brandMapper.deleteByPrimaryKey(id);
		}
	}

}
