// 
// 
// 

package com.orm;

public class Tting
{
    private int id;
    private int chewei_id;
    private String chexing;
    private String chepai;
    private String kaishishijian;
    private String jieshushijian;
    private int feiyong;
    private Tchewei chewei;
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public int getChewei_id() {
        return this.chewei_id;
    }
    
    public void setChewei_id(final int chewei_id) {
        this.chewei_id = chewei_id;
    }
    
    public String getChexing() {
        return this.chexing;
    }
    
    public void setChexing(final String chexing) {
        this.chexing = chexing;
    }
    
    public String getChepai() {
        return this.chepai;
    }
    
    public void setChepai(final String chepai) {
        this.chepai = chepai;
    }
    
    public String getKaishishijian() {
        return this.kaishishijian;
    }
    
    public void setKaishishijian(final String kaishishijian) {
        this.kaishishijian = kaishishijian;
    }
    
    public String getJieshushijian() {
        return this.jieshushijian;
    }
    
    public void setJieshushijian(final String jieshushijian) {
        this.jieshushijian = jieshushijian;
    }
    
    public int getFeiyong() {
        return this.feiyong;
    }
    
    public void setFeiyong(final int feiyong) {
        this.feiyong = feiyong;
    }
    
    public Tchewei getChewei() {
        return this.chewei;
    }
    
    public void setChewei(final Tchewei chewei) {
        this.chewei = chewei;
    }
}
