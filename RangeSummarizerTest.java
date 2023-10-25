package numberrangesummarizer;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;


import static org.junit.Assert.assertEquals;


public class RangeSummarizerTest {

    @Test
    public void test_Collect_WithEmptyString(){
        //given empty string
        String input = "";

        //when collecting input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        Collection<Integer> collection = rangeSummarizer.collect(input);

        //then return empty list
        assertEquals( 0, collection.size());
    }

    @Test
    public void test_Collect_WithValidString(){
        //given some string
        String input = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";

        //when collecting input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        int actualCollectionSize = rangeSummarizer.collect(input).size();

        //then collection list size should equal number of integers in given string
        assertEquals(14, actualCollectionSize);
    }

    @Test
    public void test_SummarizeCollection_WithEmptyList(){
        //given an empty list
        Collection<Integer> numbers = new ArrayList<>();

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String result = rangeSummarizer.summarizeCollection(numbers);

        //then output should be empty
        assertEquals(null, result);
    }

    @Test
    public void test_SummarizeCollection_WithPopulatedList_endingInRange(){
        //given a populated list
        Collection<Integer> numbers = populateList_endingOnRange();

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String actual = rangeSummarizer.summarizeCollection(numbers);
        String expected = "1, 3, 6-8";

        //then output should be
        assertEquals(expected, actual);
    }

    @Test
    public void test_SummarizeCollection_WithPopulatedList_endingInSingleValue(){
        //given a populated list
        Collection<Integer> numbers = populateList_endingOnSingleValue();

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String actual = rangeSummarizer.summarizeCollection(numbers);
        String expected = "1, 3, 6-8, 12";

        //then output should be
        assertEquals(expected, actual);
    }

    @Test
    public void test_SummarizeCollection_WithSingleValue(){
        //given a populated list
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(1);

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String actual = rangeSummarizer.summarizeCollection(numbers);
        String expected = "1";

        //then output should be
        assertEquals(expected, actual);
    }

    @Test
    public void test_SummarizeCollection_WithSingleRange(){
        //given a populated list
        Collection<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String actual = rangeSummarizer.summarizeCollection(numbers);
        String expected = "1-3";

        //then output should be
        assertEquals(expected, actual);
    }


    @Test
    public void test_SummarizeCollection_WithUnsortedPopulatedList_endingInRange(){
        //given a populated list
        Collection<Integer> numbers = populate_UnosrtedList_endingOnSingleValue();

        //when summarizing input
        RangeSummarizer rangeSummarizer = new RangeSummarizer();
        String actual = rangeSummarizer.summarizeCollection(numbers);
        String expected = "1, 3, 6-8, 12";

        //then output should be
        assertEquals(expected, actual);
    }


    private Collection<Integer> populateList_endingOnRange(){

        Collection<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(3);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        return numbers;

    }


    private Collection<Integer> populateList_endingOnSingleValue(){

        Collection<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(3);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);
        numbers.add(12);

        return numbers;
    }

    private Collection<Integer> populate_UnosrtedList_endingOnSingleValue(){

        Collection<Integer> numbers = new ArrayList<>();

        numbers.add(8);
        numbers.add(1);
        numbers.add(7);
        numbers.add(12);
        numbers.add(6);
        numbers.add(3);

        return numbers;
    }



}