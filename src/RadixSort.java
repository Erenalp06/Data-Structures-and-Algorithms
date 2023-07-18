import java.util.Arrays;
import java.util.List;

public class RadixSort {

    private static void countSort(int[] arr, int exp) {
        int[] countArray = new int[10];
        int[] output = new int[arr.length];

        int offset = Math.abs(Arrays.stream(arr).min().getAsInt());

        for (int item : arr) {
            int x = ((item + offset) / exp) % 10;
            countArray[x]++;
        }

        for (int i = 1; i < countArray.length; i++) {
            countArray[i] += countArray[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            int item = arr[i];
            int newPosition = countArray[((item + offset) / exp) % 10] - 1;
            output[newPosition] = item;
            countArray[((item + offset) / exp) % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void sort(int[] arr) {

        long posCount = Arrays.stream(arr).filter(num -> num > 0).count();

        int[] posDigits = new int[(int) posCount];
        int[] negDigits = new int[arr.length - (int) posCount];

        int posIndex = 0;
        int negIndex = 0;

        for(int item : arr){
            if(item >= 0){
                posDigits[posIndex] = item;
                posIndex++;
            }else{
                negDigits[negIndex] = item;
                negIndex++;
            }
        }


        int maxValue = Arrays.stream(arr).max().getAsInt();

        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countSort(posDigits, exp);
            countSort(negDigits, exp);
        }

        int[] resultDigits = new int[posDigits.length + negDigits.length];

      System.arraycopy(negDigits, 0, resultDigits, 0, negDigits.length);
      System.arraycopy(posDigits, 0, resultDigits, negDigits.length, posDigits.length);

      System.arraycopy(resultDigits, 0, arr, 0, arr.length);
    }
}
