package gyt.core.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;


/**
 * 文件工具类 
 */
public class FileUtil {
	
	/***
	 * 自动生成一个temp文件下按日期排序的临时文件名称 
	 */
	public static String randTempFileName()
	{
		long now = System.currentTimeMillis();
		String fileName = now + UUID.randomUUID().toString().replaceAll("\\-", "");
		return fileName;		
	}
	
	/** 复制文件*/
	public static boolean copy(File src, File dest) {
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(src));
			bos = new BufferedOutputStream(new FileOutputStream(dest));
			byte[] bts = new byte[1024];
			int len = -1;
			while ((len = bis.read(bts)) != -1) {
				bos.write(bts, 0, len);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
	/**
	 * 复制目标文件夹下的文件，并删除目标文件和文件夹
	 * @param objectFilePath
	 * @param filePath
	 */
	public static void copyDel(String objectFilePath,String filePath){
		File file = new File(objectFilePath);
		File[] files = file.listFiles();
		if(files == null)
			return;
		for (File file2 : files) {
			if(new File(filePath).exists()){
				FileUtil.copy(file2,new File(filePath+"/"+file2.getName()) );
			}else{
				File fi = new File(filePath);
				fi.mkdirs();
				FileUtil.copy(file2,new File(filePath+"/"+file2.getName()) );
			}
			//删除临时文件
			file2.delete();
		}
		//删除临时文件夹
		file.delete();
	}
	/**
	 *	下载文件
	 * @throws IOException 
	 */
	public static void downloadFile(HttpServletResponse response,String filePath,String filename) throws IOException{
            // path是指欲下载的文件的路径。
		 	File file = new File(filePath);
            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("utf-8"),"ISO-8859-1"));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
	}
}
