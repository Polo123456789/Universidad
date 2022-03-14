// @ts-check

const {app, BrowserWindow} = require('electron');

const createWindow = () => {
    const b = new BrowserWindow({
        show: false
    });
    b.maximize();
    b.show();
    b.loadFile("index.html");
};

app.whenReady().then(createWindow);
