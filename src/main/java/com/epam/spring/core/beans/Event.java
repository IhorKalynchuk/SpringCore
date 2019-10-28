package com.epam.spring.core.beans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event {
	private static int last_id;
	private int id;
	private String msg;
	private Date date;
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy : hh.mm.ss");

	static {
		last_id = 0;
	}

	public Event(Date date) {
		super();
		this.date = date;
		this.id = ++last_id;

	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getFormattedMessage() {
		return dateFormat.format(date) + "\t: " + msg;
	}

	public static boolean isDay() {
		int hours = new Date().getHours();
		return hours >= 5 && hours <= 16;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", msg=" + msg + ", date=" + dateFormat.format(date) + "]";
	}

}
