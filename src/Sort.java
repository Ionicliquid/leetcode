import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Sort {


    public static void main(String[] args) {
        Integer[] nums = new Integer[]{
                10, 9, 5, 3, 7, 4, 6, 11, 2, 8
        };
//        headSort(nums); 堆排序
//        bubbleSort(nums);  冒泡排序
//        mergeSort(nums); 归并排序
//        quickSort(nums);
//        System.out.print(Arrays.toString(nums));

        Arrays.sort(nums, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("o1 = " + o1 + " o2 = " + o2);
                return o2 - o1;
            }
        });
        System.out.println("xxxx = " + "a".compareTo("b"));
        System.out.print(Arrays.toString(nums));
    }


    public static void bubbleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


    public static void mergeSort(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        mergeSort(nums, left, right);


    }

    private static void mergeSort(int[] nums, int left, int right) {

        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(left, right, mid, nums);
        }


    }

    private static void merge(int left, int right, int mid, int[] nums) {
        int temp[] = new int[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] > nums[j]) {
                temp[k++] = nums[j++];
            } else {
                temp[k++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        for (int p = 0; p < k; p++) {
            nums[left++] = temp[p];
        }
    }

    public static void quickSort(int[] nums) {

        qSort(nums, 0, nums.length - 1);

    }

    private static void qSort(int[] nums, int l, int r) {
        if (l >= r) return;

        int p = partion1(l, r, nums);

        qSort(nums, l, p - 1);
        qSort(nums, p + 1, r);

    }

    // 快排
    private static int partion1(int l, int r, int[] nums) {
        //10, 9, 5, 3, 7, 4, 6, 11, 2, 8

        swap(l, (int) Math.random() * (r - l + 1) + l, nums);
        int base = nums[l];
        int j = l;
        for (int k = l + 1; k <= r; k++) {
            if (base > nums[k]) {
                j++;
                swap(k, j, nums);
            }


        }
        swap(l, j, nums);
        return j;
    }

    // 二路快排
    private static int partion(int l, int r, int[] nums) {
//        10, 9, 5, 3, 7, 4, 6, 11, 2, 8


        swap(l, (int) Math.random() * (r - l + 1) + l, nums);

        int base = nums[l];
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= r && nums[i] < base) i++;
            while (j >= l && nums[j] > base) j--;
            if (i > j) break;
            swap(i++, j--, nums);

        }
        swap(l, j, nums);

        return j;
    }


    public static void headSort(int[] nums) {
        int size = nums.length;
        buildHeap(nums);
        for (int i = 0; i < nums.length; i++) {
            swap(0, size - 1, nums);
            size--;
            maxHeap(0, nums, size);
        }
    }

    private static void buildHeap(int[] nums) {
        for (int i = nums.length / 2; i >= 0; i--) {
            maxHeap(i, nums, nums.length);
        }
    }

    private static void maxHeap(int i, int[] nums, int length) {
        int l = i * 2;
        int r = i * 2 + 1;
        int largest = i;
        if (l < length && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < length && nums[r] > nums[largest]) {
            largest = r;
        }
        if (i != largest) {
            swap(i, largest, nums);
            maxHeap(largest, nums, length);
        }
    }

    private static void swap(int i, int largest, int[] nums) {
        if (i != largest) {
            int temp = nums[i];
            nums[i] = nums[largest];
            nums[largest] = temp;
        }


    }


}
