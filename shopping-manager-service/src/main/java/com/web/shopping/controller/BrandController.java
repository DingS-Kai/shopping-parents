package com.web.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.web.shopping.pojo.Brand;
import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Result;
import com.web.shopping.service.BrandService;

@RestController
@CrossOrigin
public class BrandController {
	
	@Autowired
	private BrandService brandService;
	
	@RequestMapping("/findAllBrand")
	public List<Brand> findAllBrand(){
		List<Brand> list = brandService.findAllBrand();
		for(Brand brand : list) {
			System.out.println(brand.getName());
		}
		return brandService.findAllBrand();
	}
	
	@RequestMapping("/findBrandById/{id}")
	public Brand findBrandById(@PathVariable Long id) {
		return brandService.findBrandById(id);
	}
	
	@RequestMapping("/findByPage")
	public PageResult findByPage(int pageNo,int pageSize) {
		return brandService.findByPage(pageNo, pageSize);
	}
	
	@RequestMapping(value ="/addBrand" ,method=RequestMethod.POST)
	public Result addBrand(@RequestBody Brand brand) {
		
		System.out.println("addBrand----------------"+brand.getName());
		
		Result result = new Result();
		try {
			brandService.addBrand(brand);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value ="/updateBrand" ,method=RequestMethod.POST)
	public Result updateBrand(@RequestBody Brand brand) {
		
		System.out.println("updateBrand---------------"+brand.getName());
		
		Result result = new Result();
		try {
			brandService.updateBrand(brand);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value ="/deleteBrand" ,method=RequestMethod.GET)
	public Result deleteBrand(Long[] ids) {
		
		System.out.println("delete--------------------------"+ids.length);
		
		Result result = new Result();
		try {
			brandService.deleteBrand(ids);
			result.setSuccess(true);
		} catch (Exception e) {
			result.setSuccess(false);
			e.printStackTrace();
		}
		return result;
	}
}
