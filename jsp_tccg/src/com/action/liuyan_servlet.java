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
import com.orm.TLiuyan;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.dao.DB;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.orm.Tuser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class liuyan_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("liuyanAdd")) {
            this.liuyanAdd(req, res);
        }
        if (type.endsWith("liuyanMana")) {
            this.liuyanMana(req, res);
        }
        if (type.endsWith("liuyanDel")) {
            this.liuyanDel(req, res);
        }
        if (type.endsWith("liuyanHuifu")) {
            this.liuyanHuifu(req, res);
        }
        if (type.endsWith("liuyanAll")) {
            this.liuyanAll(req, res);
        }
        if (type.endsWith("liuyanDetail")) {
            this.liuyanDetail(req, res);
        }
    }
    
    public void liuyanAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final HttpSession session = req.getSession();
        final Tuser user = (Tuser)session.getAttribute("user");
        final String neirong = req.getParameter("neirong");
        final String liuyanshi = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        final String user_id = user.getId();
        final String huifu = "";
        final String huifushi = "";
        final String sql = "insert into t_liuyan(neirong,liuyanshi,user_id,huifu,huifushi) values(?,?,?,?,?)";
        final Object[] params = { neirong, liuyanshi, user_id, huifu, huifushi };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u7559\u8a00\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void liuyanMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List liuyanList = new ArrayList();
        final String sql = "select * from t_liuyan order by liuyanshi";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final TLiuyan liuyan = new TLiuyan();
                liuyan.setId(rs.getInt("id"));
                liuyan.setNeirong(rs.getString("neirong"));
                liuyan.setLiuyanshi(rs.getString("liuyanshi"));
                liuyan.setUser_id(rs.getString("user_id"));
                liuyan.setHuifu(rs.getString("huifu"));
                liuyan.setHuifushi(rs.getString("huifushi"));
                liuyanList.add(liuyan);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("liuyanList", (Object)liuyanList);
        req.getRequestDispatcher("admin/liuyan/liuyanMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void liuyanDel(final HttpServletRequest req, final HttpServletResponse res) {
        final String sql = "delete from t_liuyan where id=" + Integer.parseInt(req.getParameter("id"));
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u7559\u8a00\u4fe1\u606f\u5220\u9664\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void liuyanHuifu(final HttpServletRequest req, final HttpServletResponse res) {
        final String huifu = req.getParameter("huifu");
        final String huifushi = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        final int id = Integer.parseInt(req.getParameter("id"));
        final String sql = "update t_liuyan set huifu=?,huifushi=? where id=?";
        final Object[] params = { huifu, huifushi, id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u56de\u590d\u5b8c\u6bd5\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void liuyanAll(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List liuyanList = new ArrayList();
        final String sql = "select * from t_liuyan order by liuyanshi";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final TLiuyan liuyan = new TLiuyan();
                liuyan.setId(rs.getInt("id"));
                liuyan.setNeirong(rs.getString("neirong"));
                liuyan.setLiuyanshi(rs.getString("liuyanshi"));
                liuyan.setUser_id(rs.getString("user_id"));
                liuyan.setHuifu(rs.getString("huifu"));
                liuyan.setHuifushi(rs.getString("huifushi"));
                liuyanList.add(liuyan);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("liuyanList", (Object)liuyanList);
        req.getRequestDispatcher("qiantai/liuyan/liuyanAll.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void liuyanDetail(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("liuyan", (Object)this.get_liuyan(id));
        req.getRequestDispatcher("qiantai/liuyan/liuyanDetail.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public TLiuyan get_liuyan(final int id) {
        final TLiuyan liuyan = new TLiuyan();
        final String sql = "select * from t_liuyan where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                liuyan.setId(rs.getInt("id"));
                liuyan.setNeirong(rs.getString("neirong"));
                liuyan.setLiuyanshi(rs.getString("liuyanshi"));
                liuyan.setUser_id(rs.getString("user_id"));
                liuyan.setHuifu(rs.getString("huifu"));
                liuyan.setHuifushi(rs.getString("huifushi"));
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return liuyan;
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
