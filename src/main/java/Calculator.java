import java.util.ArrayList;
import java.util.Arrays;

public class Calculator {

    int Add (String numbers){
        ArrayList<String> nums = new ArrayList<>(Arrays.stream(numbers.split("\\n",2)).toList());
        String delimiter = ",";

        if(nums.get(0).contains("//")){
            delimiter = nums.get(0).replace("//","");
            nums.remove(0);
        }else{
            nums.set(0,numbers);
        }

        nums = new ArrayList<>(Arrays.stream(nums.get(0).split("(\\n)|("+delimiter+")")).toList());
        if(nums.stream().findFirst().get().isEmpty()) return 0;
        return nums.stream().mapToInt(Integer::parseInt).sum();
    }
}