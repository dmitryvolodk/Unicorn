create table BCBS (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table BMC (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table Connecticare (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table Fallon (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table HarvardPilgrim (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table HealthNewEngland (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table Medicare (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table NeighborhoodHealthPlan (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table Tufts (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

create table UnitedHealthCare (
  medicalService varchar(40),
  copay$ integer,
  primary key (medicalService)
);

insert into BCBS values ('Primary care visit for illness', 20);
insert into BCBS values ('Specialist visit', 20);
insert into BCBS values ('Imaging - CT/PET scans, MRIs', 50);
insert into BCBS values ('Generic drugs', 15);
insert into BCBS values ('Preferred brand drugs', 30);
insert into BCBS values ('Non-preferred brand drugs', 50);
insert into BCBS values ('Outpatient surgery facility fee', 500);
insert into BCBS values ('Emergency room care', 200);
insert into BCBS values ('Urgent care', 20);
insert into BCBS values ('Hospital stay facility fee', 750);
insert into BCBS values ('Behavioral health outpatient services', 20);
insert into BCBS values ('Behavioral health inpatient services', 750);
insert into BCBS values ('Childbirth/delivery facility services', 750);
insert into BCBS values ('Rehabilitation services', 20);
insert into BCBS values ('Habilitation services', 20);

insert into BMC values ('Primary care visit for illness', 30);
insert into BMC values ('Specialist visit', 30);
insert into BMC values ('Imaging - CT/PET scans, MRIs', 60);
insert into BMC values ('Generic drugs', 20);
insert into BMC values ('Preferred brand drugs', 40);
insert into BMC values ('Non-preferred brand drugs', 60);
insert into BMC values ('Outpatient surgery facility fee', 550);
insert into BMC values ('Emergency room care', 220);
insert into BMC values ('Urgent care', 30);
insert into BMC values ('Hospital stay facility fee', 800);
insert into BMC values ('Behavioral health outpatient services', 30);
insert into BMC values ('Behavioral health inpatient services', 800);
insert into BMC values ('Childbirth/delivery facility services', 800);
insert into BMC values ('Rehabilitation services', 30);
insert into BMC values ('Habilitation services', 30);

insert into Connecticare values ('Primary care visit for illness', 40);
insert into Connecticare values ('Specialist visit', 40);
insert into Connecticare values ('Imaging - CT/PET scans, MRIs', 70);
insert into Connecticare values ('Generic drugs', 25);
insert into Connecticare values ('Preferred brand drugs', 50);
insert into Connecticare values ('Non-preferred brand drugs', 70);
insert into Connecticare values ('Outpatient surgery facility fee', 800);
insert into Connecticare values ('Emergency room care', 240);
insert into Connecticare values ('Urgent care', 40);
insert into Connecticare values ('Hospital stay facility fee', 850);
insert into Connecticare values ('Behavioral health outpatient services', 40);
insert into Connecticare values ('Behavioral health inpatient services', 850);
insert into Connecticare values ('Childbirth/delivery facility services', 850);
insert into Connecticare values ('Rehabilitation services', 40);
insert into Connecticare values ('Habilitation services', 40);

insert into Fallon values ('Primary care visit for illness', 50);
insert into Fallon values ('Specialist visit', 50);
insert into Fallon values ('Imaging - CT/PET scans, MRIs', 80);
insert into Fallon values ('Generic drugs', 30);
insert into Fallon values ('Preferred brand drugs', 60);
insert into Fallon values ('Non-preferred brand drugs', 80);
insert into Fallon values ('Outpatient surgery facility fee', 650);
insert into Fallon values ('Emergency room care', 260);
insert into Fallon values ('Urgent care', 50);
insert into Fallon values ('Hospital stay facility fee', 850);
insert into Fallon values ('Behavioral health outpatient services', 50);
insert into Fallon values ('Behavioral health inpatient services', 850);
insert into Fallon values ('Childbirth/delivery facility services', 850);
insert into Fallon values ('Rehabilitation services', 50);
insert into Fallon values ('Habilitation services', 50);

insert into HarvardPilgrim values ('Primary care visit for illness', 55);
insert into HarvardPilgrim values ('Specialist visit', 55);
insert into HarvardPilgrim values ('Imaging - CT/PET scans, MRIs', 85);
insert into HarvardPilgrim values ('Generic drugs', 35);
insert into HarvardPilgrim values ('Preferred brand drugs', 65);
insert into HarvardPilgrim values ('Non-preferred brand drugs', 85);
insert into HarvardPilgrim values ('Outpatient surgery facility fee', 655);
insert into HarvardPilgrim values ('Emergency room care', 265);
insert into HarvardPilgrim values ('Urgent care', 55);
insert into HarvardPilgrim values ('Hospital stay facility fee', 855);
insert into HarvardPilgrim values ('Behavioral health outpatient services', 55);
insert into HarvardPilgrim values ('Behavioral health inpatient services', 855);
insert into HarvardPilgrim values ('Childbirth/delivery facility services', 855);
insert into HarvardPilgrim values ('Rehabilitation services', 55);
insert into HarvardPilgrim values ('Habilitation services', 55);

insert into HealthNewEngland values ('Primary care visit for illness', 45);
insert into HealthNewEngland values ('Specialist visit', 45);
insert into HealthNewEngland values ('Imaging - CT/PET scans, MRIs', 75);
insert into HealthNewEngland values ('Generic drugs', 30);
insert into HealthNewEngland values ('Preferred brand drugs', 55);
insert into HealthNewEngland values ('Non-preferred brand drugs', 75);
insert into HealthNewEngland values ('Outpatient surgery facility fee', 805);
insert into HealthNewEngland values ('Emergency room care', 245);
insert into HealthNewEngland values ('Urgent care', 45);
insert into HealthNewEngland values ('Hospital stay facility fee', 855);
insert into HealthNewEngland values ('Behavioral health outpatient services', 45);
insert into HealthNewEngland values ('Behavioral health inpatient services', 855);
insert into HealthNewEngland values ('Childbirth/delivery facility services', 855);
insert into HealthNewEngland values ('Rehabilitation services', 45);
insert into HealthNewEngland values ('Habilitation services', 45);

insert into Medicare values ('Primary care visit for illness', 35);
insert into Medicare values ('Specialist visit', 35);
insert into Medicare values ('Imaging - CT/PET scans, MRIs', 65);
insert into Medicare values ('Generic drugs', 25);
insert into Medicare values ('Preferred brand drugs', 45);
insert into Medicare values ('Non-preferred brand drugs', 65);
insert into Medicare values ('Outpatient surgery facility fee', 555);
insert into Medicare values ('Emergency room care', 225);
insert into Medicare values ('Urgent care', 35);
insert into Medicare values ('Hospital stay facility fee', 805);
insert into Medicare values ('Behavioral health outpatient services', 35);
insert into Medicare values ('Behavioral health inpatient services', 805);
insert into Medicare values ('Childbirth/delivery facility services', 805);
insert into Medicare values ('Rehabilitation services', 35);
insert into Medicare values ('Habilitation services', 35);

insert into NeighborhoodHealthPlan values ('Primary care visit for illness', 25);
insert into NeighborhoodHealthPlan values ('Specialist visit', 25);
insert into NeighborhoodHealthPlan values ('Imaging - CT/PET scans, MRIs', 55);
insert into NeighborhoodHealthPlan values ('Generic drugs', 20);
insert into NeighborhoodHealthPlan values ('Preferred brand drugs', 35);
insert into NeighborhoodHealthPlan values ('Non-preferred brand drugs', 55);
insert into NeighborhoodHealthPlan values ('Outpatient surgery facility fee', 525);
insert into NeighborhoodHealthPlan values ('Emergency room care', 225);
insert into NeighborhoodHealthPlan values ('Urgent care', 25);
insert into NeighborhoodHealthPlan values ('Hospital stay facility fee', 780);
insert into NeighborhoodHealthPlan values ('Behavioral health outpatient services', 25);
insert into NeighborhoodHealthPlan values ('Behavioral health inpatient services', 780);
insert into NeighborhoodHealthPlan values ('Childbirth/delivery facility services', 780);
insert into NeighborhoodHealthPlan values ('Rehabilitation services', 25);
insert into NeighborhoodHealthPlan values ('Habilitation services', 25);

insert into Tufts values ('Primary care visit for illness', 15);
insert into Tufts values ('Specialist visit', 15);
insert into Tufts values ('Imaging - CT/PET scans, MRIs', 45);
insert into Tufts values ('Generic drugs', 10);
insert into Tufts values ('Preferred brand drugs', 25);
insert into Tufts values ('Non-preferred brand drugs', 45);
insert into Tufts values ('Outpatient surgery facility fee', 480);
insert into Tufts values ('Emergency room care', 180);
insert into Tufts values ('Urgent care', 15);
insert into Tufts values ('Hospital stay facility fee', 730);
insert into Tufts values ('Behavioral health outpatient services', 15);
insert into Tufts values ('Behavioral health inpatient services', 730);
insert into Tufts values ('Childbirth/delivery facility services', 730);
insert into Tufts values ('Rehabilitation services', 15);
insert into Tufts values ('Habilitation services', 15);

insert into UnitedHealthCare values ('Primary care visit for illness', 15);
insert into UnitedHealthCare values ('Specialist visit', 30);
insert into UnitedHealthCare values ('Imaging - CT/PET scans, MRIs', 60);
insert into UnitedHealthCare values ('Generic drugs', 10);
insert into UnitedHealthCare values ('Preferred brand drugs', 35);
insert into UnitedHealthCare values ('Non-preferred brand drugs', 55);
insert into UnitedHealthCare values ('Outpatient surgery facility fee', 550);
insert into UnitedHealthCare values ('Emergency room care', 250);
insert into UnitedHealthCare values ('Urgent care', 25);
insert into UnitedHealthCare values ('Hospital stay facility fee', 700);
insert into UnitedHealthCare values ('Behavioral health outpatient services', 25);
insert into UnitedHealthCare values ('Behavioral health inpatient services', 700);
insert into UnitedHealthCare values ('Childbirth/delivery facility services', 700);
insert into UnitedHealthCare values ('Rehabilitation services', 25);
insert into UnitedHealthCare values ('Habilitation services', 25);
