package org.jms.test;

import org.jms.util.ApplicationProperties;

public class Main2 {

	public static void main(String[] args) {
		ApplicationProperties app = new ApplicationProperties();
		System.out.println(app.getProperty("requestQueque"));

	}

}
