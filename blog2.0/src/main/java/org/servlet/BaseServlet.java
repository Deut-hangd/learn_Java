package org.servlet;

import org.model.Article;
import org.model.Result;
import org.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("appliction/json; charset=UTF-8");
        Result result = new Result();
        PrintWriter pw = resp.getWriter();
        try {
            result.setSuccess(true);
            result.setCode("200xx");
            result.setMessage("Ok");
            result.setData(process(req));

        }catch(Exception e){
            result.setCode("500xx");  //500xx 自定义的错误码
            result.setMessage("服务器出错了!");
            e.printStackTrace();
        }
        pw.println(JSONUtil.serialize(result));
        pw.flush();

    }

    public abstract Object process(HttpServletRequest req) throws Exception;
}
