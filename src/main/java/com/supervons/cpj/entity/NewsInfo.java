package com.supervons.cpj.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
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
	
}
