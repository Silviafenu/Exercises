let n = Number(prompt("Inserisci un numero")); 

let arr = [n]; 

function riempiArray(){
    for(var i = 0; i < n; i++){
        arr[i] = Math.floor(Math.random() * 100) + 1;
    }
}

function stampaArray(){
    for(var i = 0; i < arr.length; i++){
        document.write("numero: " + arr[i] + " ");
    }
}

function numMinore(arr){
    let min = arr[0];
    for(var i = 0; i < arr.length; i++){
        if(arr[i] < min){
            min = arr[i];
        }
    }
    document.write("<br> Il numero minore è: " + min);
}

document.write("<br>");

function numMaggiore(arr){
    let magg = arr[0]; 
    for(var i = 0; i < arr.length; i++){
        if(arr[i] > magg){
            magg = arr[i];
        }
    }
    document.write("<br> Il numero maggiore è: " + magg);
}

riempiArray();
stampaArray(); 
numMinore(arr);
numMaggiore(arr); 