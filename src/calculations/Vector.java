package calculations;

/**
 * Clase Vector
 * @version 1.0 
 */

public class Vector {
	//Declaraci�n de los componentes del vector
	private double i;
	private double j;
	private double k;
	int ID;
	

	//Constructor cuando creas un vector sin parametros
	public Vector() {
		//Se le asiga "0" a todas las componentes
		this.i = 0;
		this.j = 0;
		this.k = 0;
	
	}
	
	//Setter del ID del vector
	public void setID(int VectorID) {
		this.ID=VectorID;
	}
	
	/**
	 * Constructor para que el usuario nos d� valores, el valor de cada vector se guarda en su posici�n 
	 * @param i Valor del vector
	 * @param j Valor del vector
	 * @param k Valor del vector
	 * @param tipo Tipo del vector
	 */
	public Vector(double i, double j, double k) {
		setI(i);
		setJ(j);
		setK(k);
	}


	//Creaci�n de getter's y setter's
	
	/**
	 * M�todo que obtiene la componente I
	 * @return la componente I
	 */
	public double getI() {
		return i;
	}
	
	/**
	 * M�todo que modifique la componente I del Vector
	 * @param i Valor con que el que se sumple la componente I del vector
	 */
	public void setI(double i) {
		this.i = i;
	}
	
	/**
	 * M�todo que obtiene la componente J
	 * @return la componente J
	 */
	public double getJ() {
		return j;
	}
	
	/**
	 * M�todo que modifique la componente J del Vector
	 * @param j Valor con que el que se sumple la componente J del vector
	 */
	public void setJ(double j) {
		this.j = j;
	}

	/**
	 * M�todo que obtiene la componente K
	 * @return la componente K
	 */
	public double getK() {
		return k;
	}
	
	/**
	 * M�todo que modifique la componente K de alg�n Vector
	 * @param k Valor con que el que se sumple la componente J del vector
	 */
	public void setK(double k) {
		this.k = k;
	}
	
	
	
	/*
	 * M�todo para clonar un vector
	 * @return el nuevo vector clonado
	 */
	@Override
	public Vector clone() {
		return new Vector(this.i, this.j, this.k);
	}

	/*
	 * @M�todo que imprime los 3 tipos de Vector
	 */
	@Override
	public String toString() {
		if(i != 0) {
			return  String.format("Vector: <%.2f i, %.2f j, %.2f k> ",i,j,k );
		}
		else {
			return "Vector Neutro: <"+ i + " i, " + j + " j, " + k + " k" + ">" ;
		}
	}
}//fin de la clase

