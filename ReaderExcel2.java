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
		int x=0;//���ڹ�����Ǳ�
		Sheet sheet = workbook.getSheetAt(x++); //��ȡһ��������
		while(true){
			
			for(int i = sheet.getFirstRowNum(); i <= sheet.getLastRowNum(); i++){ //��ѭ��������
							Row row;
							int rowCellfirst,rowCelllast;
							try{
								row=sheet.getRow(i);
								rowCellfirst=row.getFirstCellNum();
								rowCelllast=row.getLastCellNum();

							}catch(Exception e){ //��׽row.getFirstCellNum();row.getLastCellNum();�������쳣��
								System.out.println();		//�������û�����ݣ���ִ�л��С�
								continue;
							}
						for(int j = 0; j < rowCelllast; j++){ //��ѭ������ÿ�еĵ�Ԫ��
								Cell cell=row.getCell(j);
								if(cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK){//�жϸ��е�j����Ԫ���Ƿ�Ϊ�գ��ǣ�������ո�
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
						System.out.println();   //ÿ�в��������󣬻��С�
				}
				//��ȡ��һ�Ź����������IllegalArgumentException�쳣����˵��û�й������ˣ��ͽ�����ȡ��
				try{
					sheet=workbook.getSheetAt(x++);   
				}catch(IllegalArgumentException e){
					 break;
				}
		}
		
	}
	
	/**��Ԫ�������ж�
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
