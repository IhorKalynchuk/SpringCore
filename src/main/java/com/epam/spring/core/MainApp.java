package com.epam.spring.core;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.beans.Event;
import com.epam.spring.core.beans.EventType;

public class MainApp {

	private static ConfigurableApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("spring.xml");

		App app = (App) ctx.getBean("app");

		Client ihor = (Client) ctx.getBean("Ihor");
		Event ihorEvent = (Event) ctx.getBean("event");
		ihorEvent.setMsg("Ihor goes at home!");
		app.logEvent(ihorEvent, EventType.ERROR);

		ctx.close();
	}

}
