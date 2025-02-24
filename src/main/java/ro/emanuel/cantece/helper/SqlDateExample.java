package ro.emanuel.cantece.helper;

import java.sql.Date;

public class SqlDateExample {
	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		Date sqlDate = new Date(millis);
		System.out.println("java.sql.Date: " + sqlDate);
	}
}
