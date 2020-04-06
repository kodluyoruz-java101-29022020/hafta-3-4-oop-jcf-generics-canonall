package soru1.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

	public static LocalDate getCurrentDate() {

		LocalDate localDate = LocalDate.now();
		return localDate;
	}

	public static String dateFormatter(LocalDate localDate) {

		return localDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

	}
}
