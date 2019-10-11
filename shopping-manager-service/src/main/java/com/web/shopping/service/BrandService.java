package com.web.shopping.service;

import java.util.List;

import com.web.shopping.pojo.Brand;
import com.web.shopping.pojo.PageResult;

public interface BrandService {
	
	public List<Brand> findAllBrand();
	
	public Brand findBrandById(Long id);
	
	public PageResult findByPage(int pageNo,int pageSize);
	
	public void addBrand(Brand brand);
	
	public void updateBrand(Brand brand);
	
	public void deleteBrand(Long[] ids);
	
	
	
}
