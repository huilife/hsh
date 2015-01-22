package gyt.core.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import gyt.opinterface.model.RequestBean;

/**
 * 加密工具
 * @author yangyuanjiang
 * @version 2014-08-18
 */
public class ServiceKeyUtil {
	
	private static final String KEY_STORE = "gyt2014";
	
	/**
	 * 32位MD5
	 * @param plainText
	 * @return
	 */
	private static String Md532(String plainText) { 
		StringBuffer buf = new StringBuffer(""); 
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i = 0; 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) i+= 256; 
				if(i<16) 
				buf.append("0"); 
				buf.append(Integer.toHexString(i)); 
			} 
		} catch (NoSuchAlgorithmException e) { 
			return "";
		} 
		if("".equalsIgnoreCase(buf.toString())){
			return "";
		}
		return buf.toString();
	} 
	
	/**
	 * 16位MD5
	 * @param plainText
	 * @return
	 */
	private static String Md516(String plainText) { 
		StringBuffer buf = new StringBuffer(""); 
		try { 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
			md.update(plainText.getBytes()); 
			byte b[] = md.digest(); 
			int i = 0; 
			for (int offset = 0; offset < b.length; offset++) { 
				i = b[offset]; 
				if(i<0) i+= 256; 
				if(i<16) 
				buf.append("0"); 
				buf.append(Integer.toHexString(i)); 
			} 
		} catch (NoSuchAlgorithmException e) { 
			return "";
		} 
		if("".equalsIgnoreCase(buf.toString())){
			return "";
		}
		return buf.toString().substring(8,24);
	} 
	
	public static String getXmlMac(String xmlData,String mac){
		return Md516(mac+xmlData+mac);
	}
	
	/**
	 * 加密验证
	 * @param json
	 * @return
	 */
	public static boolean isValidation(RequestBean request){
		return request.getKey().equals(Md532(KEY_STORE+request.getCode()+request.getData()));
	}
	
}