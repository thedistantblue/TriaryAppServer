drop table if exists User;
drop table if exists Training;
drop table if exists Exercise;
drop table if exists Settable;
drop table if exists Running;

create table if not exists User(
									id bigint not null primary key auto_increment,
                                    name varchar(20) not null,
									password varchar(50) not null
								);

create table if not exists Training(
										id bigint not null primary key auto_increment,
                                        user_id bigint not null,
                                        uuid_id varchar(50) not null unique,
                                        training_date timestamp not null,
                                        training_name varchar(20) not null
									);
                                    
create table if not exists Exercise(
										id bigint not null primary key auto_increment,
										training_id varchar(50) not null,
										uuid_id varchar(50) not null unique,
                                        exercise_name varchar(20) not null,
                                        exercise_comments varchar(100)
									);
                                    
create table if not exists Settable(
										id bigint not null primary key auto_increment,
                                        exercise_id varchar(50) not null,
                                        uuid_id varchar(50) not null unique ,
                                        set_number int not null,
                                        set_repetitions int not null,
                                        set_weight int not null
									);

create table if not exists Running(
										id bigint not null primary key auto_increment,
                                        id_user bigint not null,
                                        name varchar(20) not null,
                                        date timestamp not null,
                                        distance double not null,
                                        speed double not null,
                                        time double not null,
                                        calories double not null,
                                        comments varchar(100)
									);
                                        
alter table Training 
			add foreign key (user_id) references User(id);
alter table Exercise
			add foreign key (training_id) references Training(uuid_id);
alter table Settable
			add foreign key (exercise_id) references Exercise(uuid_id);
alter table Running
			add foreign key (id_user) references User(id);