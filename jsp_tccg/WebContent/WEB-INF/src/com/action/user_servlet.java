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
import com.orm.Tuser;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.dao.DB;
import com.service.liuService;
import java.util.Date;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class user_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("userReg")) {
            this.userReg(req, res);
        }
        if (type.endsWith("userEditMe")) {
            this.userEditMe(req, res);
        }
        if (type.endsWith("userLogout")) {
            this.userLogout(req, res);
        }
        if (type.endsWith("userMana")) {
            this.userMana(req, res);
        }
        if (type.endsWith("userDel")) {
            this.userDel(req, res);
        }
        if (type.endsWith("userSelect")) {
            this.userSelect(req, res);
        }
    }
    
    public void userReg(final HttpServletRequest req, final HttpServletResponse res) {
        final String id = String.valueOf(new Date().getTime());
        final String loginname = req.getParameter("loginname");
        final String loginpw = req.getParameter("loginpw");
        final String xingming = req.getParameter("xingming");
        final String zhuzhi = req.getParameter("zhuzhi");
        final String dianhua = req.getParameter("dianhua");
        final String dengji = "\u666e\u901a\u4f1a\u5458";
        final String del = "no";
        final String s = liuService.panduan_zhanghao(loginname);
        if (s.equals("yizhan")) {
            req.setAttribute("message", (Object)"\u8d26\u53f7\u5df2\u88ab\u5360\u7528\uff0c\u8bf7\u8f93\u5165\u5176\u4ed6\u8d26\u53f7");
            req.setAttribute("path", (Object)"qiantai/userreg/userreg.jsp");
            final String targetURL = "/common/success.jsp";
            this.dispatch(targetURL, req, res);
        }
        else {
            final String sql = "insert into t_user values(?,?,?,?,?,?,?,?)";
            final Object[] params = { id, loginname, loginpw, xingming, zhuzhi, dianhua, dengji, del };
            final DB mydb = new DB();
            mydb.doPstm(sql, params);
            mydb.closed();
            req.setAttribute("message", (Object)"\u6ce8\u518c\u6210\u529f\uff0c\u8bf7\u767b\u5f55");
            req.setAttribute("path", (Object)"qiantai/default.jsp");
            final String targetURL2 = "/common/success.jsp";
            this.dispatch(targetURL2, req, res);
        }
    }
    
    public void userEditMe(final HttpServletRequest req, final HttpServletResponse res) {
        final String id = req.getParameter("id");
        final String loginname = req.getParameter("loginname");
        final String loginpw = req.getParameter("loginpw");
        final String xingming = req.getParameter("xingming");
        final String zhuzhi = req.getParameter("zhuzhi");
        final String dianhua = req.getParameter("dianhua");
        final String sql = "update t_user set loginname=?,loginpw=?,xingming=?,zhuzhi=?,dianhua=? where id=?";
        final Object[] params = { loginname, loginpw, xingming, zhuzhi, dianhua, id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u4fee\u6539\u6210\u529f\u91cd\u65b0\u767b\u9646\u540e\u751f\u6548");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void userLogout(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        session.setAttribute("userType", (Object)null);
        session.setAttribute("user", (Object)null);
        req.setAttribute("message", (Object)"\u6210\u529f\u9000\u51fa\u7cfb\u7edf");
        req.setAttribute("path", (Object)"qiantai/default.jsp");
        final String targetURL = "/common/success.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void userMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List userList = new ArrayList();
        final String sql = "select * from t_user where del='no'";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tuser user = new Tuser();
                user.setId(rs.getString("id"));
                user.setLoginname(rs.getString("loginname"));
                user.setLoginpw(rs.getString("loginpw"));
                user.setXingming(rs.getString("xingming"));
                user.setZhuzhi(rs.getString("zhuzhi"));
                user.setDianhua(rs.getString("dianhua"));
                user.setDengji(rs.getString("dengji"));
                user.setDel(rs.getString("del"));
                userList.add(user);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("userList", (Object)userList);
        req.getRequestDispatcher("admin/user/userMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void userDel(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String sql = "update t_user set del='yes' where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u7528\u6237\u4fe1\u606f\u5220\u9664\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void userSelect(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List userList = new ArrayList();
        final String sql = "select * from t_user where del='no'";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tuser user = new Tuser();
                user.setId(rs.getString("id"));
                user.setLoginname(rs.getString("loginname"));
                user.setLoginpw(rs.getString("loginpw"));
                user.setXingming(rs.getString("xingming"));
                user.setZhuzhi(rs.getString("zhuzhi"));
                user.setDianhua(rs.getString("dianhua"));
                user.setDengji(rs.getString("dengji"));
                user.setDel(rs.getString("del"));
                userList.add(user);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("userList", (Object)userList);
        req.getRequestDispatcher("admin/yuejuan/userSelect.jsp").forward((ServletRequest)req, (ServletResponse)res);
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
