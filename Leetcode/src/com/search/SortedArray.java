//��8.1.2  ���ַ�����

//���������࣬�ṩ���ַ������㷨
public class SortedArray
{
    public static int count=0;                   //ͳ�ƱȽϴ���������ASL�ɹ�
    
    //��֪values����Ԫ�ذ��������򣬶��ַ�������key���Ԫ�أ������ҳɹ����򷵻��±꣬���򷵻�-1��
    //��values==null��key==null��Java�׳��ն����쳣
    public static <T extends Comparable<? super T>> int binarySearch(T[] values, T key)
    {
        return binarySearch(values, 0, values.length-1, key);
    }      
    //���ַ����ҷ�Χ��begin��end��0��begin��end<values.length����begin��endԽ�磬����-1
    public static <T extends Comparable<? super T>> int binarySearch(T[] values, int begin, int end, T key)
    {
        count=0;                                 //ͳ�ƱȽϴ���������ASL�ɹ�
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                        //�߽���Ч
        {
            int mid = (begin+end)/2;             //ȡ�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print("["+mid+"]="+values[mid]+"��"); //��ʾ�Ƚ��м�������ʡ��
            count++;
            if(key.compareTo(values[mid])==0)    //���������
                return mid;                      //���ҳɹ�
            if(key.compareTo(values[mid])<0)     //key�����С
                end = mid-1;                     //���ҷ�Χ��С��ǰ���
            else
                begin = mid+1;                   //���ҷ�Χ��С������
        }
        return -1;                               //���Ҳ��ɹ�
    }
    
    //��˼����8-1��ϰ���𡿶��ַ����ҵĵݹ��㷨
    //��֪values����Ԫ�ذ��������򣬶��ַ�������key���Ԫ�أ������ҳɹ������±꣬���򷵻�-1��
    //��values==null��key==null��Java�׳��ն����쳣
    public static int binarySearch(int[] values, int key)
    { 
        return binarySearch1(values, 0, values.length-1, key);
    }    
    //���ַ����ҷ�Χ��begin��end��0��begin��end<values.length����begin��endԽ�磬����-1��
    public static int binarySearch1(int[] values, int begin, int end, int key)
    {
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                       //�߽���Ч 
        {
            int mid = (begin+end)/2;             //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(values[mid]+"? ");  //��ʾ�Ƚ��м�������ʡ��
            if(values[mid]==key) 
                return mid;                      //���ҳɹ�
            if(values[mid]>key)                  //����ֵС
                end = mid-1;                     //���ҷ�Χ��С��ǰ���
            else
                begin = mid+1;                   //���ҷ�Χ��С������
        }
        return -1;                               //���Ҳ��ɹ�
    }
    //���ַ����ҷ�Χ��begin��end��0��begin��end<values.length����begin��endԽ�磬����-1��
    //�ݹ��㷨
    public static int binarySearch(int[] values, int begin, int end, int key)
    {
        if(begin<=end)                           //�߽���Ч 
        {
            int mid = (begin+end)/2;             //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print("["+mid+"]="+values[mid]+"��");          //��ʾ�Ƚ��м�������ʡ��
            if(values[mid]==key) 
                return mid;                      //���ҳɹ�������Ԫ���±�
            if(key < values[mid])                //��keyֵС
                return binarySearch(values, key, begin, mid-1); //���ҷ�Χ��С��ǰ��Σ��ݹ����
            return binarySearch(values, key, mid+1, end);       //���򣬷�Χ��С�����Σ��ݹ����
        }
        return -1;                               //���Ҳ��ɹ�
    }    

    //ʹ�ñȽ���
    //��֪values����Ԫ�ذ��������򣬶��ַ�������key���Ԫ�أ������ҳɹ������±꣬���򷵻�-1��
    //�ɱȽ�������comparatorָ��T����Ƚϴ�С�Ĺ���
    //��values==null��key==null��comparator==null��Java�׳��ն����쳣
    public static<T> int binarySearch(T[] values, T key, java.util.Comparator<? super T> comparator)
    {
        return binarySearch(values, 0, values.length-1, key, comparator);
    }  
    //���ַ����ҷ�Χ��begin��end��0��begin��end<values.length����begin��endԽ�磬����-1��
    public static<T> int binarySearch(T[] values, int begin, int end, T key, java.util.Comparator<? super T> comparator)
    {
        if(values.length>0 && begin>=0 && end<values.length)
            return -1; 
        while(begin<=end)                             //�߽���Ч
        {
            int mid = (begin+end)/2;                  //�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(values[mid]+"? ");
            if(comparator.compare(values[mid],key)==0)//����Ƚϴ�С
                return mid;                           //���ҳɹ�
            if(comparator.compare(values[mid],key)>0) //��������С
                end = mid-1;                          //���ҷ�Χ��С��ǰ���
            else
                begin = mid+1;                        //���ҷ�Χ��С������
        }
        return -1;                                    //���Ҳ��ɹ�
    }  
}