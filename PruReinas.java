/*	Inteligencia Artificial
 *	Alumno: Santos Gonzalez Miguel Angel
 *	Problema de las 8 reinas
 */

import java.util.*;

public class PruReinas {

	public static void main(String[] Reinas) {
		OchoReinas reinas= new OchoReinas(8);
		reinas.soluciones();
		ArrayList solucion = reinas.dameSoluciones();
		for (int i = 0; i<solucion.size();i++){
			int[] apoyo  = (int[]) solucion.get(i);
			System.out.println("Solucion Número" + (i+1) + ":");
			for (int j = 0; j<apoyo.length;j++){
				System.out.print("(" + (j+1) + "," + (apoyo[j]+1) + ")");
			}
			System.out.println("");
		}

	}
}
