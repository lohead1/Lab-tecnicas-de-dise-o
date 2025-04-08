package sesion4;

public class BinarySearch {

    int binarySearch(int arr[], int lo, int hi, int x) {
        if (hi >= lo && lo < arr.length) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, lo, mid - 1, x);

            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {1, 2, 3, 4, 5};
        int x = 2;

        int position = ob.binarySearch(arr, 0, arr.length - 1, x);

        if (position == -1)
            System.out.println("¡elemento no encontrado");
        else
            System.out.println("elemento encontrado en el indice: " + position);
    }
}




