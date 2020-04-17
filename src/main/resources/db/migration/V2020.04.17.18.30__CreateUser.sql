create table user
(
	id int auto_increment,
	nickname varchar(128) not null,
	avatar varchar(256) null,
	constraint user_pk
		primary key (id)
);

