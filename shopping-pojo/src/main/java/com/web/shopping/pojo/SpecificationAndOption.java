package com.web.shopping.pojo;

import java.io.Serializable;
import java.util.List;

/** 
* @ClassName: SpecificationAndOption 
* @Description: TODO(描述)  
* @author dpk
* @date 2019-09-09 10:05:03 
*/

public class SpecificationAndOption implements Serializable{

	private static final long serialVersionUID = 1L;

	private Specification specification;
	
	private List<SpecificationOption> specificationOptionList;

	public Specification getSpecification() {
		return specification;
	}

	public void setSpecification(Specification specification) {
		this.specification = specification;
	}

	public List<SpecificationOption> getSpecificationOptionList() {
		return specificationOptionList;
	}

	public void setSpecificationOptionList(List<SpecificationOption> specificationOptionList) {
		this.specificationOptionList = specificationOptionList;
	}
	
}
