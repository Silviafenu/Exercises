-- 1)Scrivere una query in SQL per visualizzare il nome, il cognome, il numero di reparto e il nome del reparto per ogni dipendente
SELECT e.first_name, e.last_name , d.department_id,  d.department_name 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id);


-- 2)Scrivere una query in SQL per visualizzare nome e cognome, dipartimento, città e stato per ogni dipendente
 SELECT e.first_name, e.last_name , d.department_name , l.city, c.country_name 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id) 
JOIN countries c ON (l.country_id = c.country_id); 


-- 3)Scrivere una query in SQL per visualizzare il nome, il cognome, lo stipendio e il lavoro di tutti i dipendenti
SELECT e.first_name, e.last_name, e.salary, j.job_title 
FROM employees e 
JOIN jobs j ON (e.job_id = j.job_id);


-- 4)Scrivere una query in SQL per visualizzare nome, cognome, numero di reparto e nome del reparto, per tutti i dipendenti dei reparti 8 o 4
SELECT e.first_name, e.last_name , d.department_id,  d.department_name 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
WHERE d.department_id IN (8,4); 


-- 5)Scrivere una query in SQL per visualizzare i dipendenti che contengono una lettera y al loro nome e visualizzare anche il loro cognome, il dipartimento, la città e la provincia dello stato.
SELECT e.first_name, e.last_name, d.department_name, l.city, l.state_province 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id)
WHERE e.first_name LIKE '%y%'; 


-- 6)Scrivere una query in SQL per visualizzare tutti i reparti, compresi quelli in cui non ci lavorano dei dipendenti
SELECT d.department_id, department_name 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id); 

-- oppure 
SELECT department_id, department_name 
FROM departments d 


-- 7) Scrivere una query in SQL per visualizzare il nome di tutti i dipendenti e il nome del loro manager, compresi quelli che non lavorano sotto alcun manager
SELECT e.first_name, manager.first_name Manager
FROM employees e 
LEFT JOIN employees manager ON (e.manager_id = manager.employee_id);


-- 8) Scrivere una query in SQL per visualizzare nome, cognome e nome del reparto per i dipendenti che lavorano nello stesso reparto del dipendente che ha il cognome di Taylor
SELECT e.first_name, e.last_name , d.department_id,  d.department_name 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
WHERE d.department_id = (SELECT e2.department_id 
					    FROM employees e2
					    WHERE e2.last_name = 'Taylor'); 
					   
					   
-- 9)Scrivere una query in SQL per visualizzare il nome completo (nome e cognome) dei dipendenti, la qualifica e le differenze di salario rispetto al proprio lavoro per i dipendenti che lavorano nel reparto ID 8
SELECT CONCAT("Nome: ",e.first_name, "       ","Cognome: ", e.last_name) "Nome completo", j.job_title,  (j.max_salary)- (e.salary)
FROM employees e					   
JOIN jobs j ON (e.job_id = j.job_id)
WHERE e.department_id = 8; 


-- 10) Scrivi una query in SQL per visualizzare il titolo del lavoro e lo stipendio medio dei dipendenti.
SELECT j.job_title, avg(e.salary) "stipendio medio"
FROM employees e 
JOIN jobs j ON (e.job_id = j.job_id)
GROUP BY job_title; 


-- 11) Scrivere una query in SQL per visualizzare il titolo del lavoro, il nome completo (nome e cognome) del dipendente e la differenza tra il salario massimo e lo stipendio del dipendente.
SELECT j.job_title, CONCAT("Nome: ",e.first_name, "       ","Cognome: ", e.last_name) "Nome completo",  (j.max_salary)- (e.salary)
FROM employees e 
JOIN jobs j ON (e.job_id = j.job_id); 


-- 12) Scrivere una query in SQL per visualizzare il nome completo (nome e cognome) del dipendente con ID e nome del paese in cui lavora attualmente.
SELECT CONCAT("Nome: ",e.first_name, "       ","Cognome: ", e.last_name) "Nome completo", c.country_name, c.country_id 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
JOIN locations l ON (d.location_id = l.location_id)
JOIN countries c ON (l.country_id = c.country_id); 


-- 13)Trova i dipendenti che guadagnano più del loro manager
SELECT e.first_name, e.last_name, e.salary
FROM employees e 
JOIN employees manager ON (e.manager_id = manager.employee_id)
WHERE e.salary > manager.salary 


-- 14)Trova i dipendenti con lo stipendio massimo per ciascun dipartimento(visualizzare l'id del dipartimento o il nome del dipartimento)
SELECT e.first_name, e.last_name, d.department_id, e.salary 
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
WHERE e.salary = (SELECT max(e2.salary) 
				     FROM employees e2
				    WHERE e.department_id = e2.department_id); 
				   
				    
-- 15)Visualizzare per ogni dipartimento(nome) la somma degli stipendi 
SELECT d.department_name, sum(e.salary) "Somma stipendi"
FROM employees e 
JOIN departments d ON (e.department_id = d.department_id)
GROUP BY d.department_name; 







