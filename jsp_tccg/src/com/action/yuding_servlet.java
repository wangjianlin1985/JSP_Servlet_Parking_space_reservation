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
import com.service.liuService;
import com.orm.Tyuding;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import com.dao.DB;
import java.util.Date;
import com.orm.Tuser;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class yuding_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("yudingAdd")) {
            this.yudingAdd(req, res);
        }
        if (type.endsWith("yudingMine")) {
            this.yudingMine(req, res);
        }
        if (type.endsWith("yudingDel")) {
            this.yudingDel(req, res);
        }
        if (type.endsWith("yudingMana")) {
            this.yudingMana(req, res);
        }
        if (type.endsWith("yudingShouli")) {
            this.yudingShouli(req, res);
        }
    }
    
    public void yudingAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final HttpSession session = req.getSession();
        final Tuser user = (Tuser)session.getAttribute("user");
        final String id = String.valueOf(new Date().getTime());
        final String xingming = req.getParameter("xingming");
        final String dianhua = req.getParameter("dianhua");
        final String daodashi = req.getParameter("daodashi");
        final int chewei_id = Integer.parseInt(req.getParameter("chewei_id"));
        final String user_id = user.getId();
        final String zt = "\u5f85\u53d7\u7406";
        final String sql = "insert into t_yuding values(?,?,?,?,?,?,?)";
        final Object[] params = { id, xingming, dianhua, daodashi, chewei_id, user_id, zt };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u9884\u8ba2\u6210\u529f");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void yudingMine(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final HttpSession session = req.getSession();
        final Tuser user = (Tuser)session.getAttribute("user");
        final List yudingList = new ArrayList();
        final String sql = "select * from t_yuding where user_id=?";
        final Object[] params = { user.getId() };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tyuding yuding = new Tyuding();
                yuding.setId(rs.getString("id"));
                yuding.setXingming(rs.getString("xingming"));
                yuding.setDianhua(rs.getString("dianhua"));
                yuding.setDaodashi(rs.getString("daodashi"));
                yuding.setChewei_id(rs.getInt("chewei_id"));
                yuding.setUser_id(rs.getString("user_id"));
                yuding.setZt(rs.getString("zt"));
                yuding.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
                yudingList.add(yuding);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("yudingList", (Object)yudingList);
        req.getRequestDispatcher("admin/yuding/yudingMine.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void yudingDel(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String sql = "delete from t_yuding where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u4fe1\u606f\u5220\u9664\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void yudingMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List yudingList = new ArrayList();
        final String sql = "select * from t_yuding order by zt desc";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tyuding yuding = new Tyuding();
                yuding.setId(rs.getString("id"));
                yuding.setXingming(rs.getString("xingming"));
                yuding.setDianhua(rs.getString("dianhua"));
                yuding.setDaodashi(rs.getString("daodashi"));
                yuding.setChewei_id(rs.getInt("chewei_id"));
                yuding.setUser_id(rs.getString("user_id"));
                yuding.setZt(rs.getString("zt"));
                yuding.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
                yudingList.add(yuding);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("yudingList", (Object)yudingList);
        req.getRequestDispatcher("admin/yuding/yudingMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void yudingShouli(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String id = req.getParameter("id");
        final String sql = "update t_yuding set zt='\u5df2\u53d7\u7406' where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        req.setAttribute("msg", (Object)"\u53d7\u7406\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
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
