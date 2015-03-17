package org.jsoft.comm.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.jsoft.comm.vo.PageDivid;
/**
 * 对数据库的基本操作接口
 * @author 羽
 *
 * @param <T> 泛型 即对那个vo类操作
 */
public interface IBaseDAO<T> {
	/**
	 * 得到一个链接 Session
	 * @return Session
	 */
	public Session getSession();
	
	public void closeSession();
	/**
	 * 保存一个对象
	 * @param object
	 * @return
	 */
	public Serializable save(T object);
	/**
	 * 修改对象
	 * @param object
	 */
	public void update(T object);
	/**
	 * 删除一个对象
	 * @param object
	 */
	public void delete(T object);
	/**
	 * 保存或者更新一个对象
	 * @param object
	 */
	public void saveOrUpdate(T object);
	/**
	 * 根据输入的hql查询返回的结果集
	 * @param hql
	 * @return
	 */
	public List<T> find(String hql);
	/**
	 * 根据hql  以及条件元素的值返回结果集
	 * @param hql
	 * @param parament
	 * @return
	 */
	public List<T> find(String hql,List<Object> paraments);
	/**
	 * 根据hql语句以及分页bean类  返回当前页码的数据集
	 * @param hql
	 * @param pageDivid
	 * @return
	 */
	public List<T> find(String hql,PageDivid pageDivid);
	
	/**
	 * 根据hql语句和条件结果值集以及分页bean类 返回当前页码的数据集
	 * @param hql
	 * @param pageDivid
	 * @param paraments 条件的结果集
	 * @return
	 */
	public List<T> find(String hql,List<Object> paraments,PageDivid pageDivid);
	/**
	 * 根据类型 返回编号为id的这个对象值
	 * @param clazz  bean的类型
	 * @param id  这个的id属性
	 * @return
	 */
	public T get(Class<T> clazz,Serializable id);
	/**
	 * 根据所给的hql语句返回一个对应的对象
	 * @param hql
	 * @return
	 */
	public T get(String hql);
	/**
	 * 根据给定的hql 语句和给定的条件值  返回查到的特定对象
	 * @param hql
	 * @param paraments
	 * @return
	 */
	public T get(String hql,List<Object> paraments);
	/**
	 * 根据给定的hql查询数据的总条数
	 * @param hql
	 * @return
	 */
	public Serializable count(String hql);
	/**
	 * 根据给定的hql  和条件值集查询  返回总条数
	 * @param hql
	 * @param paraments
	 * @return
	 */
	public Serializable count(String hql,List<Object> paraments);
	
	public void rebuildSessionFactory();
	
}
