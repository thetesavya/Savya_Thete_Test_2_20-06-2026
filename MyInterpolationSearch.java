package com.Savya;

public class MyInterpolationSearch {
    public static void main(String[] args) {
        int[] arr = {10, 18, 26, 34, 42, 50, 58, 66, 74, 82};
        int target = 18;

        int low = 0, high = arr.length - 1;
        int steps = 0;
        boolean found = false;

        while (low <= high && target >= arr[low] && target <= arr[high]) {
            steps++;

            int pos = low + ((target - arr[low]) * (high - low))
                    / (arr[high] - arr[low]);

            System.out.println("Step " + steps +
                    ": low=" + low +
                    ", high=" + high +
                    ", pos=" + pos +
                    ", value=" + arr[pos]);

            if (arr[pos] == target) {
                found = true;
                System.out.println("Target found at index " + pos);
                break;
            }

            if (arr[pos] < target)
                low = pos + 1;
            else
                high = pos - 1;
        }

        if (!found)
            System.out.println("Target not found");

        System.out.println("Total steps = " + steps);
    }
}
