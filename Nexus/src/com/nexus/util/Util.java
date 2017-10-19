package com.nexus.util;

public class Util {
	
	public static Integer getInteger(Object object) {
		if (!object.equals(null)) {
			try {
				String trim = object.toString().trim();
				trim = trim.replace(" ", "");
				trim = trim.replace("_", "");
				trim = trim.replace(",", ".");
				if(trim.contains(".")) 
					trim =trim.split("\\.")[0];
				return Integer.valueOf(trim);

			} catch (Exception e) {
			}
		}
		return null;
	}
	
	public static boolean isPreenchido(Object object) {
		try {
			if (object != null) {
				String aux = object.toString();
				if (aux.equals("") || aux.equals(" ")) {
					return false;
				} else {
					return true;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}
	
	public static boolean naoPreenchido(Object object) {
		return !isPreenchido(object);
	}
	
	public static String getString(Object str) {
		if (naoPreenchido(str))
			return "";
		else
			return str.toString().trim();
	}

}
