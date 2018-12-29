package com.supervons.cpj.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
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

	public String getLoggerId() {
		return loggerId;
	}

	public void setLoggerId(String loggerId) {
		this.loggerId = loggerId;
	}

	public String getLoggerClientIp() {
		return loggerClientIp;
	}

	public void setLoggerClientIp(String loggerClientIp) {
		this.loggerClientIp = loggerClientIp;
	}

	public String getLoggerUri() {
		return loggerUri;
	}

	public void setLoggerUri(String loggerUri) {
		this.loggerUri = loggerUri;
	}

	public String getLoggerType() {
		return loggerType;
	}

	public void setLoggerType(String loggerType) {
		this.loggerType = loggerType;
	}

	public String getLoggerMethod() {
		return loggerMethod;
	}

	public void setLoggerMethod(String loggerMethod) {
		this.loggerMethod = loggerMethod;
	}

	public String getLoggerParamDate() {
		return loggerParamDate;
	}

	public void setLoggerParamDate(String loggerParamDate) {
		this.loggerParamDate = loggerParamDate;
	}

	public String getLoggerSessionUd() {
		return loggerSessionUd;
	}

	public void setLoggerSessionUd(String loggerSessionUd) {
		this.loggerSessionUd = loggerSessionUd;
	}

	public Date getLoggerTime() {
		return loggerTime;
	}

	public void setLoggerTime(Date loggerTime) {
		this.loggerTime = loggerTime;
	}

	public String getLoggerReturnTime() {
		return loggerReturnTime;
	}

	public void setLoggerReturnTime(String loggerReturnTime) {
		this.loggerReturnTime = loggerReturnTime;
	}

	public String getLoggerReturnData() {
		return loggerReturnData;
	}

	public void setLoggerReturnData(String loggerReturnData) {
		this.loggerReturnData = loggerReturnData;
	}

	public String getLoggerHttpStatusCode() {
		return loggerHttpStatusCode;
	}

	public void setLoggerHttpStatusCode(String loggerHttpStatusCode) {
		this.loggerHttpStatusCode = loggerHttpStatusCode;
	}

	public Long getLoggerTimeConsuming() {
		return loggerTimeConsuming;
	}

	public void setLoggerTimeConsuming(Long loggerTimeConsuming) {
		this.loggerTimeConsuming = loggerTimeConsuming;
	}
}
