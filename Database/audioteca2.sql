CREATE TABLE Album(
	id_album int PRIMARY KEY,
	nomeAlbum varchar(40) NOT NULL,
	titolo varchar(500) NOT NULL,
	id_genere int, 
	foreign KEY (id_genere) REFERENCES Genere(id_genere)
);

CREATE TABLE Brani(
	id_brano int PRIMARY KEY,
	nomeAutore varchar(40) NOT NULL,
	titolo varchar(500) NOT NULL,
	id_album int, 
	foreign KEY (id_album) REFERENCES Album(id_album)
); 

CREATE TABLE Genere(
	id_genere int PRIMARY KEY,
	nomeGenere varchar(20) NOT NULL 
); 


INSERT INTO album VALUES
(1, "Infinito", "Oltre il confine", 201 ),
(2, "Notturno", "Sogni perduti", 202),
(3, "Aurora","Un nuovo inizio", 203),
(4, "Ritmi del cuore","Battiti incessanti", 204),
(5, "Nebbie del cuore","Ombre sussuranti", 205);


INSERT INTO brani VALUES
(101, 'Giovanni Rossi', "Oltre l'orizzonte",1),
(102, 'Anna Bianchi', "Nel vento",2),
(103, 'Marco Verdi', "La strada di casa",3),
(104, 'Sara Neri', "Silenzi lontani",4),
(105, 'Luca Ferrari', "Tramonti dorati",5);


INSERT INTO genere VALUES 
(201, 'Rock'),
(202, 'Jazz'),
(203, 'Pop'),
(204, 'Reggae'),
(205, 'Folk');