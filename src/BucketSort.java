import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {

    static void sort(float[] arr){

        if(arr.length <= 0){
            return;
        }

        ArrayList<Float>[] negativeBuckets = new ArrayList[arr.length];
        ArrayList<Float>[] positiveBuckets = new ArrayList[arr.length];

        for(int i = 0; i < arr.length; i++){
            negativeBuckets[i] = new ArrayList<>();
            positiveBuckets[i] = new ArrayList<>();
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 0){
                int index = (int)(arr[i] * arr.length);
                positiveBuckets[index].add(arr[i]);
            }else{
                int index = (int)(Math.abs((arr[i] * arr.length)));
                negativeBuckets[index].add(arr[i]);
            }
        }

        for(int i = 0; i < arr.length; i++){
            Collections.sort(positiveBuckets[i]);
            Collections.sort(negativeBuckets[i], Collections.reverseOrder());
        }

        int index = 0;
        for(int i = arr.length - 1; i >= 0; i--){
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
