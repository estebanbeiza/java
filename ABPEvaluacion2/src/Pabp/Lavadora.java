package Pabp;

/**
 * Clase Lavadora contiene los atributos y metodos de la clase Lavadora
 * herada de la clase Electrodomestico
 * @author Esteban Beiza
 * @version 24/02/2020
 * @see <a href="https://github.com/estebanbeiza/java">Versión en Github</a>
 */
public class Lavadora extends Electrodomestico{
	//Atributos de la clase
	private int carga;
	
	/**
	 * Constructor vacio de la clase
	 * asigna los valores por defecto
	 * @param carga representa la carga del electrodomestico
	 */
	Lavadora () {
		super ();
		this.carga = 5;
	}
	
	
	/**
	 * Constructor que acepta precioBase y peso solamente
	 * los demas atributos quedan con el valor por defecto
	 * @param carga representa la carga del electrodomestico
	 */
	Lavadora (int precioBase, int peso) {
		super (precioBase, peso);
		this.carga = 5;
	}
	
	//Constructor todo
	/**
	 * Constructor de la clase que acepta todos los parametros
	 * @param carga representa la carga del electrodomestico
	 */
	Lavadora(int precioBase, String color, char consumoEnergetico, 
			int peso, int carga) {
		super (precioBase, color, consumoEnergetico, peso);
		this.carga = carga;
	}

	public int getCarga() {
		return carga;
	}

	@Override
	public String toString() {
		return super.toString() + " Lavadora [carga=" + carga + "]";
	}

	/**
	 * Metodo precioFinal verifica si la carga es mayor que 30 
	 * y actualiza el precio con el valor correspondiente
	 * retorna el precio del electrodomestico actualizado
	 */
	@Override
	public int precioFinal () {
		int precioFinal = super.actualizaPrecio();
		if (getCarga() > 30) {
			precioFinal += super.getPrecioBase() + 50;
		} else {
			precioFinal += super.getPrecioBase();
		}
		return precioFinal;
	}
		
}
