package gyt.core.util;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

/**
 * 字符串处理工具类 
 */
public class StringUtil {
	
	/**
	 * 验证手机号码的正则表达式
	 */
	public static final String phoneRegex = "((\\+|0)?86)?1(\\d{10})";
	
	/**
	 * 将字符串进行加密
	 */
	public static String encode(MessageDigest md,String str)
	{
		String reStr = "";
		md.update(str.getBytes());
		byte aa[] = md.digest();
		for (int i = 0; i < aa.length; i++)
		{
			int temp;
			if (aa[i] < 0)
				temp = 256 + aa[i];
			else
				temp = aa[i];
			if (temp < 16)
				reStr += "0";
			reStr += Integer.toString(temp, 16);
		}
		reStr = reStr.toUpperCase();
		return reStr;
	}
	
	/**
	 * 将数值字符串数组转成Integer数组
	 * 
	 * @param intStrs 数值字符串数组
	 */
	public static Integer[] toIntegerArray(String[] intStrs)
	{
		if(intStrs == null || intStrs.length == 0)
		{
			return new Integer[0];
		}
		List<Integer> temp = new ArrayList<Integer>(intStrs.length);
		for(int i = 0 ; i < intStrs.length ; i ++)
		{
			intStrs[i] = intStrs[i].trim();
			if(intStrs[i].matches("\\d+"))
			{
				temp.add(Integer.parseInt(intStrs[i]));
			}
		}
		return temp.toArray(new Integer[0]);
	}
	
	/**
	 * 返回定长的数字字符串，如果数字不够长，右端全补零
	 * 
	 * @param num 数字
	 * @param length 数字串长度
	 * 
	 * @return 定长的数字串
	 */
	public static String unmbetr2str(int num,int length)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(num);
		while(sb.length() < length)
		{
			sb.insert(0, "0");
		}
		return sb.toString();
	}
}
