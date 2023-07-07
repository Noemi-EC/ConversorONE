package conversorONE_I;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class ConversorTemperatura {
	
	// fórmula general
	// °C / 5 = (°F - 32) / 9 = (°K - 273.15) / 5 = (°R - 491.67) / 9 ← rankine
	
	// fórmula directa
	// °C + 273.15 = K
	// °F + 459.67 = R
	
	// variable de apoyo
	double grados;
	
	Object[] possibleValues = {"Centígrados", "Farenheit", "Kelvin", "Rankine"};
	String tipoGradoIngresado = "";
	Object selectedValueDegree = null;
	double gradoIngresado;
	double gradoConvertido;
	String mensaje;
	
	public double gradosAConvertir() {
		String gradosCadena = JOptionPane.showInputDialog(null, "Ingrese los grados que desea convertir: ");
		try {
			double gradosDouble = Double.parseDouble(gradosCadena);
			gradoIngresado = gradosDouble;
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Valor no válido. \nIngrese solo números y un punto para especificar la parte decimal.");
			gradosAConvertir();
		}
		return gradoIngresado;
	}

	public double centigradoA(String tipo, double centrigrados) {
		switch(tipo) {
		case("Farenheit"):
			grados = (centrigrados / 5) * 9 + 32;
			break;
		case("Kelvin"):
			grados = centrigrados + 273.15;
			break;
		case("Rankine"):
			grados = (centrigrados / 5) * 9 + 491.67;
			break;
		}
		return grados;
	}
	
	public double farenheitA(String tipo, double farenheit) {
		switch(tipo) {
		case("Centígrados"):
			grados = (farenheit-32) / 9 * 5;
			break;
		case("Kelvin"):
			grados = (farenheit-32) / 9 * 5 + 273.15;
			break;
		case("Rankine"):
			grados = farenheit + 459.67;
			break;
		}
		return grados;
	}
	
	public double kelvinA(String tipo, double kelvin) {
		switch(tipo) {
		case("Centígrados"):
			grados = kelvin - 273.15;
			break;
		case("Farenheit"):
			grados = (kelvin-273.15) / 5 * 9 + 32;
			break;
		case("Rankine"):
			grados = (kelvin-273.15) / 5 * 9 + 491.67;
			break;
		}
		return grados;
	}
	
	public double rankineA(String tipo, double rankine) {
		switch(tipo) {
		case("Centígrados"):
			grados = (rankine - 491.67) / 9 * 5;
			break;
		case("Farenheit"):
			grados = rankine - 459.67;
			break;
		case("Kelvin"):
			grados = (rankine - 491.67) / 9 * 5 + 273.15;
			break;
		}
		return grados;
	}
	
	public String tipoGradoAConvertir() {
		selectedValueDegree = JOptionPane.showInputDialog(null, "Elija el tipo de grado a la que desea convertir:",
				 "Temperatura a convertir", JOptionPane.INFORMATION_MESSAGE, null, this.possibleValues, this.possibleValues[0]);
		return (String) selectedValueDegree;
	}
	
	public double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, (numeroDecimales));
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}
	
	public void conversion() {
		tipoGradoIngresado = (String) JOptionPane.showInputDialog(null, "Elija el tipo de grado que está ingresando:",
				"Temperatura", JOptionPane.QUESTION_MESSAGE, null, this.possibleValues, this.possibleValues[0]);
	
		List<Object> valuesList = new ArrayList<>(Arrays.asList(possibleValues));
		valuesList.remove(tipoGradoIngresado);
		possibleValues = valuesList.toArray();

		switch(tipoGradoIngresado) {
			case("Centígrados"):
				gradoConvertido = centigradoA(tipoGradoAConvertir(), gradosAConvertir());
				break;
			case("Farenheit"):
				gradoConvertido = farenheitA(tipoGradoAConvertir(), gradosAConvertir());
				break;
			case("Kelvin"):
				gradoConvertido = kelvinA(tipoGradoAConvertir(), gradosAConvertir());
				break;
			case("Rankine"):
				gradoConvertido = rankineA(tipoGradoAConvertir(), gradosAConvertir());
				break;
		}
		
	}
	
	public void mensaje() {
		JOptionPane.showMessageDialog(null, "De "+tipoGradoIngresado+" a "+selectedValueDegree+"\n"+gradoIngresado+" ↔ "+redondearDecimales(gradoConvertido, 1));
	}
	
}
