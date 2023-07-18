import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

//        int[] data = {11, 16, 8, 7, 7};
//        int[] data = {170, 45, 75, 90, 2, 24, 802, 66, 2};
//        int[] data = {-5, 2, -9, 3, 0, 1, 7, -4, 6, -8};

//        int[] data1 = {90, 170, 802, 2, 24, 75, 45, 66};

//        System.out.println("Data: " + Arrays.toString(data));

        /*BubbleSort.bubbleSort(data);

        System.out.println("Sorted Data: " + Arrays.toString(data));*/

        /*InsertionSort.sort(data);

        System.out.println("Insertion Sorted Data: " + Arrays.toString(data));*/

        /*QuickSort.sort(data, 0, data.length-1);

        System.out.println("Quick Sorted Data: " + Arrays.toString(data));*/

        /*MergeSort.mergeSort(data);

        System.out.println("Sorted Array : " + Arrays.toString(data));*/

        /*SelectionSort.sort(data);

        System.out.println("Data: " + Arrays.toString(data));*/

        /*CountingSort.sort(data);

        System.out.println("Sorted Data : " + Arrays.toString(data));*/

        float[] data = {0.43f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        float[] data1 = {-0.2f, -0.5f, -0.1f, -0.3f, -0.4f};
        float[] data2 = {-0.2f, -1.47f, 6.4f, 2f, -1f};
        float[] arr = {-4.5f, -2.3f, -7.0f, -1.1f};
        float[] arr1 = {3.2f, -2.5f, 1.7f, -4.8f, 2.0f, -1.0f};
        float[] arr2 = {1f, 1.01f, 1f, 1f, 1f, 1f};
        float[] arr3 = {-10000.0f, -5000.0f, -20000.0f, -15000.0f};

        BucketSort.sort(arr1);

        System.out.println("Sorted data : " + Arrays.toString(arr1));


    }

    static void radixSortTest(){

        // Radix Sort Tests

        int[] data1 = {9, 7, 1, 5, 3, 8, 2, 4, 6};
        int[] data2 = {-9, -7, -1, -5, -3, -8, -2, -4, -6};
        int[] data3 = {5, -2, 9, -7, 0, -1, 3, -4, 6, -8};
        int[] data4 = {123, 456, 789, 987, 654, 321, 879, 345, 678, 912};
        int[] data5 = {5, 2, 5, 7, 2, 1, 1, 7, 2, 5};
        int[] data6 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        CountingSort.sort(data1);
        CountingSort.sort(data2);
        CountingSort.sort(data3);
        CountingSort.sort(data4);
        CountingSort.sort(data5);
        CountingSort.sort(data6);

        System.out.println("Sorted Data1 : " + Arrays.toString(data1));
        System.out.println("Sorted Data2 : " + Arrays.toString(data2));
        System.out.println("Sorted Data3 : " + Arrays.toString(data3));
        System.out.println("Sorted Data4 : " + Arrays.toString(data4));
        System.out.println("Sorted Data5 : " + Arrays.toString(data5));
        System.out.println("Sorted Data6 : " + Arrays.toString(data6));
    }

    static void radixSortTestByTime() {
        // Radix Sort Tests

        int[] data = new int[100];
        Random random = new Random();

        for (int i = 0; i < data.length; i++) {
            // Rastgele değerler için -1000 ile 1000 arasında bir aralık kullanıyoruz
            data[i] = random.nextInt(2001) - 1000;
        }

        int[] data1 = {9, 7, 1, 5, 3, 8, 2, 4, 6};
        int[] data2 = {-9, -7, -1, -5, -3, -8, -2, -4, -6};
        int[] data3 = {5, -2, 9, -7, 0, -1, 3, -4, 6, -8};
        int[] data4 = {123, 456, 789, 987, 654, 321, 879, 345, 678, 912};
        int[] data5 = {5, 2, 5, 7, 2, 1, 1, 7, 2, 5};
        int[] data6 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        long startTime, endTime, elapsedTime;

        // Test data
        startTime = System.nanoTime();
        CountingSort.sort(data);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println(" - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data1
        startTime = System.nanoTime();
        CountingSort.sort(data1);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data1 : " + Arrays.toString(data1) + " - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data2
        startTime = System.nanoTime();
        CountingSort.sort(data2);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data2 : " + Arrays.toString(data2) + " - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data3
        startTime = System.nanoTime();
        CountingSort.sort(data3);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data3 : " + Arrays.toString(data3) + " - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data4
        startTime = System.nanoTime();
        CountingSort.sort(data4);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data4 : " + Arrays.toString(data4) + " - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data5
        startTime = System.nanoTime();
        CountingSort.sort(data5);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data5 : " + Arrays.toString(data5) + " - Time elapsed: " + elapsedTime + " nanoseconds");

        // Test Data6
        startTime = System.nanoTime();
        CountingSort.sort(data6);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;
        System.out.println("Sorted Data6 : " + Arrays.toString(data6) + " - Time elapsed: " + elapsedTime + " nanoseconds");
    }

}