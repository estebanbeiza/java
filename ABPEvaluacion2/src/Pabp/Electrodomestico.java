package Pabp;
/**
 * 
 * Esta clase contiene los atributos y métodos pertenecientes a la clase Electrodomestico
 * Y será usada como Clase Padre
 * @author Esteban Beiza
 * @version 24/02/2020
 * @see <a href="https://github.com/estebanbeiza/java/tree/master/ABPEvaluacion2">Versión en Github</a>
 *
 */

public abstract class Electrodomestico {
	//Atributos de la clase
	private int precioBase;
	private String color; // Solor permite (blanco, negro, rojo, azul y gris)
	private char consumoEnergetico; // Rango entre (A y F)
	private int peso;
	
	/**
	 *
	 * Constructor vacio de la clase asigna valores por defecto a los atributos
	 * @param precioBase precio base del electrodomestico 
	 * @param color color del electrodomestico (blanco, negro, rojo, azul y gris)
	 * @param consumoEnergetico Rango entre A y F del consumo energetico
	 * @param peso peso del electrodomestico 
	 */
	Electrodomestico () {
		this.precioBase = 100000;
		this.color = "blanco";
		this.consumoEnergetico = 'F';
		this.peso = 5;
	}
	
	/**
	 *
	 * Constructor que acepta precioBase y peso solamente, los demas atributos
	 * quedan con el valor por defecto
	 * @param precioBase precio base del electrodomestico 
	 * @param color color del electrodomestico (blanco, negro, rojo, azul y gris)
	 * @param consumoEnergetico Rango entre A y F del consumo energetico
	 * @param peso peso del electrodomestico 
	 */
	Electrodomestico (int precioBase, int peso) {
		this.precioBase = precioBase;
		this.color = "blanco";
		this.consumoEnergetico = 'F';
		this.peso = peso;
	}

	/**
	 *
	 * Constructor de la clase acepta todos los atributos
	 * @param precioBase precio base del electrodomestico 
	 * @param color color del electrodomestico (blanco, negro, rojo, azul y gris)
	 * @param consumoEnergetico Rango entre A y F del consumo energetico
	 */
	Electrodomestico (int precioBase, String color, char consumoEnergetico, int peso) {
		this.precioBase = precioBase;
		this.color = comprobarColor(color);
		this.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
		this.peso = peso;
	}


	/**
	 * Metodo comprobarConsumoEnergetico comprueba si la letra es valida
	 * y dentro del rango entre A y F sino asigna F por defecto
	 * @param letra es la que se debe comprobar
	 * @return retorna la letra valida o F por defecto
	 */
	private char comprobarConsumoEnergetico(char letra) {
		//Arreglo ascii con rango de numero entre A y F
		int [] ascii = {65, 66, 67, 68, 69, 70}; 
		boolean esLetra = false;
		for (int e: ascii) {
			if ((char)e == letra) {
				esLetra = true;
			}
		}
		if (esLetra) {
			return letra;
		} else {
			return 'F';
		}
	}
	
	
	/**
	 * Metodo comprobarColor, valida si el color ingresado es valido
	 * sino asigna por defecto el color blanco y retorna el color
	 * @param color color que se valida
	 * @return retorna el color
	 */
	private String comprobarColor(String color) {
		//Arreglo con colores validos
		String [] colores = {"blanco", "negro", "rojo", "azul", "gris"};
		boolean esColor = false;
		for (String e: colores) {
			if (color.toLowerCase().contentEquals(e)) {
				esColor = true;
			}
		}
		if (esColor) {
			return color.toLowerCase();
		} else {
			return "blanco";
		}
	}
	
	/**
	 * Metodo actualizarPrecio actualiza el precio base
	 * dependiendo del consumo energetico y el peso
	 * @return retorna el precio actualizado
	 */
	public int actualizaPrecio () {
		int precioFinal = 0;
		
		if (getConsumoEnergetico() == 'A' ) {
			precioFinal += 100;
		} else if (getConsumoEnergetico() == 'B') {
			precioFinal += 80;
		} else if (getConsumoEnergetico() == 'C') {
			precioFinal += 60;
		} else if (getConsumoEnergetico() == 'D') {
			precioFinal += 50;
		} else if (getConsumoEnergetico() == 'E') {
			precioFinal += 30;
		} else if (getConsumoEnergetico() == 'F') {
			precioFinal += 10;
		}
		
		if (getPeso() >= 0 && getPeso() <= 19) {
			precioFinal += 10;
		} else if (getPeso() >= 20 && getPeso() <= 49) {
			precioFinal += 50;
		} else if (getPeso() >= 50 && getPeso() <= 79) {
			precioFinal += 80;
		} else if (getPeso() >= 80) {
			precioFinal += 100;
		} 
		return precioFinal;
	}
	
	public int getPrecioBase() {
		return precioBase;
	}

	public String getColor() {
		return color;
	}

	public char getConsumoEnergetico() {
		return consumoEnergetico;
	}

	public double getPeso() {
		return peso;
	}
	
	@Override
	public String toString() {
		return "Electrodomestico [precioBase=" + precioBase + ", color=" + color + ", consumoEnergetico="
				+ consumoEnergetico + ", peso=" + peso + "]";
	}

	public abstract int precioFinal();	
}
