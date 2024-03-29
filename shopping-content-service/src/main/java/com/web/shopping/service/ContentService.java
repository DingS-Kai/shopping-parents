package com.web.shopping.service;

import java.util.List;

import com.web.shopping.pojo.Content;
import com.web.shopping.pojo.PageResult;

public interface ContentService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Content> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum,int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(Content content);
	
	
	/**
	 * 修改
	 */
	public void update(Content content);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public Content findOne(Long id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Long [] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(Content content, int pageNum,int pageSize);
	
	/**
	 * 根据广告分类ID查询广告
	 */
	public List<Content> findByCategoryId(Long categoryId);
	
}
