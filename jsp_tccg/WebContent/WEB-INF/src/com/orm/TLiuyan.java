// 
// 
// 

package com.orm;

import java.io.Serializable;

public class TLiuyan implements Serializable
{
    private Integer id;
    private String neirong;
    private String liuyanshi;
    private String user_id;
    private String huifu;
    private String huifushi;
    private Tuser user;
    
    public String getHuifu() {
        return this.huifu;
    }
    
    public void setHuifu(final String huifu) {
        this.huifu = huifu;
    }
    
    public String getHuifushi() {
        return this.huifushi;
    }
    
    public void setHuifushi(final String huifushi) {
        this.huifushi = huifushi;
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(final Integer id) {
        this.id = id;
    }
    
    public String getLiuyanshi() {
        return this.liuyanshi;
    }
    
    public void setLiuyanshi(final String liuyanshi) {
        this.liuyanshi = liuyanshi;
    }
    
    public String getNeirong() {
        return this.neirong;
    }
    
    public void setNeirong(final String neirong) {
        this.neirong = neirong;
    }
    
    public Tuser getUser() {
        return this.user;
    }
    
    public void setUser(final Tuser user) {
        this.user = user;
    }
    
    public String getUser_id() {
        return this.user_id;
    }
    
    public void setUser_id(final String user_id) {
        this.user_id = user_id;
    }
}
