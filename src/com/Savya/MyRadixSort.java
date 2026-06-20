package com.Savya;

public class MyRadixSort {

    static void countingSort(int arr[], int exp) {
        int n = arr.length;
        int output[] = new int[n];
        int count[] = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }

    static void printArray(int arr[]) {
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {120, 45, 9, 632, 78, 211};

        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)
                max = arr[i];

        int pass = 1;

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);

            if (pass == 1)
                System.out.print("After Ones Digit Pass: ");
            else if (pass == 2)
                System.out.print("After Tens Digit Pass: ");
            else if (pass == 3)
                System.out.print("After Hundreds Digit Pass: ");

            printArray(arr);
            pass++;
        }

        System.out.print("Final Sorted Array: ");
        printArray(arr);
    }
}