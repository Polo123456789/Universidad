window.electronAPI.recieveUserName((evt, userName) => {
    document.getElementById("saludo").innerHTML = `Bienvenido ${userName}`;
});
