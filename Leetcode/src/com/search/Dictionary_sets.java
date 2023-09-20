package com.search;

public class Dictionary_sets {
    public static void main(String[] args)
    {
        int i=0;
        String[] set = StringSet.sets[i];
        System.out.println(StringSet.setNames[i]);
//        Dictionary dic = new Dictionary(set);
        BitmapDictionary dic = new BitmapDictionary(set,'a',26);
        String word="final";
        System.out.println(word+""+dic.contains(word));
    }
}
