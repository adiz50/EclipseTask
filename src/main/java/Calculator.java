import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Calculator {

    int Add (String numbers) throws Exception {
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
        ArrayList<Integer> numsInt = new ArrayList<>();
        nums.forEach(num -> numsInt.add(Integer.parseInt(num)));

        ArrayList<Integer> negative = new ArrayList<>();
        numsInt.forEach(n -> {
            if(n < 0) negative.add(n);
        });

        if(!negative.isEmpty()) throw new Exception("negatives not allowed: "+ Arrays.toString(negative.toArray()));
        return numsInt.stream().mapToInt(Integer::intValue).sum();
    }
}