package com.web.shopping.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.shopping.pojo.PageResult;
import com.web.shopping.pojo.Result;
import com.web.shopping.pojo.Specification;
import com.web.shopping.pojo.SpecificationAndOption;
import com.web.shopping.service.SpecificationService;

/** 
* @ClassName: SpecificationController 
* @Description:Specification规格管理Controller 
* @author dpk
* @date 2019-09-09 02:29:31 
*/

@RestController
@CrossOrigin
public class SpecificationController {

	@Autowired
	private SpecificationService specificationService;
	
	@RequestMapping("/findAllSpecification")
	public List<Specification> findAllSpecification(){
		List<Specification> list = specificationService.findAllSpecification();
		for(Specification b : list) {
			System.out.println(b.getSpecName());
		}
		return specificationService.findAllSpecification();
	}
	
	@RequestMapping("/findSpecificationAndOptionById/{id}")
	public SpecificationAndOption findSpecificationAndOptionById(@PathVariable Long id) {
		return specificationService.findOne(id);
	}
	
	@RequestMapping("/findSpecificationByPage")
	public PageResult findByPage(int pageNo,int pageSize,String specName) {
		System.out.println("findSpecificationByPage===========controller============="+specName);
		return specificationService.findByPage(pageNo, pageSize,specName);
	}
	
	@RequestMapping(value = "/addSpecificationAndOption" ,method=RequestMethod.POST)
	public Result add(@RequestBody SpecificationAndOption spec) {
		
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("********************************");
		System.out.println("**********"+spec.getSpecificationOptionList().get(0).getOptionName()+"**************");
		System.out.println("**********"+spec.getSpecificationOptionList().get(0).getOrders()+"**********************");
		System.out.println("********************************");
		System.out.println("addSpecificationAndOption----------------"+spec.getSpecification().getSpecName());
		
		try {
			specificationService.add(spec);;
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "增加失败");
		}
	}
	
	@RequestMapping(value = "/updateSpecificationAndOption" ,method=RequestMethod.POST)
	public Result update(@RequestBody SpecificationAndOption spec) {
		
		System.out.println();
		System.out.println("updateSpecificationAndOption----------------"+spec.getSpecification().getSpecName());
		
		try {
			specificationService.update(spec);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}
	
	@RequestMapping(value = "/deleteSpecificationAndOption" ,method=RequestMethod.GET)
	public Result delete(Long[] ids) {
		
	System.out.println("deleteSpecificationAndOption----------------"+ids.length);
		
		try {
			specificationService.delete(ids);
			return new Result(true, "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
	@RequestMapping(value = "/findSpecificationByName",method=RequestMethod.GET)
	public PageResult findSpecificationByName(@RequestParam("specName") String specName){
		
		System.out.println("specName================================================"+specName);
		return specificationService.findSpecificationByName(specName);
	}
	
	
	//规格搜索方式2，没使用
	@RequestMapping("/search")
	public PageResult search(Specification specification, int pageNo,int pageSize) {
		return specificationService.findPage(specification, pageNo, pageSize);
	}
	
	@RequestMapping("/selectOptionList")
	public List<Map> selectOptionList(){
		return specificationService.selectOptionList();
	}
	
	
}
