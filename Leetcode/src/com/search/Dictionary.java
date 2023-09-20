package com.search;

import java.util.Arrays;

public class Dictionary {
    private String[] element;
    private SortedSeqList<IndexItem> indexTable;

    public Dictionary(String[] element)
    {
        this.element = element;
        System.out.print("");
//        Array1.printBracket(this.element);
        Arrays.toString(this.element);
        createIndex();
    }

    public char toKey(String str)
    {
        return str.charAt(0);
    }

    private void createIndex()
    {
        this.indexTable = new SortedSeqList();
        int i=0, begin=0;
        {
            char key = toKey(this.element[i]);
            i++;
            while(i<this.element.length && key==toKey(this.element[i]))
                i++;
            this.indexTable.insert(new IndexItem(key, begin, i-1));
            begin=i;
        }
        System.out.println(""+this.indexTable.toString());
    }

    public boolean contains(String str)
    {
        IndexItem item = new IndexItem(toKey(str),0,0);
        int i=this.indexTable.binarySearch(item);
        if(i==-1)
            return false;
        item = this.indexTable.get(i);
        int begin = item.begin, end=item.end;
        return SortedArray.binarySearch(this.element, begin, end, str)>=0;
    }
}
