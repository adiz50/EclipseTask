import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    int Add (String numbers){
        ArrayList<String> nums = new ArrayList<>(Arrays.stream(numbers.split(",")).toList());
        if(nums.stream().findFirst().get().isEmpty()) return 0;
        return nums.stream().mapToInt(Integer::parseInt).sum();
    }
}