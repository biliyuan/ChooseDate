package xidian.qlj.tools;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class myfilter implements Filter{
	 private String encode = null;
	    private boolean ignore = false;// ¹ýÂËÆ÷¿ª¹Ø

	    public void destroy() {
	        encode = null;
	        ignore = false;
	    }

	    public void doFilter(ServletRequest request, ServletResponse response,
	            FilterChain chain) throws IOException, ServletException {
	        if (!ignore) {
	            if (null == request.getCharacterEncoding()) {
	                request.setCharacterEncoding(encode);
	                response.setCharacterEncoding(encode);

	            }
	        }
	        chain.doFilter(request, response);

	    }

	    public void init(FilterConfig filterConfig) throws ServletException {
	        String encode = filterConfig.getInitParameter("encode");
	        String ignore = filterConfig.getInitParameter("ignore");
	        if (this.encode == null)
	            this.encode = encode;
	        if ("1".equals(ignore) || "yes".equals(ignore)) {
	            this.ignore = true;
	        }
	    }


}
