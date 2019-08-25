drop table if exists User;
drop table if exists Training;
drop table if exists Exercise;
drop table if exists Settable;
drop table if exists Running;

create table if not exists User(
									id bigint not null primary key auto_increment,
                                    name varchar(20) not null,
									password binary(64) not null
								);

create table if not exists Training(
										id bigint not null primary key auto_increment,
                                        id_user bigint not null,
                                        date timestamp not null,
                                        name varchar(20) not null
									);
                                    
create table if not exists Exercise(
										id bigint not null primary key auto_increment,
										id_training bigint not null,
                                        name varchar(20) not null,
                                        comments varchar(100)
									);
                                    
create table if not exists Settable(
										id bigint not null primary key auto_increment,
                                        id_exercise bigint not null,
                                        set_column int not null,
                                        repetitions int not null,
                                        weight int not null
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
			add foreign key (id_user) references User(id);
alter table Exercise
			add foreign key (id_training) references Training(id);
alter table Settable
			add foreign key (id_exercise) references Exercise(id);
alter table Running
			add foreign key (id_user) references User(id);