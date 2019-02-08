USE StoredPr_DB; 

-- employee post relation
DELIMITER //
create trigger BeforeDelatePost
before delete
on post for each row
begin
	if exists( select * from employee where employee.post = old.post) 
	then 
		signal sqlstate '45000'
		set message_text = 'Entries from the table emploee refer to this entry';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeInsertEmployeePost
before insert
on employee for each row
begin
	if not exists( select * from post where new.post = post.post) 
	then 
		signal sqlstate '45000'
		set message_text = 'Post does not exist';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeUpdateEmployeePost
before update
on employee for each row
begin
	if not exists( select * from post where new.post = post.post) 
	then 
		signal sqlstate '45000'
		set message_text = 'Post does not exist';
    end if;
end //
DELIMITER ;

-- employee prmacy relation
DELIMITER //
create trigger BeforeDelatePharmacy
before delete
on pharmacy for each row
begin
	if exists( select * from employee where employee.pharmacy_id = old.id) 
	then 
		signal sqlstate '45000'
		set message_text = 'Entries from the table emploee refer to this pharmacy entry';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeInsertEmployeePharmacy
before insert
on employee for each row
begin
	if not exists( select * from pharmacy where new.pharmacy_id = pharmacy.id) 
	then 
		signal sqlstate '45000'
		set message_text = 'Pharmacy does not exist';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeUpdateEmployeePharmacy
before update
on employee for each row
begin
	if not exists( select * from pharmacy where new.pharmacy_id = pharmacy.id) 
	then 
		signal sqlstate '45000'
		set message_text = 'Pharmacy does not exist';
    end if;
end //
DELIMITER ;

-- prmacy street relation
DELIMITER //
create trigger BeforeDelateStreet
before delete
on street for each row
begin
	if exists( select * from pharmacy where pharmacy.street = old.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Entries from the table pharmacy refer to this street entry';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeInsertPharmacyStreet
before insert
on pharmacy for each row
begin
	if not exists( select * from street where new.street = street.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Street does not exist';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeUpdatePharmacyStreet
before update
on pharmacy for each row
begin
	if not exists( select * from street where new.street = street.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Street does not exist';
    end if;
end //
DELIMITER ;

-- medicine zone relation
DELIMITER //
create trigger BeforeDelateZone
before delete
on zone for each row
begin
	if exists( select * from medicine_zone where pharmacy.street = old.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Entries from the table pharmacy refer to this street entry';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeInsertPharmacyStreet
before insert
on pharmacy for each row
begin
	if not exists( select * from street where new.street = street.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Street does not exist';
    end if;
end //
DELIMITER ;

DELIMITER //
create trigger BeforeUpdatePharmacyStreet
before update
on pharmacy for each row
begin
	if not exists( select * from street where new.street = street.street) 
	then 
		signal sqlstate '45000'
		set message_text = 'Street does not exist';
    end if;
end //
DELIMITER ;

