
let premereTasto = document.addEventListener("keyup", tastoInvio); //azione di premere tasto

//premendo il tasto inserisco 
let inserBotton = document.getElementById("bottone");
inserBotton.addEventListener("click", inserimento);

//premendo il tasto elimino
let eliminBotton = document.getElementById("bottone2");
eliminBotton.addEventListener("click", eliminazione);

let titolo1 = document.createElement("h1");
titolo1.textContent = "Lista della spesa";
titolo1.id = "title";

let body = document.querySelector("body");
let main = document.getElementById("main");

body.insertBefore(titolo1, main);


function inserimento() {
    let idInput = document.getElementById('spesa');

    if (idInput.value === '') {
        alert("NON hai inserito nessun oggetto!");
    }
    else {
        let elementiLista = document.createElement("li"); //gli elementi che andranno nella lista 

        //ogni singolo elemento della lista se cliccato viene barrato
        elementiLista.addEventListener("click", sbarramento);

        //ogni oggetto ha la possibilita di essere eliminato 
        let elimBotton = document.createElement("button");
        elimBotton.textContent = " X ";
        elimBotton.className = "bottoneX";

        elimBotton.addEventListener("click", function () {
            if (!confirm("Sei sicuro di voler eliminare questo oggetto?")) {
                ev.preventDefault();
                console.log("Non hai cancellato l'oggetto");
                ev.stopPropagation();
            }
            else{
                elementiLista.remove();
            }
        });

       

        let oggettiSpesa = document.createTextNode(idInput.value);  //oggetti che scrivo nel input 

        elementiLista.appendChild(oggettiSpesa);
        elementiLista.appendChild(elimBotton);
        let ulPadre = document.getElementsByTagName("ul")[0];
        ulPadre.appendChild(elementiLista);

    }

    tastoInvio(premereTasto);
}

function tastoInvio(event) {
    if (event.code === 'Enter') { //se il tasto è invio 
        inserimento();
    }
};

function eliminazione(event) {
    if (!confirm("Sei sicuro di voler eliminare tutta lista ?")) {
        event.preventDefault();
        console.log("Non hai cancellato");
        event.stopPropagation();
    }
    else{
        let ulPadr = document.getElementById("lista");
        ulPadr.innerHTML = "";
    }
}

function sbarramento(event) {
    let ev = event.target;
    if (ev.style.textDecoration === "line-through") {
        ev.style.textDecoration = "none";
    } else {
        ev.style.textDecoration = "line-through";
    }
}



