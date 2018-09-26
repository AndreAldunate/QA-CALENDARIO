import java.util.InputMismatchException;

public class Calendario {
	public String sumaDia(int dia, String mes, int anho)
			throws InputMismatchException {
		int[] fecha = { dia, getMesInt(mes), anho };
		if (fecha[1] == -1) {
			throw new InputMismatchException("Mes invalido");
		}
		if (fecha[2] < 0) {
			throw new InputMismatchException("Anho invalido");
		}
		if (!verificarDia(fecha)) {
			throw new InputMismatchException("Dia invalido");
		}

		int[] nuevaFecha = aumentarDia(fecha);

		return nuevaFecha[0] + "/" + getMesString(nuevaFecha[1]) + "/"
				+ nuevaFecha[2];
	}

	private String getMesString(int mes) {
		if (mes == 1) {
			return "ENERO";
		} else if (mes == 2) {
			return "FEBRERO";
		} else if (mes == 3) {
			return "MARZO";
		} else if (mes == 4) {
			return "ABRIL";
		} else if (mes == 5) {
			return "MAYO";
		} else if (mes == 6) {
			return "JUNIO";
		} else if (mes == 7) {
			return "JULIO";
		} else if (mes == 8) {
			return "AGOSTO";
		} else if (mes == 9) {
			return "SEPTIEMBRE";
		} else if (mes == 10) {
			return "OCTUBRE";
		} else if (mes == 11) {
			return "NOVIEMBRE";
		} else if (mes == 12) {
			return "DICIEMBRE";
		}
		return null;
	}

	private int[] aumentarDia(int[] fecha) {
		int[] nuevaFecha = new int[3];
		if (fecha[1] == 1 || fecha[1] == 3 || fecha[1] == 5 || fecha[1] == 7
				|| fecha[1] == 8 || fecha[1] == 10 || fecha[1] == 12) {
			if (fecha[0] == 31) {
				nuevaFecha[0] = 1;
				nuevaFecha[1] = fecha[1] + 1;
				if (nuevaFecha[1] == 13) {
					nuevaFecha[1] = 1;
					nuevaFecha[2] = fecha[2] + 1;
				}
			} else {
				nuevaFecha[0] = fecha[0] + 1;
				nuevaFecha[1] = fecha[1];
				nuevaFecha[2] = fecha[2];
			}
		} else if (fecha[1] == 4 || fecha[1] == 6 || fecha[1] == 9
				|| fecha[1] == 11) {
			if (fecha[0] == 30) {
				nuevaFecha[0] = 1;
				nuevaFecha[1] = fecha[1] + 1;
			} else {
				nuevaFecha[0] = fecha[0] + 1;
				nuevaFecha[1] = fecha[1];
			}
			nuevaFecha[2] = fecha[2];
		} else if (fecha[1] == 2) {
			if (verificarBisiesto(fecha[2])) {
				if (fecha[0] == 29) {
					nuevaFecha[0] = 1;
					nuevaFecha[1] = fecha[1] + 1;
				} else {
					nuevaFecha[0] = fecha[0] + 1;
					nuevaFecha[1] = fecha[1];
				}
			} else {
				if (fecha[0] == 28) {
					nuevaFecha[0] = 1;
					nuevaFecha[1] = fecha[1];
				} else {
					nuevaFecha[0] = fecha[0] + 1;
					nuevaFecha[1] = fecha[1];
				}
			}
			nuevaFecha[2] = fecha[2];
		}
		return nuevaFecha;
	}

	private int getMesInt(String s) {
		if (s.equals("ENERO")) {
			return 1;
		} else if (s.equals("FEBRERO")) {
			return 2;
		} else if (s.equals("MARZO")) {
			return 3;
		} else if (s.equals("ABRIL")) {
			return 4;
		} else if (s.equals("MAYO")) {
			return 5;
		} else if (s.equals("JUNIO")) {
			return 6;
		} else if (s.equals("JULIO")) {
			return 7;
		} else if (s.equals("AGOSTO")) {
			return 8;
		} else if (s.equals("SEPTIEMBRE")) {
			return 9;
		} else if (s.equals("OCTUBRE")) {
			return 10;
		} else if (s.equals("NOVIEMBRE")) {
			return 11;
		} else if (s.equals("DICIEMBRE")) {
			return 12;
		} else {
			return -1;
		}
	}

	private boolean verificarDia(int[] fecha) {
		if (fecha[1] == 1 || fecha[1] == 3 || fecha[1] == 5 || fecha[1] == 7
				|| fecha[1] == 8 || fecha[1] == 10 || fecha[1] == 12) {
			if (fecha[0] <= 31 && fecha[0] >= 1) {
				return true;
			} else {
				return false;
			}
		} else if (fecha[1] == 4 || fecha[1] == 6 || fecha[1] == 9
				|| fecha[1] == 11) {
			if (fecha[0] <= 30 && fecha[0] >= 1) {
				return true;
			} else {
				return false;
			}
		} else if (fecha[1] == 2) {
			if (verificarBisiesto(fecha[2])) {
				if (fecha[0] <= 29 && fecha[0] >= 1) {
					return true;
				} else {
					return false;
				}
			} else {
				if (fecha[0] <= 28 && fecha[0] >= 1) {
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

	public boolean verificarBisiesto(int anho) {
		String anhoString = anho + "";
		if (anho >= 400
				&& (anhoString).substring(anhoString.length() - 2).equals("00")
				&& anho % 400 == 0) {
			return true;
		} else if (anho % 4 == 0) {
			return true;
		} else {
			return false;
		}
	}
}