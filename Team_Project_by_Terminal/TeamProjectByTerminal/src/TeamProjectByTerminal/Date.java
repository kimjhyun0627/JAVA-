package TeamProjectByTerminal;

import java.time.LocalDateTime;

public class Date {

	private int year;
	private int month;
	private int day;
	private int hour;
	private int minute;
	private int second;
	private boolean afterNoon;

	LocalDateTime now = LocalDateTime.now();

	Date() {

		year = now.getYear();
		month = now.getMonthValue();
		day = now.getDayOfMonth();
		hour = now.getHour();
		if (hour > 12) {

			hour -= 12;
			afterNoon = true;
		} else
			afterNoon = false;
		minute = now.getMinute();
		second = now.getSecond();
	}

	public String toString() {

		return "" + year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second
				+ (afterNoon ? " PM" : " AM") + "\n";
	}
	
	void abc() {
		
	}
}
