create table Patient (
  PMedicalReccord varchar(15),
  PatientFirstName varchar(50),
  PatientLastName varchar(50),
  Phone varchar(12),
  Street varchar(50),
  City varchar(20),
  StateOfCountry varchar(15),
  Zipcode varchar(5),
  primary key (PMedicalReccord)
);

create table Provider (
  ProviderID varchar(15),
  ProviderFirstName varchar(50),
  ProviderLastName varchar(50),
  primary key (ProviderID)
);

create table Appointment (
  AppointmentNo varchar(15),
  Date date,
  PMedicalReccord varchar(15),
  ProviderID varchar(15),
  primary key (AppointmentNo),
  foreign key (PMedicalReccord) references Patient (PMedicalReccord),
  foreign key (ProviderID) references Provider (ProviderID)
);

create table Scheduler (
  UserID varchar(15),
  SchedulerFirstName varchar(50),
  SchedulerLastName varchar(50),
  primary key (UserID)
);

create table Billing (
  BillingNum varchar(10),
  ProviderID varchar(15),
  PMedicalReccord varchar(15),
  BillingType varchar(15),
  AppointmentNo varchar(15),
  UserID varchar(15),
  primary key (BillingNum),
  foreign key (ProviderID) references Provider (ProviderID),
  foreign key (PMedicalReccord) references Patient (PMedicalReccord),
  foreign key (AppointmentNo) references Appointment (AppointmentNo),
  foreign key (UserID) references Scheduler (UserID)
);

insert into Patient values ('227852369', 'William', 'Shakespeare', '6172302068', 'Alstead Street', 'Albany', 'New York', '02271');
insert into Patient values ('149852369', 'Fyodor', 'Dostoevsky', '7172302068', '3rd Place', 'New York', 'New York', '02181');
insert into Patient values ('447152369', 'Leo', 'Tolstoy', '6272302068', '4th Street', 'Philadelphia', 'Pennsylvania', '02172');
insert into Patient values ('547862369', 'Charles', 'Dickens', '6182302068', 'A Street', 'Baltimore', 'Maryland', '02170');
insert into Patient values ('347853369', 'Miguel', 'Cervantes', '6173102068', 'Aberdeen Street', 'Lancaster', 'Pennsylvania', '02161');
insert into Patient values ('847852569', 'George', 'Orwell', '6172302061', 'Acadia Street', 'York', 'Pennsylvania', '01071');
insert into Patient values ('647852399', 'Ernest', 'Hemingway', '6172302078', 'Access Road', 'Princeton', 'New Jersey', '04171');
insert into Patient values ('947852360', 'Victor', 'Hugo', '6172302968', 'Accolyn Way', 'Annapolis', 'Maryland', '02371');
insert into Patient values ('347852369', 'Jane', 'Austen', '6172300068', 'Acorn Street', 'Trenton', 'New Jersey', '02193');
insert into Patient values ('747152369', 'John', 'Steinbeck', '8172312068', 'Adams Place', 'Sacramento', 'California', '02141');

insert into Provider values ('618934582', 'Andy', 'Warhol');
insert into Provider values ('319934582', 'Pablo', 'Picaso');
insert into Provider values ('218944582', 'Vincent', 'van Gogh');
insert into Provider values ('418934682', 'Leonardo', 'da Vinci');
insert into Provider values ('718934592', 'Henri', 'Matisse');

insert into Appointment values ('172839642', '2020-09-03', '227852369', '618934582');
insert into Appointment values ('932839145', '2020-10-16', '149852369', '618934582');
insert into Appointment values ('272839645', '2020-11-21', '447152369', '319934582');
insert into Appointment values ('872839655', '2020-09-09', '547862369', '319934582');
insert into Appointment values ('372839645', '2020-12-01', '347853369', '218944582');
insert into Appointment values ('752839645', '2020-10-28', '847852569', '218944582');
insert into Appointment values ('422839643', '2020-11-05', '647852399', '418934682');
insert into Appointment values ('662839645', '2020-09-15', '947852360', '718934592');
insert into Appointment values ('282839695', '2020-09-29', '347852369', '718934592');
insert into Appointment values ('992839645', '2020-10-17', '747152369', '718934592');

insert into Scheduler values ('231649758', 'Julius', 'Ceasar');
insert into Scheduler values ('124649759', 'Charlie', 'Chaplin');
insert into Scheduler values ('564619753', 'Abraham', 'Lincoln');

insert into Billing values ('193746823', '618934582', '227852369', 'Insurance', '172839642', '231649758');
insert into Billing values ('983746826', '618934582', '149852369', 'ThirdParty', '932839145', '231649758');
insert into Billing values ('273746824', '319934582', '447152369', 'Insurance', '272839645', '231649758');
insert into Billing values ('863746821', '319934582', '547862369', 'OutOfPocket', '872839655', '231649758');
insert into Billing values ('353746828', '218944582', '347853369', 'Insurance', '372839645', '124649759');
insert into Billing values ('743746822', '218944582', '847852569', 'Insurance', '752839645', '124649759');
insert into Billing values ('433746829', '418934682', '647852399', 'Research', '422839643', '124649759');
insert into Billing values ('623746824', '718934592', '947852360', 'Insurance', '662839645', '124649759');
insert into Billing values ('513746825', '718934592', '347852369', 'OutOfPocket', '282839695', '564619753');
insert into Billing values ('303746826', '718934592', '747152369', 'Insurance', '992839645', '564619753');
