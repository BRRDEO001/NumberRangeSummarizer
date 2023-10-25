package numberrangesummarizer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Werner
 *
 * Implement this Interface to produce a comma delimited list of numbers,
 * grouping the numbers into a range when they are sequential.
 *
 *
 * Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
 * Result: "1, 3, 6-8, 12-15, 21-24, 31"
 *
 * The code will be evaluated on
 *   - functionality
 *   - style
 *   - robustness
 *   - best practices
 *   - unit tests
 */

public class RangeSummarizer implements NumberRangeSummarizer{


    @Override
    public Collection<Integer> collect(String input) {
        Collection<Integer> numbers = new ArrayList<>();

        if (input.isEmpty()){
            return numbers;
        }

        String [] strNumbers = input.split(",");

        for (String i : strNumbers){
            numbers.add(Integer.parseInt(i));
        }

        return numbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        StringBuilder collectionSummary = new StringBuilder();

        if (input.isEmpty()){
            return null;
        }

        ArrayList<Integer> newList = new ArrayList<>(input);
        Collections.sort(newList);
        int expected,actual,rangeEnd;
        int rangeStart = newList.get(0);



        for(int i = 0; i < newList.size(); i++){

            if(i != newList.size()-1){ //not end of array
                expected = newList.get(i) +1;
                actual = newList.get(i+1);

                if (expected!= actual || (i==newList.size()-1)){ //end of range
                    rangeEnd = newList.get(i);
                    collectionSummary.append(getRange(rangeStart,rangeEnd));
                    rangeStart = newList.get(i+1);
                }  //else not end of range
            }
            else{ //end of array
                rangeEnd = newList.get(i);
                String range = getRange(rangeStart,rangeEnd);
                collectionSummary.append(range, 0, range.length()-2);
            }

        }
        return collectionSummary.toString();
    }


    private String getRange(int rangeStart, int rangeEnd){
        if(rangeStart == rangeEnd){ //only one number in range
           return rangeEnd +", ";
        }
        else{
            return rangeStart+"-"+rangeEnd+", ";
        }

    }

}
