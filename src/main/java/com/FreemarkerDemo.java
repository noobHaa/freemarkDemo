package com;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.*;

/**
 * @Author ll
 * @Date 2018/11/22 13:49
 */
public class FreemarkerDemo {
    public static void main(String[] args) throws IOException, TemplateException {
        //获取配置对象
        Configuration configuration = new Configuration(Configuration.getVersion());
        //获取文件路径
        configuration.setDirectoryForTemplateLoading(new File("D:/workForIdea/freemarkDemo/src/main/resources"));
        //设置字符集
        configuration.setDefaultEncoding("utf-8");
        //获取模板
        Template template = configuration.getTemplate("test.ftl");

        Map map = new HashMap();
        map.put("name", "张三");
        map.put("message", "欢迎你");
        map.put("success", true);

        List goodsList = new ArrayList();
        Map goods1 = new HashMap();
        goods1.put("name", "苹果");
        goods1.put("price", 5.8);
        Map goods2 = new HashMap();
        goods2.put("name", "香蕉");
        goods2.put("price", 2.5);
        Map goods3 = new HashMap();
        goods3.put("name", "橘子");
        goods3.put("price", 3.2);
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        map.put("goodsList", goodsList);

        map.put("point",100000);
        map.put("today", new Date());
        //输出流
        Writer writer = new FileWriter(new File("D:\\test.html"));
        //输出到文件
        template.process(map, writer);
        writer.close();
    }
}
