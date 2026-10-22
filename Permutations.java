import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        // Start the recursive backtracking process
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentPermutation, int[] nums) {
        // Base Case: If the current permutation contains all elements, add it to the result list
        if (currentPermutation.size() == nums.length) {
            // Create a new copy of currentPermutation because lists are passed by reference
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        // Explore choices for the next position in the permutation
        for (int num : nums) {
            // Skip elements that are already used in the current permutation
            if (currentPermutation.contains(num)) {
                continue;
            }

            // 1. CHOOSE: Add the current element to our temporary list
            currentPermutation.add(num);

            // 2. EXPLORE: Recurse to build the rest of the permutation
            backtrack(result, currentPermutation, nums);

            // 3. UNCHOOSE: Backtrack by removing the last added element
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
