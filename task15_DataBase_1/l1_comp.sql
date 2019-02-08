use labor_sql;
/*
	БД «Комп. фірма». Знайти виробників ноутбуків. 
    Вивести: maker, type. 
    Вихідні дані впорядкувати за зростанням за стовпцем maker.
*/
select maker, type from product 
where type = "Laptop"
order by maker;

/*
БД «Комп. фірма». Знайти номер моделі, об’єм пам’яті та
розміри екранів ноутбуків, ціна яких перевищує 1000 дол.
Вивести: model, ram, screen, price. Вихідні дані впорядкувати
за зростанням за стовпцем ram та за спаданням за стовпцем
price.
*/
select model, ram, screen, price from laptop
where price > 1000
order by ram, price desc;


/*
БД «Комп. фірма». Знайдіть усі записи таблиці Printer для
кольорових принтерів. Вихідні дані впорядкувати за
спаданням за стовпцем price.
*/
select * from printer
where color = "y"
order by price desc;

/*
БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
диску ПК, що мають CD-приводи зі швидкістю '12х' чи '24х' та
ціну меншу 600 дол. Вивести: model, speed, hd, cd, price.
Вихідні дані впорядкувати за спаданням за стовпцем speed.
*/
select model, speed, hd, cd, price from pc
where cd = "12x" or "24x" and price < 600
order by speed desc;

/*
БД «Комп. фірма». Отримати інформацію про комп’ютери, що
мають частоту процесора не менше 500 МГц та ціну нижче 800
дол. Вихідні дані впорядкувати за спаданням за стовпцем price.
*/
select * from pc
where speed >= 500 and price < 800
order by price desc; 

/*
БД «Комп. фірма». Отримати інформацію про всі принтери,
які не є матричними та коштують менше 300 дол. Вихідні дані
впорядкувати за спаданням за стовпцем type.
*/
select * from printer
where type != "Matrix" and price < 300
order by type desc;

/*
БД «Комп. фірма». Знайти модель та частоту процесора
комп’ютерів, що коштують від 400 до 600 дол. Вивести: model,
speed. Вихідні дані впорядкувати за зростанням за стовпцем
hd.
*/
select model, speed from pc
where price > 400 and price <= 600
order by hd; 

/*
БД «Комп. фірма». Знайти модель, частоту процесора та об’єм
жорсткого диску для тих комп’ютерів, що комплектуються
накопичувачами 10 або 20 Мб та випускаються виробником
'A'. Вивести: model, speed, hd. Вихідні дані впорядкувати за
зростанням за стовпцем speed.
*/
select pc.model, speed, hd, maker from pc join product
on pc.model = product.model
where  product.maker = "A" and hd = 10 or hd = 20
group by model
order by speed;

/*
БД «Комп. фірма». Знайдіть номер моделі, швидкість та розмір
жорсткого диску для усіх ноутбуків, екран яких не менше 12
дюймів. Вивести: model, speed, hd, price. Вихідні дані
впорядкувати за спаданням за стовпцем price.
*/
select model, speed, hd, price from laptop
where screen >= 12
order by speed desc;

/*
БД «Комп. фірма». Знайдіть номер моделі, тип та ціну для усіх
принтерів, вартість яких менше 300 дол. Вивести: model, type,
price. Вихідні дані впорядкувати за спаданням за стовпцем
type.
*/
select model, type, price from printer
where price < 300
order by type desc; 

/*
БД «Комп. фірма». Вивести моделі ноутбуків з кількістю RAM
рівною 64 Мб. Вивести: model, ram, price. Вихідні дані
впорядкувати за зростанням за стовпцем screen.
*/
select model, ram, price from laptop
where ram = 64
order by screen; 

/*
БД «Комп. фірма». Вивести моделі ПК з кількістю RAM
більшою за 64 Мб. Вивести: model, ram, price. Вихідні дані
впорядкувати за зростанням за стовпцем hd.
*/
select model, ram, price from pc
where ram > 64
order by hd;

/*
БД «Комп. фірма». Вивести моделі ПК зі швидкістю процесора
у межах від 500 до 750 МГц. Вивести: model, speed, price.
Вихідні дані впорядкувати за спаданням за стовпцем hd.
*/
select model, speed, price from pc
where speed > 500 and speed < 750
order by hd;





