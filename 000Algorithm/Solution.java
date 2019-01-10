import java.util.Map;
import java.util.HashMap;
public class Solution{
	public static void main(String[] args){
		int[] arr = {2, 7, 11, 15};
		int target =9;
		Solution solution = new Solution();
		int[] result = solution.twoSum(arr,target);
		System.out.println(result[0]+","+result[1]);
	}
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (map.containsKey(target - numbers[i])) {
				result[1] = i;
				result[0] = map.get(target - numbers[i]);
				return result;
			}
			map.put(numbers[i], i);
		}
		return result;
	}
}