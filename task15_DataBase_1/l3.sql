use labor_sql;
/*БД «Комп. фірма». Вкажіть виробника для тих ПК, що мають
жорсткий диск об’ємом не більше 8 Гбайт. Вивести: maker,
type, speed, hd.*/
select maker, type, speed, hd from pc join product
on pc.model = product.model
where hd <= 8;

/*БД «Комп. фірма». Знайдіть виробників ПК з процесором не
менше 600 МГц. Вивести: maker.*/
select maker from pc join product
on pc.model = product.model
where speed >= 600
group by maker;

/*БД «Комп. фірма». Знайдіть виробників ноутбуків з
процесором не вище 500 МГц. Вивести: maker.*/
select maker from laptop join product
on laptop.model = product.model
where speed <= 500
group by maker;

/*БД «Комп. фірма». Знайдіть пари моделей ноутбуків, що
мають однакові об’єми жорстких дисків та RAM (таблиця
Laptop). У результаті кожна пара виводиться лише один раз.
Порядок виведення: модель з більшим номером, модель з
меншим номером, об’єм диску та RAM.*/
select l1.model, l2.model, l1.hd, l1.ram from laptop l1 join laptop l2
on l1.hd = l2.hd and l1.ram = l2.ram 
;

/*БД «Кораблі». Знайдіть країни, що мали класи як звичайних
бойових кораблів 'bb', так і класи крейсерів 'bc'. Вивести:
country, типи з класом 'bb', типи з класом 'bc'.*/
select c1.country, c1.type, c2.type from classes c1 join classes c2
on c1.country = c2.country
where c1.type = 'bb' and c2.type = 'bc';

/*БД «Комп. фірма». Знайдіть номер моделі та виробника ПК,
яка має ціну менше за 600 дол. Вивести: model, maker.*/
select  pc.model, maker from pc join product
on pc.model = product.model
where price < 600
group by model;

/*БД «Комп. фірма». Знайдіть номер моделі та виробника
прінтера, яка має ціну вищу за 300 дол. Вивести: model, maker.*/
select  printer.model, maker from printer join product
on printer.model = product.model
where price > 300
group by model;

/*БД «Комп. фірма». Виведіть виробника, номер моделі та ціну
кожного комп’ютера, що є у БД. Вивести: maker, model, price.*/
select  pc.model, maker, price from pc join product
on pc.model = product.model
group by model;

/*БД «Комп. фірма». Виведіть усі можливі моделі ПК, їх
виробників та ціну (якщо вона вказана). Вивести: maker,
model, price.*/
select  pc.model, maker, price from pc join product
on pc.model = product.model
where price is not null
group by model;


/*БД «Комп. фірма». Виведіть виробника, тип, модель та частоту
процесора для ноутбуків, частота процесорів яких перевищує
600 МГц. Вивести: maker, type, model, speed.*/
select  laptop.model, maker, type, speed from laptop join product
on laptop.model = product.model
where speed > 600;

/*БД «Кораблі». Для кораблів таблиці Ships вивести їх
водотоннажність.*/
select name, displacement from ships join classes
on ships.class = classes.class;

/*БД «Кораблі». Для кораблів, що вціліли у битвах, вивести
назви та дати битв, у яких вони брали участь.*/
select ship, date from outcomes join battles
on outcomes.battle = battles.name
where outcomes.result = 'OK' ;

/*БД «Кораблі». Для кораблів таблиці Ships вивести країни,
яким вони належать.*/
select name, country from ships join classes
on ships.class = classes.class;

/*БД «Аеропорт». Для рейсових літаків 'Boeing' вказати назви
компаній, яким вони належать.*/
select name from trip join company
on trip.ID_comp = company.ID_comp
where plane = 'Boeing'
group by company.ID_comp;

/*БД «Аеропорт». Для пасажирів таблиці Passenger вивести
дати, коли вони користувалися послугами авіаліній.*/
select name, date from passenger join pass_in_trip
on passenger.ID_psg = pass_in_trip.ID_psg;