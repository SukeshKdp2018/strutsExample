package org.websparrow.interceptors;

/*
 * (C) 2007 Mark Menard & Vita Rara, Inc.
 *
 * Mark Menard and Vita Rara, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;
import org.websparrow.bean.User;
import org.websparrow.dao.Admin;

/**
 * A Struts 2 interceptor that implements a login system.
 */
public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	private Admin admin = new Admin();
	private static final Log log = LogFactory.getLog (LoginInterceptor.class);
	private static final String USER_HANDLE = "QUADRAN_USER_SESSSION_HANDLE";
	private static final String LOGIN_ATTEMPT = "QUADRAN_LOGIN_ATTEMPT";
	private static final String USERNAME = "QUADRAN_USERNAME";
	private static final String PASSWORD = "QUADRAN_PASSWORD";

	public void init () {
		log.info ("Intializing LoginInterceptor");
	}

	public void destroy () {}

	public String intercept (ActionInvocation invocation) throws Exception {
		// Get the action context from the invocation so we can access the
		// HttpServletRequest and HttpSession objects.
		final ActionContext context = invocation.getInvocationContext ();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		HttpSession session =  request.getSession (true);
		Object user = session.getAttribute (USER_HANDLE);
		if (user == null) {
			String loginAttempt = request.getParameter (LOGIN_ATTEMPT);
			if (loginAttempt != null && loginAttempt.length()!= 0) { // The user is attempting to log in.
				if (processLoginAttempt (request, session) ) {
					return "login-success";
				} else {
					Object action = invocation.getAction ();
					if (action instanceof com.opensymphony.xwork2.ValidationAware) {
						((com.opensymphony.xwork2.ValidationAware) action).addActionError ("Username or password incorrect.");
					}
				}
			}
			return "login";
		} else {
			return invocation.invoke ();
		}
	}

	/**
	 * Attempt to process the user's login attempt delegating the work to the 
	 * SecurityManager.
	 */
	public boolean processLoginAttempt (HttpServletRequest request, HttpSession session) throws Exception {
		String username = request.getParameter (USERNAME);
		String password = request.getParameter (PASSWORD);
		User user = admin.login(username, password);
		if (user != null) {
			session.setAttribute (USER_HANDLE, user);
			return true;
		} else {
			return false;
		}
	}

}
