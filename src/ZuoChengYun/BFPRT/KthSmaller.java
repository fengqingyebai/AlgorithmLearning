package ZuoChengYun.BFPRT;

import java.util.Arrays;

/**
 *
 */
public class KthSmaller {

    private void heapInsert(int[] arr, int index, int val) {
//        arr[index] = val;
        while (index >= 1) {
            int parent = (index - 1) / 2;
            if (arr[parent] < val){
//                swap(arr, parent, index);
                arr[index] = arr[parent];
                index = parent;
            }else {
                break;
            }
        }
        arr[index] = val;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void shiftDown(int[] arr, int k, int value) {
        while (k*2+2 <= arr.length-1) {
            int j = k*2+1;
            if (arr[j] < arr[j+1]) {
                j = j+1;
            }
            if (arr[j] <= value) {
                break;
            }
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = value;
    }

    public int[] solve(int[] arr, int k) {
        int[] maxHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(maxHeap, i, arr[i]);
        }
        System.out.println(Arrays.toString(maxHeap));
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < maxHeap[0]) {
                shiftDown(maxHeap, 0, arr[i]);
            }
        }
        return maxHeap;
    }

    public static void main(String[] args) {
        KthSmaller instance = new KthSmaller();
        int[] arr = {14,7,12,8,15,3,28,6,34,19,10,2,1};
        int[] res = instance.solve(arr, 10);
        System.out.println(Arrays.toString(res));
    }
}
