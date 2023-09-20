//§8.2.2   静态索引，字典集合
//【例8.1】Java关键字集合的存储与查找，字典的稀疏索引技术。

public class StringSet  //字符串集合 
{
	public static String[] setNames={"Java关键字集合","月份集合","月份集合","星期集合"};
	public static String[][] sets={
		//图8.4，Java关键字集合，排序（升序），字典主表。数组元素不含空对象
        {"abstract","assert","boolean","break","byte","case","catch","char","class","continue",
         "default","do","double","else","extends","false","final","finally","float","for",
         "if","implements","import","instanceof","int","interface","long","native","new","null",
         "package","private","protected","public","return","short","static","super","switch",
         "synchronized","this","throw","throws","transient","true","try","void","volatile","while"},
        
        //月份集合，英文月份字符串集合
        {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"},

        {"January","February","March","April","May","June",
         "July","August","September","October","November","December"},
		{"1","2","3","4","5","6",
				"7","8","9","10","11","12"},

			//星期集合，英文星期字符串集合
        {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"}};        
}
