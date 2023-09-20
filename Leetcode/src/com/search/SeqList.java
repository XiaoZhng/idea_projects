//��2.2  ���Ա��˳��洢��ʵ��
//��2.2.2  ˳���
//��10.2.2  �ṩ����������

//1.  ˳��������������ȡ������Ч�ʷ���
//package dataStructure;                         //������ǰ.java�ļ��е�����ָ������

// ˳����࣬T��ʾ����Ԫ�ص��������ͣ�Ĭ�ϼ̳�Object
public class SeqList<T> extends Object
                implements Iterable<T>//,List<T>   //10.2.2��ʵ�ֿɵ����ӿ�
//public class SeqList<T>  extends MyAbstractList<T> //˳����࣬�̳г����б��ࡣ�ṩ����������
{
    protected int n;                             // ˳���Ԫ�ظ��������ȣ�
    protected Object[] element;                  // �������飬������Ա
    private static final int MIN_CAPACITY=16;    // ������ָ��element������������Сֵ
   
    //1. ���졢��ȡ
    // ����ձ�lengthָ��������������length<MIN_CAPACITY����ȡ��Сֵ��O(1)
    public SeqList(int length)
    {
//      super();                                 // Ĭ�ϵ��ã�ִ��Object()
        if(length<MIN_CAPACITY)
            length=MIN_CAPACITY;
        this.element = new Object[length];       // ��������ռ䣬Ԫ��Ϊnull
        this.n = 0;
    }//˵����length=0�������׳��쳣����Ϊ��ͼҲҪ�����ռ䡣

    public SeqList()                             // ����Ĭ�������Ŀձ����췽������
    {
        this(MIN_CAPACITY);                      // ���ñ�����������ָ�������б�Ĺ��췽��
    }
    
    public SeqList(T[] values)                   // ����˳�����values�����ṩԪ�أ��������пն���O(n)
    {
        // ����2��values���������Ŀձ���values==null�����׳�NullPointerException�ն����쳣
    	this(values.length*2);
        for(int i=0;  i<values.length;  i++)     // ���Ʒǿյ�����Ԫ��
            if(values[i]!=null)
                this.element[this.n++]=values[i];// �������ø�ֵ
      //Ҳ��              this.add(values[i]);           // β���룬this.n++�����Ҳ��ã���Ϊ��û�н���
        
      //Ҳ��        for (T x : values)               //������Ԫѭ��
//                  this.add(x);                 //β���룬this.n+1
    }    
    
    public boolean isEmpty()                     // �ж��Ƿ�գ���Ϊ�գ��򷵻�true��O(1)
    {
        return this.n==0;
    }

    public int size()                            // ����Ԫ�ظ�����O(1)
    {
        return this.n;
    }

    //��ȡ����
    public T get(int i)                          // ��0��i<n�����ص�i��Ԫ�أ����򣬷���null��O(1)
    {
        if(i>=0 && i<this.n)
            return (T)this.element[i];           // ��������Ԫ�����õĶ��󣬴��ݶ�������
        ////��i<=0 || i>=this.element.lengthʱ��Java���׳�ArrayIndexOutOfBoundsException�����±�Խ���쳣
//            return this.element[i];              //�����Object�����ܷ���T����
        return null;
//        else throw new java.lang.IndexOutOfBoundsException(i+"");//�׳����Խ���쳣
        //�����׳��쳣����Ϊnull��������Ϊѭ����ִ�е�������
    }    

    // ��0��i<n��x��null�����õ�i��Ԫ��Ϊx�������׳����Խ���쳣��ն����쳣��O(1)  ////��Ҫ����ֵ��
    public void set(int i, T x)
    {
        if(x==null)
            throw new NullPointerException("x==null");     //�׳��ն����쳣
        if(i>=0 && i<this.n)
            this.element[i] = x;                           //�������ø�ֵ
        else
            throw new IndexOutOfBoundsException(i+"");//�׳����Խ���쳣
    }
    
    // ��������Ԫ�ص������ַ�������ʽΪ��(,)��������Object���toString()������O(n)
    public String toString()
    {
//        String str=this.getClass().getName()+"(";//��������
        String str="(";
        if(this.n>0)
            str += this.element[0].toString();   // ִ��T���toString()����������ʱ��̬
        for(int i=1; i<this.n; i++)
            str += ","+this.element[i].toString();
        return str+") ";                         // �ձ���()
    }
/*    ���У�Ч��ͬ��
    public String toString() 
    {
        String str="(";
        if(this.n()!=0)
        {
            for(int i=0; i<this.n()-1; i++)
                str += this.get(i).toString()+", ";
            str += this.get(this.n()-1).toString();
        }
        return str+")";
    }
*/    
    // ��������Ԫ�ص������ַ�����Ԫ�ش���Ӻ���ǰ��������ʡ��
    // ˳��ջ�ã�O(n)�����裬ջ�����ȶ����á�
    public String toPreviousString()
    {
//        String str=this.getClass().getName()+"(";       // ��������
        String str="(";
        if(this.n>0)
            str += this.element[this.n-1].toString();      // ִ��T���toString()����������ʱ��̬
        for(int i=this.n-2; i>=0; i--)
            str += ","+this.element[i].toString();
        return str+") ";                         // �ձ���()
    }
    
    //2. ˳���Ĳ������
    // ����xΪ��i��Ԫ�أ�x!=null�����ز���Ԫ����š�
    // ��i�ݴ���i<0����ͷ���룻��i>���ȣ���β���롣O(n)
    public int insert(int i, T x)
    {
        if(x==null)
            return -1;                           // û�в��롣//����һ��ִ�н�������Ǵ��󣬲��׳��ն����쳣
        if(i<0)
            i=0;                                 // ����λ��i�ݴ���������ǰ��ͷ���룩
        if(i>this.n)
            i=this.n;                            // ���������β���룩
        Object[] source = this.element;          // ����������ø�ֵ��sourceҲ����element����
        if(this.n==element.length)               // ����������������˳������������
        {
            this.element = new Object[source.length*2];    // ������һ���������������
            for(int j=0; j<i; j++)               // ���Ƶ�ǰ����ǰi-1��Ԫ��
                this.element[j] = source[j];     // ��������Ԫ�أ����ݶ�������
        }
        for(int j=this.n-1; j>=i; j--)           // ��i��ʼ����β��Ԫ������ƶ�������Ӻ���ǰ
            this.element[j+1] = source[j];       // ��������Ԫ�أ����ݶ�������
        this.element[i] = x;
        this.n++;
        return i;                                // ���ز���Ԫ�����
    }
    public int insert(T x)                       // ˳���β����xԪ�أ�O(1)����Ա��������
    {
        return this.insert(this.n, x);           // ����insert(i, x)����
    }
    //�δ��õ��˷���ֵ��֮ǰinsert(x)����int��7.2�� ͼ���붥��ʱ�ã��޸�
    //10.3.3 Heap<T>���insert(T x)�����õ�����ֵ
    
    //3. ˳����ɾ������
    public T remove(int i)           // ɾ����i��Ԫ�أ�0��i<n�����ر�ɾ��Ԫ�ء���iԽ�磬����null��O(n)
    {
        if(i>=0 && i<this.n) 
        {
            T x = (T)this.element[i];            // x�д洢��ɾ��Ԫ��
            for(int j=i; j<this.n-1; j++)
                this.element[j] = this.element[j+1];       // Ԫ��ǰ��һ��λ��
            this.element[this.n-1]=null;         // ��������Ԫ�ض���Ϊ�գ��ͷ�ԭ����ʵ��
            this.n--;
            return x;                            // ����x�ֲ��������õĶ��󣬴��ݶ�������
        }
        return null;
        //throw new IndexOutOfBoundsException(i+"");     // �׳����Խ���쳣
    }
    public void clear()                          // ɾ������Ԫ��
    {
        this.n=0;                                // ���ó���Ϊ0��δ�ͷ�����ռ�
    }
    //����2.1�����Josephus�����⡣
    
    //4. ˳�����
    // ��this���õ�˳����У�˳������׸���key���Ԫ�أ�����Ԫ�����i��0��i<n�������Ҳ��ɹ����򷵻�-1��
    // keyԪ�ذ�����Ϊ�������ݵĹؼ����������T���equals()����ȷ�������Ƿ���ȡ�
    // ��key==null��Java���׳�NullPointerException�ն����쳣��
    // ˳�������㷨��˳������㷨��O(n)
    public int search(T key)
    {
//        System.out.print(this.getClass().getName()+".search("+key+")��");
        for(int i=0;  i<this.n;  i++)            // ����˳���
        {
//            System.out.print(this.element[i].toString()+"��");
            if(key.equals(this.element[i]))      // ִ��T���equals(Object)����������ʱ��̬
               return i;
        }
        return -1;                               // �ձ��δ�ҵ�ʱ
    }//ע�⣺��������Ԫѭ�����޷�����i��


    // ˳����Ҳ�ɾ���׸���key���Ԫ�أ����ر�ɾ��Ԫ�أ������Ҳ��ɹ����򷵻�null��
    // �㷨���ò��ҽ��ȷ������λ��
    public T remove(T key)
    {
        return this.remove(this.search(key));    // �Ȳ��ң��ٵ���remove(i)�������Ҳ��ɹ�������-1����ɾ��
    }    


    //6.  ˳����ǳ���������
/*    public SeqList(SeqList<T> list)              // ǳ�������췽��
    {
        this.n = list.n;                         // int������ֵ������������ֵ
        this.element = list.element;             // �������ø�ֵ��������������һ�����飬����
    }
*/    
    
    //��6�棬�����������ֱ�������õ�copy(list)��2020��7��23��
    public SeqList(SeqList<? extends T> list)    // �������췽���������<? extends T>��ʾT������
    {
        this.copy(list);
    }
    public void copy(SeqList<? extends T> list)  // ����list����Ԫ�ص�this������thisԭ����Ԫ�ء�O(n)
    {
        this.element = new Object[list.element.length];// ����һ������
        for(int i=0; i<list.n; i++)              // ����list����Ԫ�ص�this
            this.element[i] = list.element[i];   // �������ø�ֵ��û�д����¶���
        this.n = list.n; 
    }
//�����﷨�����ܿ�������
//this.element[i] = new T(list.element[i]);      //�﷨����ΪJavaû���ṩĬ�Ͽ������췽��
//this.element[i] = new Object(list.element[i]); //���������Ҫ����Object����
                                       //�﷨��Objectû���ṩ�������췽�������췽�����ܼ̳� 
    //������ֵ�Ľ���������䣬ʧ�ܡ�
//    this.insert((T)list.element[i]);           //β���룬this.n++��������Ȼ���ø�ֵ��û�и���
//��Ϊ������SortedSeqList(SeqList<? extends T> list)��super(list)��insert(x)����ʱ��̬��������β�ٲ��룬Ч��O(n*n)

    
    //7. ˳���Ƚ����
    public boolean equals(Object obj)            // �Ƚ�this��obj���õ�˳����Ƿ���ȡ����ǡ�O(n)
    {
        System.out.print(this.getClass().getName()+".equals("+obj.getClass().getName()+")��");
    	if(this==obj)                            // ��this��obj����ͬһ��˳���ʵ���������
            return true;
        if(obj instanceof SeqList<?>)            // ��obj����˳���ʵ����SeqList<?>������SeqList<T>�ĸ���
        {
            SeqList<T> list = (SeqList<T>)obj;   // ����listҲ����obj�����õ�ʵ��
            if(this.n==list.n)                   // ��Ƚ����߳����Ƿ����
            {
                for(int i=0;  i<this.n;  i++)    // �ٱȽ�����˳��������Ԫ���Ƿ����
                    // һ��������������ӦԪ�ز���ȣ����ȷ������˳�����ȡ�equals(Object)����ʱ��̬
                	if(!(this.element[i].equals(list.element[i])))
                        return false; 
                return true;
            }
        }
        return false;
    }    
    //����ʵ��ADT List����2��2.2.2������
    
/*    ////���µ�5��ûд
    public boolean contains(T key)               //�ж��Ƿ�����ؼ���ΪkeyԪ��
    {
        return this.search(key)!=-1;//˳������׸���key���Ԫ�أ�����Ԫ�����i��0��i<n�������Ҳ��ɹ�����-1
    }*/
    
    ////���µ�5��ûд
    //8.  ���ϲ����㣬���͵ļ̳���
    //����̳У�����Ҫ���ǣ���������ʱ��̬
    //���ϲ����㣬��this֮�����list����Ԫ�أ�this+=list���ܣ�<? extends T>��ʾT������
    public void addAll(SeqList<? extends T> list)
    {
        for(int i=0;  i<list.n;  i++) 
            this.insert(list.get(i));        //����ʱ��̬��˳���β���룻����˳���ֵ����
    }
    //˵��������this.get(i)��O(1)������(T)this.element[i]�����ϸ��������ͬ��

//���  public void addAll(SeqList<T> list)          //�򲻽���T������
//���  public void addAll(SeqList<?> list)          //�����this.insert(x)�������
//���  public void insert(SeqList<T> list)          //���أ�����ʱ��������Ϊnullʱ��������޷�ʶ�����ط����е���һ��
    
    //������this֮������list��˳���������this+list�Ĳ������ܣ����ı�this��list
    public SeqList<T> union(SeqList<? extends T> list)
    {
        SeqList<T> result = new SeqList<T>(this);   //���this���޷���������ʵ��
        result.addAll(list);                        //˳���ϲ����ӣ�β����
        return result;                              //ֻ�ܷ���SeqList<T>��������Ҫ����
    }
    //����        return new SeqList<T>(this).addAll(list);
    //9.5.1 ����mergeAll�ϲ����鲢�����ã�������

    //��ʵ����2-1����5��ûд
    //���ش�begin��endԪ����ɵ��ӱ���Ϊ����T��ĳ�����ࡣ
//  SeqList<? extends T> subList(int begin, int end)   //����Ҫ���﷨ 
    SeqList<T> subList(int begin, int end)   
    {
        SeqList<T> list = new SeqList<T>();
        for(int i=begin;  i<end;  i++) 
            list.insert(this.get(i));
        return list;
    }

        
    //��10��
    //��10.2.2   �ṩ�������������
    //1.  ˳������ṩ������
    public java.util.Iterator<T>  iterator()     // ���ص���������ʵ��Iterable<T>�ɵ����ӿ�
    {
        return new SeqIterator();
    }
    private class SeqIterator  implements java.util.Iterator<T>// ˽���ڲ��࣬ʵ�ֵ������ӿ�
    {
        int index=-1, succ=0;                    // ��ǰԪ�غͺ��Ԫ�����
        public boolean hasNext()                 // ���к��Ԫ�أ�����true
        {
            return this.succ<SeqList.this.n;     // SeqList.this.n���ⲿ�൱ǰʵ���ĳ�Ա����
        }
        public T next()                          // ���غ��Ԫ�أ���û�к��Ԫ�أ�����null
        {
            T value = SeqList.this.get(this.succ);// �����ⲿ��SeqList��ǰʵ���ĳ�Ա����
            if(value!=null)
            {
                this.index = this.succ++;
                return value;
            }
            throw new java.util.NoSuchElementException();  // �׳��޴�Ԫ���쳣
        }
        public void remove()                     // ɾ�������������ʾ�ļ��ϵ�ǰԪ��
        {
            if(this.index>=0 && this.index<SeqList.this.n)
            {
                // �����ⲿ��SeqList��ǰʵ���ĳ�Ա������ɾ����index��Ԫ�أ�����SeqList.this.n-1
                SeqList.this.remove(this.index);
                if(this.succ>0)
                    this.succ--;
                this.index=-1;                   // ���ò�������ɾ���ı��
            }
            else throw new IllegalStateException(); // �׳���Ч״̬�쳣
        }
    }//SeqIterator�ڲ������


    //��˼����10-3��˳������ṩ�б��������
    public java.util.ListIterator<T> listIterator()        //����Java�б����������
    {
        return new SeqListIterator(0);
    }
    public java.util.ListIterator<T> listIterator(final int index) //����Java�б����������
    {
        if(index>=0 && index<this.n)
            return new SeqListIterator(index);
        else throw new IndexOutOfBoundsException("Index: "+index);
    }

    //˽���ڲ��࣬�̳�ʵ�ֵ������ӿڵ�SeqIterator�ڲ��࣬ʵ���б�������ӿ�
    private class SeqListIterator extends SeqIterator implements java.util.ListIterator<T>
    {
        public SeqListIterator(int index)
        {
            this.succ=index;
        }
        public boolean hasPrevious()             //����ǰ��Ԫ�أ�����true
        {
            return this.succ!=0;
        }

        public T previous()                      //����ǰ��Ԫ��
        {
            T value = SeqList.this.get(this.succ-1);
            if(value!=null)
            {
                this.index = this.succ--;
                return value;
            }
            throw new java.util.NoSuchElementException();  //�׳��޴�Ԫ���쳣
        }
      
        public int nextIndex()                   //���غ��Ԫ�����
        {
            return this.succ;
        }
        public int previousIndex()               //����ǰ��Ԫ�����
        {
            return this.succ-1;
        } 
      
        public void set(T x)                     //�����ϵ�ǰԪ���滻Ϊx
        {
            if(this.index>=0 && this.index<SeqList.this.n)
                SeqList.this.set(this.index, x); //�����ⲿ�൱ǰʵ���ĳ�Ա����
            else throw new IllegalStateException(); //�׳���Ч״̬�쳣
        }
        public void add(T x)                     //����Ԫ��x
        {
            SeqList.this.insert(this.succ, x);   //�����ⲿ�൱ǰʵ���ĳ�Ա����
            this.succ++;                         //����Ԫ��Ϊ��ǰԪ��
        }
    }//SeqListIterator�ڲ������
}