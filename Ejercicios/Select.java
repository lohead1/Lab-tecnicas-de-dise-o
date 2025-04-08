public class Select {
    public static int menorElem(int[] arr, int k){
        return quickSelect(arr, 0, arr.length - 1, k-1);
    }

    private static int quickSelect(int[] arr, int low, int high, int k){

        //Caso base
        if(low == high) return arr[low];

        int pivIndex = high; //El pivote es el ultimo indice del arreglo o subArreglo

        //Particion del arreglo
        pivIndex = particion(arr, low, high, pivIndex);

        //Casos
        if(pivIndex == k){
            return arr[k];
        }else if (pivIndex > k) {
            return quickSelect(arr, low, pivIndex - 1, k);
        }else{
            return quickSelect(arr, pivIndex + 1, high, k);
        }
    }

    //Se encarga de reorganizar el arreglo
    private static int particion(int[] arr, int low, int high ,int piv){
        /*
         * Recorre el arreglo hasta un indice menor que pivote
         * "low" representa el indice del primer elemento de arreglo o subarreglo
         * "high" representa el indice del ultimo elemento de arreglo o subarreglo
         * "piv" indice del pivote
         */

        int piValue = arr[piv]; //Valor del pivote
        int pivIndex = low; //indica el valor donde se encuentra el pivote
        
        //Recorrer el arreglo
        for (int i = low; i < high; i++) {
        
            //Debug
            /* 
            System.out.println("Piv" + piValue);
            System.out.println("Piv Index" + pivIndex);
            */

            if(arr[i] < piValue){
                //Intercambio
                swap(arr, i, pivIndex);
                pivIndex++; //Incrementa el valor del indice final del pivote
            }
        }

        //Intercambio Final con la posicion final del pivote
        swap(arr, pivIndex, high);
        return pivIndex;

    }

    //Intercambio de elementos
    private static void swap(int[] arr, int i, int pivIndex){
        int temp = arr[i];
        arr[i] = arr[pivIndex];
        arr[pivIndex] = temp;
        
    }
}
