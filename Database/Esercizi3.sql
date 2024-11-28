-- 1-Scrivete una query in SQL per visualizzare il job_id, il numero di dipendenti, la somma dello stipendio e la differenza tra lo stipendio più alto e quello più basso per un lavoro.
  SELECT COUNT(job_id), count(employee_id), SUM(salary) "Somma Salario",  (MAX(salary)- MIN(salary)) "Differenza Salario" 
  FROM employees e
  GROUP BY job_id;
 

-- 2- Scrivere una query in SQL per visualizzare i reparti in cui un manager gestisce 4 o più dipendenti.
SELECT department_id, count(manager_id) 
FROM employees e 
GROUP BY manager_id, department_id 
HAVING count(manager_id) >= 4; 


-- 3- Scrivere una query in SQL per visualizzare i reparti in cui lavorano più di 5 dipendenti che hanno il numero di telefono
SELECT count(department_id) 
FROM employees e 
WHERE phone_number IS NOT NULL 
GROUP BY department_id 
HAVING count(department_id) > 5; 

-- 4- Scrivete una query in SQL per visualizzare l'ID del lavoro per quei lavori il cui stipendio medio è superiore a 8000.
SELECT count(job_id), avg(salary) 
FROM employees e 
GROUP BY job_id
HAVING avg(salary) > 8000; 


-- 5- Scrivere una query in SQL per visualizzare il titolo del lavoro, la differenza tra il salario minimo e massimo per quei lavori il cui salario massimo è compreso tra 12000 e 18000.
SELECT job_id , (MAX(salary)- MIN(salary)) "Differenza Salario"
FROM employees e 
GROUP BY job_id 
HAVING max(salary) BETWEEN 12000 AND 18000;  


-- 6 Scrivere una query in SQL per visualizzare il nome e il cognome e lo stipendio di quei dipendenti che guadagnano meno del dipendente il cui numero è 179
SELECT first_name, last_name, salary 
FROM employees e 
WHERE salary < (SELECT salary
				FROM employees e2
				WHERE employee_id = 179); 
			

-- 7- Scrivere una query SQL dove bisogna ottenere il nome completo dei dipendenti che lavorano sotto il manager "Raphaely"
SELECT concat(first_name, last_name) 
FROM employees e 
WHERE manager_id = (SELECT employee_id 
					FROM employees e2
					WHERE last_name = 'Raphaely'); 
				
				
-- 8- Scrivere una query SQL che stampi l'Elenco dei dipendenti che hanno uno stipendio superiore alla media degli stipendi del loro dipartimento.
SELECT concat(first_name, " ", last_name), salary,department_id 
FROM employees e
WHERE salary  > (SELECT avg(salary)  
				     FROM employees e2
				    WHERE e.department_id = e2.department_id); 
				
-- 9-  Trova i dipendenti che hanno uno stipendio superiore a tutti gli stipendi dei dipendenti del dipartimento 6.
SELECT concat(first_name, " ", last_name)
FROM employees e
WHERE salary  > ALL (SELECT salary 
				     FROM employees e2
					 WHERE department_id = 6); 

			

			
