function setCookie(name, value, exDays) {
    const dataNow = new Date();
    dataNow.setTime(dataNow.getTime() + (exDays * 24 * 60 * 60 * 1000));
    const expires = "expires="+dataNow.toUTCString();
    document.cookie = name + "=" + value + ";" + expires + ";path=/;" + "SameSite=Strict";
}

function getCookie(cname) {
    const name = cname + "=";
    const ca = document.cookie.split(';');
    for(let i = 0; i < ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) === ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) === 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

function deleteCookie(name) {
    setCookie(name, "", 0);
}

function cookieIsSet(name){
    const cookies = document.cookie.split(";");
    for (let i in cookies)
    {
        if (cookies[i].indexOf(name + "=") === 0)
            return true;
    }
    return false;
}
