package gyt.core.dao;

import java.io.Serializable;

/**
 *	POJO基础类 
 */
@SuppressWarnings("serial")
public abstract class BaseObject<PK extends Serializable> implements Serializable,Cloneable{
	/**
	 *	主键 
	 */
	protected PK id;

	public PK getId()
	{
		return id;
	}

	public void setId(PK id)
	{
		this.id = id;
	}
	
	public BaseObject clone() throws CloneNotSupportedException
	{
		return (BaseObject)super.clone();
	}
}
