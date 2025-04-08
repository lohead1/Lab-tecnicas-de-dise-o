import java.util.ArrayList;

public class eje1 {
	public static boolean potencia(int n) { // metodo para obtener potencia a traves de binarios 
        return n > 0 && (n & (n - 1)) == 0;
	}
	public static boolean impar(int n) { //metodo para obtener numeros impares  
		return n % 2!=0;
	}
	/*
	public boolean potencia2(int o) {
		if(o==1) {
			return true; 
		}
		else if(o>1 &&o<2) {
			return false; 
		}
		else if (o>=2) {
			return potencia2(o/2);
		}
		return false; 
	}
	*/
	public boolean calcular(int []valores) {
		
		int cantidad=valores[0];  // toma en la cantidad en el primer valor del orden 
		int[] evaluar = new int[cantidad]; // nuevo arreglo para evaluar los numeros que pueden ser usados
		int resultado=valores[valores.length-1];  // ultimo valor que va a ser la suma de los demas valores
		ArrayList<Integer>valorest=new ArrayList<>();  // crea el nuevo array donde seran ingresados todos los valores que cumplen 
		
		for(int i=0;i<cantidad;i++) {       // for que recorre el arrelog y los copia a evaluar
			 evaluar[i] = valores[i + 1];
		}
		
		for(int i=0;i<cantidad;i++) {   //recorre todos los valores en el arrelgo evaluar
			int num=evaluar[i];
			
			if(potencia(num)) {   // verifica si un numero es potencia de dos y si los es lo agregag 
				valorest.add(num); 
			}
			else if (num % 5 == 0 && i + 1 < cantidad && impar(evaluar[i + 1])) {    // // Si el número es múltiplo de 5 y el siguiente es impar, se omite
				continue;
			}else if (i > 0 && evaluar[i - 1] % 5 == 0 && impar(num)) {  // Si el anterior es múltiplo de 5 y el actual es impar, también se omite
				continue;
			}else {
				valorest.add(num);
			}
			
		}
		int sumto=0;     // Calcular la suma de los valores seleccionados
		for(int num: valorest) {
			System.out.print(num + " ");
		    sumto += num;
		}
		
		System.out.println("\nla suma es de " +sumto);
		return sumto == resultado;
	}
	  public static void main(String[] args) {
	        eje1 a = new eje1();
	        int[] valores = {4,2,5,7,6,13}; 	        
	        boolean resultado = a.calcular(valores);
	        System.out.println("¿La suma de los valores coincide con el resultado? " + resultado);
	    }
	}

