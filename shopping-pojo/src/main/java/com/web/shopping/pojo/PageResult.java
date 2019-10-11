/**  
 * @Title: PageResult.java
 * @Description: TODO(描述)
 * @author dpk
 * @date 2019-09-06 02:21:48 
 */  
package com.web.shopping.pojo;

import java.util.List;

/** 
* @ClassName: PageResult 
* @Description: 分页助手pojo
* @author dpk
* @date 2019-09-06 02:21:48 
*/

public class PageResult {

	private List rows;
	private long total;
	
	/** 
	* @Title: PageResult 
	* @Description: PageResult构造函数 
	* @date 2019-09-09 11:13:36 
	*/ 
	public PageResult() {
	}

	public PageResult(long total, List rows) {
		this.total = total;
		this.rows = rows;
	}
	
	public List getRows() {
		return rows;
	}
	public void setRows(List rows) {
		this.rows = rows;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long l) {
		this.total = l;
	}
}
