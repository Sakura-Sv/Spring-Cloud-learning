create table product
(
    id int auto_increment,
    name varchar(64) not null,
    cover_image varchar(128) null,
    price int not null,
    constraint product_pk
        primary key (id)
);

create table product_comment
(
    id int auto_increment,
    product_id int not null,
    author_id int not null,
    content varchar(200) null,
    create_time datetime null,
    constraint product_comment_pk
        primary key (id),
    constraint product_comment_product_id_fk
        foreign key (product_id) references product (id),
    constraint product_comment_user_id_fk
        foreign key (author_id) references user (id)
);

