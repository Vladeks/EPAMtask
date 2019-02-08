use labor_sql;

/*1. БД «Комп. фірма». Знайти тих виробників ПК, усі моделі ПК
яких є у наявності в таблиці PC (використовуючи операцію
EXISTS). Вивести maker.*/
select distinct maker from product
where exists (
	select * from pc
	where model = product.model
);

/*2. БД «Комп. фірма». Знайдіть виробників, які б випускали ПК зі
швидкістю 750 МГц та вище. Виведіть: maker.*/
select maker from product
where exists (
	select * from pc
    where model = product.model and speed >= 750
);

/*3. БД «Комп. фірма». Знайдіть виробників, які б випускали
одночасно ПК та ноутбуки зі швидкістю 750 МГц та вище.
Виведіть: maker.*/
select distinct maker from product
where exists (
	select * from pc
    where model = product.model and speed >= 750
)
or  exists (
	select * from laptop
    where model = product.model and speed >= 750
);

/*4. БД «Комп. фірма». Знайдіть виробників принтерів, що
випускають ПК з найвищою швидкістю процесора. Виведіть:
maker.*/
select  maker from product join pc
on pc.model= product.model
where exists(
	select * from printer
    where product.model= printer.model
) ;


/*5. За Вашингтонським міжнародним договором від початку 1922
р. заборонялося будувати лінійні кораблі водотоннажністю
понад 35 тис. тонн. Вкажіть кораблі, що порушили цей договір
(враховувати лише кораблі з відомим спуском на воду, тобто з
таблиці Ships). Виведіть: name, launched, displacement.*/
select name, launched from  ships
where exists(
	select * from classes
    where ships.class = classes.class and displacement > 35000
)
and launched is not null;

/*6. БД «Кораблі». Знайдіть класи кораблів, у яких хоча б один
корабель був затоплений у битвах. Вивести: class. (Назви
класів кораблів визначати за таблицею Ships, якщо його там
немає, тоді порівнювати чи його назва не співпадає з назвою
класу, тобто він є головним)*/
select class from ships
where exists(
	select * from outcomes
    where outcomes.ship = ships.name and result = 'sunk'
);

/*7. БД «Комп. фірма». Виведіть тих виробників ноутбуків, які
також випускають і принтери.*/
select  distinct maker from product
where exists(
	select * from laptop
    where laptop.model= product.model
) 
and exists (
	select * from printer
    where printer.model= product.model
);

/*8. БД «Комп. фірма». Виведіть тих виробників ноутбуків, які не
випускають принтери.*/
select distinct maker from product join laptop
on laptop.model= product.model
where  exists (
	select * from printer
    where printer.model= product.model
);





