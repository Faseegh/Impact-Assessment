package app;

import java.util.*;

public class NumberSummarizer implements NumberRangeSummarizer{

    /**
     * method used to convert the user input (string) to a List of integers.
     */
    public Collection<Integer> collect(String input) {
        String [] numbers = input.split(",");
        List<Integer> data =  new ArrayList<>();
        for (String n : numbers){
            data.add(Integer.parseInt(n));
        }
        data.sort(Comparator.comparingInt(Integer::intValue));
        return data;
    }

    public String collect_data(){
        String set = "";
        boolean another = true;
        while (another){
            //take in input from user.
            set = "5";
            another = false;
        }
        return set;
    }

    /**
     * method used to construct the expected output string of sequential groups
     * */
    public String summarizeCollection(Collection<Integer> input) {
        List<Integer> arrayInput = (ArrayList<Integer>) input;
        //System.out.println(arrayInput.size());
        String orderedList = "";
        //System.out.println(groupNumbers(arrayInput));
        for (List<Integer> group : groupNumbers(arrayInput)){

            if (group.size()==1){
                orderedList += String.format("%d, ",group.get(0));
            }
            else{
                orderedList += String.format("%d-%d, ",group.get(0),group.get(group.size()-1));
            }
        }

       return orderedList.substring(0,orderedList.length()-2) ;
    }

    /**
     * method used to group sequential numbers and returns a List of Lists, each list containing the sequential groups
     * e.g [[5], [22,23,24], ...]
     * called by summarizeCollection parsing the ordered List of numbers
     */

    public List<List<Integer>> groupNumbers(List<Integer> listNumber){
        List<List<Integer>> ordered = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(listNumber.get(0));

        for (int i = 0; i < listNumber.size()-1; i++) {
            if (listNumber.get(i+1) == listNumber.get(i) +1){
                temp.add(listNumber.get(i+1));
            }
            else {
                //System.out.println(temp);
                ordered.add(temp);
                temp = new ArrayList<>();
                temp.add(listNumber.get(i+1));
                //System.out.println(i);
            }
        }
        ordered.add(temp);
        return ordered;
    }


}
