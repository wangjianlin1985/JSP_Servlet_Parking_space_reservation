// 
// 
// 

package com.util;

import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletResponse;
import javax.servlet.ServletRequest;
import javax.servlet.FilterConfig;
import javax.servlet.Filter;

public class EncodingFilter implements Filter
{
    protected String encoding;
    protected FilterConfig filterConfig;
    
    public EncodingFilter() {
        this.encoding = null;
        this.filterConfig = null;
    }
    
    public void destroy() {
        this.encoding = null;
        this.filterConfig = null;
    }
    
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final String encoding = this.selectEncoding(request);
        if (encoding != null) {
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);
    }
    
    public void init(final FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        this.encoding = filterConfig.getInitParameter("encoding");
    }
    
    protected String selectEncoding(final ServletRequest request) {
        return this.encoding;
    }
}
