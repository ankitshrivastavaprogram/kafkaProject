Database Initialization:
	Mysql> 
		drop database kafkatry1;
		create database kafkatry1;
		use kafkatry1;

now run the project  projecttry1 it will create all the required tables;

1)insert to default records in counter types.
  hance we have two types of counter
  a) TokenGenerator
  b)ServiceProvider
  mysql>
  insert into counter_type(counter_type) values('ROLE_TokenGenerator');
  insert into counter_type(counter_type) values('ROLE_ServiceProvider');
  insert into counter_type(counter_type) values('ROLE_ADMIN');