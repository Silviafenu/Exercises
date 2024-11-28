
function cambioColore() {
    let element = document.getElementById('main');
    let idInput = document.getElementById('spesa');

    if (idInput.value.length === 0) {
        element.style.backgroundColor = 'red';
        idInput.style.border = '1px solid black';
    }
    else if(idInput.value.length > 12 && idInput.value.includes('@')){
        idInput.style.border = '5px solid green';
        element.style.backgroundColor = 'yellow';
    }
    else if(idInput.value.length > 12){
        element.style.backgroundColor = 'yellow';
        idInput.style.border = '1px solid black';
    }
    else if(idInput.value.includes('@')){
        idInput.style.border = '5px solid green';
        element.style.backgroundColor = 'white';
    }
    else{
        element.style.backgroundColor = 'white';
        idInput.style.border = '1px solid black';
    }

}