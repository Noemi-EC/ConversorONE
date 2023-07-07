package conversorONE_I;

import javax.swing.JOptionPane;

public class Menu {
	
	public void continuar() {
		String dialogo = "¿Desea continuar con el programa?";
		int confirmacion = JOptionPane.showConfirmDialog(null, dialogo);
		// Yes: 0, No: 1, Cancel: 2
		if(confirmacion == 0) {
			this.menu();
		} else {
			JOptionPane.showMessageDialog(null, "Programa finalizado exitosamente");
		}
	}
	
	public void menu() {
		Object selectedValue = null;
		Object[] possibleValues = { "Conversor de Moneda", "Conversor de Temperatura" };
		
		selectedValue = JOptionPane.showInputDialog(null,
		             "Seleccione una opción de conversión", "Menú",
		             JOptionPane.INFORMATION_MESSAGE, null,
		             possibleValues, possibleValues[0]);
		
		try {
			
			if(selectedValue.equals("Conversor de Moneda")) {
				ConversorDivisa conversorMoneda = new ConversorDivisa();
				conversorMoneda.cantidad();
				conversorMoneda.conversion();
				conversorMoneda.mensaje();
				this.continuar();
			} else if (selectedValue.equals("Conversor de Temperatura")) {
				ConversorTemperatura conversorTemperatura = new ConversorTemperatura();
				conversorTemperatura.conversion();
				conversorTemperatura.mensaje();
				this.continuar();
			}
			
		} catch(NullPointerException ex) {
			// System.out.println(selectedValue); // Es null si hace clic en el botón cancel del menú
			this.continuar();
		}
		 
	}
	
}
