public class Test {
    public static void main(String[] args) {
        String[] keys = {"January","February","March","April","May","June",
                "July","August","September","October","November","December"};
        String[] vals = {"1","2","3","4","5","6",
                "7","8","9","10","11","12"};


        MonthDictionary dic = new MonthDictionary(keys, vals);
        String word = "Nov";
        MonthItem res = dic.binarySearch(word);
        System.out.println(word+" The search result is:"+res.getKey()+" / "+res.getVal());
    }
}
