let frase = prompt("Inserisci la frase: ");
let lettera;

do {
    lettera = prompt("Inserisci la lettera da ricercare");

    if (lettera.length !== 1) {
        alert("INSERIRE UN SOLO CARATTERE");
    }
} while (lettera.length !== 1);


var countChar = function (frase, lettera) {
    var contaLettere = 0;

    for (var i = 0; i < frase.length; i++) {
        if (frase.charAt(i) == lettera) {
            contaLettere++;
        }
    }
    document.write("Il numero di lettere presenti nella frase è: " + contaLettere);
}

countChar(frase, lettera);