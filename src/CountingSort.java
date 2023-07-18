import java.util.Arrays;

public class CountingSort {

    public static void sort(int[] arr){
        int maxValue = Arrays.stream(arr).max().getAsInt();
        int minValue = Arrays.stream(arr).min().getAsInt();

        int arrayRange = maxValue - minValue + 1;

        int[] countArray = new int[arrayRange];
        int[] output = new int[arr.length];

        for(int item : arr){
            int x = item - minValue;
            countArray[x]++;
        }

        // cumulative sum

        for(int i = 1; i < countArray.length; i++){
            countArray[i] += countArray[i - 1];
        }

        for(int item : arr){
            int newPosition = countArray[item - minValue] - 1;
            countArray[item - minValue]--;
            output[newPosition] = item;
        }

        System.arraycopy(output, 0, arr, 0, arr.length);
    }
}
