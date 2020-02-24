package Pabp;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta es la clase que realiza las acciones agrega a un array objetos de electrodomesticos
 * luego se recorre el array se usa el metodo precioFinal de cada clase
 * para obtener el precio actualizado de cada articulo 
 * @author: Esteban Beiza
 * @version: 19/02/2020
 * @see <a href="https://github.com/escribir direccion del github contenedor">Versión en Github</a>
 */
public class Ejecutable {

	/**
	 * Metodo main de la clase
	 */
	public static void main(String[] args) {
		//Array de la clase Electrodomesticos que guardara los artiuclos
		List<Electrodomestico> articulos = new ArrayList<Electrodomestico>();
		//contadores donde se sumaran los precios de cada clase y el total
		int sumTv = 0, sumLav = 0, sumElec = 0;
		//contador para mostrar el numero del electrodomestico
		int contElec = 1;
		
		//instanciamos objetos de Electrodomestico y los agregamos al Array
		for (int i = 0; i < 10; i++) {
			if (i < 2) {
				Lavadora lav1 = new Lavadora();
				articulos.add(lav1);
			} else if (i < 4) {
				Television tv1 = new Television();
				articulos.add(tv1);
			} else if (i < 6) {
				Lavadora lav1 = new Lavadora(130000, 10 + i);
				articulos.add(lav1);
			} else if (i < 7) {
				Lavadora lav1 = new Lavadora(130000, 10 + i);
				articulos.add(lav1);
			} else if (i < 8) {	
				Television tv1 = new Television(200000, "GrIs", 'A', 19 + i, 25, false);
				articulos.add(tv1);
			} else if (i < 9) {
				Electrodomestico tv2 = new Television(200000, "NeGRO", 'E', 20, 40, true);
				articulos.add(tv2);
			} 
			else {
				Electrodomestico tv2 = new Television(200000, "morado", 'E', 20, 41, true);
				articulos.add(tv2);
			}
		}
		
		/*
		 * recorremos el arreglo creado, mostramos articulos 
		 * sumamos los precios de Televisores, lavadoras y 
		 * el total de ambos usando metodo precioFinal() de cada clase
		 */
		for (Electrodomestico e: articulos) {
			//System.out.println(e);
			System.out.println("-----------------------------------");
			System.out.println("Articulo " + contElec++);
			System.out.println("-----------------------------------");
	
			if (e instanceof Television) {
				System.out.println("Television");
				System.out.println("Resolucion        : " + ((Television) e).getResolucion());
				System.out.println("Sintonizador TDT  : " + ((Television) e).isSintonizadorTDT());
				sumTv += e.precioFinal();
				
			} else if (e instanceof Lavadora) {
				System.out.println("Lavadora");
				System.out.println("Carga             : " + ((Lavadora) e).getCarga());
				sumLav += e.precioFinal();
			}
			sumElec += e.precioFinal();
			
			System.out.println("Color             : " + e.getColor());
			System.out.println("Consumo Energetico: " + e.getConsumoEnergetico());
			System.out.println("Peso              : " + e.getPeso());
			System.out.println("Precio Base       : " + e.getPrecioBase());
			System.out.println("Precio final      : " + e.precioFinal());
			System.out.println("-----------------------------------\n\n");
		}
		
		/*
		 * Mostramos la suma del precio de cada electrodomestico
		 * y la suma del precio de todos los electrodomesticos
		 */
		
		System.out.println("\n\nPrecio total de Televisores      : " + sumTv);
		System.out.println("Precio total de lavadoras        : " + sumLav);
		System.out.println("Precio total de Electrodomesticos: " + sumElec);
		
	}

}
