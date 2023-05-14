// 
// 
// 

package com.action;

import javax.servlet.ServletConfig;
import javax.servlet.RequestDispatcher;
import java.sql.ResultSet;
import java.util.List;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import com.orm.TZhengce;
import java.util.ArrayList;
import com.dao.DB;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class zhengce_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("zhengceAdd")) {
            this.zhengceAdd(req, res);
        }
        if (type.endsWith("zhengceMana")) {
            this.zhengceMana(req, res);
        }
        if (type.endsWith("zhengceDel")) {
            this.zhengceDel(req, res);
        }
        if (type.endsWith("zhengceDetailHou")) {
            this.zhengceDetailHou(req, res);
        }
        if (type.endsWith("zhengceAll")) {
            this.zhengceAll(req, res);
        }
        if (type.endsWith("zhengceDetailQian")) {
            this.zhengceDetailQian(req, res);
        }
    }
    
    public void zhengceAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final String id = String.valueOf(new Date().getTime());
        final String biaoti = req.getParameter("biaoti");
        final String neirong = req.getParameter("neirong");
        String fujian = req.getParameter("fujian");
        if (fujian.equals("")) {
            fujian = "/images/zanwu.jpg";
        }
        final String shijian = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        final String sql = "insert into t_zhengce values(?,?,?,?,?)";
        final Object[] params = { id, biaoti, neirong, fujian, shijian };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u64cd\u4f5c\u6210\u529f");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void zhengceMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List zhengceList = new ArrayList();
        final String sql = "select * from t_zhengce";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final TZhengce zhengce = new TZhengce();
                zhengce.setId(rs.getString("id"));
                zhengce.setBiaoti(rs.getString("biaoti"));
                zhengce.setNeirong(rs.getString("neirong"));
                zhengce.setFujian(rs.getString("fujian"));
                zhengce.setShijian(rs.getString("shijian"));
                zhengceList.add(zhengce);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("zhengceList", (Object)zhengceList);
        req.getRequestDispatcher("admin/zhengce/zhengceMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void zhengceDel(final HttpServletRequest req, final HttpServletResponse res) {
        final String id = req.getParameter("id");
        final String sql = "delete from t_zhengce where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u64cd\u4f5c\u6210\u529f");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void zhengceDetailHou(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final TZhengce zhengce = new TZhengce();
        final String sql = "select * from t_zhengce where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            rs.next();
            zhengce.setId(rs.getString("id"));
            zhengce.setBiaoti(rs.getString("biaoti"));
            zhengce.setNeirong(rs.getString("neirong"));
            zhengce.setFujian(rs.getString("fujian"));
            zhengce.setShijian(rs.getString("shijian"));
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("zhengce", (Object)zhengce);
        req.getRequestDispatcher("admin/zhengce/zhengceDetailHou.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void zhengceAll(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List zhengceList = new ArrayList();
        final String sql = "select * from t_zhengce";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final TZhengce zhengce = new TZhengce();
                zhengce.setId(rs.getString("id"));
                zhengce.setBiaoti(rs.getString("biaoti"));
                zhengce.setNeirong(rs.getString("neirong"));
                zhengce.setFujian(rs.getString("fujian"));
                zhengce.setShijian(rs.getString("shijian"));
                zhengceList.add(zhengce);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("zhengceList", (Object)zhengceList);
        req.getRequestDispatcher("qiantai/zhengce/zhengceAll.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void zhengceDetailQian(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final TZhengce zhengce = new TZhengce();
        final String sql = "select * from t_zhengce where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            rs.next();
            zhengce.setId(rs.getString("id"));
            zhengce.setBiaoti(rs.getString("biaoti"));
            zhengce.setNeirong(rs.getString("neirong"));
            zhengce.setFujian(rs.getString("fujian"));
            zhengce.setShijian(rs.getString("shijian"));
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("zhengce", (Object)zhengce);
        req.getRequestDispatcher("/qiantai/zhengce/zhengceDetailQian.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void dispatch(final String targetURI, final HttpServletRequest request, final HttpServletResponse response) {
        final RequestDispatcher dispatch = this.getServletContext().getRequestDispatcher(targetURI);
        try {
            dispatch.forward((ServletRequest)request, (ServletResponse)response);
        }
        catch (ServletException e) {
            e.printStackTrace();
        }
        catch (IOException e2) {
            e2.printStackTrace();
        }
    }
    
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
    }
    
    public void destroy() {
    }
}
