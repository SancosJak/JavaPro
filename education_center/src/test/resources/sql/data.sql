-- INSERT INTO course (title, description, begin_date, end_date, price, state) VALUES
--                                                                                 ('Course 1 Title', 'Description for course 1', '2024-06-01', '2024-07-01', 100.00, 'PUBLISHED'),
--                                                                                 ('Course 2 Title', 'Description for course 2', '2024-07-01', '2024-08-01', 150.00, 'DRAFT'),
--                                                                                 ('Course 3 Title', 'Description for course 3', '2024-08-01', '2024-09-01', 120.00, 'PUBLISHED'),;
--                                                                                 ('Course 4 Title', 'Description for course 4', '2024-09-01', '2024-10-01', 120.00, 'DRAFT');
insert into course(description,begin_date,end_date,price,state,title)
values ( 'Description1','2024-05-06','2024-05-06',100,'DRAFT' ,'Course1');

insert into course(description,begin_date,end_date,price,state,title)
values ( 'Description2','2024-05-06','2024-05-06',60,'PUBLISHED' ,'Course2');

insert into course(description,begin_date,end_date,price,state,title)
values ( 'Description3','2024-05-06','2024-05-06',10,'DRAFT' ,'Course3');

insert into course(description,begin_date,end_date,price,state,title)
values ( 'Description4','2024-05-06','2024-05-06',20,'PUBLISHED' ,'Course4');