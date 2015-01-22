package gyt.system.model;

import java.util.List;

/**
 * 菜单
 * @author yangyuanjiang
 *
 */
public class MenuInfo {
	
	/** 菜单ID */
	private int menuId;
	/** 父级ID */
	private int parentMenuId;
	/** 菜单名称 */
	private String menuName;
	/** 图片 */
	private String image;
	/** 点击图片 */
	private String cimage;
	/** 菜单链接 */
	private String url;
	/** 子菜单 */
	private List<MenuInfo> itemMenuList;

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getParentMenuId() {
		return parentMenuId;
	}

	public void setParentMenuId(int parentMenuId) {
		this.parentMenuId = parentMenuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCimage() {
		return cimage;
	}

	public void setCimage(String cimage) {
		this.cimage = cimage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuInfo> getItemMenuList() {
		return itemMenuList;
	}

	public void setItemMenuList(List<MenuInfo> itemMenuList) {
		this.itemMenuList = itemMenuList;
	}

	
}
