drop database if exists wenote;
create database if not exists wenote charset=utf8;
use wenote;
create table users(
userName char(20) not null primary key,
nickname char(10) not null,#�ǳ�
password char(32) not null,
telephone char(11) not null,
photo char(100) not null default 'default.jpg',
isAuthor char(1) not null default 'N',#'Y'��ʾ�����ߣ�'N'��ʾ��������
brief char(24) not null,#���Ҳ����������������24���ַ�
createTime timestamp not null default current_timestamp#����ʱ��
)engine=InnoDB charset=utf8;

create table note(
noteID int auto_increment primary key,
author char(20) not null,
noteTitle char(100) not null,
noteContent text not null,
visit int not null default 0,#�ʼǵķ��ʴ�����Ĭ��ֵ����
categoryName char(50) not null,
createTime timestamp not null default current_timestamp,#����ʱ��
updateTime timestamp null,#�޸�ʱ��
constraint note_users_fk foreign key (author) references users(userName)
)engine=InnoDB charset=utf8;

create table tag(
tagName char(50) not null,
noteID int not null,
primary key(tagName,noteID),
constraint tag_note_fk foreign key (noteID) references note(noteID)
)engine=InnoDB charset=utf8;

create table comment(
commentID int auto_increment primary key,
noteID int not null,
userName char(20) not null,
commentTitle char(100) not null,#�����б���
commentContent text not null,
remoteIP char(50) not null,
createTime timestamp not null default current_timestamp,#����ʱ��
constraint comment_note_fk foreign key (noteID) references note(noteID),
constraint comment_users_fk foreign key (userName) references users(userName)
)engine=InnoDB charset=utf8;

use wenote;
show tables;use wenote;
desc users;
show create table users;

insert into users values('administrator','�ʼ�����',md5(md5('administrator')),'00000000001','default.jpg','Y','�򵥾�����LESS IS MORE',null);
insert into users values('failure','������',md5(md5('failure')),'00000000002','default.jpg','N','����ʧ�ܣ�����ѡ�������',null);
insert into users values('success','��Ŭ��',md5(md5('success')),'00000000003','default.jpg','N','��һ��Ŭ������һ��ɹ���',null);

insert into note values(null,'administrator','administrator�ʼǱ���1','administrator�ʼ�����1',default,'�ʼ����1',null,null);
insert into note values(null,'administrator','administrator�ʼǱ���2','administrator�ʼ�����2',default,'�ʼ����1',null,null);
insert into note values(null,'administrator','administrator�ʼǱ���3','administrator�ʼ�����3',default,'�ʼ����2',null,null);

insert into tag values('�ʼǱ�ǩ1',1);
insert into tag values('�ʼǱ�ǩ1',2);
insert into tag values('�ʼǱ�ǩ1',3);
insert into tag values('�ʼǱ�ǩ2',1);
insert into tag values('�ʼǱ�ǩ2',2);
insert into tag values('�ʼǱ�ǩ2',3);
insert into tag values('�ʼǱ�ǩ3',1);
insert into tag values('�ʼǱ�ǩ3',2);
insert into tag values('�ʼǱ�ǩ3',3);

insert into comment values(null,1,'failure','failure���۱���1','failure��������1','127.0.0.1',null);
insert into comment values(null,2,'failure','failure���۱���2','failure��������2','127.0.0.1',null);
insert into comment values(null,3,'failure','failure���۱���3','failure��������3','127.0.0.1',null);
insert into comment values(null,1,'success','success���۱���4','success��������4','127.0.0.1',null);
insert into comment values(null,2,'success','success���۱���5','success��������5','127.0.0.1',null);
insert into comment values(null,3,'success','success���۱���6','success��������6','127.0.0.1',null);

select * from users;
select * from note;
select * from comment;

#�޸ıʼǵ��������
select * from note;
update note set visit=visit+1 where noteID=1;
select * from note;

#ɾ��ĳƪ�ʼ�ǰ��������ɾ���ñʼǵ��������ۺ����б�ǩ��ע����ɾ���ӱ��¼��
insert into note values(10,'administrator','administrator�ʼǱ���10','administrator�ʼ�����10',default,'�ʼ����2',null,null);
insert into tag values('�ʼǱ�ǩ1',10);
insert into comment values(100,10,'failure','failure���۱���100','failure��������100','127.0.0.1',null);
delete from note where noteID=10;#ɾ��ʧ��
delete from tag where noteID=10;
delete from comment where noteID=10;
delete from note where noteID=10;



#�����û�������ѯ�û����ж��û����Ƿ���ã�
select * from users where userName='failure';
#�����û��������룬��ѯ�û����ж��û��ܷ�ɹ���¼��
select * from users where userName='failure' and password=md5(md5('failure'));
#���ձʼǵ�ID����ѯ�ʼ���ϸ��Ϣ
select * from note where noteID=1;
#���ձʼǵ�ID����ѯ�ʼǵ����б�ǩ��
select tagName from tag where noteID=1;
#��ѯ����������ƣ����˵��ظ������ƣ�
select distinct categoryName from note;
#��ѯ���б�ǩ���ƣ����˵��ظ������ƣ�
select distinct tagName from tag;
#���ձʼǷ���ʱ��Ľ��򣬲�ѯ���бʼ�
select * from note order by createTime desc;

#��ѯĳƪ�ʼǵ���һƪ�ʼ�
select * from note where noteID>2 limit 1;
#��ѯĳƪ�ʼǵ���һƪ�ʼ�
select * from note where noteID<2 limit 1;
#��ѯĳ���û�����������
select * from comment where userName='failure' order by createTime desc;
#ģ����ѯ
select * from note where noteTitle like '%�ʼ�%' or noteContent like '%�ʼ�%' order by createTime desc;

#��ѯ���бʼ��������Ӧ�ıʼ�ƪ��
select categoryName,count(*) as num from note group by categoryName;
#��ѯ���бʼǱ�ǩ����ǩ��Ӧ�ıʼ�ƪ��
select tagName,count(*) num from tag join note on tag.noteID=note.noteID group by tagName;

#���ձʼ�ID����ѯ�ʼǵ�������Ϣ�Լ��������۵��û���Ϣ
select commentID,commentTitle,commentContent,comment.createTime createTime,
remoteIP,noteID,comment.userName userName,nickName,photo,brief 
from comment join users on comment.userName=users.userName 
where noteID=1 order by createTime desc;

#�������������ѯ���������бʼ�
select * from note where categoryName='�ʼ����2' order by createTime desc;
#���ݱ�ǩ������ѯ�ñ�ǩ�����бʼ�
select note.noteID,author,noteTitle,noteContent,visit,categoryName,
createTime,updateTime from note join tag on tag.noteID=note.noteID 
where tagName='�ʼǱ�ǩ1' order by createTime desc;