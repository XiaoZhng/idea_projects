package com.zledu.qqcommon;

import java.io.Serializable;

/**
 * @author Alonso
 * 表示客户端和服务器端通信时的消息对象
 */
public class Message implements Serializable {//因为要作为对象流传递，所以要序列化
    private static final long serialVersionUID = 1L;//增强兼容性
    private String sender;//发送者
    private String getter;//接收者
    private String content;//消息内容
    private String sendTime;//发送时间
    private String mesType;//消息类型[可以在接口定义消息类型]

    //发送文件，属性扩展
    private byte[] bytes;//字节数组缓存
    private int fileLen = 0;//文件长度
    private String dest;//接收方保存文件地址
    private String src;//源文件路径

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public int getFileLen() {
        return fileLen;
    }

    public void setFileLen(int fileLen) {
        this.fileLen = fileLen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
