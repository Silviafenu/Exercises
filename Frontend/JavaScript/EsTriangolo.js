var n = Number(prompt("Inserisci un numero: ")); 

for(var i = 0; i < n; i++){
    for(var j = 0; j <= i; j++){
        document.write("#");
    }
    document.write("<br>");
}
