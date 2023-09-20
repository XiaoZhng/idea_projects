package com.search;

public class IndexItem implements Comparable<IndexItem>{
    final char key;
    int begin, end;

    public IndexItem(char key, int begin, int end)
    {
        this.key = key;
        this.begin = begin;
        this.end = end;
    }
    public String toString()
    {
        return "("+this.key+","+begin+","+end+")";
    }

    public int compareTo(IndexItem item)
    {
        return this.key - item.key;
    }
}
