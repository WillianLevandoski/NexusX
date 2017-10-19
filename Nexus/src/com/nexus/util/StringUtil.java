package com.nexus.util;

public class StringUtil {
	
	public static String primeiraLetraToUpperCase(String string) {
		if (string != null && string.length() > 0)
			return string.replaceFirst(String.valueOf(string.charAt(0)), String.valueOf(string.charAt(0)).toUpperCase());
		return string;
	}
	
	public static String tiraAcento(String linha) {
		String LinhaNova = "";
		String Acento = "";
		String Letra = "";
		String ComAcento = "àáãäâÀÁÃÄÂèéëêÈÉËÊ";
		ComAcento += "ìíïîÌÍÏÎòóõöôÒÓÕÖÔùúüûÙÚÜÛçÇ";
		String SemAcento = "aaaaaAAAAAeeeeEEEE";
		SemAcento += "iiiiIIIIoooooOOOOOuuuuUUUUcC";
		for (int i = 0; i <= linha.length() - 1; i++) {
			Letra = linha.substring(i, i + 1);
			for (int j = 0; j <= ComAcento.length() - 1; j++) {
				if (ComAcento.substring(j, j + 1).equals(Letra))
					Letra = SemAcento.substring(j, j + 1);
			}
			LinhaNova = LinhaNova + Letra;
		}
		Acento = LinhaNova;
		Acento = Acento.replace("#", "");
		Acento = Acento.replace("'", "");
		return Acento;
	}
	
	public static String removeCaracteresEspeciais(String linha) {
		linha = linha.replaceAll("[^a-zA-Z0-9 ]", " ");
			return linha;
	}

}
