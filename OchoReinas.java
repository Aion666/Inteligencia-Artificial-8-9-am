/*	Inteligencia Artificial
 *	Alumno: Santos Gonzalez Miguel Angel
 *	Problema de las 8 reinas
 */

import java.util.*;

public class OchoReinas {

	int v; 
	int[] solucion;
	ArrayList soluciones = new ArrayList();
	boolean[] diagonalSuperior;
	boolean[] diagonalInferior;
	boolean[] horizontal;
	boolean[] vertical;
	boolean soluc, siSolucion;
	
	
	public void encontrarSolucion (int fila){
		int col = 0;
		while (col < v && !siSolucion){
			if (horizontal[fila] && vertical[col] && diagonalInferior[col-fila+v-1] && diagonalSuperior[col+fila]){

				solucion[fila] = col;
				horizontal[fila] = false;
				vertical[col] = false;
				diagonalInferior[col-fila+v-1] = false;
				diagonalSuperior[col+fila] = false;

				if (fila == v-1 && solucionNueva(this.solucion)){
					siSolucion = true;
				}else{
					if (fila+1 < v ){
						encontrarSolucion(fila+1);	
					}
					if (!siSolucion){					
						solucion[fila] = -1;
						horizontal[fila] = true;
						vertical[col] = true;
						diagonalInferior[col-fila+v-1] = true;
						diagonalSuperior[col+fila] = true;

					}
				}
			}
			col++;
		}
	}
	
	public void buscarUnaSolucion(){
		encontrarSolucion(0);
		agregarSolucion();
	}
	
	public void empezar(){
		this.horizontal = new boolean[v];
		this.vertical = new boolean[v];
		this.solucion = new int[v];
		for (int i = 0; i<v;i++){
			this.horizontal [i] = true;
			this.vertical [i] = true;
			this.solucion [i] = -1;
		}
		this.diagonalInferior = new boolean[2*v-1];
		this.diagonalSuperior = new boolean[2*v-1];
		for (int i = 0; i<2*v-1;i++){
			this.diagonalInferior[i] = true;
			this.diagonalSuperior[i] = true;
		}
		siSolucion = false;
	}
	
	public ArrayList dameSoluciones(){
		return this.soluciones;
	}	
	
	public boolean solucionNueva(int[] nuevaSolucion){
		if (nuevaSolucion[0] == -1) return false;
		boolean esNueva = true;
		int i = 0;
		while (i<soluciones.size() && esNueva){ 
			int[] unaSol = (int[]) soluciones.get(i);
			esNueva = !iguales(unaSol,nuevaSolucion);
			i++;
		}

		return esNueva;
	}
	
	public void agregarSolucion(){
		soluciones.add(this.solucion);	
	}
	
	public void soluciones(){
		boolean flag = true;
		while(flag){
			encontrarSolucion(0);
			if (solucionNueva(solucion)){
				flag = true;
				agregarSolucion();
				
			} else{
				flag = false;
			}
			empezar();
		}
	}
	
	public  boolean iguales (int[] a, int[] b){
		int x = 0;
		int y = 0;
		boolean enciende = true;		
		while ((x<a.length) && (y<b.length)){
			if(a[x] != b[y]){
				return false;
			}
			x++;
			y++;			
		}
		return enciende;
	}
	
	public OchoReinas(int tam){
		if (tam < 4) throw new NullPointerException();
		this.v = tam;
		empezar();
	}	
}
