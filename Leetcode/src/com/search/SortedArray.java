//§8.1.2  二分法查找

//排序数组类，提供二分法查找算法
public class SortedArray
{
    public static int count=0;                   //统计比较次数，计算ASL成功
    
    //已知values数组元素按升序排序，二分法查找与key相等元素，若查找成功，则返回下标，否则返回-1。
    //若values==null或key==null，Java抛出空对象异常
    public static <T extends Comparable<? super T>> int binarySearch(T[] values, T key)
    {
        return binarySearch(values, 0, values.length-1, key);
    }      
    //二分法查找范围是begin～end，0≤begin≤end<values.length，若begin、end越界，返回-1
    public static <T extends Comparable<? super T>> int binarySearch(T[] values, int begin, int end, T key)
    {
        count=0;                                 //统计比较次数，计算ASL成功
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                        //边界有效
        {
            int mid = (begin+end)/2;             //取中间位置，当前比较元素位置
            System.out.print("["+mid+"]="+values[mid]+"？"); //显示比较中间结果，可省略
            count++;
            if(key.compareTo(values[mid])==0)    //两对象相等
                return mid;                      //查找成功
            if(key.compareTo(values[mid])<0)     //key对象较小
                end = mid-1;                     //查找范围缩小到前半段
            else
                begin = mid+1;                   //查找范围缩小到后半段
        }
        return -1;                               //查找不成功
    }
    
    //【思考题8-1，习题解答】二分法查找的递归算法
    //已知values数组元素按升序排序，二分法查找与key相等元素，若查找成功返回下标，否则返回-1。
    //若values==null或key==null，Java抛出空对象异常
    public static int binarySearch(int[] values, int key)
    { 
        return binarySearch1(values, 0, values.length-1, key);
    }    
    //二分法查找范围是begin～end，0≤begin≤end<values.length，若begin、end越界，返回-1。
    public static int binarySearch1(int[] values, int begin, int end, int key)
    {
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                       //边界有效 
        {
            int mid = (begin+end)/2;             //中间位置，当前比较元素位置
            System.out.print(values[mid]+"? ");  //显示比较中间结果，可省略
            if(values[mid]==key) 
                return mid;                      //查找成功
            if(values[mid]>key)                  //给定值小
                end = mid-1;                     //查找范围缩小到前半段
            else
                begin = mid+1;                   //查找范围缩小到后半段
        }
        return -1;                               //查找不成功
    }
    //二分法查找范围是begin～end，0≤begin≤end<values.length，若begin、end越界，返回-1。
    //递归算法
    public static int binarySearch(int[] values, int begin, int end, int key)
    {
        if(begin<=end)                           //边界有效 
        {
            int mid = (begin+end)/2;             //中间位置，当前比较元素位置
            System.out.print("["+mid+"]="+values[mid]+"？");          //显示比较中间结果，可省略
            if(values[mid]==key) 
                return mid;                      //查找成功，返回元素下标
            if(key < values[mid])                //若key值小
                return binarySearch(values, key, begin, mid-1); //查找范围缩小到前半段，递归调用
            return binarySearch(values, key, mid+1, end);       //否则，范围缩小到后半段，递归调用
        }
        return -1;                               //查找不成功
    }    

    //使用比较器
    //已知values数组元素按升序排序，二分法查找与key相等元素，若查找成功返回下标，否则返回-1。
    //由比较器对象comparator指定T对象比较大小的规则。
    //若values==null、key==null或comparator==null，Java抛出空对象异常
    public static<T> int binarySearch(T[] values, T key, java.util.Comparator<? super T> comparator)
    {
        return binarySearch(values, 0, values.length-1, key, comparator);
    }  
    //二分法查找范围是begin～end，0≤begin≤end<values.length，若begin、end越界，返回-1。
    public static<T> int binarySearch(T[] values, int begin, int end, T key, java.util.Comparator<? super T> comparator)
    {
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                             //边界有效
        {
            int mid = (begin+end)/2;                  //中间位置，当前比较元素位置
            System.out.print(values[mid]+"? ");
            if(comparator.compare(values[mid],key)==0)//对象比较大小
                return mid;                           //查找成功
            if(comparator.compare(values[mid],key)>0) //给定对象小
                end = mid-1;                          //查找范围缩小到前半段
            else
                begin = mid+1;                        //查找范围缩小到后半段
        }
        return -1;                                    //查找不成功
    }  
}