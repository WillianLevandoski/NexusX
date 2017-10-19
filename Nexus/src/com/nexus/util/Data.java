package com.nexus.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public abstract class Data {

	public static Integer getDia(Date dataPonto) {
		Calendar dataAtual = getCalendar(dataPonto);
		return dataAtual.get(Calendar.DAY_OF_MONTH);
	}

public static Calendar getCalendar(Date data) {
    Calendar calendar = new GregorianCalendar();
    calendar.setTime(data);
    return calendar;
}


}