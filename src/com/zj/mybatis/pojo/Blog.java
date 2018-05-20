package com.zj.mybatis.pojo;

public class Blog {
	
	private Integer id;
	private String title;
	private int authorId;
	private String state;
	private String featured;
	private String style;
	
	public Blog() {
		super(); 
		/*this.title = "Î´ÃüÃû";
		this.authorId = 11;
		this.state = "N";
		this.featured = "2";
		this.style = "red";*/
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getFeatured() {
		return featured;
	}
	public void setFeatured(String featured) {
		this.featured = featured;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", authorId=" + authorId + ", state=" + state + ", featured="
				+ featured + ", style=" + style + "]";
	}
	
}
