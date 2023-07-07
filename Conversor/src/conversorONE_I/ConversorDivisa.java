package conversorONE_I;

import javax.swing.JOptionPane;

public class ConversorDivisa extends Divisas{
	
	float solesCambio = 0;
	/* Moneda */
	protected float cantidad = 0;
	String monedaPropia = "Sol";
	Object[] possibleCoins = {"De "+monedaPropia+" a Dólar", "De "+monedaPropia+" a Euro", "De "+monedaPropia+" a Libras",
			"De "+monedaPropia+" a Yen", "De "+monedaPropia+" a Won Coreano", "De Dólar a "+monedaPropia,
			"De Euro a "+monedaPropia, "De Libras a "+monedaPropia, "De Yen a "+monedaPropia,
			"De Won Coreano a "+monedaPropia};
	/* Mensaje final */
	String mensaje = "Tienes ";
	
	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cant) {
		if(cant > 0) {
			this.cantidad = cant;			
		}
	}

	public void cantidad() {
		String cantCadena = JOptionPane.showInputDialog("Ingrese la cantidad de dinero que desee convertir:");
		try {
			float cant = Float.parseFloat(cantCadena);
			setCantidad(cant);
		} catch(NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Valor no válido. \nIngrese solo números y un punto para especificar la parte decimal.");
			cantidad();
		}
	}
	
	public double redondearDecimales(double valorInicial, int numeroDecimales) { // 123.5332, 2
		double parteEntera, resultado; // 123.5332
		resultado = valorInicial; // 123.5332
		// obtenemos la parte entera
		parteEntera = Math.floor(resultado); // 123.0
		// obtenemos la parte decimal y la multiplicamos para obtener la cantidad de decimales como enteros
		resultado = (resultado - parteEntera) * Math.pow(10, (numeroDecimales)); // 0.5332 * 100 = 53.32
		// obtenemos la cantidad de decimales deseados redondeandolo a entero
		resultado = Math.round(resultado); // 53
		// dividimos la parte entera que obtuvimos ↑ y lo convertimos en decimal, después sumamos con la parte entera
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera; // 53 / 100 + 123.0 = 123.53 
		return resultado;
	}
	
	public String convertirSolesA(String tipo, float cant) {
		String cadena = null;

		if(tipo.contains("Dólar")) {
			solesCambio = cant * solDolar;
			cadena = "Dólar";
		} else if(tipo.contains("Euro")) {
			solesCambio = cant * solEuro;
			cadena = "Euro";
		} else if(tipo.contains("Libras")) {
			solesCambio = cant * solLibra;
			cadena = "Libras";
		} else if(tipo.contains("Yen")) {
			solesCambio = cant * solYen;
			cadena = "Yen";
		} else if(tipo.contains("Won Coreano")) {
			solesCambio = cant * solWon;
			cadena = "Won";
		}
		
		solesCambio = (float) redondearDecimales(solesCambio, 2);
		return solesCambio + " en " + cadena;
	}
	
	public float convertirTipoASoles(String tipo, float cant) {
		if(tipo.contains("Dólar")) {
			solesCambio = cant * dolarSol;
		} else if(tipo.contains("Euro")) {
			solesCambio = cant * euroSol;
		} else if(tipo.contains("Libras")) {
			solesCambio = cant * libraSol;
		} else if(tipo.contains("Yen")) {
			solesCambio = cant * yenSol;
		} else if(tipo.contains("Won Coreano")) {
			solesCambio = cant * wonSol;
		}

		solesCambio = (float) redondearDecimales(solesCambio, 2);
		return solesCambio;
				
	}
		
	public void conversion() {
		 Object selectedValueCoin = JOptionPane.showInputDialog(null, "Elija la moneda a la que desea convertir su dinero",
				 "Monedas", JOptionPane.INFORMATION_MESSAGE, null, this.possibleCoins, this.possibleCoins[0]);
		 // si el valor seleccionado contiene la frase " De Sol a ... " llamar al método convertirSolesA
		 if((selectedValueCoin.toString()).contains("De Sol a ")) { 
			 mensaje += this.convertirSolesA((String) selectedValueCoin, getCantidad());
		 }
		 // si el valor seleccionado contiene la frase " De ... a Sol " llamar al método convertirTipoASoles
		 else if((selectedValueCoin.toString()).contains("a Sol")) {
			 mensaje += this.convertirTipoASoles((String) selectedValueCoin, getCantidad()) + " en Sol.";
		 }

	}
		
	public void mensaje(){
		JOptionPane.showMessageDialog(null, mensaje);
	}
	

		 
		 // JAVA SWING
		 // https://docs.oracle.com/javase/8/docs/api/javax/swing/JOptionPane.html

}
