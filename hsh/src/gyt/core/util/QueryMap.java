package gyt.core.util;

import java.util.HashMap;

/**
 * 查询条件装配 
 */
@SuppressWarnings("serial")
public class QueryMap extends HashMap<String, Object>{
	
	/**
	 * 增加查询条件 
	 */
	@Override
	public Object put(String key, Object value) {
		if(value == null)
		{
			return super.put(key, value);
		}
		if(value.getClass() == String[].class)
		{	
			String[] valArray = (String[]) value;
			if(valArray.length == 1)
			{
				value = ((String[]) value)[0];
			}
		}
		return super.put(key, value);
	}
	
	@Override
	public boolean containsKey(Object key) {
		return true;
	}
		
	@Override
	public Object get(Object key) {
		Object value = super.get(key);
		if(value == null && !"page".endsWith(key.toString()) 
				&& !"key".equals(key.toString()) 
				&& !"keys".equals(key.toString()))
		{
			value = "";
		}
		return value;
	}
}
