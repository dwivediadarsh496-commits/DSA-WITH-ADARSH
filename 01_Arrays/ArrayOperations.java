import java.util.Arrays;

public class ArrayOperations {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static int[] insertElement(int[] arr, int element, int index) {
        if (index < 0 || index > arr.length) return arr;
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < index; i++) newArr[i] = arr[i];
        newArr[index] = element;
        for (int i = index; i < arr.length; i++) newArr[i + 1] = arr[i];
        return newArr;
    }

    public static int[] deleteElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) return arr;
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i == index) continue;
            newArr[j++] = arr[i];
        }
        return newArr;
    }

    public static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Search 30: " + linearSearch(arr, 30));
        reverseArray(arr);
        System.out.println("Reversed: " + Arrays.toString(arr));
    }
}
