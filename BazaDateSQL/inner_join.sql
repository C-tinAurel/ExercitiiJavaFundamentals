-- sa se afiseze modelul masini ,marca ziua si luna in care a fost programat la rar

use dealer;

select * from cars join rar; -- acesta este cross join combina taoate randurile intre ele

select * from cars inner join rar on cars.rar_id = rar.id;

-- sa se afiseze marca masinii,modelul si numele cumparatorului
 
 select make,model,name from customers inner join cars on customers.car_id = cars.id;
 
 select * from cars left join rar on cars.rar_id = rar.id;
 
 select make,model,name from customers right join cars on customers.car_id = cars.id;