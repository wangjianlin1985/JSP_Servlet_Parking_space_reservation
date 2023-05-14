// 
// 
// 

package com.orm;

public class TAdmin
{
    private int userId;
    private String userName;
    private String userPw;
    
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(final String userName) {
        this.userName = userName;
    }
    
    public String getUserPw() {
        return this.userPw;
    }
    
    public void setUserPw(final String userPw) {
        this.userPw = userPw;
    }
    
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(final int userId) {
        this.userId = userId;
    }
}
