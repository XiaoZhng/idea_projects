package com.zledu;

/**
 * @author Alonso
 */
public class BufferedReader_ extends Reader_{
    private Reader_ reader_;//属性是 Reader_类型

    //接收 Reader_ 子类对象
    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    //也可以封装一层，单独调
    public void readFile(){
        reader_.readFile();
    }

    //让方法更加灵活，多次读取文件，或者加缓冲char[]
    public void readFile(int num){
        for (int i = 0; i < num; i++){
            reader_.readFile();
        }
    }

    //扩展 readString，批量处理字符串数据
    public void readString(int num){
        for (int i = 0; i < num; i++){
            reader_.readString();
        }
    }

}
