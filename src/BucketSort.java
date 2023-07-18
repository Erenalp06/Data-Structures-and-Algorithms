import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {

    static void sort(float[] arr){

        if(arr.length <= 0){
            return;
        }

        float max = arr[0];
        float min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
        }

        ArrayList<Float>[] negativeBuckets = new ArrayList[arr.length];
        ArrayList<Float>[] positiveBuckets = new ArrayList[arr.length];

        for(int i = 0; i < arr.length; i++){
            negativeBuckets[i] = new ArrayList<>();
            positiveBuckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < arr.length; i++) {
            int index;
            if (arr[i] >= 0) {
                index = (int) ((arr[i] - min) * (arr.length - 1) / (max - min));
                positiveBuckets[index].add(arr[i]);
            } else {
                index = (int) Math.abs(((arr[i] - min) * (arr.length - 1) / (max - min)));
                negativeBuckets[index].add(arr[i]);
            }
        }

         for(int i = 0; i < arr.length; i++){
            Collections.sort(positiveBuckets[i]);
            Collections.sort(negativeBuckets[i]);
        }

        int index = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < negativeBuckets[i].size(); j++){
                arr[index++] = negativeBuckets[i].get(j);

            }
        }

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < positiveBuckets[i].size(); j++){
                arr[index++] = positiveBuckets[i].get(j);
            }
        }
    }


}