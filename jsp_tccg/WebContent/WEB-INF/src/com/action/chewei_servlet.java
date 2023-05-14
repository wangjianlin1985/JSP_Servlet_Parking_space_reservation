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
import com.orm.Tchewei;
import java.util.ArrayList;
import com.dao.DB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class chewei_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("cheweiMana")) {
            this.cheweiMana(req, res);
        }
        if (type.endsWith("cheweiAdd")) {
            this.cheweiAdd(req, res);
        }
        if (type.endsWith("cheweiDel")) {
            this.cheweiDel(req, res);
        }
        if (type.endsWith("cheweiSelect")) {
            this.cheweiSelect(req, res);
        }
        if (type.endsWith("cheweiAll")) {
            this.cheweiAll(req, res);
        }
    }
    
    public void cheweiAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final String bianhao = req.getParameter("bianhao");
        final String quyu = req.getParameter("quyu");
        final String zt = "\u7a7a\u95f2\u4e2d";
        final String del = "no";
        final String sql = "insert into t_chewei(bianhao,quyu,zt,del) values(?,?,?,?)";
        final Object[] params = { bianhao, quyu, zt, del };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("message", (Object)"\u64cd\u4f5c\u6210\u529f");
        req.setAttribute("path", (Object)"chewei?type=cheweiMana");
        final String targetURL = "/common/success.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void cheweiDel(final HttpServletRequest req, final HttpServletResponse res) {
        final String sql = "update t_chewei set del='yes' where id=" + Integer.parseInt(req.getParameter("id"));
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("message", (Object)"\u64cd\u4f5c\u6210\u529f");
        req.setAttribute("path", (Object)"chewei?type=cheweiMana");
        final String targetURL = "/common/success.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void cheweiMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List cheweiList = new ArrayList();
        final String sql = "select * from t_chewei where del='no' order by quyu";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tchewei chewei = new Tchewei();
                chewei.setId(rs.getInt("id"));
                chewei.setBianhao(rs.getString("bianhao"));
                chewei.setQuyu(rs.getString("quyu"));
                chewei.setZt(rs.getString("zt"));
                cheweiList.add(chewei);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("cheweiList", (Object)cheweiList);
        req.getRequestDispatcher("admin/chewei/cheweiMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void cheweiSelect(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List cheweiList = new ArrayList();
        final String sql = "select * from t_chewei where del='no' and zt='\u7a7a\u95f2\u4e2d' order by quyu";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tchewei chewei = new Tchewei();
                chewei.setId(rs.getInt("id"));
                chewei.setBianhao(rs.getString("bianhao"));
                chewei.setQuyu(rs.getString("quyu"));
                chewei.setZt(rs.getString("zt"));
                cheweiList.add(chewei);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("cheweiList", (Object)cheweiList);
        req.getRequestDispatcher("admin/chewei/cheweiSelect.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void cheweiAll(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List cheweiList = new ArrayList();
        final String sql = "select * from t_chewei where del='no' order by quyu";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tchewei chewei = new Tchewei();
                chewei.setId(rs.getInt("id"));
                chewei.setBianhao(rs.getString("bianhao"));
                chewei.setQuyu(rs.getString("quyu"));
                chewei.setZt(rs.getString("zt"));
                cheweiList.add(chewei);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("cheweiList", (Object)cheweiList);
        req.getRequestDispatcher("qiantai/chewei/cheweiRes.jsp").forward((ServletRequest)req, (ServletResponse)res);
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
