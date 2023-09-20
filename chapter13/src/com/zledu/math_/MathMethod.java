package com.zledu.math_;

public class MathMethod {
    public static void main(String[] args) {

        /**
         * abs()：绝对值
         * pow()：求幂
         * ceil()：向上取整
         * floor()：向下取整
         * round()：四舍五入
         * sqrt()：求开方
         * random()：求随机数
         * max()：求两个数最大值
         * min()：求两个数最小值
         */

        /**
         * random 求随机数
         * random 返回的是 0 <= x < 1 之间的一个随机小数
         * 思考：请写出 a-b之间的一个随机整数，a,b为整数，比如 a=2,b=7
         * 即返回一个 2 <= x <= 7
         * 解读：
         * (1) (int)(a) <= x <= (int)(a + Math.random() * (b - a +1))
         * (2) 使用具体的数给举例 a=2,b=7
         * (int)(a + Math.random() * (b - a + 1)) = (int)(2 + Math.random() * 6)
         * Math.random() * 6 返回的就是 0 <= x < 6 的小数
         * 2 + Math.random() * 6 返回的就是 2 <= x <= 8 的小数
         * (int)(2 + Math.random() * 6) = 2 <= x <= 7
         * 公式就是 (int)(a + Math.random() * (b - a + 1))
         */
        for (int i = 0; i < 10; i++){
            System.out.println((int)(2 + Math.random() * (7 - 2 + 1)));
        }
    }
}
