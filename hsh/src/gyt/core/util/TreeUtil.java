package gyt.core.util;

import gyt.system.model.DepartmentInfo;

import java.util.List;

public class TreeUtil {
	
	public static String bulidDepHtml(List<DepartmentInfo> depList){
		if(depList != null && depList.size() > 0){
			StringBuffer html = new StringBuffer();
			html.append("<ul>");
			for(DepartmentInfo depInfo : depList){
				html.append("<li onclick='showDep("+depInfo.getDepId()+")'><a href='#'>"+depInfo.getDepName()+"</a></li>");
				html.append(bulidDepHtml(depInfo.getDepList()));
			}
			html.append("</ul>");
			return html.toString();
		}
		return "";
	}
}
