package com.zledu.interFace_;

public class InterfacePolyArr {
    public static void main(String[] args) {

        //多态数组 -> 接口类型数组
        USB[] usbs = new USB[2];
        usbs[0] = new Phone_();
        usbs[1] = new Camera_();

        //遍历USB数组
        for (int i = 0; i < usbs.length; i++) {
            usbs[i].hi();//动态绑定机制
            //和前面一样，我们仍然需要进行类型的向下转型
            if (usbs[i] instanceof Phone_){ //判断运行类型是 Phone_
                ((Phone_) usbs[i]).cal();
            }
        }
    }
}

interface USB{
    void hi();
}//接口
class Phone_ implements USB{
    public void cal(){
        System.out.println("手机通话中...");
    }

    @Override
    public void hi() {
        System.out.println("手机使用中...");
    }
}

class Camera_ implements USB{
    @Override
    public void hi() {
        System.out.println("相机使用中...");
    }
}
