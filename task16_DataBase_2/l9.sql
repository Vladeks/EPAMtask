use labor_sql;

-- 9 (Оператор CASE)

/*1. БД «Комп. фірма». Для таблиці Product отримати підсумковий
набір у вигляді таблиці зі стовпцями maker, pc, в якій для
кожного виробника необхідно вказати, чи виробляє він ('yes'),
чи ні ('no') відповідний тип продукції. У першому випадку
('yes') додатково вказати поруч у круглих дужках загальну
кількість наявної (тобто, що знаходиться у таблиці PC)
продукції, наприклад, 'yes(2)'. (Підказка: використовувати
підзапити у якості обчислювальних стовпців та оператор
CASE)*/

/*2. БД «Фірма прий. вторсировини». Приймаючи, що прихід та
розхід грошей на кожному пункті прийому фіксується не
частіше одного разу на день (лише таблиці Income_o та
Outcome_o), написати запит з такими вихідними даними: point
(пункт), date (дата), inc (прихід), out (розхід). (Підказка:
використовувати зовнішнє з’єднання та оператор CASE)*/

/*3. БД «Кораблі». Визначити назви усіх кораблів з таблиці Ships,
які задовольняють, у крайньому випадку, комбінації будь-яких
чотирьох критеріїв з наступного списку: numGuns=8, bore=15,
displacement=32000, type='bb', country='USA', launched=1915,
class='Kongo'. Вивести: name, numGuns, bore, displacement,
type, country, launched, class. (Підказка: використати для
перевірки умов оператор CASE)*/

/*4. БД «Аеропорт». Для кожного рейсу (таблиця Trip) визначити
тривалість його польоту. Вивести: trip_no, назва компанії,
plane, town_from, town_to, тривалість польоту. (Підказка:
використати для перевірки умов оператор CASE)*/

/*5. БД «Фірма прий. вторсировини». Визначіть лідера за сумою
виплат у змаганні між кожною парою пунктів з однаковими
номерами із двох різних таблиць – Outcome та Outcome_o – на
кожний день, коли здійснювався прийом вторинної сировини
хоча б на одному з них. Вивести: Номер пункту, дата, текст: –
'once a day', якщо сума виплат є більшою у фірми зі звітністю
один раз на день; – 'more than once a day', якщо – у фірми зі
звітністю декілька разів на день; – 'both', якщо сума виплат є
однаковою. (Підказка: для з’єднання таблиць
використовувати повне зовнішнє з’єднання, а для перевірки
умов оператор CASE; для пунктів що не мають у певні дні
видачі грошей – необхідно обробляти NULL-значення за
допомогою перевірки умови IS [NOT] NULL)*/

