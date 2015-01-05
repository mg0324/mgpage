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
	private boolean showNumberLink;
	private boolean showGoLink;
	private boolean showPageInfo;
	
	public boolean isShowPageInfo() {
		return showPageInfo;
	}

	public void setShowPageInfo(boolean showPageInfo) {
		this.showPageInfo = showPageInfo;
	}

	public boolean isShowNumberLink() {
		return showNumberLink;
	}

	public void setShowNumberLink(boolean showNumberLink) {
		this.showNumberLink = showNumberLink;
	}

	public boolean isShowGoLink() {
		return showGoLink;
	}

	public void setShowGoLink(boolean showGoLink) {
		this.showGoLink = showGoLink;
	}

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
			sb.append("<div id='mgpage'>");
		}else{
			sb.append("<div id='"+id+"'>");
		}
		
		sb.append("<ul><li>"+firstPageLink+"</li>");
		sb.append("<li>"+prePageLink+"</li>");
		//数字链接
		if(showNumberLink){
			showNumberLink(sb);
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
		//GO
		if(showGoLink){
			showGoLink(sb);
		}
		//显示分页信息
		if(showPageInfo){
			showPageInfo(sb);
		}
		
		sb.append("</div>");
		try {
			out.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	/**
	 * 显示分页信息
	 * @param sb
	 */
	private void showPageInfo(StringBuffer sb) {
		//分页信息显示
		String descPart = "<desc>当前第<red> "+page.getCurrentPage()+"</red> 页 | 共 <red>"+page.getTotalPage()+"</red> 页 | 共<red> "+page.getTotalCount()+"</red> 条记录</desc>";
		sb.append(descPart);
	}
	/**
	 * 显示跳转到部分
	 * @param sb
	 */
	private void showGoLink(StringBuffer sb) {
		//跳转到第几页 9 GO
		String goForm = "<form action='"+url+"' method='post'>";
		goForm += "<input type='number' required min='1' max='"+page.getTotalPage()+"' name='currentPage'/>";
		goForm += "<button type='submit'>GO</button>";
		goForm += "</form>";
		sb.append(goForm);
	}
	/**
	 * 显示数字链接部分
	 * @param sb
	 */
	private void showNumberLink(StringBuffer sb) {
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
			if(page.getCurrentPage()<10){
				for(int i=1;i<=10;i++){
					String iLink = "<a href='"+url+"&currentPage="+i+"'>"+ i +"</a>";	
					if(i==page.getCurrentPage()){
						iLink = "<a class='isNow' href='javascript:void(0);'>"+ i +"</a>";
					}
					sb.append("<li>"+iLink+"</li>");
				}
			}else if((page.getTotalPage()-page.getCurrentPage())<10){
				for(int i=(page.getTotalPage()-10);i<=page.getTotalPage();i++){
					String iLink = "<a href='"+url+"&currentPage="+i+"'>"+ i +"</a>";	
					if(i==page.getCurrentPage()){
						iLink = "<a class='isNow' href='javascript:void(0);'>"+ i +"</a>";
					}
					sb.append("<li>"+iLink+"</li>");
				}
			}else{
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
			
		}
	}
	
	
}
