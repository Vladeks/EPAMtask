use labor_sql;

/*1. БД «Комп. фірма». Виведіть середню ціну ноутбуків з
попереднім текстом 'середня ціна = '.*/
select concat('середня ціна = ', cast(avg(price)as char)) as avg_price
from laptop ;


/*2. БД «Комп. фірма». Для таблиці PC вивести усю інформацію з
коментарями у кожній комірці, наприклад, 'модель: 1121',
'ціна: 600,00' і т.д.*/
select concat('код: ',code), concat('модель:', model), concat('частота процесора: ',speed),
concat('оперативна память: ',ram), concat('жорсткий диск: ',hd), 
concat('привод: ',cd), concat('ціна: ', price)
from pc;

/*3. БД «Фірма прий. вторсировини». З таблиці Income виведіть
дати у такому форматі: рік.число_місяця.день, наприклад,
2001.02.15 (без формату часу).*/
select date_format(date,'%Y.%m.%d') as `date` from income;

/*4. БД «Кораблі». Для таблиці Outcomes виведіть дані, а заміть
значень стовпця result, виведіть еквівалентні їм надписи
українською мовою.*/
select ship, battle, 
case result 
	when 'sunk' then 'потоплено'
    when 'OK' then 'цілий'
    when 'damaged' then 'пошкоджено'
end as `result`
from outcomes;

/*5. БД «Аеропорт». Для таблиці Pass_in_trip значення стовпця
place розбити на два стовпця з коментарями, наприклад,
перший – 'ряд: 2' та другий – 'місце: a'.*/
select concat('ряд: ',substring(place from 1 for 1)) as `ряд`, 
concat('місце: ',substring(place from 2)) as `місце` 
from pass_in_trip;

/*6. БД «Аеропорт». Вивести дані для таблиці Trip з об’єднаними
значеннями двох стовпців: town_from та town_to, з
додатковими коментарями типу: 'from Rostov to Paris'.*/
select *, concat('from ', town_from, 'to ', town_to) from trip;

