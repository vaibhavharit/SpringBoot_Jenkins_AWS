insert into User(userid, firstname, lastname, age, emailid, password) 
values(1,'John', 'Wick', 34, 'johnw@gmail.com', 'jwick');
insert into User(userid, firstname, lastname, age, emailid, password) 
values(2,'Harry', 'Adams', 23, 'harryad@gmail.com', 'hadams');
insert into User(userid, firstname, lastname, age, emailid, password) 
values(3,'Vaibhav', 'Harit', 23, 'vaibhav16x@gmail.com', 'vaibhavharit);


insert into Category(categoryid, name) 
values(1,'basketball shoes');
insert into Category(categoryid, name) 
values(2,'running shoes');
insert into Category(categoryid, name) 
values(3,'soccer shoes');



insert into Product(productid, name, brand, price, category_categoryid)
values(1, 'Nike Air Jordans', 'Nike', 7000, 1) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(2, 'Adidas Ultra Boost', 'Adidas', 6000, 1) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(3, 'Sketchers Memory Foam', 'Sketchers', 4900, 1) ;
insert into Product(productid, name, brand, price, category_categoryid)
values(4, 'Adidas Swayde', 'Adidas', 5000, 2) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(5, 'Nike Leap', 'Nike', 4000, 2) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(6, 'Nike DRose', 'Nike', 10000, 3) ;
insert into Product(productid, name, brand, price, category_categoryid)
values(7, 'Asics Zoom', 'Asics', 4000, 3) ;




insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(1, 2, sysdate(), 1, 1) ; 
insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(2, 1, sysdate(), 1, 6) ; 
insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(3, 1, sysdate(), 2, 2) ; 
insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(4, 1, sysdate(), 2, 3) ; 
insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(5, 1, sysdate(), 3, 7) ; 
insert into Purchase(purchaseid, quantity, date, user_userid, product_productid)
values(6, 1, sysdate(), 3, 4) ; 



insert into Admin(username, password)
values('root', 'root') ; 
insert into Admin(username, password)
values('admin', 'password') ; 
