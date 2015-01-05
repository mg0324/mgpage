package com.mgang.page.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.mgang.page.util.Page;

/**
 * 
 * @author meigang
 *  2015-1-4
 *	mgpage分页标签的标签类
 */
public class MgPageTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	private String url;
	private Page page;
	private String id;
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer();
		//首页 上一页 
		String firstPageLink = "<a href='"+url+"&currentPage=1'>首页</a>";
		String prePageLink = "<a href='"+url+"&currentPage="+(page.getCurrentPage()-1)+"'>&lt;&lt;</a>";
		if(page.isFirst()){
			firstPageLink = "首页";
			prePageLink = "&lt;&lt;";
		}
		
		if(null == id){
			//使用官方id=mgpage的css样式，请导入项目中的css目录下的mg-page.xx.css文件
			sb.append("<ul id='mgpage'>");
		}else{
			sb.append("<ul id='"+id+"'>");
		}
		sb.append("<li>"+firstPageLink+"</li>");
		sb.append("<li>"+prePageLink+"</li>");
		
		//数字链接
		if(page.getTotalPage()<=10){
			for(int i=1;i<=page.getTotalPage();i++){
				String iLink = "<a href='"+url+"&currentPage="+i+"'>"+ i +"</a>";	
				if(i==page.getCurrentPage()){
					iLink = "<a class='isNow' href='javascript:void(0);'>"+ i +"</a>";
				}
				sb.append("<li>"+iLink+"</li>");
			}
		}else if(page.getTotalPage()>10){
			for(int i=page.getCurrentPage()-4;i<page.getCurrentPage() && i>=1;i++){
				String iLink = "<a href='"+url+"&currentPage="+i+"'>"+ i +"</a>";	
				sb.append("<li>"+iLink+"</li>");
			}
			for(int i=page.getCurrentPage();i<page.getCurrentPage()+5 && i<=page.getTotalPage();i++){
				String iLink = "<a href='"+url+"&currentPage="+i+"'>"+ i +"</a>";	
				if(i==page.getCurrentPage()){
					iLink = "<a class='isNow' href='javascript:void(0);'>"+ i +"</a>";
				}
				sb.append("<li>"+iLink+"</li>");
			}
		}
		String nextPageLink = "<a href='"+url+"&currentPage="+(page.getCurrentPage()+1)+"'>&gt;&gt;</a>"; 
		String lastPageLink = "<a href='"+url+"&currentPage="+page.getTotalPage()+"'>尾页</a>";
		if(page.isLast()){
			nextPageLink = "&gt;&gt;";
			lastPageLink = "尾页";
		}
		
		//下一页 尾页
		sb.append("<li>"+nextPageLink+"</li>");
		sb.append("<li>"+lastPageLink+"</li>");
		sb.append("</ul>");
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	
	
}
