package sesion4;

public class Hanoi {
	
static int contador =1;

	public static void main(String[] args) {
	torresHanoi(5,1,2,3);

}
	
	public static void torresHanoi(int discos, int torre1, int torre2, int torre3){
		if (discos == 1){
			System.out.println("movimiento:  "+ contador++ +" -> mover disco de torre " + torre1 + " a torre " + torre3);
		} else{
				torresHanoi(discos-1, torre1,torre3, torre2);
				System.out.println("movimineto: "+ contador++ +" -> mover disco de torre "+ torre1 + " a torre " + torre3);
				torresHanoi(discos-1, torre2, torre1, torre3);
		}
	}

}

