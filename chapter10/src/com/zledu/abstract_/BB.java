package com.zledu.abstract_;

public class BB extends Template{

    public void job(){

        long num = 0;
        for (int i = 0; i < 99999; i++) {//实现Template的抽象方法job
            num += i;
        }

    }

}
