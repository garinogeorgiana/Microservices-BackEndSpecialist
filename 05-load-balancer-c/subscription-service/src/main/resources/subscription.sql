insert into plan(name, price) values ('Plan Intensivo', 500)
insert into plan(name, price) values ('Plan Relax', 200)

insert into subscription(start_date, end_date, user_id, plan_id) values ('2022-08-31', '2022-12-31', 1, 1)
insert into subscription(start_date, end_date, user_id, plan_id) values ('2022-08-31', '2022-12-31', 2, 1)
insert into subscription(start_date, end_date, user_id, plan_id) values ('2022-06-31', '2022-12-31', 3, 2)
insert into subscription(start_date, end_date, user_id, plan_id) values ('2022-06-31', '2022-12-31', 4, 2)
insert into subscription(start_date, end_date, user_id, plan_id) values ('2022-06-31', '2022-08-11', 5, 2)