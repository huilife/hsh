package cn.itcast.poi;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaderExcel2 {

	public static void main(String[] args) {
//		String filepath="c:\\12345.xlsx";
		String filepath="c:\\123.xls";
		try{
			InputStream in=new FileInputStream(filepath);
			Workbook workbook=WorkbookFactory.create(in);
			toReader(workbook);
			in.close();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}

	public static void toReader(Workbook workbook) {
		int x=0;//用于工作表角标
		Sheet sheet = workbook.getSheetAt(x++); //获取一个工作表
		while(true){
			
			for(int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++){ //外循环控制行
							Row row;
							int rowCellfirst,rowCelllast;
							try{
								row=sheet.getRow(i);
								rowCellfirst=row.getFirstCellNum();
								rowCelllast=row.getLastCellNum();

							}catch(Exception e){ //捕捉row.getFirstCellNum();row.getLastCellNum();引发的异常。
								System.out.println();		//如果该行没有数据，就执行换行。
								continue;
							}
						for(int j = 0; j < rowCelllast; j++){ //内循环控制每行的单元格
								Cell cell=row.getCell(j);
								if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK){//判断该行第j个单元格是否为空，是，就输出空格。
									System.out.print("\t");
									continue;
								} 
								
								String str=CheckType(cell);
								if(str==null){
									System.out.print(cell.toString() + "   ");
									continue;
								}
								System.out.print(str + "   ");
							}
						System.out.println();   //每行操作结束后，换行。
				}
				//获取下一张工作表。如果抛IllegalArgumentException异常，就说明没有工作表了，就结束读取。
				try{
					sheet=workbook.getSheetAt(x++);   
				}catch(IllegalArgumentException e){
					 break;
				}
		}
		
	}
	
	/**单元格类型判断
	 * */
	private static String CheckType(Cell cell) {

		if(cell.getCellType() == Cell.CELL_TYPE_STRING){
			  return cell.toString();
		}
	 
    else if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
		  
		  Date date=cell.getDateCellValue();
		  Calendar cal=Calendar.getInstance();
		  cal.setTime(date);
		  
		  SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		  String s=df.format(date);
		  
				  if(cal.get(Calendar.YEAR)<1949){
					  try{
						  int x=Integer.parseInt(cell.toString()); 
						  return x + "";
					  }catch(NumberFormatException e){
						  Double d=cell.getNumericCellValue();
						  return d.toString();
					  }
				  }
	    	return s;
	  }
		
		return null;
	}

}
