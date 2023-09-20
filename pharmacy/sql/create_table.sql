create table user
(
    id            int auto_increment comment 'id'
        primary key,
    user_name     varchar(255) charset utf8 null comment '用户名',
    user_password varchar(255) charset utf8 null comment '密码',
    real_name     varchar(255) charset utf8 null comment '真实姓名',
    dept          varchar(255) charset utf8 null comment '所属部门',
    enable        varchar(255) charset utf8 null comment '是否启用'
);

create table drugs
(
    id             int auto_increment comment 'id'
        primary key,
    drugsName      varchar(255) charset utf8 null comment '药品名称',
    factory        varchar(255) charset utf8 null comment '生产厂家',
    specifications varchar(255) charset utf8 null comment '规格',
    company        varchar(255) charset utf8 null comment '药品单位',
    price          varchar(255)              null comment '药品单价'
);

create table drugstock
(
    id       int auto_increment comment 'id'
        primary key,
    drugs_id int null comment '药品id',
    stock    int null comment '库存'
);