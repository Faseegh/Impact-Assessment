package app;

public class Runner {
    public static void main(String[] args) {

        NumberSummarizer grouper = new NumberSummarizer();

        String sample1 = "1,52,5,6,51,88,7,10,23,11,12,50,8,22";
        ///System.out.println(numb_summ.collect(sample1));
        String group1 = grouper.summarizeCollection(grouper.collect(sample1));
        System.out.println(group1);
    }
}