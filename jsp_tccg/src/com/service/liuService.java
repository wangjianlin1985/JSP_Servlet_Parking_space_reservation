// 
// 
// 

package com.service;

import com.orm.TZhengce;
import java.util.ArrayList;
import java.util.List;
import com.orm.Tuser;
import java.sql.ResultSet;
import com.orm.Tchewei;
import com.dao.DB;

public class liuService
{
    public static void update_chewei_zt(final int id, final String zt) {
        final String sql = "update t_chewei set zt=? where id=?";
        final Object[] params = { zt, id };
        final DB mydb = new DB();
        mydb.doPstm(sql, params);
        mydb.closed();
    }
    
    public static Tchewei get_chewei(final int id) {
        final Tchewei chewei = new Tchewei();
        final String sql = "select * from t_chewei where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                chewei.setId(rs.getInt("id"));
                chewei.setBianhao(rs.getString("bianhao"));
                chewei.setQuyu(rs.getString("quyu"));
                chewei.setZt(rs.getString("zt"));
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return chewei;
    }
    
    public static Tuser get_user(final String id) {
        final Tuser user = new Tuser();
        final String sql = "select * from t_user where id=?";
        final Object[] params = { id };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                user.setId(rs.getString("id"));
                user.setLoginname(rs.getString("loginname"));
                user.setLoginpw(rs.getString("loginpw"));
                user.setXingming(rs.getString("xingming"));
                user.setZhuzhi(rs.getString("zhuzhi"));
                user.setDianhua(rs.getString("dianhua"));
                user.setDengji(rs.getString("dengji"));
                user.setDel(rs.getString("del"));
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return user;
    }
    
    public static List zhengceList() {
        final List zhengceList = new ArrayList();
        final String sql = "select * from t_zhengce order by id desc";
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
        return zhengceList;
    }
    
    public static String panduan_zhanghao(final String loginname) {
        String s = "meizhan";
        final String sql = "select * from t_user where del='no' and loginname=?";
        final Object[] params = { loginname.trim() };
        final DB mydb = new DB();
        try {
            mydb.doPstm(sql, params);
            final ResultSet rs = mydb.getRs();
            while (rs.next()) {
                s = "yizhan";
            }
            rs.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        mydb.closed();
        return s;
    }
    
    public static List cheweiList() {
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
        return cheweiList;
    }
}
