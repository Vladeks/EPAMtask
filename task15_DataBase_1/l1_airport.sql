use labor_sql;
/*
БД «Аеропорт». Знайдіть номера усіх рейсів, що бувають у
місті 'London'. Вивести: trip_no, town_from, town_to. Вихідні
дані впорядкувати за зростанням за стовпцем time_out.
*/
select trip_no, town_from, town_to from trip
where town_from = 'London' or town_to = 'London'
order by time_out;

/*
БД «Аеропорт». Знайдіть номера усіх рейсів, на яких курсує
літак 'TU-134'. Вивести: trip_no, plane, town_from, town_to.
Вихідні дані впорядкувати за спаданням за стовпцем time_out.
*/
select trip_no, plane, town_from, town_to from trip
where plane = 'TU-134'
order by time_out desc;

/*
БД «Аеропорт». Знайдіть номера усіх рейсів, на яких не курсує
літак 'IL-86'. Вивести: trip_no, plane, town_from, town_to. Вихідні
дані впорядкувати за зростанням за стовпцем plane.
*/
select trip_no, plane, town_from, town_to from trip
where plane != 'IL-86'
order by plane;

/*
БД «Аеропорт». Знайдіть номера усіх рейсів, що не бувають у
місті 'Rostov'. Вивести: trip_no, town_from, town_to. Вихідні дані
впорядкувати за зростанням за стовпцем plane.
*/
select trip_no, plane, town_from, town_to from trip
where town_from = 'Rostov' or town_to = 'Rostov'
order by plane;

