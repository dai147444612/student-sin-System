package com.inet.drh;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import com.inet.drh.entity.po.Check;
import com.inet.drh.entity.po.User;
import com.inet.drh.service.ICheckService;
import com.inet.drh.service.IUserService;
import com.inet.drh.util.POIUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;
import java.io.*;
import java.util.Iterator;
import java.util.List;

public class test1 {
    @Resource
    private ICheckService iCheckService;

    /**
     * 导出Excel
     *
     * @throws Exception
     * @author HCY
     * @since 2020-10-14
     */
    @Test
    void contextLoads1() throws Exception {
        File file = new File("C:\\Users\\PC\\Desktop\\123.xls");

        ImportParams params = new ImportParams();
        //设置标题
        params.setTitleRows(1);
        //设置说明
        params.setHeadRows(1);
        //导入获取集合
        List<User> users = ExcelImportUtil.importExcel(file, User.class, params);
        //遍历集合
        users.forEach(System.out::println);
        //进行批量添加
        boolean batch = iCheckService.saveBatch(users);
        //输出结果
        System.out.println(batch);
    }

    /**
     * 导入Excel
     *
     * @author HCY
     * @since 2020-10-14
     */
    @Test
    void contextLoads2() throws Exception {
        //查询全部
        List<Check> list = iCheckService.list();
        //设置Excel的描述文件
        ExportParams exportParams = new ExportParams("用户列表的所有数据", "Sheet1", ExcelType.XSSF);
        //进行导出的基本操作
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, User.class, list);
        //输入输出流地址
        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\PC\\Desktop\\123.xls");
        //进行输出流
        workbook.write(fileOutputStream);
        //关流
        fileOutputStream.close();
        workbook.close();
    }

}
