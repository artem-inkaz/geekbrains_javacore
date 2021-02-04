CREATE TABLE IF NOT EXISTS Cats
          (
           StudID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
           Name TEXT NOT NULL,
           GroupName TEXT NOT NULL,
           Score INTEGER NOT NULL
           );

CREATE TABLE Cats(CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, Name TEXT NOT NULL, Age INTEGER NOT NULL, Type TEXT NOT NULL, Sex TEXT NOT NULL );

insert into Cats(Name, Age, Type, Sex) values ('Barsik', 2, 'Bobtail', 'M'), ('Izolda', 1, 'Siam', 'W'), ('Dymok', 3, 'Homeless','M');

select * from Cats;

delete from Cats where Type like '%Home%';
delete from Cats where CatID > 100;
delete from Cats where id = ?;

update Cats set Name = 'Tom' where CatID < 100;
update Cats set Name = 'Jungle' where CatID = ?;