package gyt.core.util;

import java.util.List;

public class Page {
	
	/** 当前页码 */
	private int pageNo = 1;
	/** 每页显示条数 */
	private int barNumbers=10;
	/** 总页数 */
	private int pageSize = 10;
	/** 总条数 */
	private int pageTotal;
	/** 数据 */
	private List dataList;
    /** 查询条件 */
	private Object conditions;
	/** 上一条*/
	private Object theLastObject;
	/** 下一条*/
	private Object theNextObject;
	public Object getTheLastObject() {
		return theLastObject;
	}

	public void setTheLastObject(Object theLastObject) {
		this.theLastObject = theLastObject;
	}

	public Object getTheNextObject() {
		return theNextObject;
	}

	public void setTheNextObject(Object theNextObject) {
		this.theNextObject = theNextObject;
	}

	private String bulidHtml;
	
	public Page() {}

	public Page(int pageNo,int barNumbers) {
		this.pageNo = pageNo;
		if(barNumbers>0){
			this.barNumbers = barNumbers;
		}
	}
	
	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getBarNumbers() {
		return barNumbers;
	}

	public void setBarNumbers(int barNumbers) {
		this.barNumbers = barNumbers;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
		if(pageTotal%this.barNumbers==0){
			this.pageSize = pageTotal/this.barNumbers;
		}else if(pageTotal%this.barNumbers>0){
			this.pageSize = pageTotal/this.barNumbers+1;
		}
		buildHtml();
	}

	public List getDataList() {
		return dataList;
	}

	public void setDataList(List dataList) {
		this.dataList = dataList;
	}

	public Object getConditions() {
		return conditions;
	}

	public void setConditions(Object conditions) {
		this.conditions = conditions;
	}
    

	public void buildHtml(){
		StringBuffer html = new StringBuffer();
		html.append("<script>");
		html.append("function swichPage(pageNo){document.forms[0]['pageNo'].value=pageNo;document.forms[0].submit();}");
		html.append("</script>");
		html.append("<div class='message'>共<i class='blue'>"+this.pageTotal+"</i>条记录,每页&nbsp;<i class='blue'>"+this.barNumbers+"&nbsp;</i>条,当前显示第&nbsp;<i class='blue'>"+this.pageNo+"&nbsp;</i>页</div>");
		html.append("<ul class='paginList'>");
		if(this.pageNo > 1){
			html.append("<li class='paginItem'><a href='javascript:swichPage("+(this.pageNo-1)+");'><span class='pagepre'></span></a></li>");
		}
		if(this.pageSize <= 8){
			for(int i=1;i<=this.pageSize;i++){
				if(i==this.pageNo){
					html.append("<li class='paginItem current'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
				}else{
					html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
				}
			}
		}else{
			if(this.pageNo<6){
				for(int i=1;i<=5&&i<this.pageSize;i++){
					if(i==this.pageNo){
						html.append("<li class='paginItem current'><a href='javascript:;'>"+(i)+"</a></li>");
					}else{
						html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
					}
				}
				if(this.pageSize>7){
					html.append("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
					html.append("<li class='paginItem'><a href='javascript:swichPage("+this.pageSize+");'>"+this.pageSize+"</a></li>");
				}else{
					if(this.pageSize>5){
						for(int i=6;i<=this.pageSize;i++){
							html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+i+"</a></li>");
						}
					}
				}
			}else if(this.pageNo>5){
					if(this.pageSize-this.pageNo>=5){
						html.append("<li class='paginItem'><a href='javascript:swichPage(1);'>1</a></li>");
						html.append("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
						for(int i=this.pageNo;i<this.pageNo+4&&i<=this.pageSize;i++){
							if(i==this.pageNo){
								html.append("<li class='paginItem current'><a href='javascript:;'>"+(i)+"</a></li>");
							}else{
								html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
							}
						}
						if(this.pageSize>this.pageNo+5){
							html.append("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
							html.append("<li class='paginItem'><a href='javascript:swichPage("+this.pageSize+");'>"+this.pageSize+"</a></li>");
						}else{
							if(this.pageSize>this.pageNo+4){
								for(int i=this.pageNo+4;i<=this.pageSize;i++){
									html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+i+"</a></li>");
								}
							}
						}
					}else{
						int pageCache = this.pageSize-5;
						if(pageCache>3){
							html.append("<li class='paginItem'><a href='javascript:swichPage(1);'>1</a></li>");
							html.append("<li class='paginItem more'><a href='javascript:;'>...</a></li>");
							for(int i=pageCache;i<=this.pageSize;i++){
								if(i==this.pageNo){
									html.append("<li class='paginItem current'><a href='javascript:;'>"+(i)+"</a></li>");
								}else{
									html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
								}
							}
						}else{
							for(int i=1;i<=this.pageSize;i++){
								if(i==this.pageNo){
									html.append("<li class='paginItem current'><a href='javascript:;'>"+(i)+"</a></li>");
								}else{
									html.append("<li class='paginItem'><a href='javascript:swichPage("+i+");'>"+(i)+"</a></li>");
								}
							}
						}
						
						
					}
					
			}
		}
		
		if(this.pageNo < this.pageSize){
			html.append("<li class='paginItem'><a href='javascript:swichPage("+(this.pageNo+1)+");'><span class='pagenxt'></span></a></li>");
		}
		html.append("</ul>");
		
		this.bulidHtml = html.toString();
	}

	public String getBulidHtml() {
		return bulidHtml;
	}

	public void setBulidHtml(String bulidHtml) {
		this.bulidHtml = bulidHtml;
	}
	
	
	

}
