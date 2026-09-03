package JavaClasses;

import java.io.IOException;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;

public class FollwerCountTag extends SimpleTagSupport {

	private int count;
	public void setCount(int count) {
		this.count=count;
	}
	    public void doTag() throws JspException, IOException {

	        String result;

	        if (count >= 1000000) {
	            result = String.format("%.1fM", count / 1000000.0);
	        } 
	        else if (count >= 1000) {
	            result = String.format("%.1fK", count / 1000.0);
	        } 
	        else {
	            result = String.valueOf(count);
	        }

	        getJspContext().getOut().print(result);
	    }

	}
	

