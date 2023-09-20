package com.search;

import com.search.IndexItem;

import java.util.Arrays;

public class MonthDictionary {
    private String[] element;
    private SortedSeqList<MonthItem> monthList;
    private SortedSeqList<IndexItem> indexTable;
    private SortedSeqList<SecondIndexItem> secondIndexTable; /

    private char first;

    public MonthDictionary(String[] keys, String[] vals){
        this.monthList = new SortedSeqList<MonthItem>();
        int i = 0;
        while (i<keys.length){
            monthList.insert(new MonthItem(keys[i],vals[i]));
            i++;
        }
        System.out.println("monthList"+monthList);
        createSecondIndex();
        createIndex();
    }
    private void createSecondIndex(){
        this.secondIndexTable = new SortedSeqList<SecondIndexItem>();
        int i = 0;
        while (i<this.monthList.size()){
            String str = monthList.get(i).getKey().substring(0, 3);
            this.secondIndexTable.insert(new SecondIndexItem(str,i));
            i++;
        }
        System.out.println(""+this.secondIndexTable.toString());
    }

    private void createIndex()
    {
        this.indexTable = new SortedSeqList<IndexItem>();
        int i=0, begin=0;
        char key = toKey(this.secondIndexTable.get(0).getKey());
        while(i<this.secondIndexTable.size())
        {
            key=toKey(this.secondIndexTable.get(i).getKey());
            while(i<this.secondIndexTable.size() && key==toKey(this.secondIndexTable.get(i).getKey())){
                i++;
            }
            this.indexTable.insert(new IndexItem(key, begin, i-1));
            begin=i;
//            System.out.println("i="+i+"key="+key);
        }
        System.out.println(""+this.indexTable.toString());
    }

    public MonthItem binarySearch(String str){
        int i = IndexbinarySearch(0, this.indexTable.size(), toKey(str));
        System.out.println();
        int i2 = SecondIndexbinarySearch(this.indexTable.get(i).begin, this.indexTable.get(i).end, str.substring(0,3));
        System.out.println();
        return monthList.get(this.secondIndexTable.get(i2).getVal());
    }

    public int IndexbinarySearch(int begin, int end,char key)
    {
        SortedSeqList<IndexItem> list = this.indexTable;
//        int count=0;
        if(list.size()==0 || begin< 0 || end>list.size())
            return -1;
        while(begin<=end)
        {
            int mid = (begin+end)/2;
            System.out.print("["+mid+"]="+list.get(mid)+"");
//            count++;
            if(key-list.get(mid).key==0)
                return mid;
            if(key-list.get(mid).key<0)
                end = mid-1;
            else
                begin = mid+1;
        }
        return -1;
    }

    public int SecondIndexbinarySearch(int begin, int end,String key){

        SortedSeqList<SecondIndexItem> list = this.secondIndexTable;
        if(list.size()==0 || begin< 0 || end>list.size())
            return -1;
        while(begin<=end)
        {
            int mid = (begin+end)/2;
            System.out.print("["+mid+"]="+list.get(mid)+"");
//            count++;
            if(key.compareTo(list.get(mid).getKey())==0)
                return mid;
            if(key.compareTo(list.get(mid).getKey())<0)
                end = mid-1;
            else
                begin = mid+1;
        }
        return -1;
    }


    public char toKey(String str)
    {
        return str.charAt(0);
    }

}