import app.NumberSummarizer;
import org.junit.jupiter.api.RepeatedTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.Collection;

public class TestNumberSummarizer {
    //create class instance to use for various tests
    NumberSummarizer summarizer = new NumberSummarizer();

    /**
     * unit test method, checking if the implementation works as expected using sample data
     * from the question.
     * Expect the sample String to sorted and then extract the values (Integers) and
     * to be stored in a Collection that is returned
     */

    String sample_data = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
    @Test
    public void collect_test_simple_data(){
        Collection<Integer> collected_sample = summarizer.collect(sample_data);
        //System.out.println(collected_sample.toString());
        assertEquals(collected_sample.toString(),
                "[1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31]");

    }

    /**
     * Unit test method for the summarizeCollection
     * conforming if the output is displayed as expected, based on the sample input provided
     * in the question
     */
    @Test
    public void summarizeCollection_test_simple_data(){
        String summarized_data = summarizer.summarizeCollection(summarizer.collect(sample_data));
        //System.out.println(summarized_data);
        assertEquals(summarized_data,"1, 3, 6-8, 12-15, 21-24, 31");

    }

    /**
     * test data used to check if the split, sort and grouping works as expected for different delimiters
     * ',', ';', '-'
     * @return string containing the unsorted numbers, with above specified delimiters.
     * note: more delimiters can be added, only used 3 for this solution.
     */
    @DataProvider(name = "delimiter_test_data")
    public Object[][] delimiter_test_data(){
        return new Object[][] {
                {"2,11,58,3,77,13,4,14,15,57,56"},
                {"2;11;58;3;77;13;4;14;15;57;56"},
                {"2-11-58-3-77-13;4-14-15-57-56"},
                {"2-11;58-3,77-13;4;14;15-57,56"}
        };
    }

    /**
     * test using the test data defined above
     * 1. string with delimiter ','
     * 2. string with delimiter ';'
     * 3. string with delimiter '-'
     * 4. string with a combination of all the delimiters above
     * @param test_data
     */
    @Test(dataProvider = "delimiter_test_data")
    public void complete_test_various_delimiter(String test_data){
        Collection<Integer> org_data = summarizer.collect(test_data);
        String summarized_data = summarizer.summarizeCollection(org_data);
        assertEquals(org_data.toString(),"[2, 3, 4, 11, 13, 14, 15, 56, 57, 58, 77]");
        assertEquals(summarized_data,"2-4, 11, 13-15, 56-58, 77");

    }

    @Test
    public void test_random_numbers(){
        String random_string_numbers = summarizer.collect_data();
        Collection<Integer> random_data = summarizer.collect(random_string_numbers);
        String summarized_random_data = summarizer.summarizeCollection(random_data);
        System.out.println("\nRandom generated string: "+random_string_numbers);
        System.out.println("List of sorted random numbers: "+random_data.toString());
        System.out.println("Summarized random data: "+summarized_random_data);
    }

}
