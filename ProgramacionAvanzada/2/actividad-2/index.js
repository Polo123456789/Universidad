// @ts-check

const form = document.querySelector("form");

/**
 * @type HTMLInputElement
 */
const userName = document.querySelector("#user-name")

/**
 * @type HTMLInputElement
 */
const email = document.querySelector("#email");

/**
 * @type HTMLInputElement
 */
const password = document.querySelector("#password");

/**
 * @type HTMLInputElement
 */
const date = document.querySelector("#date");

/**
 * @type HTMLInputElement
 */
const error = document.querySelector("#error-msg");

/**
 * @param {string} text
 */
const reportError = (text) => {
    if (error.classList.contains("invisible")) {
        error.classList.remove("invisible");
    }
    error.textContent = text;
}

const checkUserName = () => {
    const p = /[a-zA-Z0-9 ]+/;
    const res = p.exec(userName.value);
    if (res[0] != res.input) {
        reportError(
            "El nombre de usuario puede estar formado solo por letras y "
            + "numeros"
        );
        return false;
    }
    return true;
};

const checkEmail = () => {
    const acceptedDomains = [
        "gmail.com",
        "yahoo.com",
        "icloud.com",
        "outlook.com"
    ];
    const domain = email.value.split("@")[1];

    if (!acceptedDomains.includes(domain)) {
        let error = "Los dominios para la direccion de correo aceptados son: ";
        for (const d of acceptedDomains) {
            error += `'${d}' `
        }
        reportError(error);
        return false;
    }
    return true;
};

const checkPassword = () => {
    const specialCharacters = [
        "!",
        "?",
        ".",
        "(",
        ")",
        "#",
        "$",
        "%",
    ];

    /**
     * @param text {string}
     * @returns {boolean} Verdadero si el texto contiene letras del alfabeto
     */
    const hasAlpha = (text) => {
        const p = /[a-zA-Z]+/;
        return p.test(text);
    };

    /**
     * @param text {string}
     * @returns {boolean} Verdadero si el texto contiene numeros
     */
    const hasNumeric = (text) => {
        const p = /[0-9]+/;
        return p.test(text);
    };

    /**
     * @param text {string}
     * @returns {boolean} Verdadero si el texto contiene uno de los caracteres
     *                    en `specialCharacters`.
     */
    const hasSpecial = (text) => {
        for (const sc of specialCharacters) {
            if (text.includes(sc)) {
                return true;
            }
        }
        return false;
    };

    const pwd = password.value;
    if (!hasAlpha(pwd) || !hasNumeric(pwd) || !hasSpecial(pwd)) {
        let error = "La contraseña tiene que tener al menos una letra, "
                    + "un numero, y uno de los siguientes caracteres: ";
        for (const sc of specialCharacters) {
            error += `${sc}`;
        }
        reportError(error);
        return false;
    }
    return true;
};

const checkDate = () => {
    /**
     * Tomar solo date.valueAsDate daba el dia enterior, la forma correcta de
     * sacar la fecha la tome de:
     * https://stackoverflow.com/questions/35205627/why-a-given-date-turns-into-a-day-before-when-using-new-date
     *
     * @param date {string}
     * @returns {Date}
     */
    const parseDate = (date) => {
        const d = date.split("-");
        const year = +d[0];
        const month = +d[1] - 1;
        const day = +d[2];
        const result = new Date(year, month, day);
        result.setHours(0, 0, 0, 0);
        return result;
    };

    /**
     * @param d1 {Date}
     * @param d2 {Date}
     * @returns {number} Diferencia entre las fechas en años.
     */
    const calculateYearsDiff = (d1, d2) => {
        const diffInMiliseconds = d1.getTime() - d2.getTime();
        const diffDate = new Date(diffInMiliseconds);
        return Math.abs(diffDate.getUTCFullYear() - 1970);
    };

    const today = new Date();
    const selected = parseDate(date.value);

    today.setHours(0, 0, 0 ,0);

    if (today <= selected) {
        reportError(
            "La fecha seleccionada no puede ser mayor o igual al dia de hoy."
        );
        return false;
    }

    if (calculateYearsDiff(today, selected) <= 12) {
        reportError(
            "Tiene que tener al menos 13 años para poder utilizar el sitio"
        );
        return false;
    }

    return true;
};

form.addEventListener("submit", (e) => {
    e.preventDefault();
    if (!checkUserName()
        || !checkEmail()
        || !checkPassword()
        || !checkDate()) {
        return false;
    }
    window.electronAPI.sayHello(userName.value);
});
