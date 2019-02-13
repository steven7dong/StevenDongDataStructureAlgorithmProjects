
public class QuickSort {

    public static void main(String[] args) {
        int[] l = {300, 190, 198, 326, 257, 193, 176, 393, 307, 364, 327, 203, 315, 189, 308, 313, 152, 126, 144, 216, 385};
        quickSort(l);
        for (int i = 0; i < l.length; i++){
            System.out.print(l[i] + " ");
        }
        System.out.println();
    }

    public static class ResultType{

        private int left;
        private int right;

        public ResultType(int right, int left){
            this.left = left;
            this.right = right;
        }
    }

    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);

    }

    public static void quickSort(int[] array, int start, int end){
        if (end <= start){
            return;
        }
        ResultType rt = partition(array, start, end);
        quickSort(array, start, rt.right);
        quickSort(array, rt.left, end);
    }

    public static ResultType partition(int[] array, int start, int end){
        int left = start;
        int right = end;

        int pivot = (start + end) / 2;
        while (left <= right){
            while (left <= right && array[left] < array[pivot]){
                left++;
            }
            while (left <= right && array[right] > array[pivot]){
                right--;
            }
            if (left <= right){
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;
            }
            left++;
            right--;
        }
        return new ResultType(right, left);
    }
}
