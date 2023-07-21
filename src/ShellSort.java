public class ShellSort {
    public static void sort(int[] arr){
        for(int interval = arr.length / 2; interval > 0; interval /= 2){
            for(int i = interval; i < arr.length; i++){
                int temp = arr[i];
                int j;
                for(j = i; j >= interval && arr[j - interval] > temp; j -= interval){
                    arr[j] = arr[j - interval];
                }
                arr[j] = temp;
            }
        }
    }
}
