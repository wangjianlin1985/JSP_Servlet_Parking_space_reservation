// 
// 
// 

package com.service;

import java.util.Date;
import com.util.Util;
import java.sql.ResultSet;
import javax.servlet.http.HttpSession;
import org.directwebremoting.WebContext;
import com.orm.Tuser;
import java.sql.SQLException;
import com.orm.TAdmin;
import com.dao.DB;
import org.directwebremoting.WebContextFactory;

public class loginService
{
    public String login(final String userName, final String userPw, final int userType) {
        System.out.println(String.valueOf(userType) + "UUU");
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        String result = "no";
        Label_0251: {
            if (userType == 0) {
                final String sql = "select * from t_admin where userName=? and userPw=?";
                final Object[] params = { userName, userPw };
                final DB mydb = new DB();
                mydb.doPstm(sql, params);
                try {
                    final ResultSet rs = mydb.getRs();
                    final boolean mark = rs != null && rs.next();
                    if (!mark) {
                        result = "no";
                    }
                    else {
                        result = "yes";
                        final TAdmin admin = new TAdmin();
                        admin.setUserId(rs.getInt("userId"));
                        admin.setUserName(rs.getString("userName"));
                        admin.setUserPw(rs.getString("userPw"));
                        session.setAttribute("userType", (Object)0);
                        session.setAttribute("admin", (Object)admin);
                    }
                    rs.close();
                }
                catch (SQLException e) {
                    System.out.println("\u767b\u5f55\u5931\u8d25\uff01");
                    e.printStackTrace();
                    break Label_0251;
                }
                finally {
                    mydb.closed();
                }
                mydb.closed();
            }
        }
        if (userType == 1) {
            final String sql = "select * from t_user where loginname=? and loginpw=? and del='no'";
            final Object[] params = { userName, userPw };
            final DB mydb = new DB();
            try {
                mydb.doPstm(sql, params);
                final ResultSet rs = mydb.getRs();
                final boolean mark = rs != null && rs.next();
                if (!mark) {
                    result = "no";
                }
                if (mark) {
                    result = "yes";
                    final Tuser user = new Tuser();
                    user.setId(rs.getString("id"));
                    user.setLoginname(rs.getString("loginname"));
                    user.setLoginpw(rs.getString("loginpw"));
                    user.setXingming(rs.getString("xingming"));
                    user.setZhuzhi(rs.getString("zhuzhi"));
                    user.setDianhua(rs.getString("dianhua"));
                    user.setDengji(rs.getString("dengji"));
                    user.setDel(rs.getString("del"));
                    session.setAttribute("userType", (Object)1);
                    session.setAttribute("user", (Object)user);
                }
                rs.close();
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
            mydb.closed();
        }
        return result;
    }
    
    public String userlogin(final String userName, final String userPw, final int userType) {
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        String result = "no";
        final String sql = "select * from t_user where loginname=? and loginpw=? and del='no'";
        final Object[] params = { userName, userPw };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            final boolean mark = rs != null && rs.next();
            if (!mark) {
                result = "no";
            }
            if (mark) {
                result = "yes";
                final Tuser user = new Tuser();
                user.setId(rs.getString("id"));
                user.setLoginname(rs.getString("loginname"));
                user.setLoginpw(rs.getString("loginpw"));
                user.setXingming(rs.getString("xingming"));
                user.setZhuzhi(rs.getString("zhuzhi"));
                user.setDianhua(rs.getString("dianhua"));
                user.setDengji(rs.getString("dengji"));
                user.setDel(rs.getString("del"));
                session.setAttribute("userType", (Object)1);
                session.setAttribute("user", (Object)user);
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return result;
    }
    
    public String adminPwEdit(final String userPwNew) {
        System.out.println("DDDD");
        try {
            Thread.sleep(700L);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        final WebContext ctx = WebContextFactory.get();
        final HttpSession session = ctx.getSession();
        final TAdmin admin = (TAdmin)session.getAttribute("admin");
        final String sql = "update t_admin set userPw=? where userId=?";
        final Object[] params = { userPwNew, admin.getUserId() };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        return "yes";
    }
    
    public int jisuanfeiyong(final String kaishishijian, final String jieshushijian, final String chexing) throws Exception {
        final String s = "\u5165\u573a\u65f6\u95f4:" + kaishishijian + ",\u51fa\u573a\u65f6\u95f4:" + jieshushijian + ",\u8f66\u578b\uff1a" + chexing;
        System.out.println(s);
        final int danjia = 1;
        int beishu = 1;
        int zong = 0;
        if (chexing.equals("\u5c0f\u578b")) {
            beishu = 1;
        }
        if (chexing.equals("\u4e2d\u578b")) {
            beishu = 2;
        }
        if (chexing.equals("\u5927\u578b")) {
            beishu = 3;
        }
        final Date aa = Util.newDate1(kaishishijian);
        final Date bb = Util.newDate1(jieshushijian);
        final long gg = bb.getTime() - aa.getTime();
        final long fenzhong = gg / 1000L / 60L;
        if (fenzhong < 60L) {
            zong = danjia * 1 * beishu;
        }
        if (fenzhong > 60L && fenzhong < 120L) {
            zong = danjia * 2 * beishu;
        }
        if (fenzhong > 120L && fenzhong < 180L) {
            zong = danjia * 3 * beishu;
        }
        if (fenzhong > 180L && fenzhong < 240L) {
            zong = danjia * 4 * beishu;
        }
        if (fenzhong > 240L && fenzhong < 300L) {
            zong = danjia * 5 * beishu;
        }
        if (fenzhong > 300L && fenzhong < 360L) {
            zong = danjia * 6 * beishu;
        }
        if (fenzhong > 360L && fenzhong < 420L) {
            zong = danjia * 7 * beishu;
        }
        if (fenzhong > 420L && fenzhong < 480L) {
            zong = danjia * 8 * beishu;
        }
        if (fenzhong > 480L && fenzhong < 540L) {
            zong = danjia * 9 * beishu;
        }
        if (fenzhong > 540L && fenzhong < 600L) {
            zong = danjia * 10 * beishu;
        }
        if (fenzhong > 600L) {
            zong = danjia * 10 * beishu;
        }
        return zong;
    }
}
