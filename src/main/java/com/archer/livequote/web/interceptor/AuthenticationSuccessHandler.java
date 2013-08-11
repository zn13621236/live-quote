/**
 * 
 */
package com.archer.livequote.web.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.util.StringUtils;

import com.archer.livequote.service.CompanyService;


/**
 * 
 * 
 * @author Aaron Yang
 * 
 */
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler implements InitializingBean {
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
   // private Map<LoginType, String> redirctUrls;
    private String defaultUrl;
	@Autowired
	CompanyService cs;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
    	String userName=request.getParameter("username");
    	String guid=cs.findByUserName(userName).getGuid();
    	String targetUrl = null;
        if (!StringUtils.hasText(targetUrl)) {
            targetUrl = defaultUrl+guid+"/manage";
        }
        redirectStrategy.sendRedirect(request, response, targetUrl);
        super.clearAuthenticationAttributes(request);
    }

    /**
     * @param defaultUrl
     *            the defaultUrl to set
     */
    public void setDefaultUrl(String defaultUrl) {
        this.defaultUrl = defaultUrl;
    }

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}
}
