package com.zledu.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Alonso
 * 体验正则表达式的威力，给我们文本处理带来哪些便利
 */
public class Regexp_ {
    public static void main(String[] args) {

        //假定，编写了爬虫，从百度页面得到如下文本
//        String content = "1995年，互联网的蓬勃发展给了Oak机会。业界为了使死板、单调的" +
//                "静态网页能够“灵活”起来，急需一种软件技术来开发一种程序，这种程序可以通过" +
//                "网络传播并且能够跨平台运行。于是，世界各大IT企业为此纷纷投入了大量的人力" +
//                "、物力和财力。这个时候，Sun公司想起了那个被搁置起来很久的Oak，并且重新审" +
//                "视了那个用软件编写的试验平台，由于它是按照嵌入式系统硬件平台体系结构进行编" +
//                "写的，所以非常小，特别适用于网络上的传输系统，而Oak也是一种精简的语言，程" +
//                "序非常小，适合在网络上传输。Sun公司首先推出了可以嵌入网页并且可以随同网页" +
//                "在网络上传输的Applet（Applet是一种将小程序嵌入到网页中进行执行的技术），" +
//                "并将Oak更名为Java。5月23日，Sun公司在Sun world会议上正式发布Java和" +
//                "HotJava浏览器。IBM、Apple、DEC、Adobe、HP、Oracle、Netscape和微" +
//                "软等各大公司都纷纷停止了自己的相关开发项目，竞相购买了Java使用许可证，并为" +
//                "自己的产品开发了相应的Java平台。";

//        String content = "</span><a target=\"_blank\" title=\"9月16日，接英雄回家\" href=\"/s?wd=9%E6%9C%8816%E6%97%A5%EF%BC%8C%E6%8E%A5%E8%8B%B1%E9%9B%84%E5%9B%9E%E5%AE%B6&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=459daY%2Fj0u2IIrdHsF47kRpSoFXWJ%2BCFTVYIKXx1aN6R9cPgaHgrPmrRf%2Bk&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_1&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 1, page: 1&#39;}\">9月16日，接英雄回家</a></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   c-index-single-hot1\" style=\"opacity:1;\">1</span><a target=\"_blank\" title=\"深圳立法临终抢救由患者说了算\" href=\"/s?wd=%E6%B7%B1%E5%9C%B3%E7%AB%8B%E6%B3%95%E4%B8%B4%E7%BB%88%E6%8A%A2%E6%95%91%E7%94%B1%E6%82%A3%E8%80%85%E8%AF%B4%E4%BA%86%E7%AE%97&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_2&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 2, page: 1&#39;}\">深圳立法临终抢救由患者说了算</a><span class=\"c-text c-text-hot opr-toplist1-label_3Mevn\">热</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   c-index-single-hot2\" style=\"opacity:1;\">2</span><a target=\"_blank\" title=\"中科院一男子向女生杯中投放异物\" href=\"/s?wd=%E4%B8%AD%E7%A7%91%E9%99%A2%E4%B8%80%E7%94%B7%E5%AD%90%E5%90%91%E5%A5%B3%E7%94%9F%E6%9D%AF%E4%B8%AD%E6%8A%95%E6%94%BE%E5%BC%82%E7%89%A9&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_3&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 3, page: 1&#39;}\">中科院一男子向女生杯中投放异物</a><span class=\"c-text c-text-hot opr-toplist1-label_3Mevn\">热</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   c-index-single-hot3\" style=\"opacity:1;\">3</span><a target=\"_blank\" title=\"香港故宫文化博物馆建成背后的故事\" href=\"/s?wd=%E9%A6%99%E6%B8%AF%E6%95%85%E5%AE%AB%E6%96%87%E5%8C%96%E5%8D%9A%E7%89%A9%E9%A6%86%E5%BB%BA%E6%88%90%E8%83%8C%E5%90%8E%E7%9A%84%E6%95%85%E4%BA%8B&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_4&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 4, page: 1&#39;}\">香港故宫文化博物馆建成背后的故事</a><span class=\"c-text c-text-hot opr-toplist1-label_3Mevn\">热</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">4</span><a target=\"_blank\" title=\"父亲锻炼孩子自己回家 孩子走丢\" href=\"/s?wd=%E7%88%B6%E4%BA%B2%E9%94%BB%E7%82%BC%E5%AD%A9%E5%AD%90%E8%87%AA%E5%B7%B1%E5%9B%9E%E5%AE%B6%20%E5%AD%A9%E5%AD%90%E8%B5%B0%E4%B8%A2&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_5&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 5, page: 1&#39;}\">父亲锻炼孩子自己回家 孩子走丢</a></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT toplist1-ad_MP3Tt  toplist1-hot-normal_12THH\" style=\"opacity:1;\"></span><a target=\"_blank\" title=\"智慧旗舰大六座问界M7发布\" href=\"/s?wd=%E9%97%AE%E7%95%8CM7&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_6&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 6, page: 1&#39;}\">智慧旗舰大六座问界M7发布</a><span class=\"c-text c-text-business opr-toplist1-label_3Mevn\">商</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">5</span><a target=\"_blank\" title=\"小学毕业论文答辩被批过于成人化\" href=\"/s?wd=%E5%B0%8F%E5%AD%A6%E6%AF%95%E4%B8%9A%E8%AE%BA%E6%96%87%E7%AD%94%E8%BE%A9%E8%A2%AB%E6%89%B9%E8%BF%87%E4%BA%8E%E6%88%90%E4%BA%BA%E5%8C%96&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_7&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 7, page: 1&#39;}\">小学毕业论文答辩被批过于成人化</a><span class=\"c-text c-text-new opr-toplist1-label_3Mevn\">新</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">6</span><a target=\"_blank\" title=\"15岁童星为何从六楼纵身一跃\" href=\"/s?wd=15%E5%B2%81%E7%AB%A5%E6%98%9F%E4%B8%BA%E4%BD%95%E4%BB%8E%E5%85%AD%E6%A5%BC%E7%BA%B5%E8%BA%AB%E4%B8%80%E8%B7%83&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_8&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 8, page: 1&#39;}\">15岁童星为何从六楼纵身一跃</a></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">7</span><a target=\"_blank\" title=\"#演员袁冰妍公司偷漏税被罚97万#\" href=\"/s?wd=%23%E8%A2%81%E5%86%B0%E5%A6%8D%E5%85%AC%E5%8F%B8%E5%81%B7%E6%BC%8F%E7%A8%8E%E8%A2%AB%E7%BD%9A97%E4%B8%87%23&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=8207hSnHaw03PtMNiU4ZWqjcZlBHfvzJIyqT9NuL6BwzxyaVl%2FZ51SfPuVY&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_9&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 9, page: 1&#39;}\">#演员袁冰妍公司偷漏税被罚97万#</a><span class=\"c-text c-text-new opr-toplist1-label_3Mevn\">新</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">8</span><a target=\"_blank\" title=\"6省15地再现疫情 问题出在哪\" href=\"/s?wd=6%E7%9C%8115%E5%9C%B0%E5%86%8D%E7%8E%B0%E7%96%AB%E6%83%85%20%E9%97%AE%E9%A2%98%E5%87%BA%E5%9C%A8%E5%93%AA&amp;usm=6&amp;ie=utf-8&amp;rsv_pq=a5561ba500013bed&amp;oq=java&amp;rsv_t=31c8%2BnpsNGpuIt6Vy%2F8ynd9KJ8f%2BWVgfE9GGp2IzGRwUUGW21ajudeftZ88&amp;rqid=a5561ba500013bed&amp;rsf=7cd1b0667e0ef7016ee9637832f8a0c9_1_15_10&amp;rsv_dl=0_right_fyb_pchot_20811&amp;sa=0_right_fyb_pchot_20811\" class=\"c-font-medium c-color-t opr-toplist1-subtitle_3FULy\" data-click=\"{&#39;clk_info&#39;: &#39;index: 10, page: 1&#39;}\">6省15地再现疫情 问题出在哪</a><span class=\"c-text c-text-hot opr-toplist1-label_3Mevn\">热</span></div></div><div class=\"toplist1-tr_4kE4D\"><div class=\"toplist1-td_3zMd4 opr-toplist1-link_2YUtD\"><span class=\"c-index-single toplist1-hot_2RbQT   toplist1-hot-normal_12THH\" style=\"opacity:1;\">9</span>";
        String content = "以下列出留用的内部私有地址\n" +
                "A类 10.0.0.0--10.255.255.255\n" +
                "B类 172.16.0.0--172.31.255.255\n" +
                "C类 192.168.0.0--192.168.255.255";

        //提取文章中所有的英文单词
        //提取文章中所有的数字
        //提取文章中所有的英文单词和数字
        //提取文章中的热搜标题
        //提取文章中的IP地址

        //(1)：传统方法，使用遍历方式，代码量大，效率不高
        //(2)：正则表达式：
        //1.先创建一个 Pattern对象，模式对象，可以理解成就是一个正则表达式对象
        //Pattern compile = Pattern.compile("[a-zA-Z]+");
        //Pattern compile = Pattern.compile("[0-9]+");
        //Pattern compile = Pattern.compile("([a-zA-Z]+)|([0-9]+)");
        //Pattern compile = Pattern.compile("<a target=\"_blank\" title=\"(\\S*)\"");
        Pattern compile = Pattern.compile("\\d+\\.\\d+\\.\\d+\\.\\d+");
        //2.创建一个匹配器对象
        //理解：就是 matcher 匹配器按照 pattern(模式/样式)，到 content 文本中去匹配
        //找到就返回true，否则返回false
        int num = 0;
        Matcher matcher = compile.matcher(content);
        //3.开始循环匹配
        while (matcher.find()){
            //匹配内容，文本，放到 m.group(0)
            System.out.println("找到：" + (++num) + " " + matcher.group(0));
        }

        //结论：正则表达式是处理文本的利器
    }
}
