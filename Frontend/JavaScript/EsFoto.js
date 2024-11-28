function cambioImmagine(immagine) {
    let element = document.getElementById('immagineCentrale');
    element.src = document.getElementById(immagine).src;
}