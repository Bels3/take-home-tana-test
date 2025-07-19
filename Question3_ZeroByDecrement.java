public class Question3_ZeroByDecrement {
    public static int canConvertToZero(int[] arr) {
        if (arr.length == 1) {
            return 1;
        }
        int totalGcd = arr[0];
        for (int i = 1; i < arr.length; i++) {
            totalGcd = gcd(totalGcd, arr[i]);
        }
        if (arr[0] != totalGcd) {
            return 0; // If the first element is not equal to the GCD, return 0
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] % arr[0] != 0) {
                return 0; // If any element is not divisible by the GCD, return 0
            }
        }

        return 1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;// this finds the remainder
            a = temp;
        }
        return a;
    }
//testing the functionality of the canConvertToZero method
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        System.out.println("Result 1: " + canConvertToZero(arr1));

        int[] arr2 = {1, 1, 2};
        System.out.println("Result 2: " + canConvertToZero(arr2));

        int[] arr3 = {2, 4, 6};
        System.out.println("Result 3: " + canConvertToZero(arr3));

        int[] arr4 = {3, 6, 9};
        System.out.println("Result 4: " + canConvertToZero(arr4));

        int[] arr5 = {2, 3, 5};
        System.out.println("Result 5: " + canConvertToZero(arr5));

    }
}
