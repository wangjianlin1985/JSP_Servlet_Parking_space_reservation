// 
// 
// 

package com.orm;

public class Tyuding
{
    private String id;
    private String xingming;
    private String dianhua;
    private String daodashi;
    private int chewei_id;
    private String user_id;
    private String zt;
    private Tchewei chewei;
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getXingming() {
        return this.xingming;
    }
    
    public void setXingming(final String xingming) {
        this.xingming = xingming;
    }
    
    public String getDianhua() {
        return this.dianhua;
    }
    
    public void setDianhua(final String dianhua) {
        this.dianhua = dianhua;
    }
    
    public String getDaodashi() {
        return this.daodashi;
    }
    
    public void setDaodashi(final String daodashi) {
        this.daodashi = daodashi;
    }
    
    public int getChewei_id() {
        return this.chewei_id;
    }
    
    public void setChewei_id(final int chewei_id) {
        this.chewei_id = chewei_id;
    }
    
    public String getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final String user_id) {
        this.user_id = user_id;
    }
    
    public String getZt() {
        return this.zt;
    }
    
    public void setZt(final String zt) {
        this.zt = zt;
    }
    
    public Tchewei getChewei() {
        return this.chewei;
    }
    
    public void setChewei(final Tchewei chewei) {
        this.chewei = chewei;
    }
}
