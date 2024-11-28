-- 1 Scrivere una query in SQL per visualizzare tutte le informazioni degli impiegati.

SELECT *
FROM employees e; 

-- 2  Scrivi una query in SQL per visualizzare gli stipendi di tutti gli impiegati.
SELECT salary 
FROM employees e ;

-- 3 Scrivere una query in SQL per visualizzare i lavori attivi nella tabella impiegati.
SELECT DISTINCT job_id 
FROM employees e;

-- 4 Scrivere una query in SQL per elencare il nome dell'impiegato e lo stipendio aumentato del 15%. Il valore dovrà essere espresso in Euro 
SELECT last_name, salary, (salary * 1.15), "Euro"
FROM employees e;

-- 5 Scrivere una query in SQL per produrre un output che deve visualizzare il nominativo  (nome e cognome) e l'id del lavoro, rinominando la colonna "Impiegato & job_id".
SELECT CONCAT ("Impiegato: ",first_name, "", last_name, "              Job id: ", job_id) "Impiegato & Job Id" 
FROM employees e; 