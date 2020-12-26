use fitness_for_life;

insert into fitness_coachs(
name,surname,coach_workout)
values('Marian','Lup','aerobic');

insert into subscriptions(
name,price,begin_date,end_date)
values('BodyCuts',100, '10.02.2020' ,'09.03.2020');

insert into subscriptions(
name,price,begin_date,end_date)
values('BodyBuild',150, '10.20.2020' ,'09.03.2020');

insert into workouts(
name,schedule,day_workout,subscriptions_id)
values('Aerobic','10-15','Luni,Marti,Vineri',1);

insert into costumers(
name,surname,age,subscriptions_id,workouts_id)
values('Vlad','Popescu',30,1,1);

insert into costumers(
name,surname,age,subscriptions_id)
values('Marius','Marian',27,2);

insert into costumers(
name,surname,age,subscriptions_id,workouts_id)
values('Vlad','Liviu',24,2,1);

select * from costumers;

delete from costumers where surname='Liviu';

update fitness_coachs set coach_workout='zumbra' where name='Marian';

-- mai jos urmeaza sa facem innner join
select * from costumers inner join subscriptions on costumers.subscriptions_id=subscriptions.id 
where subscriptions.price=100;

select * from subscriptions inner join workouts on workouts.subscriptions_id=subscriptions.id
where workouts.name='aerobic';

-- mai jos urmeaza sa facem left join
select * from workouts left join costumers on costumers.workouts_id=workouts.id;

-- mai jos urmeaza sa facem right join
select * from workouts right join costumers on costumers.workouts_id=workouts.id;

select * from costumers;