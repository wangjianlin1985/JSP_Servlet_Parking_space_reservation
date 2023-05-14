// 
// 
// 

package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class DB
{
    private Connection con;
    private PreparedStatement pstm;
    private String user;
    private String password;
    private String className;
    private String url;
    
    public DB() {
        this.user = "root";
        this.password = "123456";
        this.className = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://127.0.0.1/jsp_tccg?useUnicode=true&amp;characterEncoding=utf-8";
        try {
            Class.forName(this.className);
        }
        catch (ClassNotFoundException e) {
            System.out.println("\u52a0\u8f7d\u6570\u636e\u5e93\u9a71\u52a8\u5931\u8d25\uff01");
            e.printStackTrace();
        }
    }
    
    public Connection getCon() {
        try {
            this.con = DriverManager.getConnection(this.url, this.user, this.password);
        }
        catch (SQLException e) {
            System.out.println("\u521b\u5efa\u6570\u636e\u5e93\u8fde\u63a5\u5931\u8d25\uff01");
            this.con = null;
            e.printStackTrace();
        }
        return this.con;
    }
    
    public void doPstm(final String sql, Object[] params) {
        if (sql != null && !sql.equals("")) {
            if (params == null) {
                params = new Object[0];
            }
            this.getCon();
            if (this.con != null) {
                try {
                    System.out.println(sql);
                    this.pstm = this.con.prepareStatement(sql, 1004, 1007);
                    for (int i = 0; i < params.length; ++i) {
                        this.pstm.setObject(i + 1, params[i]);
                    }
                    this.pstm.execute();
                }
                catch (SQLException e) {
                    System.out.println("doPstm()\u65b9\u6cd5\u51fa\u9519\uff01");
                    e.printStackTrace();
                }
            }
        }
    }
    
    public ResultSet getRs() throws SQLException {
        return this.pstm.getResultSet();
    }
    
    public int getCount() throws SQLException {
        return this.pstm.getUpdateCount();
    }
    
    public void closed() {
        try {
            if (this.pstm != null) {
                this.pstm.close();
            }
        }
        catch (SQLException e) {
            System.out.println("\u5173\u95edpstm\u5bf9\u8c61\u5931\u8d25\uff01");
            e.printStackTrace();
        }
        try {
            if (this.con != null) {
                this.con.close();
            }
        }
        catch (SQLException e) {
            System.out.println("\u5173\u95edcon\u5bf9\u8c61\u5931\u8d25\uff01");
            e.printStackTrace();
        }
    }
}
