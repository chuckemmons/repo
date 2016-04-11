package com.cee.wsr.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String DATE_STRING_FORMAT = "dd MMM yyyy";
	private static final DateFormat DATE_FORMATER = new SimpleDateFormat(DATE_STRING_FORMAT);

	private DateUtil() {
	}

	public static Date toDate(String string) {
		Date date = null;
		try {
			date = DATE_FORMATER.parse(string);
		} catch (ParseException pe) {
			throw new IllegalArgumentException("String must be in the following format - '"
					+ DATE_STRING_FORMAT + "'", pe);
		}
		return date;
	}

	public static String toString(Date date) {
		return DATE_FORMATER.format(date);
	}

}
