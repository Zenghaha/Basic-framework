package com.ud.basic.system.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.util.CollectionUtils;

import com.google.gson.annotations.SerializedName;
import com.ud.basic.common.core.exception.CommonBizException;


public class ExcelUtil {
	
	/**
	 * 返回一个byte[]交给action;
	 * @param wb
	 * @return
	 */
	public static byte[] getExcelBytes(Workbook wb){
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] bytes = null;
		
		try {
			wb.write(baos);
			bytes = baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if (baos!=null) {
				try {
					baos.close();
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		}
		return bytes;
	}
	/**
	 * 
	 * @param list 传进来的list集合
	 * @param arg  sheet的名称;
	 * @return
	 * @throws Exception
	 */
	public static <T> Workbook getWb(List<T> list,String arg) throws Exception{
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet(arg);
		//设置默认行高和列宽
		Row row = sheet.createRow(0);
		if(list.size()>0){
			Map<String,List<String>> objMap = getAttributes(list.get(0));
			List<String> annoList = objMap.get("anno");
			//设置表头
			for (int i = 0; i < annoList.size(); i++) {
				row.createCell(i).setCellValue(annoList.get(i));
			}
			//设置的表格样式;
			//后边在设置别的样式; 5-19	
			CellStyle cellStyle = workbook.createCellStyle();
			cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
			
			//传入的对象;
			for (int i = 1; i <= list.size(); i++) {
				//创建一row
				Row rowCurr = sheet.createRow(i);
				rowCurr.setHeightInPoints(16);
				Map<String,List<String>> tempMap = getAttributes(list.get(i-1));
				//然后在这个row中set进去值
				List<String> valueList = tempMap.get("value");
				//遍历valueList先,获取一个包含了每一个column 的最大宽度的list 集合.
				for(int j = 0 ;  j <  valueList.size(); j++){
					Cell cell = rowCurr.createCell(j);
					//然后获取这个cell的宽度,以下这段代码是为了适应性宽度;
					Integer cellPreWidth =sheet.getColumnWidth(j)<4*512?5*512:sheet.getColumnWidth(j);
					
					Integer cellWidth= isChineseWords(valueList.get(j))?(valueList.get(j).length()+1)*512:(valueList.get(j).length()+1)*256;
					sheet.setColumnWidth(j, cellWidth>cellPreWidth?cellWidth:cellPreWidth);
					cell.setCellStyle(cellStyle);
					cell.setCellValue(valueList.get(j));
	   			}
			}
		}
		return workbook;
	}
	
	/**
	 * 读取传入的obj对象所带的属性值,属性名称,声明类型,注解名称; 
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public static Map<String,List<String>> getAttributes(Object obj) throws Exception {
		//首先获取所有注解;
		Map<String, List<String>> classMap = new HashMap<String, List<String>>();
		List<String> valueStr = new ArrayList<String>();//此属性的值
		List<String> attrStr = new ArrayList<String>();//带有注解的属性的名称;
		List<String> typeStr = new ArrayList<String>();//带有注解属性的类型;
		List<String> annStr = new ArrayList<String>();//带有注解属性的类型;
		//首先通过这个对象获得class;
		Class userCla = (Class) obj.getClass();
		//然后获得这个class属性的集合;
		Field[] fs = userCla.getDeclaredFields();  
	       for(int i = 0 ; i < fs.length; i++){  
	    	   //属性
	           Field f = fs[i];  
	           f.setAccessible(true);
	           //这个是获取属性上注解的值
	           SerializedName bbb = f.getAnnotation(SerializedName.class);
			   	           if(bbb!=null){
			   //把注解内容放进去,属性名称放进去,类型名称放进去,属性值放进去;
			   annStr.add(bbb.toString());
			   attrStr.add(f.getName());
			   typeStr.add(f.getGenericType().toString());
			   valueStr.add((f.get(obj)==null?"":f.get(obj).toString()));
	           }
	       	}  
	    classMap.put("attr",attrStr);
	    classMap.put("value",valueStr);
	    classMap.put("type",typeStr);
	    classMap.put("anno",annStr);
	    return classMap;
	}
	
	/**
	 * 判断是否包含中文字符
	 * @param str
	 * @return
	 */
	public static boolean isChineseWords(String str){
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		return m.find();
	}
	
	public static <T> boolean export(List<T>data, HttpServletResponse response) throws Exception{
		boolean flag = true;
		if(CollectionUtils.isEmpty(data)) {
			flag = false;
			return flag;
		}
		byte[] excel = ExcelUtil.getExcelBytes(ExcelUtil.getWb(data, "数据列表"));
		String excelName = "attachment;filename=Data.xls";
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.addHeader("Content-Disposition", excelName);
		response.getOutputStream().write(excel);
		return flag;
	}
	
}