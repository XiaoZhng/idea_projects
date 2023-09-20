package com.zledu.dao_.test;

import com.zledu.dao_.dao.ActorDAO;
import com.zledu.dao_.dao.goodsDAO;
import com.zledu.dao_.domain.Actor;
import com.zledu.dao_.domain.goods;
import org.junit.Test;

import java.util.List;

/**
 * @author Alonso
 */
public class testDAO {

    //测试 ActorDAO对 actor表的crud操作
    @Test
    public void test(){

        ActorDAO actorDAO = new ActorDAO();

        //多行操作
        List<Actor> actors =
                actorDAO.QueryMultiply("select * from actor where id >= ?", Actor.class, 1);
        System.out.println("多行操作====");
        for (Actor actor : actors) {
            System.out.println(actor);
        }

        //单行操作
        System.out.println("单行操作====");
        Actor actor =
                actorDAO.QuerySingle("select * from actor where id = ?", Actor.class, 2);
        System.out.println(actor);

        //单行单列操作
        System.out.println("单行单列操作====");
        Object o =
                actorDAO.QueryScalar("select name from actor where id = ?", 3);
        System.out.println(o);

        //dml操作
        System.out.println("dml操作====");
        int update = actorDAO.update("insert into actor values(null, ?, ?, ?, ?)", "jack", "男", "2020-09-09", "117");
        System.out.println(update > 0? "执行成功" : "没有对数据库发生改变");

    }

    //测试 goodsDAO对 goods表的crud操作
    @Test
    public void goodsTest(){

        goodsDAO goodsDAO = new goodsDAO();

        //多行操作
        System.out.println("多行操作====");
        List<goods> goods =
                goodsDAO.QueryMultiply("select * from goods where id >= ?", goods.class, 1);
        for (goods goods1 : goods) {
            System.out.println(goods1);
        }


        //单行操作
        System.out.println("单行操作====");
        goods goods2 = goodsDAO.QuerySingle("select * from goods where id = ?", goods.class, 2);
        System.out.println(goods2);

        //单行单列
        System.out.println("单行单列====");
        Object o = goodsDAO.QueryScalar("select goods_name from goods where id = ?", 3);
        System.out.println(o);

        //dml操作
        System.out.println("dml操作====");
        int oppo = goodsDAO.update("insert into goods values(null, ?, ?)", "oppo手机", "500.1");
        System.out.println(oppo > 0 ? "执行成功"  : "没有对数据库发生改变");

    }
}
