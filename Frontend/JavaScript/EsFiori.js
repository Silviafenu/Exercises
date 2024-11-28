var fiori = ['petunie', 'viole', 'rose', 'gigli', 'garofani'];
var prezzi = [0.50, 0.75, 1.50, 0.50, 0.80];

var scelta = 0;
var prezzoTot = 0;
var quantita = 0;

do {
    scelta = Number(prompt("Quali sono fiori vuoi? \n1)Petunie \n2)Viole \n3)Rose \n4)Gigli \n5)Garofani \n6)ESCI"));


    if (scelta == 1) {
        document.write("<br> il prezzo delle petunie è: " + prezzi[0] + " euro <br>");
    }
    else if (scelta == 2) {
        document.write("<br> il prezzo delle viole è: " + prezzi[1] + " euro <br>");
    }
    else if (scelta == 3) {
        document.write("<br> il prezzo delle rose è: " + prezzi[2] + " euro <br>");
    }
    else if (scelta == 4) {
        document.write("<br> il prezzo dei gigli è: " + prezzi[3] + " euro <br>");
    }
    else if (scelta == 5) {
        document.write("<br> il prezzo delle garofani è: " + prezzi[4] + " euro <br>");
    }

    if (scelta >= 1 && scelta <= 5) {
        quantita = Number(prompt("Quante ne vuoi di " + fiori[scelta - 1]));

        prezzoTot += prezzi[scelta - 1] * quantita;
        document.write("Hai scelto " + fiori[scelta - 1] + " e ne vuoi " + quantita);

        document.write("<br> Il prezzo totale dei fiori presi è: " + (quantita* prezzi[scelta-1]) + "<br>");

    }

} while (scelta >= 1 && scelta <= 5);

document.write("<br> Il prezzo totale dei fiori presi è: " + prezzoTot + "<br>");


