public class QuickSelect {

    public static void main(String[] args){
        int[] l = {1, 3, 4, 2, 7};
        System.out.print(quickSelect(l, 3));
    }

    public static int quickSelect(int[] array, int k){
        return quickSelect(array, 0, array.length - 1, k);
    }

    public static int quickSelect(int[] array, int start, int end, int k) {
        if (start == end) {
            return array[start];
        }

        int left = start;
        int right = end;
        int pivot = array[(start + end) / 2];
        while (left <= right) {
            while (left <= right && array[left] > pivot) {
                left++;
            }
            while (left <= right && array[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
            left++;
            right--;
        }
        if (start + k - 1 <= right) {
            quickSelect(array, start, right, k);
        } else if (start + k - 1 >= left) {
            quickSelect(array, left, end, k - right - 1);
        }
        return array[k];
    }
}
