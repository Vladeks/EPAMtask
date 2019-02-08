use labor_sql;

/*БД «Комп. фірма». Вивести усі моделі ПК, у номерах яких є
хоча б дві одинички.*/
select * from pc
where model rlike'1{2,}';

/*БД «Фірма прий. вторсировини». З таблиці Outcome вивести
усю інформацію за березень місяць.*/
select * from outcome
where MONTH(date) = 3;

/*БД «Фірма прий. вторсировини». З таблиці Outcome_o вивести
усю інформацію за 14 число будь-якого місяця.*/
select * from outcome_o
where dayofmonth(date) = 14; 

/*БД «Кораблі». З таблиці Ships вивести назви кораблів, що
починаються на 'W' та закінчуються літерою 'n'.*/
select name from ships
where name rlike'^W.*n$';

/*БД «Кораблі». З таблиці Ships вивести назви кораблів, що
мають у своїй назві дві літери 'e'.*/
select name from ships
where name rlike'e{2}';

/*БД «Кораблі». З таблиці Ships вивести назви кораблів та роки
їх спуску на воду, назва яких не закінчується на літеру 'a'.*/
select name, launched from ships
where name rlike '[^a]$';

/*БД «Кораблі». Вивести назви битв, які складаються з двох слів
та друге слово не закінчується на літеру 'c'.*/
select name from battles
where name rlike '^.+ .+[^c]$';

/*БД «Аеропорт». З таблиці Trip вивести інформацію про рейси,
що вилітають в інтервалі часу між 12 та 17 годинами включно.*/
select * from trip
where hour(time_out) >= 12 and hour(time_out) <= 17;

/*БД «Аеропорт». З таблиці Trip вивести інформацію про рейси,
що прилітають в інтервалі часу між 17 та 23 годинами
включно.*/
select * from trip
where hour(time_in) >= 17 and hour(time_in) <= 23;

/*БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були
зайняті місця у першому ряду.*/
select date, place from pass_in_trip
where place rlike '^1';

/*БД «Аеропорт». З таблиці Pass_in_trip вивести дати, коли були
зайняті місця 'c' у будь-якому ряді.*/
select date, place from pass_in_trip
where place rlike '.c';

/*БД «Аеропорт». Вивести прізвища пасажирів (друге слово у
стовпці name), що починаються на літеру 'С'.
substring(name, CHARINDEX(name), )*/
select substring(name, position(' ' in name)) from passenger
where  name rlike ' C';

/*БД «Аеропорт». Вивести прізвища пасажирів (друге слово у
стовпці name), що не починаються на літеру 'J'.*/
select substring(name, position(' ' in name)) from passenger
where  name rlike ' [^J]';

