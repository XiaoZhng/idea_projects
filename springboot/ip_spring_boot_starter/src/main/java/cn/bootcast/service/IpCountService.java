package cn.bootcast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author Alonso
 */
public class IpCountService {

    private HashMap<String, Integer> hashMap = new HashMap<>();
    //IP地址需要请求才能拿到
    @Autowired
    //当前的request对象的注入工作由使用当前starter的工程提供自动装配
    private HttpServletRequest httpServletRequest;

    public void count(){
        //每次调用当前操作，就记录当前访问的IP，然后累加访问次数
        //1.获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        System.out.println("==============" + ip);
        //2.根据IP地址Map取值，并递增
        Integer count = hashMap.get(ip);
        if (count == null){
            hashMap.put(ip, 1);
        }else {
            hashMap.put(ip, count + 1);
        }
    }
}
