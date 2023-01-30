package app;

import java.util.*;

public class NumberSummarizer implements NumberRangeSummarizer{

    /**
     * method used to convert the user input (string) to a List of integers.
     */
    public Collection<Integer> collect(String input) {
        String [] numbers = input.split("[,;-]");
        //System.out.println(numbers);
        List<Integer> data =  new ArrayList<>();
        //add all numbers to set, to remove any and all duplicate values
        Set<Integer> set = new HashSet<>(data);
        for (String n : numbers){
            //System.out.println(n);
            set.add(Integer.parseInt(n));
        }
        data.addAll(set);
        //System.out.println(data.toString());
        data.sort(Comparator.comparingInt(Integer::intValue));
        return (Collection<Integer>) data;
    }

    /**
     * method to generate a random set of numbers in range 1-30
     * @return string containing numbers separated by random delimiter
     */
    public String collect_data(){
        String set = "";
        String delimiters = ",;-";

        String d = String.valueOf(delimiters.charAt((int) (Math.random()*(2))));
        //System.out.println(d);
        //boolean another = true;
        for (int i=0; i<30; i++){
            //take in input from user.
            int rand_n = (int) ((Math.random() * (30)+1));
            set += rand_n+d;
            //System.out.println(set);
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
