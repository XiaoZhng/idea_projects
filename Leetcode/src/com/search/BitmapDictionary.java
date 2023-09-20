package com.search;

import java.util.Arrays;

public class BitmapDictionary {
    private String[] element;
    private SortedSeqList<IndexItem> indexTable;
    private char first;

    public BitmapDictionary(String[] element, char first, int length)
    {
        this.element = element;
        System.out.print("");
//        Array1.printBracket(this.element);
        Arrays.toString(this.element);
        this.first = first;
        createIndex(length);
    }
    public char toKey(String str)
    {
        return str.charAt(0);
    }

    private void createIndex(int length)
    {
        this.indexTable = new SortedSeqList<IndexItem>(length);
        int i=0, begin=0;
        this.first = toKey(this.element[0]);
        char key = this.first;
        while(i<this.element.length)
        {
            while(i<this.element.length && key==toKey(this.element[i]))
                i++;
            if(begin==i)
                this.indexTable.insert(new IndexItem(key,-1,-1));
            else
            {
                this.indexTable.insert(new IndexItem(key, begin, i-1));
                begin=i;
            }
            key=(char)(key+1);
        }
        System.out.println(""+this.indexTable.toString());
    }

    public boolean contains(String str)
    {
        char key=str.charAt(0);
        int i = key - this.first;
        if(i>=0 && i<this.indexTable.size())
        {
            IndexItem item = this.indexTable.get(i);

            return item.begin!=-1 && SortedArray.binarySearch(this.element, item.begin, item.end, str)>=0;
        }
        return false;
    }
}
