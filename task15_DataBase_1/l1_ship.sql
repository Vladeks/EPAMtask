use labor_sql;
/*
БД «Кораблі». Перерахувати назви головних кораблів (з
таблиці Ships). Вивести: name, class. Вихідні дані
впорядкувати за зростанням за стовпцем name.
*/
select name, class from ships
where name = class
order by name;

/*
БД «Кораблі». Вивести інформацію про усі класи кораблів для
країни 'Japan'. Вихідні дані впорядкувати за спаданням за
стовпцем type.
*/
select * from classes
where country = 'Japan'
order by type desc;

/*
БД «Кораблі». Знайти всі кораблі, що були спущені на воду у
термін між 1920 та 1942 роками. Вивести: name, launched.
Вихідні дані впорядкувати за спаданням за стовпцем launched.
*/
select name, launched from ships
where launched >= 1920 and launched <= 1942
order by launched desc;

/*
БД «Кораблі». Вивести усі кораблі, що брали участь у битві
'Guadalcanal' та не були потопленими. Вивести: ship, battle,
result. Вихідні дані впорядкувати за спаданям за стовпцем ship.
*/
select ship, battle, result from outcomes
where battle = 'Guadalcanal'
order by ship desc;


/*
БД «Кораблі». Вивести усі потоплені кораблі. Вивести: ship,
battle, result. Вихідні дані впорядкувати за спаданням за
стовпцем ship.
*/
select ship, battle, result from outcomes
where result = 'sunk'
order by ship desc;

/*
БД «Кораблі». Вивести назви класів кораблів з
водотоннажністю не меншою, аніж 40 тонн. Вивести: class,
displacement. Вихідні дані впорядкувати за зростанням за
стовпцем type.
*/
select class, displacement from classes
where displacement >= 40000
order by type;