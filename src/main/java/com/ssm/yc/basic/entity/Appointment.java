package com.ssm.yc.basic.entity;

import java.util.Date;

/**
 * 预约图书实体
 */
public class Appointment {

	/**
	 * 图书ID
	 */
	private long bookId;

	/**
	 * 学号
	 */
	private long studentId;

	/**
	 * 预约时间
	 */
	private Date appointTime;

	/**
	 * 多对一的复合属性
	 * 		图书实体
	 */
	private Book book;
}
