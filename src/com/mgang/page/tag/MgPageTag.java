package com.mgang.page.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * @author meigang
 *  2015-1-4
 *	mgpage分页标签的标签类
 */
public class MgPageTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	//list属性
	private List list;
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		for(Object obj : list){
			sb.append(obj.toString()+"<br/>");
		}
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
}
