import java.util.Arrays;

public class Sorter {

	public static int[] sortMax(double[] arr) {
		int[] indexes = new int[arr.length];
		
		
		for (var j = 0; j < arr.length; j++) {
			double cur = -1;
			int curPos = 1;
			for (var k = 0; k < arr.length; k++) {
				int c = k;
				if (!Arrays.stream(indexes).anyMatch(i -> i == c+1) && (arr[c]> cur)) {
					curPos = c;
					//System.out.println(cur);
					cur = arr[c];
				}
			}
			//System.out.println(cur);
			//System.out.println(curPos);
			indexes[j] = curPos+1;
		}
		
		for (var i = 0; i < indexes.length; i++) {
			indexes[i] -=1;
		}
		
		return indexes;
	}
	
}
