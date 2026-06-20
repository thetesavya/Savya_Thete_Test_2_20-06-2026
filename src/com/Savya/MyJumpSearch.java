package com.Savya;

public class MyJumpSearch {
    public static void main(String[] args) {
        int[] arr = {2, 6, 10, 14, 18, 22, 26, 30, 34, 38, 42, 46};
        int target = 34;

        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int prev = 0;

        System.out.println("Jump Search Trace:");

        while (prev < n && arr[Math.min(step, n) - 1] < target) {
            System.out.println("Jumping to block: Index " + prev + " to " + (Math.min(step, n) - 1));
            prev = step;
            step += (int) Math.sqrt(n);

            if (prev >= n) {
                System.out.println("Target not found");
                return;
            }
        }

        System.out.println("Searching in block: Index " + prev + " to " + (Math.min(step, n) - 1));

        while (prev < Math.min(step, n)) {
            System.out.println("Checking index " + prev + " : " + arr[prev]);

            if (arr[prev] == target) {
                System.out.println("Target found at index " + prev);
                return;
            }

            prev++;
        }

        System.out.println("Target not found");
    }
}