drop table  vendor;
drop table purchase_order;
drop table vendor_purchase;

drop sequence  vendor_id_seq;
drop sequence  purchase_id_seq;
CREATE SEQUENCE vendor_id_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  
  CREATE SEQUENCE purchase_id_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;

CREATE TABLE vendor
(
    vendor_id integer   PRIMARY KEY,
    vendorname   VARCHAR2(4000) NOT NULL 
);
CREATE TABLE vendor_purchase
(
    vendor_id integer NOT NULL ,
    purchase_id   integer NOT NULL ,
    PRIMARY KEY (vendor_id, purchase_id)
);

CREATE TABLE purchase_order
(
    purchase_id integer   PRIMARY KEY,
    purchasedetail   VARCHAR2(4000) NOT NULL ,
    purchaseType VARCHAR2(400) NOT NULL,
     purchaseAmount integer NOT NULL,
     purchaseDate date
);

insert into vendor(vendor_id,vendorname) values(vendor_id_seq.nextval,'HCL');
insert into vendor(vendor_id,vendorname) values(vendor_id_seq.nextval,'DELL');

insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',80,TO_DATE('2012/12/31 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',80,TO_DATE('2012/11/21 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',80,TO_DATE('2012/11/11 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',30,TO_DATE('2012/10/01 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',70,TO_DATE('2012/12/31 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',75,TO_DATE('2012/11/21 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',75,TO_DATE('2012/11/11 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));
insert into purchase_order(purchase_id,purchasedetail,purchaseType,purchaseAmount,purchaseDate) values(purchase_id_seq.nextval,'DELL','Staff augmentation',30,TO_DATE('2012/10/01 12:00:00', 'YYYY/MM/DD HH24:MI:SS'));

insert into vendor_purchase(vendor_id, purchase_id) values(1,1);
insert into vendor_purchase(vendor_id, purchase_id) values(1,2);
insert into vendor_purchase(vendor_id, purchase_id) values(1,3);
insert into vendor_purchase(vendor_id, purchase_id) values(1,4);
insert into vendor_purchase(vendor_id, purchase_id) values(2,5);
insert into vendor_purchase(vendor_id, purchase_id) values(2,6);
insert into vendor_purchase(vendor_id, purchase_id) values(2,7);
insert into vendor_purchase(vendor_id, purchase_id) values(2,8);
commit;


