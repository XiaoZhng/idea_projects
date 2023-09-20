package com.zledu.qqcommon;

/**
 * @author Alonso
 * 表示消息类型
 */
public interface MessageType {
    //1.在接口中定义一些变量
    //2.不同的常量的值，表示不同的消息类型
    String MESSAGE_LOGIN_SUCCESS = "1";//表示登录成功
    String MESSAGE_LOGIN_FALT = "2";//表示登录失败
    String MESSAGE_COMM_MES = "3";//普通信息包
    String MESSAGE_GET_ONLINE_FRIEND = "4";//获取在线用户
    String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT = "6";//客户端请求退出
    String MESSAGE_To_All = "7";//群发消息
    String MESSAGE_FILE_MES = "8";//文件信息(发送文件)
    String Message_offLine = "9";//用户不在线
}
