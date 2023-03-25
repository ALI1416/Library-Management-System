CREATE DATABASE ck
go
USE ck
go
CREATE TABLE admin (
  id int  NOT NULL identity,
  user1 varchar(16) UNIQUE NOT NULL,
  pwd varchar(16) NOT NULL,
  PRIMARY KEY (id)
)
go
CREATE TABLE book (
  id int  NOT NULL identity,
  name varchar(128) NOT NULL,
  author varchar(16) NOT NULL,
  publishing varchar(16) NOT NULL,
  isbn char(13) NOT NULL,
  count1 int  NOT NULL,
  remain int  NOT NULL,
  PRIMARY KEY (id)
)
go
CREATE TABLE reader (
  id int NOT NULL identity,
  name varchar(16) NOT NULL,
  gender tinyint NOT NULL,
  year1 int NOT NULL,
  id_card char(18) NOT NULL,
  tel char(11) NOT NULL,
  addr varchar(128) NOT NULL,
  PRIMARY KEY (id)
)
go
CREATE TABLE borrow (
  id int NOT NULL identity,
  reader_id int NOT NULL,
  book_id int NOT NULL,
  borrow_time datetime NOT NULL,
  return_borrow tinyint  NOT NULL DEFAULT '0',
  PRIMARY KEY (id),
  FOREIGN KEY (reader_id) REFERENCES reader (id),
  FOREIGN KEY (book_id) REFERENCES book (id)
)
go
INSERT INTO admin(user1,pwd) VALUES ('root', 'root');
INSERT INTO admin(user1,pwd) VALUES ('ck', 'chengkai');
INSERT INTO admin(user1,pwd) VALUES ('txf', 'txf');
INSERT INTO book(name,author,publishing,isbn,count1,remain) VALUES ('计算机网络', '谢希仁', '电子工业出版社', '9787121302954', '10', '10');
INSERT INTO book(name,author,publishing,isbn,count1,remain) VALUES ('SqlServer2008数据库应用技术', '刘卫国、刘泽星', '人民邮电出版社', '9787115377302', '25', '24');
INSERT INTO book(name,author,publishing,isbn,count1,remain) VALUES ('JavaEE企业级应用开发教程', '黑马程序员', '人民邮电出版社', '9787115461025', '17', '16');
INSERT INTO book(name,author,publishing,isbn,count1,remain) VALUES ('Android应用开发教程', '钟元生、高成珍', '江西高校出版社', '9787549317066', '13', '12');
INSERT INTO reader(name,gender,year1,id_card,tel,addr) VALUES ('ck', '1', '1998', '370811199805250000', '18807700000', '山东济宁');
INSERT INTO reader(name,gender,year1,id_card,tel,addr) VALUES ('txf', '0', '1996', '451000000000000000', '18888888888', '广西玉林');
INSERT INTO reader(name,gender,year1,id_card,tel,addr) VALUES ('zk', '1', '1995', '510000000000000000', '17700000000', '四川绵阳');
INSERT INTO reader(name,gender,year1,id_card,tel,addr) VALUES ('hhd', '0', '1996', '310000000000000000', '11100000000', '福建漳州');
INSERT INTO borrow(reader_id,book_id,borrow_time,return_borrow) VALUES ('1', '1', '2019-05-08 11:03:35', '1');
INSERT INTO borrow(reader_id,book_id,borrow_time,return_borrow) VALUES ('2', '2', '2019-05-08 11:04:36', '0');
INSERT INTO borrow(reader_id,book_id,borrow_time,return_borrow) VALUES ('1', '3', '2019-05-08 11:11:24', '0');
INSERT INTO borrow(reader_id,book_id,borrow_time,return_borrow) VALUES ('1', '4', '2019-05-08 11:12:10', '0');
go
create trigger book_borrow on borrow for insert as
declare @bookId int
select @bookId=book_id from inserted
update book set remain=remain-1 where id=@bookId
go
create trigger book_return on borrow for update as
declare @newRB int, @oldRB int, @bookId int
select @newRB=return_borrow from inserted
select @oldRB=return_borrow from deleted
select @bookId=book_id from deleted
if(@newRB!=@oldRB)
	begin
	if(@newRB=1)
		begin
		update book set remain=remain+1 where id=@bookId
		end
	if(@newRB=0)
		begin
		update book set remain=remain-1 where id=@bookId
		end
	end
