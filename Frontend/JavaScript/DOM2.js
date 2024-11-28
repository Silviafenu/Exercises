// accedere sull'elemento singolo
//primo elemento della lista (carne)
let elemento = document.getElementById("uno");

//manipolo elemento 
elemento.innerText += " di manzo"; 

let element2 = document.querySelector("#uno");

let element3 = document.querySelector(".listaFiglio"); //recupera il primo in ordine di riga delle classi 

let el = document.getElementsByClassName("listaFiglio")[0]; //puntando elemento carne

let elementiLista = document.getElementsByTagName("li");

//let ulPadre = document.getElementsByTagName("ul")[0];

let elemLista = document.querySelectorAll(".listaFiglio");

 
element2.setAttribute("class", "rosso");
element2.className = "rosso";  //sovvrascrive i valori delle classi di un elemento 
element2.classList.add("blu", "verde");

var pesce = element2.nextElementSibling; //elemento successivo
var element5 = pesce.previousElementSibling; //elemento precedente 
var ulPadre2 = pesce.parentElement; //elemento padre 
ulPadre2.lastChild; //ultimo figlio 
ulPadre2.firstChild; //primo figlio 

//creazione nuovo nodo/elemento 
//nuovo elemento della lista 
var newElement = document.createElement("li");

//creo contenuto del nuovo elemento
var testo = document.createTextNode("Latticini");

//unisco i due elementi creati 
newElement.appendChild(testo); 

//puntare su un elemento dove aggiungere quello creato 
let ulPadre = document.getElementsByTagName("ul")[0];

//unisco
ulPadre.appendChild(newElement); 

//metto prima di pesce 
ulPadre.insertBefore(newElement, pesce);

