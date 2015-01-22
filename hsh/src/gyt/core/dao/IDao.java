package gyt.core.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *	数据持久化接口 
 */
public interface IDao<T extends BaseObject<PK>,PK extends Serializable> {

	/**
	 *	通过ID获取实体对象
	 *	
	 *	@return T POJO实体对象
	 */
	public T get(PK id);
	
	/**
	 *	查询实体对象集合
	 *
	 *	@return List<T> 满足条件的POJO实体对象集合
	 */
	public List<T> find(Map<String, Object> args);
	
	/**
	 *	保存实体对象
	 *
	 *	@return T POJO实体对象
	 */
	public T save(T obj);
	
	/**
	 *	修改实体对象
	 *
	 *	@return T POJO实体对象
	 */
	public T update(T obj);
	
	/**
	 *	修改或更新实体对象 
	 *
	 *	@return T POJO实体对象
	 */
	public T saveOrUpdate(T obj);
		
	/**
	 *	批量删除
	 */
	public int delete(PK[] keys);
	
	/**
	 *	批量删除
	 */
	public int delete(List<PK> keys);
	
	/**
	 *	删除
	 */
	public int delete(PK key);
	
	/**
	 *	自定义对象集合查询
	 */
	public List queryList(Map<String, Object> args);
	
	/**
	 *	自定义对象查询
	 */
	public Object queryObject(Map<String, Object> args);
	
	/**
	 *	自定义更新执行
	 *
	 *	@param args 参数MAP
	 */
	public int execute(Map<String, Object> args);

}
