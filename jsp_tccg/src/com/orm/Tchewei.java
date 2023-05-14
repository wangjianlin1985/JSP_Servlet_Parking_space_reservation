// 
// 
// 

package com.orm;

public class Tchewei
{
    private int id;
    private String bianhao;
    private String quyu;
    private String zt;
    private String del;
    
    public String getBianhao() {
        return this.bianhao;
    }
    
    public void setBianhao(final String bianhao) {
        this.bianhao = bianhao;
    }
    
    public String getDel() {
        return this.del;
    }
    
    public void setDel(final String del) {
        this.del = del;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getZt() {
        return this.zt;
    }
    
    public void setZt(final String zt) {
        this.zt = zt;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getQuyu() {
        return this.quyu;
    }
    
    public void setQuyu(final String quyu) {
        this.quyu = quyu;
    }
}
