package org.websparrow.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.websparrow.bean.EmpBean;
import org.websparrow.dao.Admin;

import com.opensymphony.xwork2.ActionSupport;

public class ReportAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	EmpBean bean = null;
	List<EmpBean> beanList = null;
	Admin admin = new Admin();
	HttpServletRequest request;

	@Override
	public String execute()  throws Exception {
		try {
			beanList = new ArrayList<EmpBean>();
			rs = admin.report();
			if (rs != null) {
				while (rs.next()) {
					bean = new EmpBean();
					bean.setUname(rs.getString("UNAME"));
					bean.setUemail(rs.getString("UEMAIL"));
					bean.setUpass(rs.getString("UPASS").replaceAll("(?s).", "*"));
					bean.setUdeg(rs.getString("UDEG"));
					beanList.add(bean);
				}
				request.setAttribute("disp", beanList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "REPORT";
	}

	public List<EmpBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpBean> beanList) {
		this.beanList = beanList;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
}
