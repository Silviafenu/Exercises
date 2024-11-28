var numero = Number(prompt("Inserisci un numero: "));

if (numero % 2 == 0){
    alert('Il numero è pari');
}
else if (numero % 2 == 1){
    alert('Il numero è dispari');
}
else{
    alert('Quello che hai inserito non è un numero !!!!!')
}
if (numero % 2 == 0  || numero % 2 == 1){
switch(numero){
    case 1:
        document.write("uno");
        break;
    case 2: 
        document.write("due");
        break;
    case 3: 
        document.write("tre");
        break;
    case 4:
        document.write("quattro");
        break;
    case 5: 
        document.write("cinque");
        break;
    case 6: 
        document.write("sei");
        break;
    case 7: 
        document.write("sette");
        break;
    case 8: 
        document.write("otto");
        break;
    case 9: 
        document.write("nove");
        break;
    case 10: 
        document.write("dieci");
        break;
    default:
        alert("Il numero inserito non è compreso tra 1 e 10");
        break;       
}
}
else{
    alert("Il numero non è un numero !")
}