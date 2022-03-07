const {contextBridge, ipcRenderer} = require("electron");

contextBridge.exposeInMainWorld("electronAPI", {
    sayHello: (username) => ipcRenderer.send("say-hello", username),
    recieveUserName: (callback) => ipcRenderer.on("print-username", callback)
});
