package Pabp;

/**
 * Clase Television contiene los atributos y metodos de la clase Television
 * herada de la clase Electrodomestico
 * @author Esteban Beiza
 * @version 24/02/2020
 * @see <a href="https://github.com/estebanbeiza/java">Versión en Github</a>
 */
public class Television extends Electrodomestico {
	//Atributos de la clase
	private int resolucion;
	private boolean sintonizadorTDT;
	
	//Constructor por defecto
	/**
	 * Constructor vacio de la clase
	 * asigna los valores por defecto
	 * @param resolucion double que corresponde a la resolucion
	 * @param sintonizadorTDT booleano que indica si tiene o no esa caracteristica
	 */
	Television () {
		super();
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}
	
	
	/**
	 * Constructor que acepta precioBase y peso solamente
	 * los demas atributos quedan con el valor por defecto
	 * @param resolucion double que corresponde a la resolucion
	 * @param sintonizadorTDT booleano que indica si tiene o no esa caracteristica
	 */
	Television (int precioBase, int peso) {
		super (precioBase, peso);
		this.resolucion = 20;
		this.sintonizadorTDT = false;
	}
	
	
	/**
	 * Constructor de la clase que acepta todos los parametros
	 * @param carga representa la carga del electrodomestico
	 * @param resolucion double que corresponde a la resolucion
	 * @param sintonizadorTDT booleano que indica si tiene o no esa caracteristica
	 */
	Television (int precioBase, String color, char consumoEnergetico, int peso,
				int resolucion, boolean sintonizadorTDT) {
		super (precioBase, color, consumoEnergetico, peso);
		this.resolucion = resolucion;
		this.sintonizadorTDT = sintonizadorTDT;
		
	}
	
	
	//Metodos Getters
	public int getResolucion() {
		return resolucion;
	}

	public boolean isSintonizadorTDT() {
		return sintonizadorTDT;
	}

	//Metodo toString
	@Override
	public String toString() {
		return super.toString() + " Television [resolucion=" + resolucion + ", sintonizadorTDT=" + sintonizadorTDT + "]";
	}

	/**
	 * Metodo precioFinal verifica si la resolucion es mayor que 40
	 * verifica si contiene sintonizadorTDT y actualiza el precio 
	 * con el valor correspondiente, por ultimo retorna el precio actualizado
	 */
	@Override
	public int precioFinal () {
		int precioFinal = super.actualizaPrecio();
		
		if (resolucion > 40) {
			precioFinal += (int) (super.getPrecioBase() * 0.3);
		}
		if (sintonizadorTDT) {
			precioFinal += super.getPrecioBase() + 50;
		}
		if (resolucion < 40 && !sintonizadorTDT ) {
			precioFinal += super.getPrecioBase();
		}
		
		return precioFinal;
	}
	
}
