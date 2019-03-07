create table airlines(id int PRIMARY KEY,airlines_name varchar2(30) NOT NULL UNIQUE);

create sequence seq_airlinesid 
start with 1
increment by 1;

create table passengers(id int CONSTRAINT pk_passangers_id primary key,name varchar2(20),email varchar2(30)not null,
phonenumber long,username varchar2(20)not null,password varchar2(30) not null,
created_date date);

SELECT *  from passengers;

create sequence seq_passengers_id
start with 1
increment by 1;

ALTER TABLE PASSENGERS ADD father_dateofbirth date;

create table airlines_flight(id int CONSTRAINT pk_airlines_id primary key,flight_name varchar2(30),flight_no varchar2(10),
adult_seats int,child_seats int,adult_price int,child_price int,status char,flight_class varchar(30));

alter table AIRLINES_FLIGHT ADD CONSTRAINT fk_flightname foreign key (flight_name) references airlines(id);

create sequence seq_airlines_id
start with 1
increment by 1;

create table bookingairlines(id int primary key,airlines_id int CONSTRAINT fk_booking_airlines_id references airlines(id),
adult_seats int,child_seats int,co_passangersname varchar2(40),
price int,booking_date date,
passengers_id int CONSTRAINT fk_booking_passengers_id references passengers(id));

alter table BOOKINGAIRLINES ADD infant int;
ALTER TABLE BOOKINGAIRLINES ADD cancel_status int;
ALTER TABLE BOOKINGAIRLINES ADD pnr_no VARCHAR2(10);

select * from bookingairlines;

delete from bookingairlines;

select * from airlines;

update airlines set ADULT_SEATS=30,CHILD_SEATS=16 where id=11;
commit;

create sequence seq_bookingairlines_id
start with 1
increment by 1;

CREATE TABLE flight_destinations(id int CONSTRAINT pk_flight_destinations_id PRIMARY KEY,place varchar2(30) NOT NULL UNIQUE,
created_by int,created_time timestamp,updated_by int,updated_time timestamp);

CREATE SEQUENCE flight_destinations_id_seq 
START WITH 1
INCREMENT by 1;


