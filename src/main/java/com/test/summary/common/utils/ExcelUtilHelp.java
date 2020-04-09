package com.test.summary.common.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dukaixiang
 * @date 2019/7/4.
 * @Version 1.0
 */
public class ExcelUtilHelp {

    @SuppressWarnings("static-access")
    private static String getValue(XSSFCell xssfRow) {
        if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
            return String.valueOf(xssfRow.getBooleanCellValue());
        } else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
            return String.valueOf(xssfRow.getNumericCellValue());
        } else {
            return String.valueOf(xssfRow.getStringCellValue());
        }
    }

    @SuppressWarnings("static-access")
    private static String getValue(HSSFCell hssfCell) {
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }

    /**
     * 所有版本都可以读取
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static List<Map> readXlsxByStream(InputStream is) throws IOException {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        Map map = null;
        List<Map> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            List<String> stringList = null;
            if (numSheet == 0) {
                XSSFRow xssfRow0 = xssfSheet.getRow(0);
                stringList = new ArrayList<>();
                for (int i = 1; i <= xssfRow0.getLastCellNum(); i++) {
                    XSSFCell paramName = xssfRow0.getCell(i - 1);
                    stringList.add(getValue(paramName));
                }
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    map = new HashMap<>();
                    int i = 0;
                    for (String param : stringList) {
                        map.put(param, getValue(xssfRow.getCell(i)));
                        i = i + 1;
                    }
                    list.add(map);
                }
            }
        }
        return list;
    }

    /**
     * HSSFWorkbook只能处理扩展名为.xls的文件，也就是excel2007以前的文件。
     * 可以将.xlsx文件另存为.xls文件再进行处理（不是直接改扩展名）
     * 改扩展名会报错
     *
     * @param is
     * @return
     * @throws IOException
     */
    public static List<Map> readXlsByStream(InputStream is) throws IOException {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Map map = null;
        List<Map> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            List<String> stringList = null;
            if (numSheet == 0) {
                HSSFRow hssfRow = hssfSheet.getRow(0);
                stringList = new ArrayList<>();
                for (int i = 1; i <= hssfRow.getLastCellNum(); i++) {
                    HSSFCell paramName = hssfRow.getCell(i - 1);
                    stringList.add(getValue(paramName));
                }
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    map = new HashMap<>();
                    int i = 0;
                    for (String param : stringList) {
                        map.put(param, getValue(hssfRow.getCell(i)));
                        i = i + 1;
                    }
                    list.add(map);
                }
            }
        }
        return list;
    }

    /**
     * 所有版本都可以读取
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Map> readXlsx(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
        Map map = null;
        List<Map> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
            if (xssfSheet == null) {
                continue;
            }
            List<String> stringList = null;
            if (numSheet == 0) {
                XSSFRow xssfRow0 = xssfSheet.getRow(0);
                stringList = new ArrayList<>();
                for (int i = 1; i <= xssfRow0.getLastCellNum(); i++) {
                    XSSFCell paramName = xssfRow0.getCell(i - 1);
                    stringList.add(getValue(paramName));
                }
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                if (xssfRow != null) {
                    map = new HashMap<>();
                    int i = 0;
                    for (String param : stringList) {
                        map.put(param, getValue(xssfRow.getCell(i)));
                        i = i + 1;
                    }
                    list.add(map);
                }
            }
        }
        return list;
    }

    /**
     * HSSFWorkbook只能处理扩展名为.xls的文件，也就是excel2007以前的文件。
     * 可以将.xlsx文件另存为.xls文件再进行处理（不是直接改扩展名）
     * 改扩展名会报错
     *
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Map> readXls(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        Map map = null;
        List<Map> list = new ArrayList<>();
        // Read the Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            List<String> stringList = null;
            if (numSheet == 0) {
                HSSFRow hssfRow = hssfSheet.getRow(0);
                stringList = new ArrayList<>();
                for (int i = 1; i <= hssfRow.getLastCellNum(); i++) {
                    HSSFCell paramName = hssfRow.getCell(i - 1);
                    stringList.add(getValue(paramName));
                }
            }
            // Read the Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {
                    map = new HashMap<>();
                    int i = 0;
                    for (String param : stringList) {
                        map.put(param, getValue(hssfRow.getCell(i)));
                        i = i + 1;
                    }
                    list.add(map);
                }
            }
        }
        return list;
    }

    /**
     * read the Excel file
     *
     * @param path the path of the Excel file
     * @return
     * @throws IOException
     */
    public static List<Map> readExcel(String path) throws IOException {
        if (StringUtils.isEmpty(path)) {
            return null;
        } else {
            String postfix = path.substring(path.lastIndexOf(".") + 1);
            if (!StringUtils.isEmpty(postfix)) {
                if ("xls".equalsIgnoreCase(postfix)) {
                    return readXls(path);
                } else if ("xlsx".equalsIgnoreCase(postfix)) {
                    return readXlsx(path);
                } else {
                    System.out.println(path + ",不是Excel文件");
                }
            } else {
                System.out.println(path + ",不是Excel文件");
            }
        }
        return null;
    }

    public static void inputStreamToFile(InputStream ins, File file) {
        try {
            OutputStream os = new FileOutputStream(file);
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
//        MultipartFile转换为FileInputStream流
//        MultipartFile invoiceContentFile = null;
//        InputStream ins = invoiceContentFile.getInputStream();
//        File toFile = new File(invoiceContentFile.getOriginalFilename());
//        ExcelUtilHelp.inputStreamToFile(ins, toFile);
//        ins.close();
//        List<Map> record = ExcelUtilHelp.readXlsxByStream(new FileInputStream(toFile));

        List<Map> mapList = readExcel("D://1.订单导入(2).XLS");
//        List<Map> mapList = readXls("D://1.订单导入(2).xls");
//        List<Map> mapList = readXlsx("D://1.订单导入(2).xls");
        for (Map map : mapList) {
            System.out.println(map.toString());
        }
    }
}
