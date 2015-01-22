package gyt.core.dao;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import gyt.core.util.SysControl;

/**
 * 基础持久化访问类
 */
@SuppressWarnings("unchecked")
public class DatabaseDao<T extends BaseObject<PK>, PK extends Serializable> extends SqlSessionDaoSupport implements
    IDao<T, PK>
{
    /**
     * POJO SQL mapping的命名空间
     * 
     * 建议使用POJO的类全名
     */
    private String namespace;

    public DatabaseDao(String namespace)
    {
        this.namespace = namespace;
    }

    /**
     * 通过ID获取实体对象
     * 
     * @return T POJO实体对象
     */
    public T get(PK id)
    {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("id", id);
        return (T) getSqlSession().selectOne(namespace + ".get", args);
    }

    /**
     * 查询实体对象集合
     * 
     * @return List<T> 满足条件的POJO实体对象集合
     */
    public List<T> find(Map<String, Object> args)
    {
        List<T> list = getSqlSession().selectList(namespace + ".find", args);
        return list;
    }

    /**
     * 保存实体对象
     * 
     * @return T POJO实体对象
     */
    public T save(T obj)
    {
        getSqlSession().insert(namespace + ".insert", obj);
        return obj;
    }

    /**
     * 修改实体对象
     * 
     * @return T POJO实体对象
     */
    public T update(T obj)
    {
        getSqlSession().update(namespace + ".update", obj);
        return obj;
    }

    /**
     * 修改或更新实体对象
     * 
     * @return T POJO实体对象
     */
    public T saveOrUpdate(T obj)
    {
        if (obj.getId() != null)
        {
            obj = update(obj);
        }
        else
        {
            obj = save(obj);
        }
        return obj;
    }

    /**
     * 批量删除
     */
    public int delete(PK[] keys)
    {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("keys", keys);
        return getSqlSession().delete(namespace + ".delete", args);
    }

    /**
     * 批量删除
     */
    public int delete(List<PK> keys)
    {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("keys", keys);
        return getSqlSession().delete(namespace + ".delete", args);
    }

    /**
     * 删除
     */
    public int delete(PK key)
    {
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("key", key);
        return getSqlSession().delete(namespace + ".delete", args);
    }

    /**
     * 自定义对象集合查询
     */
    public List queryList(Map<String, Object> args)
    {
        List list = getSqlSession().selectList(namespace + "." + args.get(SysControl.DAO_METHOD_KEY), args);
        return list;
    }

    /**
     * 自定义对象查询
     */
    public Object queryObject(Map<String, Object> args)
    {
        Object obj = getSqlSession().selectOne(namespace + "." + args.get(SysControl.DAO_METHOD_KEY), args);
        return obj;
    }

    /**
     * 自定义更新执行
     * 
     * @param args
     *            参数MAP
     */
    public int execute(Map<String, Object> args)
    {
        return getSqlSession().update(namespace + "." + args.get(SysControl.DAO_METHOD_KEY), args);
    }
    
    /**
     * 保存实体对象
     * 
     * @return T POJO实体对象
     */
    public int executeDelete(Map<String, Object> args)
    {
        return getSqlSession().insert(namespace + "." + args.get(SysControl.DAO_METHOD_KEY), args);
    }

    /**
     * 查询记录数
     */
    public long count(Map<String, Object> args)
    {
        return (Long) getSqlSession().selectOne(namespace + ".count", args);
    }

    /**
     * 自定义更新执行
     * 
     * @param methodKey
     *            执行配置的key
     * @param obj
     *            参数对象
     */
    public int execute(String methodKey, Object obj)
    {
        return getSqlSession().update(namespace + "." + methodKey, obj);
    }

    /**
     * 自定义sql更新执行
     * 
     * @param sql
     *            需要执行的SQL
     */
    public int executeBySQL(String sql)
    {
        Map<String, String> args = new HashMap<String, String>();
        args.put("sql", sql);
        return getSqlSession().update(SysControl.DEFAULT_SQL_EXECUTE, args);
    }

    /**
     * 自定义sql查询单行记录
     * 
     * @param sql
     *            需要执行的SQL
     * 
     * @return Object 单行记录
     */
    public Object queryOneBySQL(String sql)
    {
        Map<String, String> args = new HashMap<String, String>();
        args.put("sql", sql);
        return getSqlSession().selectOne(SysControl.DEFAULT_SQL_QUERY_ONE, args);
    }

    /**
     * 自定义sql查询多行记录
     * 
     * @param sql
     *            需要执行的SQL
     * 
     * @return List 单行记录
     */
    public List queryListBySQL(String sql)
    {
        Map<String, String> args = new HashMap<String, String>();
        args.put("sql", sql);
        return getSqlSession().selectList(SysControl.DEFAULT_SQL_QUERY_LIST, args);
    }

    /**
     * 判断给定表是否存在
     * 
     * @param tableName
     *            表名称
     * @return true,存在；false ,不存在
     */
    public boolean hasTable(String tableName)
    {
        // 判断某一个表是否存在
        boolean result = false;
        ResultSet set = null;
        try
        {
            DatabaseMetaData meta = this.getSqlSession().getConnection().getMetaData();
            set = meta.getTables(null, null, tableName, null);
            while (set.next())
            {
                result = true;
            }
        }
        catch (Exception eHasTable)
        {
            System.err.println(eHasTable);
            eHasTable.printStackTrace();
        }
        finally
        {
            if (set != null)
            {
                try
                {
                    set.close();
                }
                catch (SQLException e)
                {
                }
            }
        }
        return result;
    }

}
