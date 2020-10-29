create table reimbursement.ers_reimbursement_status(
reimb_status_id  serial primary key,
reimb_status varchar(10)
);

create table reimbursement.ers_reimbursement_type(
reimb_type_id serial primary key,
reimb_type varchar(10)
);

create table reimbursement.ers_user_roles(
ers_user_role_id serial primary key,
user_role varchar(20)
);

create table reimbursement.ers_users(
ers_users_id serial primary key,
ers_username varchar(50),
ers_password varchar(50),
user_first_name varchar(100),
user_last_name varchar(100),
user_email varchar(150),
user_role_id int4 references reimbursement.ers_user_roles(ers_user_role_id)
);

create table reimbursement.ers_reimbursement (
reimb_id serial primary key,
reimb_amount  numeric,
reimb_submitted date,
reimb_resolved date,
reimb_description varchar(250),
reimb_receipt bytea,
reimb_author int4 references reimbursement.ers_users(ers_users_id),
reimb_resolver int4 references reimbursement.ers_users(ers_users_id),
reimb_status_id int4 references reimbursement.ers_reimbursement_status(reimb_status_id),
reimb_type_id int4  references reimbursement.ers_reimbursement_type(reimb_type_id));

create view reimbursement.vw_reimbursement as 
select r.reimb_id ,r.reimb_amount,r.reimb_description ,r.reimb_resolved,r.reimb_submitted , 
s.reimb_status_id,s.reimb_status, 
t.reimb_type_id,t.reimb_type,
r.reimb_author, concat(u.user_first_name,'-', u.user_last_name) as author_name ,
r.reimb_resolver, concat(eu.user_first_name,'-', eu.user_last_name) as resolver_name
from reimbursement.ers_reimbursement r  
join reimbursement.ers_reimbursement_status s on  r.reimb_status_id = s.reimb_status_id 
join reimbursement.ers_reimbursement_type t on r.reimb_type_id = t.reimb_type_id 
join reimbursement.ers_users u on r.reimb_author=u.ers_users_id 
join reimbursement.ers_users eu on r.reimb_resolver =eu.ers_users_id;

create view reimbursement.vw_users as
select u.ers_users_id, u.ers_username ,u.ers_password ,u.user_first_name ,u.user_last_name ,u.user_email,r.ers_user_role_id,r.user_role 
from reimbursement.ers_users u join reimbursement.ers_user_roles r on u.user_role_id =r.ers_user_role_id;

create or replace function reimbursement.hashPassword()
returns trigger
as $$
begin
if(new.ers_password=old.ers_password)then
return new;
end if;
new.ers_password :=
md5(new.ers_username||new.ers_password||'salt');
return new;
end;
$$ language plpgsql;

DROP TRIGGER IF EXISTS hashPass on reimbursement.ers_users;
create trigger hashPass before insert or update on reimbursement.ers_users for each row execute function reimbursement.hashPassword();

insert into  reimbursement.ers_reimbursement_status(reimb_status) values('Pending');
insert into  reimbursement.ers_reimbursement_status(reimb_status) values('Denied');
insert into  reimbursement.ers_reimbursement_status(reimb_status) values('Approved');

insert into reimbursement.ers_reimbursement_type(reimb_type) values ('Lodging');
insert into reimbursement.ers_reimbursement_type(reimb_type) values ('Travel');
insert into reimbursement.ers_reimbursement_type(reimb_type) values ('Food');
insert into reimbursement.ers_reimbursement_type(reimb_type) values ('Other');

insert into reimbursement.ers_user_roles(user_role) values ('finance manager');
insert into reimbursement.ers_user_roles(user_role) values ('employee');