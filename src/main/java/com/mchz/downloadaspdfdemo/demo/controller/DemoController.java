package com.mchz.downloadaspdfdemo.demo.controller;



import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.mchz.downloadaspdfdemo.demo.Util.PDFTemplateUtil;
import com.mchz.downloadaspdfdemo.demo.entity.TableBase;
import com.mchz.downloadaspdfdemo.demo.entity.XvZhuoQunDemo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/pdf")
public class DemoController {



    @RequestMapping("/export")
    public void exportPdf(HttpServletResponse response) throws Exception{
        ByteArrayOutputStream baos = null;
        OutputStream out = null;
        try {
            // 模板中的数据，实际运用从数据库中查询
            Map<String,Object> data = new HashMap<>();

            XvZhuoQunDemo xvZhuoQunDemo = new XvZhuoQunDemo("徐卓群","女","广岛","霓虹");
//            data.put("curr", 1);
//            data.put("one", 2);
//            data.put("two", 1);
//            data.put("three", 6);

//            List<TableBase> detailList = new ArrayList<>();
//            detailList.add(new TableBase(123456,"测试","测试","测试","测试"));
//            detailList.add(new TableBase(111111,"测试","测试","测试","测试"));
//            detailList.add(new TableBase(222222,"测试","测试","测试","测试"));
//            data.put("detailList", detailList);
            data.put("datebase",xvZhuoQunDemo);


            baos = PDFTemplateUtil.createPDF(data, "xvzhuoqundemo.xml");;
            // 设置响应消息头，告诉浏览器当前响应是一个下载文件
            response.setContentType( "application/x-msdownload");
            // 告诉浏览器，当前响应数据要求用户干预保存到文件中，以及文件名是什么 如果文件名有中文，必须URL编码
            String fileName = URLEncoder.encode("徐卓群不正常简历.pdf", "UTF-8");
            response.setHeader( "Content-Disposition", "attachment;filename=" + fileName);
            out = response.getOutputStream();
            baos.writeTo(out);
            baos.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("导出失败：" + e.getMessage());
        } finally{
            if(baos != null){
                baos.close();
            }
            if(out != null){
                out.close();
            }
        }
    }
}
