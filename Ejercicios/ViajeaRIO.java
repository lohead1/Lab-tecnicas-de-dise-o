package sesion4;

public class ViajeaRIO {

	    static final int X = Integer.MAX_VALUE;

	    public static void calcularCostosYPredecesores(int[][] T, int[][] C, int[][] P) {
	        int n = T.length;

	        /*
	         * inicializamos las matrices C y P con valores de T
	         * si no hay un camino directo la matriz P se marca sin predecesor
	         */
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < n; j++) {
	                if (i == j) {
	                    C[i][j] = 0; //el costo de ir de un node a si mismo es 0
	                    P[i][j] = -1; //como es el mismo nodo no hay predecesor
	                } else {
	                    C[i][j] = T[i][j];
	                    P[i][j] = (T[i][j] != X) ? i : -1;
	                }
	            }
	        }
	        
	        /*
	         * 1er for recorre los nodos de derecha a izquierda, para recorrer las matrices en un orden
	         * 2do for compara los costos de ir de i a j utilizando nodo intermedio k
	         * 3er for compara si el costo de ir de i a j pasando por k es menor que es costo directo
	         * if -> nos asegura que solo se consideren las rutas validad (que no esten marcadas como X
	         * 
	         */

	        for (int i = n - 1; i >= 0; i--) {
	            for (int j = i + 1; j < n; j++) {
	                for (int k = i + 1; k < j; k++) {
	                    if (T[i][k] != X && C[k][j] != X) {
	                        int nuevoCosto = T[i][k] + C[k][j];
	                        if (nuevoCosto < C[i][j]) {
	                            C[i][j] = nuevoCosto;
	                            P[i][j] = k;
	                        }
	                    }
	                }
	            }
	        }
	    }

	    public static void imprimirMatriz(int[][] matriz) {
	        for (int[] fila : matriz) {
	            for (int val : fila) {
	                if (val == X) System.out.print("X ");
	                else if (val == -1) System.out.print("P ");
	                else System.out.print(val + " ");
	            }
	            System.out.println();
	        }
	    }

	    public static void main(String[] args) {
	        int[][] T = {
	            {0, 3, 10, X},
	            {X, 0, 1, 7},
	            {X, X, 0, 2},
	            {X, X, X, 0}
	        };

	        int n = T.length;
	        int[][] C = new int[n][n];
	        int[][] P = new int[n][n];

	        calcularCostosYPredecesores(T, C, P);

	        System.out.println("Matriz de Costos Mínimos:");
	        imprimirMatriz(C);

	        System.out.println("\nMatriz de Predecesores (P):");
	        imprimirMatriz(P);
	    }
	

}

