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
import com.orm.Tting;
import java.util.ArrayList;
import com.service.liuService;
import com.dao.DB;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;

public class ting_servlet extends HttpServlet
{
    public void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String type = req.getParameter("type");
        if (type.endsWith("tingAdd")) {
            this.tingAdd(req, res);
        }
        if (type.endsWith("tingMana")) {
            this.tingMana(req, res);
        }
        if (type.endsWith("tingDel")) {
            this.tingDel(req, res);
        }
        if (type.endsWith("jiesuanPre")) {
            this.jiesuanPre(req, res);
        }
        if (type.endsWith("feiyongAdd")) {
            this.feiyongAdd(req, res);
        }
        if (type.endsWith("tingRes")) {
            this.tingRes(req, res);
        }
    }
    
    public void tingAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final int id = 0;
        final int chewei_id = Integer.parseInt(req.getParameter("chewei_id"));
        final String chexing = req.getParameter("chexing");
        final String chepai = req.getParameter("chepai");
        final String kaishishijian = req.getParameter("kaishishijian");
        final String jieshushijian = "";
        final int feiyong = 0;
        final String sql = "insert into t_ting(chewei_id,chexing,chepai,kaishishijian,jieshushijian,feiyong) values(?,?,?,?,?,?)";
        final Object[] params = { chewei_id, chexing, chepai, kaishishijian, jieshushijian, feiyong };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        liuService.update_chewei_zt(chewei_id, "\u5df2\u5360\u7528");
        req.setAttribute("msg", (Object)"\u505c\u8f66\u4fe1\u606f\u6dfb\u52a0\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void tingMana(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final List tingList = new ArrayList();
        final String sql = "select * from t_ting order by id desc";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tting ting = new Tting();
                ting.setId(rs.getInt("id"));
                ting.setChewei_id(rs.getInt("chewei_id"));
                ting.setChexing(rs.getString("chexing"));
                ting.setChepai(rs.getString("chepai"));
                ting.setKaishishijian(rs.getString("kaishishijian"));
                ting.setJieshushijian(rs.getString("jieshushijian"));
                ting.setFeiyong(rs.getInt("feiyong"));
                ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
                tingList.add(ting);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("tingList", (Object)tingList);
        req.getRequestDispatcher("admin/ting/tingMana.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void tingDel(final HttpServletRequest req, final HttpServletResponse res) {
        final int chewei_id = Integer.parseInt(req.getParameter("chewei_id"));
        final int id = Integer.parseInt(req.getParameter("id"));
        final String sql = "delete from t_ting where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        liuService.update_chewei_zt(chewei_id, "\u7a7a\u95f2\u4e2d");
        req.setAttribute("msg", (Object)"\u4fe1\u606f\u5220\u9664\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void jiesuanPre(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final Tting ting = new Tting();
        final String sql = "select * from t_ting where id=?";
        final Object[] params = { Integer.parseInt(req.getParameter("id")) };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                ting.setId(rs.getInt("id"));
                ting.setChewei_id(rs.getInt("chewei_id"));
                ting.setChexing(rs.getString("chexing"));
                ting.setChepai(rs.getString("chepai"));
                ting.setKaishishijian(rs.getString("kaishishijian"));
                ting.setJieshushijian(rs.getString("jieshushijian"));
                ting.setFeiyong(rs.getInt("feiyong"));
                ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("ting", (Object)ting);
        req.getRequestDispatcher("admin/ting/jiesuanPre.jsp").forward((ServletRequest)req, (ServletResponse)res);
    }
    
    public void feiyongAdd(final HttpServletRequest req, final HttpServletResponse res) {
        final int chewei_id = Integer.parseInt(req.getParameter("chewei_id"));
        final int id = Integer.parseInt(req.getParameter("id"));
        final String jieshushijian = req.getParameter("jieshushijian");
        final int feiyong = Integer.parseInt(req.getParameter("feiyong"));
        final String sql = "update t_ting set jieshushijian=?,feiyong=? where id=?";
        final Object[] params = { jieshushijian, feiyong, id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
        liuService.update_chewei_zt(chewei_id, "\u7a7a\u95f2\u4e2d");
        req.setAttribute("msg", (Object)"\u8d39\u7528\u7ed3\u7b97\u5b8c\u6bd5");
        final String targetURL = "/common/msg.jsp";
        this.dispatch(targetURL, req, res);
    }
    
    public void tingRes(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String chexing = req.getParameter("chexing");
        final String chepai = req.getParameter("chepai");
        final List tingList = new ArrayList();
        final String sql = "select * from t_ting where jieshushijian !='' and chexing like '%" + chexing + "%'" + " and chepai like '%" + chepai.trim() + "%'";
        final Object[] params = new Object[0];
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                final Tting ting = new Tting();
                ting.setId(rs.getInt("id"));
                ting.setChewei_id(rs.getInt("chewei_id"));
                ting.setChexing(rs.getString("chexing"));
                ting.setChepai(rs.getString("chepai"));
                ting.setKaishishijian(rs.getString("kaishishijian"));
                ting.setJieshushijian(rs.getString("jieshushijian"));
                ting.setFeiyong(rs.getInt("feiyong"));
                ting.setChewei(liuService.get_chewei(rs.getInt("chewei_id")));
                tingList.add(ting);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        req.setAttribute("tingList", (Object)tingList);
        req.getRequestDispatcher("admin/ting/tingRes.jsp").forward((ServletRequest)req, (ServletResponse)res);
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
