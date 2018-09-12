package com.zj.mybatis.poj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.zj.mybatis.pojo.YsDwzqk;
import com.zj.mybatis.pojo.YsJbzcb;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
public class ReadExcel {
    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下C:\Users\zhengj\Desktop
        File file = new File("C:/Users/zhengj/Desktop/abc.xls");
        List excelList = obj.readExcel(file);
        System.out.println("list中的数据打印出来");
        System.out.println(excelList);
        /*for (int i = 0; i < excelList.size(); i++) {
            //List list = (List) excelList.get(i);
            for (int j = 0; j < list.size(); j++) {
                //System.out.print(list.get(j));
            	//System.out.print("--");
            }
            //System.out.println(list.size());
        }*/

    }
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List readExcel(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
            	List<YsDwzqk> innerList=new ArrayList<YsDwzqk>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 1; i < sheet.getRows(); i++) {
                    //List<YsDwzqk> innerList=new ArrayList<YsDwzqk>();
                	YsDwzqk ys = new YsDwzqk();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                    	
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        if(j==1) {
                        	String information = sheet.getCell(j, i).getContents();
                        	//System.out.print(information);
                        	ys.setInformation(information);
                        	//System.out.print(ys);
                        }
                        else if(j==0) {
                        	String dwid = sheet.getCell(j, i).getContents();
                        	//System.out.print(information);
                        	ys.setDwid(Integer.valueOf(dwid));
                        	//System.out.print(ys);
                        }
                        
                        else if(j==2) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setValidation(dwe);
                        }
                        ys.setInputMan("admin");
                    }
                    innerList.add(ys);
                }
                return innerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    public List readExcelSend(File file) {
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
            	List<YsJbzcb> innerList=new ArrayList<YsJbzcb>();
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    //List<YsDwzqk> innerList=new ArrayList<YsDwzqk>();
                	YsJbzcb ys = new YsJbzcb();
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                    	
                        String cellinfo = sheet.getCell(j, i).getContents();
                        if(cellinfo.isEmpty()){
                            continue;
                        }
                        if(j==1) {
                        	String information = sheet.getCell(j, i).getContents();
                        	//System.out.print(information);
                        	ys.setUnit(information);
                        	//System.out.print(ys);
                        }
                        else if(j==0) {
                        	String dwid = sheet.getCell(j, i).getContents();
                        	//System.out.print(information);
                        	ys.setJbid(Integer.valueOf(dwid));
                        	//System.out.print(ys);
                        }
                        
                        else if(j==2) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setUnitType(dwe);
                        }
                        
                        else if(j==3) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setItemType(dwe);
                        }
                        
                        else if(j==4) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setItemName(dwe);
                        }
                        
                        else if(j==5) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setZccnSubcode(dwe);
                        }
                        
                        
                        else if(j==6) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setZcjjSubcode(dwe);
                        }
                        
                        else if(j==7) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setZfJjfl(dwe);
                        }
                        
                        else if(j==8) {
                        	int x = 1;
                        	String dwe = sheet.getCell(j, i).getContents();
                        	if(dwe == "否") {
                        		x = 0;
                        	}
                        	ys.setSfCg(x);
                        }
                        
                        else if(j==9) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setTotalMoney(Float.valueOf(dwe));
                        }
                        
                        else if(j==10) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setYsMoney(Float.valueOf(dwe));
                        }
                        
                        else if(j==11) {
                        	String dwe = sheet.getCell(j, i).getContents();
                        	ys.setOtherMoney(Float.valueOf(dwe));
                        }
    
                        ys.setInputMan("admin");
                    }
                    innerList.add(ys);
                }
                return innerList;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}