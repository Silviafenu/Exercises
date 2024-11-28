-- creazione tabelle
CREATE TABLE Auto(
	targa varchar(20) PRIMARY KEY NOT NULL,
	marca varchar(20) UNIQUE,
	cilindrata varchar(20) NOT NULL,
	potenza int (3),
	CodF varchar(20) NOT NULL,
	foreign KEY (CodF) REFERENCES Proprietari(CodF),
	CodAss varchar(20) NOT NULL,
	foreign KEY (CodAss) REFERENCES Assicurazioni(CodAss)
);


CREATE TABLE Proprietari(
	CodF varchar(20) PRIMARY KEY NOT NULL,
	nomePropr varchar(20) NOT NULL,
	residenza varchar(40) NOT NULL UNIQUE 
);


CREATE TABLE Assicurazioni(
	CodAss varchar(20) PRIMARY KEY NOT NULL,
	nome varchar(20) NOT NULL,
	sede varchar(20)
);


CREATE TABLE Sinistro(
	CodS varchar(20) PRIMARY KEY NOT NULL,
	localita varchar(20),
	dataSinistro date	
);

CREATE TABLE AutoCoinvolte(
	ImportoDelDenaro int,
	CodS varchar(20) NOT NULL,
	foreign KEY (CodS) REFERENCES Sinistro(CodS),
	targa varchar(20),
   foreign KEY (targa) REFERENCES Auto(targa)
); 



-- inserimento dati 
INSERT INTO Auto VALUES
("AA123BB", "Fiat","3902 cc", 70, "RSSMRA85M01H501Z", 'ASSR001A'),
("CC456DD", "Volkswagen","6498 cc", 110, "VRDLGI75C12F205K", 'ASSR002B'),
("EE789FF", "BMW","4395 cc",  150, "BNCLRA60T08L219W", 'ASSR003C'),
("GG101HH", "Audi","3979 cc",  140, "FNTGPP90S15B963H",'ASSR004D'),
("II112JJ", "Toyota","2339",  90,"PLSMNL70P22C351R", 'ASSR005E'); 


INSERT INTO Proprietari VALUES
('RSSMRA85M01H501Z', 'Mario Rossi', 'Milano'),
('VRDLGI75C12F205K', 'Luigi Verdi', 'Napoli'),
('BNCLRA60T08L219W', 'Laura Bianchi', 'Firenze'),
('FNTGPP90S15B963H', 'Giuseppe Fontana', 'Torino'),
('PLSMNL70P22C351R', 'Manuela Palestra', 'Roma');


INSERT INTO Assicurazioni VALUES
('ASSR001A', 'Generali', 'Trieste'),
('ASSR002B', 'UnipolSai', 'Bologna'),
('ASSR003C', 'Allianz', 'Milano'),
('ASSR004D', 'Reale Mutua', 'Torino'),
('ASSR005E', 'AXA Italia', 'Roma');

-- PROVA ES 3 
UPDATE assicurazioni 
SET nome = "SARA"
WHERE nome = 'AXA Italia';

UPDATE assicurazioni 
SET nome = "SARA"
WHERE nome = 'Generali';


INSERT INTO Sinistro VALUES 
('SIN001A202', 'Milano', '2023-05-12'),
('SIN002B304', 'Roma', '2023-06-18'),
('SIN003C406', 'Napoli', '2023-07-22'),
('SIN004D508', 'Torino', '2023-08-15'),
('SIN005E610', 'Firenze', '2023-09-10');

-- prova es 4
UPDATE sinistro 
SET dataSinistro = '2012-01-12'
WHERE dataSinistro =  '2023-05-12'; 

 INSERT INTO AutoCoinvolte VALUES 
 (150,'SIN001A202', "AA123BB" ),
 (1200,'SIN002B304',"CC456DD" ),
 (350,'SIN003C406', "EE789FF"),
 (500,'SIN004D508', "GG101HH"),
 (1000,'SIN005E610',"II112JJ"); 

-- 1 Targa e Marca delle Auto di cilindrata superiore a 2000 cc o di potenza superiore a 120 CV
SELECT targa, marca
FROM auto a 
WHERE cilindrata > "2000 cc"
OR  potenza > 120


-- 2 Nome del proprietario e Targa delle Auto di cilindrata superiore a 2000 cc oppure di potenza superiore a 120 CV
SELECT p.nomePropr, a.targa 
FROM auto a 
JOIN proprietari p ON (a.CodF = p.CodF)
WHERE cilindrata > "2000 cc"
OR  potenza > 120; 


-- 3. Targa e Nome del proprietario delle Auto di cilindrata superiore a 2000 cc oppure di potenza superiore a 120 CV, assicurate presso la “SARA”
SELECT p.nomePropr, a.targa, a2.nome 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
WHERE a2.nome =  'SARA'
AND cilindrata > "2000 cc"
OR  potenza > 120;

-- 4. Targa e Nome del proprietario delle Auto assicurate presso la “SARA” e coinvolte in sinistri il 20/01/12
SELECT p.nomePropr, a.targa, a2.nome, s.dataSinistro 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
JOIN autocoinvolte a3 ON (a.targa = a3.targa)
JOIN sinistro s ON (a3.CodS = s.CodS)
WHERE a2.nome =  'SARA'
AND s.dataSinistro = '2012-01-12'; 


-- 5. Per ciascuna Assicurazione, il nome, la sede ed il numero di auto assicurate
SELECT a2.nome, a2.sede, count(a.targa) 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
GROUP BY a2.CodAss 


-- 6. Per ciascuna auto “Fiat”, la targa dell’auto ed il numero di sinistri in cui è stata coinvolta
SELECT count(a.targa) 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
JOIN autocoinvolte a3 ON (a.targa = a3.targa)
JOIN sinistro s ON (a3.CodS = s.CodS)
WHERE a.targa = "Fiat"
GROUP BY a3.CodS ;

-- 7. Per ciascuna auto coinvolta in più di un sinistro, la targa dell’auto, il nome dell’ Assicurazione ed il totale dei danni riportati
 SELECT count(s.CodS), a.targa, a2.nome, sum(a3.ImportoDelDenaro) 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
JOIN autocoinvolte a3 ON (a.targa = a3.targa)
JOIN sinistro s ON (a3.CodS = s.CodS)
GROUP BY a.targa
HAVING count(s.CodS) >= 1; 


-- 8. CodF e Nome di coloro che possiedono più di un’auto
SELECT a.CodF, p.nomePropr, count(a.targa) 
FROM auto a 
JOIN proprietari p ON (a.CodF = p.CodF)
WHERE a.targa > 1
GROUP BY a.targa; 

-- 9. La targa delle auto che non sono state coinvolte in sinistri dopo il 20/01/10
SELECT  a.targa, s.dataSinistro 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
JOIN autocoinvolte a3 ON (a.targa = a3.targa)
JOIN sinistro s ON (a3.CodS = s.CodS)
WHERE s.dataSinistro < "2010-01-20"; 


-- 10. Il codice dei sinistri in cui non sono state coinvolte auto con cilindrata inferiore a 2000 cc
SELECT s.CodS 
FROM auto a 
JOIN assicurazioni a2 ON (a.codAss = a2.CodAss)
JOIN proprietari p ON (a.CodF = p.CodF)
JOIN autocoinvolte a3 ON (a.targa = a3.targa)
JOIN sinistro s ON (a3.CodS = s.CodS) 
WHERE a.cilindrata > "2000 cc"; 


