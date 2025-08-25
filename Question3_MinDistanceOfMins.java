public class Question3_MinDistanceOfMins {
    public static int distanceBetweenClosestMinimums(int[] arr){
        int min = Integer.MAX_VALUE;

        //step 1: Find the minimum value
        for(int num : arr){
            if(num < min){
                min = num;
            }
        }
        //step 2 find the smallest distance between two minimums
        int prevIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] == min){
                if(prevIndex != -1){
                    //calculate distance from previous minimum
                    int distance = i - prevIndex;
                    if(distance < minDistance){
                        minDistance = distance;
                    }
                }
                //update previous index to current
                prevIndex = i;
            }
        }
        return minDistance;
    }
//testing the functionality of the distanceBetweenClosestMinimums method
    public static void main(String[] args){
        int[] arr1 = {1, 2, 3, 1, 4, 5, 2};
        System.out.println("Result 1: " + distanceBetweenClosestMinimums(arr1)); // Should print 3
        int[] arr2 = {5, 3, 1, 6, 1, 9, 1};
        System.out.println("Result 2: " + distanceBetweenClosestMinimums(arr2)); // Should print 2
        int[] arr3 = {2, 2, 2, 2};
        System.out.println("Result 3: " + distanceBetweenClosestMinimums(arr3)); // Should print 1
    }
}
