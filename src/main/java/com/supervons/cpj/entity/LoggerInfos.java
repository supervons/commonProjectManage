package com.supervons.cpj.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "logger_infos")
@GenericGenerator(name = "uuid", strategy = "uuid")
public class LoggerInfos{

	@Id
	@GeneratedValue(generator = "uuid")
	@Column(name = "logger_id")
	private String loggerId;

	@Column(name = "logger_client_ip")
	private String loggerClientIp;

	@Column(name = "logger_uri")
	private String loggerUri;

	@Column(name = "logger_type")
	private String loggerType;

	@Column(name = "logger_method")
	private String loggerMethod;

	@Column(name = "logger_param_date")
	private String loggerParamDate;

	@Column(name = "logger_session_ud")
	private String loggerSessionUd;

	@Column(name = "logger_time")
	private java.util.Date loggerTime;

	@Column(name = "logger_return_time")
	private String loggerReturnTime;

	@Column(name = "logger_return_data")
	private String loggerReturnData;

	@Column(name = "logger_http_status_code")
	private String loggerHttpStatusCode;

	@Column(name = "logger_time_consuming")
	private Long loggerTimeConsuming;

	}

