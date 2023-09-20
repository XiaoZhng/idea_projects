//��2.4   �������Ա�Ĵ洢��ʵ��
//��2.4.1  ����˳���
//��5��̲�ûд������8.1��������
//����8.1��Java�ؼ��ּ��ϵĴ洢����ң��ֵ伯�ϵ�ϡ������������
//��9.5.1   ˳���������㷨

//����˳��������࣬�̳�˳����ࣻ
//T��T��ĳ��������?ʵ��Comparable<?>�ӿڣ��ṩcompareTo()�����Ƚ϶����С�����
public class SortedSeqList<T extends Comparable<? super T>> extends SeqList<T>
{
    //2.  ��ļ̳�ԭ��
    //��2�� ���಻�ܼ̳и���Ĺ��췽��
    //���췽��
    public SortedSeqList()                       //���������˳���
    {
        super();                                 //Ĭ�ϵ��ø��๹�췽��SeqList()
    }
    public SortedSeqList(int length)             //���������˳�������Ϊlength
    {
        super(length);                           //���ø��๹�췽��SeqList(length)����ʡ�ԣ�Ĭ�ϵ���super()
    }
    
    public SortedSeqList(T[] values)             //��������˳�����values�����ṩԪ�أ�O(n*n)
    {
        super(values.length);                    //����SeqList(length)��Ҳ�ɵ���this(values.length)
//        this(values.length);        
        for(int i=0; i<values.length; i++)       //ֱ�Ӳ�������ÿ�˲���1��Ԫ��
            this.insert(values[i]);              //�������า�ǵ�insert(T)��������ֵ����Ԫ�أ�O(n)
    }//��9.5.1   ˳���������㷨
    
    //����toPreviousString()�����õ����������˳���
    
    //4.  ����˳����า�Ǹ����Ա����
    //��1�� ����Ҫ�Ӹ���̳����ķ��������ǲ��׳��쳣
    //��֧�ָ���������������������串�ǲ��׳��쳣
    public void set(int i, T x)                  //����˳��������Ԫ�ؾ���ֻ�����ԣ���֧��
    {
        throw new UnsupportedOperationException("set(int i, T x)");
    }
    public int insert(int i, T x)                //��֧����ָ��λ�ò���
    {        
        throw new UnsupportedOperationException("insert(int i, T x)");
    }
    
    //��2�� ����˳���Ĳ������
    //����x��x!=null������x�����С˳�����ȷ������λ�ã����򣩣������ڵ�ֵԪ��֮�󣬷���x��š�
    //����T��compareTo()�����Ƚ϶����С�����Ǹ���insert(x)�������б�ͷ���ֵ��ͬ��O(n)��
    ////�����ڵ�ֵ���֮�����ȶ�����
    //9.5.1 ֱ�Ӳ��������һ��
    public int insert(T x)
    {
        int i=0;
        if(this.isEmpty() || x.compareTo(this.get(this.n-1))>0)//compareTo(T) 插入元素比最后一个大
            i=this.n;                            //���ֵβ���룬O(1) 
        else
            //插入元素比列表的小
            while(i<this.n && x.compareTo(this.get(i))>=0)
                i++;
        super.insert(i, x);                      //���ø��౻���ǵ�insert(i,x)����������x��Ϊ��i��Ԫ�� 
        return i;
    }

    //��3�� ����˳���Ĳ��Ҳ���
    //˳������׸���key���Ԫ�أ���key��compareTo()����ȷ��Ԫ�صĴ�С����ȣ�
    //����Ԫ�����i��0��i<n���������Ҳ��ɹ�����-1��O(n)������
    public int search(T key)
    {
        System.out.print(this.getClass().getName()+".search("+key+")��");
        for(int i=0;  i<this.n && key.compareTo(this.get(i))>=0;  i++)//������
        {
            if(key.compareTo(this.get(i))==0)    //������ȣ�����ʱ��̬
                return i;
        }
        return -1;                               //�ձ��δ�ҵ�ʱ
    }

    //��4�� ����˳����ɾ������
    //�̳У�����Ҫ���ǡ�����ʱ��̬��    ////�㷨���ò��ҽ��ȷ������λ��
//    public T remove(T key) //���Ҳ�ɾ���׸���key���Ԫ�أ����ر�ɾ��Ԫ�أ������Ҳ��ɹ�������null
//    {
//        //�Ȳ��ң��ٵ���remove(i)�������Ҳ��ɹ�������-1����ɾ��������this.search(key)ִ������Ĳ��ҷ���
//        return this.remove(this.search(key));
//    }    
    //2015��1��30�ղ��ԣ�У��������ȷ������Ҫ���ǡ�

    //5.  ���͵Ķ�̬����������Ǹ������
    //��2�� ����˳������ؿ������췽��
    public SortedSeqList(SortedSeqList<? extends T> slist)//�������췽���������O(n)��<? extends T>��ʾT������
    {
        super(slist);                  //����SeqList(SeqList<T> list)������list=slist��ֵ���ݣ�list��������ʵ��
    }    
    
    //��˳���list��������˳���this�������O(n*n)��list����������ʵ����
    //��������SeqList<T>�е�T����SortedSeqList<T>��������T���ɱȽϴ�С
//    public SortedSeqList(<? extends T> list)
//    {
//        super(list.element.length);              //����SeqList(length)��������˳���
//        for(int i=0;  i<list.n;  i++)            //ֱ�Ӳ��������㷨��ÿ�˲���1��Ԫ�أ�O(n*n)
//            this.insert(list.get(i));            //�������า�ǵ�insert(T)��������ֵ���룬O(n)
//
//        ////��9.5.1   ˳���������㷨
////        super(list);                             //˳��������δ����Ԫ�ض���O(n)
//        //����һ�������㷨��˳����this.element����Ԫ�ؽ��������㷨ʡ�ԣ�
//        //��Ҫ����SeqList<T>�ĳ�Ա����element��n��������ߵ�Ȩ��Ӧ����Ϊprotected
////        Array9.insertSort(list.element);  //����
//        //���У�list.element������Object[]������T[]
//    }
    //����           this(list.element);          //����SortedSeqList(T[] values) 

    
    ////���¡��о�������5��ûд
//    public void addAll(SeqList<? extends T> list)      //�̳�

//    public SeqList<T> union(SeqList<? extends T> list)   //�̳У�����
    //���ǣ�����ֵ���Ͳ�ͬ����ֵ���ݣ���������SortedSeqList<? extends T> 
    public SortedSeqList<T> union(SeqList<? extends T> list)
    {
        SortedSeqList<T> result = new SortedSeqList<T>(this);   //��������ʵ�����������ʵ����ֻ��һ�䲻ͬ
        result.addAll(list);                     //����˳���ϲ�����ֵ����
        return result;                           //����SortedSeqList<T>����
    }



    //����8.1��������
    //8.2   ��������˳���Ķ��ַ�����     ��4��̲�û��д��д����Ķ��ַ�������
    //���ַ����ҹؼ���ΪkeyԪ�أ������ҳɹ������±꣬���򷵻�-1    
    public int binarySearch(T key)
    {
        return binarySearch(key, 0, this.n-1);
//    	return SortedArray.binarySearch((T)this.element, key);  //�﷨���󣬲��ܽ�Object[]ת����T[]
    }  
    //��begin��end��Χ�ڣ����ַ����ҹؼ���ΪkeyԪ�أ������ҳɹ������±꣬���򷵻�-1��
    //��key==null��Java���׳��ն����쳣����begin��endԽ�磬����-1
    public int binarySearch(T key, int begin, int end)
    {
        while(begin<=end)                        //�߽���Ч
        {
            int mid = (begin+end)/2;             //ȡ�м�λ�ã���ǰ�Ƚ�Ԫ��λ��
            System.out.print(this.get(mid)+"? ");//��ʾ�Ƚ��м�������ʡ��
            if(key.compareTo(this.get(mid))==0)  //���������
                return mid;                      //���ҳɹ�
            if(key.compareTo(this.get(mid))<0)   //key�����С
                end = mid-1;                     //���ҷ�Χ��С��ǰ���
            else
                begin = mid+1;                  //���ҷ�Χ��С������
        }
        return -1;                               //���Ҳ��ɹ�
    }
    //���ܵ������·������������Ϊ���ܽ�Object[]ת����T[]        
    //SortedArray.binarySearch((T)this.element, begin, end, key);
    //���Ƚ�����������
    
    
    //��9��
    //9.5.1   ˳���������㷨
/*    //ע�⣬����3����������á�������������飬û�и��ƶ��󣬲�������ڹ��ö�������
    public SortedSeqList(T[] values)             //��������˳�����values�����ṩԪ��
    {
        super(values);                           //����˳�����values�����ṩԪ��
        //����һ�������㷨��˳����this.element����Ԫ�ؽ��������㷨ʡ��
                
//        Array9.insertSort(this.element);         //���������㷨����˳��������Ԫ�ؽ�������
//                                                 //�������Ϊ���ܽ�Object[]ת����T[]        
    }
    
    //��˳���list��������˳���
//    public SortedSeqList(SeqList<? extends T> list)    //SeqList<T>�е�T����SortedSeqList<T>��������T���ɱȽϴ�С
    public SortedSeqList(SeqList<T> list)        //SeqList<T>�е�T����SortedSeqList<T>��������T���ɱȽϴ�С
    {
        super(list);                             //˳������������˳���δ����Ԫ�ض���
        //���²���һ�������㷨��˳����this.element����Ԫ�ؽ��������㷨ʡ�ԣ���Ҫ����SeqList<T>�ĳ�Ա����element��n��������ߵ�Ȩ��Ӧ����Ϊprotected
//      Array9.insertSort((T)this.element);      //�﷨���󣬲��ܰ�Object[]ת����T[]
        for(int i=1; i<this.n; i++)              //ֱ�Ӳ�����������
        {
            T temp=(T)this.element[i];           //���棺ǿ������ת��Object��T������ȫ
            int j;
            for(j=i-1;  j>=0 && temp.compareTo((T)this.element[j])<0;  j--)  //(T)this.element[j]��T�ɱȽϴ�С
                this.element[j+1] = this.element[j];
            this.element[j+1] = temp;
        }
    }
*/    
    
    //9.5.1   ˳���������㷨
    //���¹鲢this��list����˳������򣩣�this+=list�������this�����ı�list��һ�ι鲢�㷨
    //��5��̲ķ�����ʡ��
//    public void merge(SortedSeqList<? extends T> list)  
    public void merge(SortedSeqList<T> list)  
    {
        Object[] temp = this.element;
        this.element = new Object[(this.n+list.n)*2];  //���䵱ǰ˳�������
        int i=0, j=0, k=0;
        while(i<this.n && j<list.n)
            if(((T)temp[i]).compareTo((T)list.element[j])<=0)
                this.element[k++]=temp[i++];
            else
            	this.element[k++]=list.element[j++];

        while(i<this.n)
            this.element[k++]=temp[i++];
        while(j<list.n)
            this.element[k++]=list.element[j++];
        this.n+=list.n;
    }
    //����Java�Ķ�������ģ�ͣ��Զ����������ᵼ������C++�ظ��ͷŴ洢��Ԫ�ռ����⣬��û�и���Ԫ��
    //��list==null���׳��ն����쳣
    
    //���·���this��list�鲢�������˳������򣩣�this+list���ܣ����ı�this��list��һ�ι鲢�㷨
//    public SortedSeqList<T> mergeWith(SortedSeqList<? extends T> list)  
    public SortedSeqList<T> mergeWith(SortedSeqList<T> list)  
    {
        SortedSeqList<T> templist = new SortedSeqList<T>((this.n+list.n)*2);
        int i=0, j=0, k=0;
        while(i<this.n && j<list.n)
            if(((T)this.element[i]).compareTo((T)list.element[j])<=0)
                templist.element[k++]=this.element[i++];
            else
                templist.element[k++]=list.element[j++];

        while(i<this.n)
            templist.element[k++]=this.element[i++];
        while(j<list.n)
            templist.element[k++]=list.element[j++];
        templist.n=this.n+list.n;
        return templist;
    }
}