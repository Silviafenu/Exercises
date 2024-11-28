var n = Number(prompt("Inserisci un numero: ")); 
var somma = 0;

for(var i = 0; i <= n; i++){
    if(i % 2 == 1){
         somma += i; 
    }
}
document.write("La somma dei numeri dispari è: " + somma); 
