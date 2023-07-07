package conversorONE_I;

/*
import java.util.ArrayList;
import javax.swing.JOptionPane;
*/
public class TestConversor {

	public static void main(String[] args) {
		Menu conversorMenu = new Menu();
		/*
		conversor.menu();
		conversor.cantidad();
		conversor.conversion();
		conversor.mensaje();
		 */
		conversorMenu.menu();
		
		/*
        ArrayList<Object> possibleValues = new ArrayList<>();
        possibleValues.add("Celsius");
        possibleValues.add("Fahrenheit");
        possibleValues.add("Kelvin");
        possibleValues.add("Rankine");

        Object[] possibleValuesArray = possibleValues.toArray();

        // Imprimir los elementos del array
        for (Object value : possibleValuesArray) {
            System.out.println(value);
        }
		*/
		/*
		 ArrayList<String> possibleValues = new ArrayList<>();
	        possibleValues.add("Celsius");
	        possibleValues.add("Fahrenheit");
	        possibleValues.add("Kelvin");
	        possibleValues.add("Rankine");

	        String[] possibleValuesArray = possibleValues.toArray(new String[0]);

	        // Utilizar con JOptionPane.showInputDialog()
	        String selectedValue = (String) JOptionPane.showInputDialog(null, "Elija el tipo de grado a la que desea convertir:",
	                "Temperatura a convertir", JOptionPane.INFORMATION_MESSAGE, null, possibleValuesArray, possibleValuesArray[0]);

	        System.out.println("Valor seleccionado: " + selectedValue);
		*/
	}

}
