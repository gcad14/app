package com.app.service.impl;

import com.app.model.User;
import com.app.service.ExportService;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExportServiceImpl implements ExportService {
    @Override
    public void word(HttpServletResponse response) throws IOException, XDocReportException {

        //获取Word模板，模板存放路径在项目的resources目录下
        InputStream ins = this.getClass().getResourceAsStream("/模板.docx");
        //注册xdocreport实例并加载FreeMarker模板引擎
        IXDocReport report = XDocReportRegistry.getRegistry().loadReport(ins,
                TemplateEngineKind.Freemarker);
        //创建xdocreport上下文对象
        IContext context = report.createContext();

        //创建要替换的文本变量
        context.put("cnt", "5");
        context.put("nan_cnt", "3");
        context.put("nv_cnt", "2");
        context.put("time", LocalDateTime.now());

        List<User> userList = new ArrayList<>();
        userList.add(new User(2, "张三", "李四", "111111", LocalDateTime.now().toString()));
        userList.add(new User(2, "李四", "大师傅", "111111", LocalDateTime.now().toString()));
        userList.add(new User(2, "王五", "防风固沙", "111111", LocalDateTime.now().toString()));
        context.put("users", userList);

        //创建字段元数据
        FieldsMetadata fm = report.createFieldsMetadata();
        //Word模板中的表格数据对应的集合类型
        fm.load("users", User.class, true);

        //输出到本地目录
/*        FileOutputStream out = new FileOutputStream(new File("D:\\workspace\\testSpringBootMavenexport\\src\\main\\resources\\生成.docx"));
        report.process(context, out);*/

        //浏览器端下载
        response.setCharacterEncoding("utf-8");
        response.setContentType("applica.tion/msword");
        String fileName = "生成.docx";
        response.setHeader("Content-Disposition", "attachment;filename="
                .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
        report.process(context, response.getOutputStream());
    }
}
