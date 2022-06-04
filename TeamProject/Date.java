package TeamProject;

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

	public Date() {

		setDate(true);
	}

	public Date(boolean NowOrDefault) {

		setDate(NowOrDefault);
	}

	public Date(int newYear, int newMonth, int newDay, int newHour, int newMinute, int newSecond) {

		if (isValidTime(newYear, newMonth, newDay, newHour, newMinute, newSecond)) {

			setDate(newYear, newMonth, newDay, newHour, newMinute, newSecond);

		} else
			errorhandler("invalid initializing");
	}

	public Date(Date origin) {// copy constructor

		if (isValidTime(origin.getYear(), origin.getMonth(), origin.getDay(), origin.getHour(), origin.getMinute(),
				origin.getSecond())) {

			setDate(origin.getYear(), origin.getMonth(), origin.getDay(), origin.getHour(), origin.getMinute(),
					origin.getSecond());

		} else
			errorhandler("invalid initializing");
	}

	public void setDate(boolean NowOrDefault) {

		if (NowOrDefault) {

			now = LocalDateTime.now();
			year = now.getYear();
			month = now.getMonthValue();
			day = now.getDayOfMonth();
			hour = now.getHour();

			if (hour > 12)
				afterNoon = true;
			else
				afterNoon = false;

			minute = now.getMinute();
			second = now.getSecond();

		} else {

			setDate(2021, 1, 1, 0, 0, 0);
		}
	}

	public void setDate(int newYear, int newMonth, int newDay, int newHour, int newMinute, int newSecond) {

		if (isValidTime(newYear, newMonth, newDay, newHour, newMinute, newSecond)) {

			year = newYear;
			month = newMonth;
			day = newDay;
			hour = newHour;

			if (hour > 12)
				afterNoon = true;
			else
				afterNoon = false;

			minute = newMinute;
			second = newSecond;

		} else
			errorhandler("invalid setting");
	}

	public boolean isValidTime() {

		return ((year > 2020) && (year <= 3000) && (month > 0) && (month <= 12) && (day > 0) && (day <= 31)
				&& (hour >= 0) && (hour < 24) && (minute >= 0) && (minute < 60) && (second >= 0) && (second < 60));
	}

	public boolean isValidTime(int year, int month, int day, int hour, int minute, int second) {

		return ((year > 2020) && (year <= 3000) && (month > 0) && (month <= 12) && (day > 0) && (day <= 31)
				&& (hour >= 0) && (hour < 24) && (minute >= 0) && (minute < 60) && (second >= 0) && (second < 60));
	}

	public int compareTime(Date other) {

		if (year - other.year != 0)
			return year - other.year;

		if (month - other.month != 0)
			return month - other.month;

		if (day - other.day != 0)
			return day - other.day;

		if (hour - other.hour != 0)
			return hour - other.hour;

		if (minute - other.minute != 0)
			return minute - other.minute;

		if (second - other.second != 0)
			return second - other.second;

		else
			return 0;
	}

	public int getYear() {

		return year;
	}

	public int getMonth() {

		return month;
	}

	public int getDay() {

		return day;
	}

	public int getHour() {

		return hour;
	}

	public int getMinute() {

		return minute;
	}

	public int getSecond() {

		return second;
	}
	
	public Date addDay(Date date){
		int m = date.getMonth();
		int d = date.getDay();
		if(d==31){
			if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
				m+=1;
				d=1;
			}
		}else if(d==30){
			if(m==1||m==3||m==5||m==7||m==8||m==10||m==12){
				d+=1;
			}else if(m==4||m==6||m==9||m==11){
				m+=1;
				d=1;
			}
		}else if(d==29 && (year % 4 == 0 && year % 100 != 0)){
			
		}
		
		date.setDate(date.getYear(), m, d, date.getHour(), date.getMinute(), date.getSecond());
		return date;
	}
	
	/*if (year % 4 == 0 && year % 100 != 0) {
			System.out.printf("%d 년은 윤년입니다 \n", year);
		} else if (year % 100 != 0 || year % 400 == 0) {
			System.out.printf("%d 는 윤년이네요 \n", year);
		} else {
			System.out.printf("%d 년은 윤년이 아니네요 \n", year);
			System.out.println("이 해는 평년입니다");
		}*/

	public String toString() {

		return "" + year + "-" + month + "-" + day + " " + ((hour > 12) ? hour - 12 : hour) + ":" + minute + ":"
				+ second + (afterNoon ? " PM" : " AM");
	}

	private void errorhandler(String errorType) {

		System.err.println("Error occured in Date class: " + errorType);
	}
}
