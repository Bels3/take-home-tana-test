import java.util.*;

public class Question2_UniqueSums {
    public static int countUniqueSums(int[] nums, int target){
        Set<String> uniqueCombos = new HashSet<>();//initialize a set to store unique combinations
        Arrays.sort(nums);
        backtrack(nums, target, 0, new ArrayList<>(), uniqueCombos);//this finds the combinations
        return uniqueCombos.size();
    }

    private static void backtrack(int[] nums, int target, int start, List<Integer> current, Set<String> result){
if(target == 0){
    List<Integer> sorted =new ArrayList<>(current);
    Collections.sort(sorted);
    String key = sorted.toString();
    result.add(key);//add the sorted combination as a key to the set
    return;
}
      for(int i = start; i < nums.length; i++){
                if(nums[i] > target) continue; //skip if number exceeds target
                current.add(nums[i]);
                backtrack(nums, target - nums[i], i + 1, current, result); //i + 1 to avoid reusing the same number
                current.remove(current.size() - 1); //backtrack
            }
    }
//Testing the functionality of the countUniqueSums method
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int target1 = 10;
        System.out.println("Result 1: " + countUniqueSums(arr1,target1));   // should be 3

        int[] arr2 = {1, 2, 4, 7, 5};
        int target2 = 17;
        System.out.println("Result 2: " + countUniqueSums(arr2,target2));   // should be 1
    }
}
