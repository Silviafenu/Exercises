-- 1)Scrivere una query in SQL per visualizzare il nome completo (nome e cognome) e lo stipendio per i dipendenti che guadagnano meno di 6000.
SELECT CONCAT ("Nome: ",first_name, " ","           Cognome: ", last_name) "Nome Completo", salary 
FROM employees e
WHERE salary < 6000; 


-- 2)Scrivere una query in SQL per visualizzare il nome e cognome, il numero di reparto e lo stipendio per i dipendenti che guadagnano più di 8000 euro.
SELECT first_name, last_name, salary 
FROM employees e
WHERE salary > 8000; 

-- 3)Scrivere una query in SQL per visualizzare il nome e il cognome e il numero di reparto per tutti i dipendenti il cui cognome è "Taylor". 
SELECT first_name, last_name, job_id 
FROM employees e 
WHERE last_name =  'Taylor'; 

-- 4)Scrivere una query in SQL per visualizzare tutte le informazioni per tutti i dipendenti senza alcun numero di reparto
SELECT *
FROM employees
WHERE department_id IS NULL ;

-- 5)Scrivere una query in SQL per visualizzare tutte le informazioni sul reparto Marketing
SELECT *
FROM departments d 
WHERE department_name = 'Marketing'; 

-- 6)Scrivete una query in SQL per visualizzare il nome completo (nome e cognome), la data di assunzione, lo stipendio e il numero di reparto per quei dipendenti il cui nome non contiene la lettera M ed eseguite il risultato in ordine crescente per numero di reparto.
SELECT CONCAT ("Nome: ",first_name, " ","           Cognome: ", last_name) "Nome Completo", hire_date, salary, department_id 
FROM employees e
WHERE first_name  NOT LIKE '%m%' -- non compreso 
ORDER BY department_id; 

-- 7)Scrivere una query in SQL per visualizzare tutte le informazioni dei dipendenti il cui stipendio è nell'intervallo 8000 e 12000 e il numero di telefono non è nullo o il numero di reparto è diverso dal numero 40, 120 e 70 e sono stati assunti prima del 5 giugno 1987.
SELECT *
FROM employees e
WHERE salary BETWEEN 8000 AND 1200
AND phone_number IS NOT NULL 
AND department_id NOT IN (40, 120, 70)
AND hire_date < '1987-06-05'; 

-- 8)Scrivere una query in SQL per visualizzare il nome completo (nome e cognome), il numero di telefono e l'e-mail separati da un trattino, e lo stipendio, per quei dipendenti il cui stipendio è compreso tra 9000 e 17000. Le intestazioni di colonna saranno rispettivamente con Nominativo, Contatti e Remunerazione
SELECT CONCAT ("Nome: ",first_name, " ","           Cognome: ", last_name) "Nominativo", concat_ws(" - ", phone_number, email) "Contatti", salary "Remunerazione"
FROM employees e
WHERE SALARY BETWEEN 9000  AND 17000; 

-- 9)Scrivere una query in SQL per visualizzare il nome e il cognome e lo stipendio dei dipendenti il cui nome termina con la lettera m
SELECT first_name, last_name, salary 
FROM employees e
WHERE first_name LIKE '%m';

-- 10)Scrivere una query in SQL per visualizzare il nome completo (nome e cognome) e lo stipendio, per tutti i dipendenti il cui stipendio è fuori dall'intervallo 7000 e 15000 ed effettuare il risultato impostato in ordine crescente con il nome completo
SELECT CONCAT ("Nome: ",first_name, " ","           Cognome: ", last_name) "Nome Completo", salary 
FROM employees e
WHERE salary NOT BETWEEN 7000 AND 15000
ORDER BY salary ASC;  

-- 11)Scrivere una query in SQL per visualizzare il nome completo (nome e cognome), lo stipendio e il numero di manager per i dipendenti che lavorano sotto un manager
SELECT CONCAT ("Nome: ",first_name , " ","           Cognome: ",last_name ) "Nome Completo", salary 
FROM employees e 
WHERE manager_id IS NOT NULL;  

-- 12)Scrivere una query in SQL per visualizzare tutte le informazioni della tabella Dipendenti per i dipendenti assunti prima del 21 giugno 2002
SELECT * 
FROM employees e 
WHERE hire_date < '2002-06-21';

-- 13)Scrivere una query in SQL per visualizzare tutte le informazioni per tutti i dipendenti che hanno le lettere D, S, o N nel loro nome e anche organizzare il risultato in ordine decrescente per salario
SELECT * 
FROM employees e 
WHERE first_name LIKE '%d%'
OR first_name LIKE '%s%'
OR first_name LIKE '%n%'
ORDER BY salary DESC; 

-- 14)Scrivere una query in SQL per visualizzare il nome e il cognome e il numero del reparto per i dipendenti che hanno una lettera s come 3° carattere nel loro nome
SELECT first_name, last_name, department_id 
FROM employees e 
WHERE first_name LIKE '__s%';

-- 15)Scrivere una query in SQL per visualizzare l'ID del dipendente, il nome, l'id del lavoro e il numero del reparto per i dipendenti che lavorano, ad eccezione dei reparti 5, 3 e 8 
SELECT department_id, first_name, job_id
FROM employees e 
WHERE department_id NOT IN (5, 3, 8); 

-- 16)Scrivere una query in SQL per visualizzare l'id del dipendente, il nome, l'id del lavoro e il numero di reparto per quei dipendenti il cui numero di reparto è pari a 3, 4 o 9
SELECT department_id, first_name, job_id
FROM employees e 
WHERE department_id IN (3, 4, 9); 