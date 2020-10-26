insert into User(userid, firstname, lastname, age, emailid, password) 
values(1,'Siddharth', 'Basu', 22, 'siddharthbasu98@gmail.com', 'siddharth98');
insert into User(userid, firstname, lastname, age, emailid, password) 
values(2,'Saphal', 'Patro', 23, 'saphal98@gmail.com', 'saphal98');
insert into User(userid, firstname, lastname, age, emailid, password) 
values(3,'Vaibhav', 'Harit', 23, 'vharit98@gmail.com', 'vaibhav98');


insert into Category(categoryid, name) 
values(1,'running shoes');
insert into Category(categoryid, name) 
values(2,'tennis shoes');
insert into Category(categoryid, name) 
values(3,'basketball shoes');



insert into Product(productid, name, brand, price, category_categoryid)
values(1, 'Nike Revolution', 'Nike', 3734, 1) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(2, 'Adidas Asweerun', 'Adidas', 4200, 1) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(3, 'Sketchers Nordic', 'Sketchers', 2800, 1) ;
insert into Product(productid, name, brand, price, category_categoryid)
values(4, 'Adidas Court Adapt', 'Adidas', 3000, 2) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(5, 'Nike Court Lite', 'Nike', 4200, 2) ; 
insert into Product(productid, name, brand, price, category_categoryid)
values(6, 'Nike Air Jordan 11', 'Nike', 9000, 3) ;
insert into Product(productid, name, brand, price, category_categoryid)
values(7, 'Asics Jump', 'Asics', 6700, 3) ;




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
values('siddharth98', 'sid98') ; 
