import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class FirstWeek {

    public static void main(String[] args) {
        System.out.println(isPrime(7));
        System.out.println(isInArray(3, new int[]{1, 2, 3, 4}));
            int[] array = new int[]{1, 2, 3, 4, 5};
            deleteKth(array, 2);
            for (int i = 0; i<array.length;i++){
                System.out.println(array[i]);
            }

    int[] array2 = new int[]{1, 2, 3, 4, 5};
    insertKth(array2, 2, 10);
    for (int i = 0; i<array2.length;i++) {
        System.out.println(array2[i]);
    }

    int[][] array3 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[] sum_col = sumColumns(array3);
    for (int i = 0; i<sum_col.length;i++){
        System.out.println(sum_col[i]);
    }

    int[] max_col = maxOfColumns(array3);
    for (int i = 0; i<max_col.length;i++){
        System.out.println(max_col[i]);
        }

        System.out.println(kThFibonacciIterative(7));

        ;
        for (int i : positiveDivisorsOfANumber(36))
            System.out.println(i);


        System.out.println(iterativeGreatestCommonDivisor(6,18));
    }
















    public static boolean isPrime(int N){
        if (N<2)
            return false;
        for (int i = 2; i<=Math.sqrt(N) ;i++){
            if (N%i==0){
                return false;
            }
        }
        return true;
    }

    public static boolean isInArray(int K, int[] array){
        for (int i = 0; i<array.length;i++){
            if (array[i] == K){
                return true;
            }
        }
        return false;
    }

    public static void deleteKth(int[] array, int k){
     for (int i = k; i<array.length-1 ;i++){
                array[i] = array[i+1];

     }
     array[array.length-1] = 0;

    }

    public static void insertKth(int[] array, int k, int newValue){
    for (int i=array.length-1 ; i>k ;i--){
        array[i]=array[i-1];

    }
    array[k]= newValue;
    }

    public static int[] sumColumns(int[][] array){
    int col_count = array[0].length;                 // - - - -
    int [] sum_col = new int [col_count];

    for (int i = 0; i < array[0].length ;i++){ //i=col, j=row    array[0].length gives column length, array.length gives row length.
        int temp = 0;
        for (int j = 0; j< array.length;j++){
            temp += array[j][i];

        }
        sum_col[i]=temp;
    }
    return sum_col;
    }

    public static int[] maxOfColumns(int[][] array){
       int [] max_col = new int[array[0].length];    // - - -

        for (int col = 0; col<array[0].length ; col++){
            int max_num = Integer.MIN_VALUE;
            for (int row= 0; row< array.length;row++){
                if (max_num < array[row][col])
                    max_num = array[row][col];

            }

            max_col[col]=max_num;

        }
return max_col;
    }

    public static int kThFibonacciIterative(int k){
        if (k<=1) return k;
        int n0=1; int n1=1;
        int fibo = 0;
        for (int i = 2; i<=k ;i++){
            fibo = n0+n1;
            n0=n1;
            n1=fibo;

        }
return fibo;

    }

    public static int[] positiveDivisorsOfANumber(int N){  // 12  -> 1,2,3,4,6,12
        int count = 0;
        for (int i = 1;i<=N;i++){
            if (N%i == 0)
                count++;
        }
         int index =0;
         int [] pos_div = new int[count];
        for (int i=1;i<= N ;i++){

            if (N%i == 0)
                pos_div[index++]=i;

        }

       /* public static int[] findDivisors(int N) {
            List<Integer> divisors = new ArrayList<>();
            for (int i = 1; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    divisors.add(i); // Küçük bölen
                    if (i != N / i) {
                        divisors.add(N / i); // Eşleşen büyük bölen
                    }
                }
            }
            // Listeyi diziye çevirip dönebilirsin
        }
*/

        return pos_div;

    }

    public static int iterativeGreatestCommonDivisor(int a, int b){    //  12 18    -> 6  //EBOB(a, b) = EBOB(b, a mod b).
        while( b !=0 ){

            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    public static int recursiveGreatestCommonDivisor(int a, int b) { //EBOB(a, b) = EBOB(b, a mod b).
        if (b == 0) return a;
        return recursiveGreatestCommonDivisor(b, a % b);
    }

    public static int recursiveSumUntilN(int N) {
        if (N <= 1) return N;
        return N + recursiveSumUntilN(N - 1);
    }

    // Bir sayının rakamlarını rekürsif olarak diziye ayırır.
    public static int[] recursiveDigitsBase10(int N) {
        String s = Integer.toString(N);
        int[] digits = new int[s.length()];
        fillDigits(N, digits, digits.length - 1);
        return digits;
    }

    // recursiveDigitsBase10 için yardımcı metod
    private static void fillDigits(int N, int[] digits, int index) {
        if (index < 0) return;
        digits[index] = N % 10;
        fillDigits(N / 10, digits, index - 1);
    }
}

