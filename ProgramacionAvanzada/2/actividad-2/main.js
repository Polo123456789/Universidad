// @ts-check

const {app, BrowserWindow, ipcMain} = require("electron");
const path = require("path");

const createWindow = () => {
    const b = new BrowserWindow({
        width: 800,
        height: 640,
        webPreferences: {
            preload: path.join(__dirname, "preload.js")
        }
    });

    ipcMain.on("say-hello",(evt, userName) => {
        b.loadFile("bienvenido.html")
        b.webContents.on("did-finish-load", () => {
            b.webContents.send("print-username", userName)
        });
    })

    b.loadFile("index.html");
};

app.whenReady().then(createWindow);
