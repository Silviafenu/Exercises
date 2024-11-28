let arr = [];

let operazioni = ["addizione", "sottrazione", "divisione", "moltiplicazione"];

for (var i = 0; i < 4; i++) {
    arr[i] = Math.floor(Math.random() * 10) + 1;
    document.write("numero: " + arr[i] + " ");
}


function operazioneAritm(arr, operazioni) {
    let risultato = arr[0];
    let scelta = Number(prompt("Quale operazione vuoi che venga fatta: \n1)Addizione \n2)Sottrazione \n3)Divisione \n4)Moltiplicazione"));

    switch (scelta) {
        case 1:
            document.write("<br>");

            for (let i = 1; i < arr.length; i++) {
                risultato += arr[i];
            }
            document.write("<br> Il risultato dell' addizione è: " + risultato);
            break;

        case 2:
            document.write("<br>");

            for (let i = 1; i < arr.length; i++) {
                risultato -= arr[i];
            }
            document.write("<br> Il risultato della sottrazione è: " + risultato);
            break;

        case 3:
            document.write("<br>");

            for (let i = 1; i < arr.length; i++) {
                risultato /= arr[i];
            }
            document.write("<br> Il risultato della divisione è: " + risultato);
            break;

        case 4:
            document.write("<br>");

            for (let i = 1; i < arr.length; i++) {
                risultato *= arr[i];
            }
            document.write("<br> Il risultato della moltiplicazione è: " + risultato);
            break;
    }

}

operazioneAritm(arr, operazioni);