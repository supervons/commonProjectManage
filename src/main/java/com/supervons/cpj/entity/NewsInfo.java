package com.supervons.cpj.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "news_info")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class NewsInfo  implements Serializable {

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "news_id")
	private String newsId;

	@Column(name = "news_title")
	private String newsTitle;

	@Column(name = "news_introduction")
	private String newsIntroduction;

	@Column(name = "news_favorite_id")
	private String newsFavoriteId;

	@Column(name = "news_comments_id")
	private String newsCommentsId;

	@Column(name = "news_time")
	private String newsTime;

	@Column(name = "news_title_image")
	private String newsTitleImage;

	@Column(name = "news_content_image")
	private String newsContentImage;

	@Column(name = "news_content")
	private String newsContent;

	public String getNewsId() {
		return newsId;
	}

	public void setNewsId(String newsId) {
		this.newsId = newsId;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getNewsIntroduction() {
		return newsIntroduction;
	}

	public void setNewsIntroduction(String newsIntroduction) {
		this.newsIntroduction = newsIntroduction;
	}

	public String getNewsFavoriteId() {
		return newsFavoriteId;
	}

	public void setNewsFavoriteId(String newsFavoriteId) {
		this.newsFavoriteId = newsFavoriteId;
	}

	public String getNewsCommentsId() {
		return newsCommentsId;
	}

	public void setNewsCommentsId(String newsCommentsId) {
		this.newsCommentsId = newsCommentsId;
	}

	public String getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(String newsTime) {
		this.newsTime = newsTime;
	}

	public String getNewsTitleImage() {
		return newsTitleImage;
	}

	public void setNewsTitleImage(String newsTitleImage) {
		this.newsTitleImage = newsTitleImage;
	}

	public String getNewsContentImage() {
		return newsContentImage;
	}

	public void setNewsContentImage(String newsContentImage) {
		this.newsContentImage = newsContentImage;
	}

	public String getNewsContent() {
		return newsContent;
	}

	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
}
