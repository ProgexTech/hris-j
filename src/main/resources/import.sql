--Department
insert into department(id, name) values (1, 'HR')
insert into department(id, name) values (2, 'Admin')
insert into department(id, name) values (3, 'Development')
insert into department(id, name) values (4, 'IT Support')

--Designation
insert into Designation(id, title, description) values (1, 'Software Engineer','Software Engineer')
insert into Designation(id, title, description) values (2, 'HR Manager', 'HR Manager')
insert into Designation(id, title, description) values (3, 'Admin Assistant', 'Admin Assistant')
insert into Designation(id, title, description) values (4, 'Technical Lead', 'Technical Lead')

--Role
insert into role(id, type) values (1, 'Super Admin')
insert into role(id, type) values (2, 'Admin')
insert into role(id, type) values (3, 'User')

--User
insert into user(id, user_name, password, first_name, last_name, nic, address, email, supervisor_id, dob, active, role_id, designation_id, department_id) values(1, 'admin','admin', 'Kamal', 'Perera', 'G328769R', 'Colombo', 'admin@gmail.com', 2,'1980-05-20', true, 1, 3, 2)
