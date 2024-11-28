
//notazione letterale
let Utente = {
    username: "Silvia",
    password: "Miao123!!",

    checkcontrolloPassword: function () {
        let tentativi = 3;
        do {
            let passw = prompt("Inserisci la password: ");

            if (this.password == passw) {
                alert("Password corretta");
                tentativi = 0;
            }
            else if (tentativi > 0) {
                tentativi--;
                alert("Riprova password");
            }
            else {
                alert("Hai esaurito i tentativi");

            }
        }
        while (tentativi > 0);
    }

}
Utente.checkcontrolloPassword();
document.write("Utente1 riconosciuto");

//costruttore

function Utentee(username, password) {
    this.username = username;
    this.password = password;

    this.checkcontrolloPassword = function () {
        let tentativi = 3;
        do {
            let passw = prompt("Inserisci la password: ");

            if (this.password == passw) {
                alert("Password corretta");
                break;
            }
            else if (tentativi > 0) {
                tentativi--;
                alert("Riprova password");
            }
            else {
                alert("Hai esaurito i tentativi");

            }
        }
        while (tentativi > 0);
    }
}

class Utenteee {
    constructor(username, password) {
        this.username = username;
        this.password = password;
    }
        checkcontrolloPassword = function () {
            let tentativi = 3;
            do {
                let passw = prompt("Inserisci la password: ");

                if (this.password == passw) {
                    alert("Password corretta");
                    break;
                }
                else if (tentativi > 0) {
                    tentativi--;
                    alert("Riprova password");
                }
                else {
                    alert("Hai esaurito i tentativi");

                }
            }
            while (tentativi > 0);
        }
    }



let utente = new Utenteee("Gatto3", "MiaoCibo1!");
let utente2 = new Utenteee("Cane2", "Bau345$");
let utente3 = new Utenteee("Panda7", "Boh8!");

let database = [];
database.push(utente, utente2, utente3);






