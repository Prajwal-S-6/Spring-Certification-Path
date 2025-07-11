create table employee
(
    id          int,
    firstName   varchar(32),
    lastName    varchar(32),
    email       varchar(32),
    phoneNumber varchar(32),
    hireDate    date,
    salary      int
);

insert into employee(id, firstName, lastName, email, phoneNumber, hireDate, salary)
values (1, 'John', 'Doe', 'John.Doe@corp.com', '555-55-55', '2019-06-05', 70000),
       (2, 'Willow', 'Zhang', 'Willow.Zhang@corp.com', '555-55-56', '2019-07-12', 80000),
       (3, 'Jayvon', 'Grant', 'Jayvon.Grant@corp.com', '555-55-57', '2019-07-17', 90000),
       (4, 'Shaylee', 'Mcclure', 'Shaylee.Mcclure@corp.com', '555-55-58', '2019-07-19', 120000),
       (5, 'Miley', 'Krueger', 'Miley.Krueger@corp.com', '555-55-59', '2019-07-20', 110000);