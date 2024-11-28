-- creazione tabelle 
CREATE TABLE Utenti(
	id_utente int PRIMARY KEY AUTO_INCREMENT, 
	nome varchar(40) NOT NULL,
	cognome varchar(40) NOT NULL,
	eta int(3) 
	CONSTRAINT etacheck CHECK (eta > 17)
);

CREATE TABLE Libri(
	id_libro int PRIMARY KEY AUTO_INCREMENT,
	titolo varchar(500) NOT NULL,
	autore varchar(500) NOT NULL
); 

CREATE TABLE Prestito(
	id_prestito int PRIMARY KEY AUTO_INCREMENT,
	dataInizio date, 
	dataFine date,
	id_utente int NOT NULL, 
	foreign KEY (id_utente) REFERENCES Utenti(id_utente),
	id_libro int NOT NULL, 
	foreign KEY (id_libro) REFERENCES Libri(id_libro)
);

-- inserisco i valori nelle tabelle 
INSERT INTO Utenti VALUES 
(1001, "Mario", "Rossi", 35), 
(1002, "Laura", "Bianchi", 28), 
(1003, "Giovanni", "Verdi", 42), 
(1004, "Sara", "Neri", 30), 
(1005, "Luca", "Esposito", 25); 

INSERT INTO Libri VALUES
(006, "L'ombra del vento", "Carlos Ruiz Zafón"), 
(007, "Cento anni di solitudine", "Gabriel García Márquez"), 
(008, "La solitudine dei numeri primi", "Paolo Giordano"), 
(009, "La casa degli spiriti", "Isabel Allende"), 
(010, "Norwegian Wood", "Haruki Murakami");

INSERT INTO Prestito VALUES 
(201, "2024-01-10", "2024-01-24", 1001, 006),
(202, "2024-02-05", "2024-02-19", 1002, 007),
(203, "2024-03-15", "2024-03-29", 1003, 008), 
(204, "2024-04-20", "2024-05-04", 1004, 009),
(205, "2024-05-10", "2024-05-24", 1005, 010); 

-- prova es3 
UPDATE prestito 
SET dataFine = NULL 
WHERE id_prestito = 204;

-- prova es6 
UPDATE prestito 
SET dataInizio = "2024-02-01"
WHERE id_prestito = 202; 

UPDATE prestito 
SET dataFine = "2024-05-29"
WHERE id_prestito = 205; 

UPDATE prestito 
SET dataInizio = "2024-01-05"
WHERE id_prestito = 201; 

-- 1. Cercare tutti i libri prestati ad un utente specifico
SELECT l.titolo, l.autore 
FROM prestito p 
JOIN libri l ON (p.id_libro = l.id_libro)
WHERE p.id_utente = 1001
ORDER BY p.dataInizio;


-- 2. Individua i primi tre lettori che hanno letto più libri
SELECT u.nome, u.cognome, count(*) libriLetti
FROM prestito p 
JOIN utenti u ON (p.id_utente = u.id_utente)
GROUP BY u.id_utente
ORDER BY libriLetti DESC
LIMIT 3; 


-- 3. Individua tutti i possessori dei libri non ancora rientrati e il titolo degli stessi.
SELECT u.nome, u.cognome, l.titolo 
FROM utenti u 
JOIN prestito p ON (u.id_utente = p.id_utente)
JOIN libri l ON (p.id_libro = l.id_libro)
WHERE p.dataFine IS NULL; 


-- 4 . Dare lo storico dei libri chiesti in prestito da un utente indicando il periodo di riferimento. 
SELECT l.titolo 
FROM prestito p 
JOIN libri l ON (p.id_libro = l.id_libro)
WHERE p.id_utente = 1003
AND p.dataInizio BETWEEN "2024-03-15" AND "2024-03-30";


-- 5 Fai la classifica dei libri maggiormente prestati.
SELECT l.titolo, count(*) libriPrestati
FROM utenti u 
JOIN prestito p ON (u.id_utente = p.id_utente)
JOIN libri l ON (p.id_libro = l.id_libro)
GROUP BY l.id_libro 
ORDER BY libriPrestati DESC; 


-- 6. Individua tutti i prestiti la cui durata supera i 15gg.
SELECT l.titolo, p.dataInizio 
FROM prestito p 
JOIN libri l ON (p.id_libro = l.id_libro)
WHERE datediff(p.dataFine, p.dataInizio) > 15;   
 




