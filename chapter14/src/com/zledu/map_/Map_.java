package com.zledu.map_;

import java.util.HashMap;
import java.util.Map;

public class Map_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        //解读Map 接口实现类的特点，使用实现类HashMap
        /**
         * 1. Map与Collection并列存在，用于保存具有映射关系的数据：Key-Value(双列元素)
         * 2. Map 中的 key 和 value 可以是任何引用类型的数据，会封装到HashMap$Node 对象中
         * 3. Map 中的 key值不允许重复
         * 4. Map 中的 value值可以重复
         * 5. Map 中的key 可以为null，value也可以为null，注意：key 为null，只能有一个，value为 null，可以多个
         * 6. 常用String类作为Map 的key
         * 7. key 和 value 之间存在单向一对一关系，即通过指定的 key 总能找到对应的 value
         */

        Map map = new HashMap();
        map.put("No1", "jack");
        map.put("No2", "tom");
        map.put("No2", "tim");//当有相同的k，就等价于替换
        map.put("No3", "tim");
        map.put(null, null);
        map.put(null, "Jams");//等价于替换
        map.put("No4", null);
        map.put("No5", null);
        System.out.println(map.get("No2"));//tim

        System.out.println("map=" + map);

    }
}
