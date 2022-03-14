// @ts-check

/**
 * @typedef {{
 *      imageUrl: string,
 *      description: string
 * }} climateData
 */

/**
 * @type climateData
 */
const sunny = {
    imageUrl: "images/sunny.png",
    description: "Despejado"
};

/**
 * @type climateData
 */
const cloudy = {
    imageUrl: "images/cloudy.png",
    description: "Nublado"
};

/**
 * @type climateData
 */
const rainy = {
    imageUrl: "images/rainy.png",
    description: "Lluvioso"
};

/**
 * @param {number} min
 * @param {number} max
 * @returns {number} Numero al azar, entre `min` y `max`.
 */
const getRandomIntInRange = (min, max) => Math.floor(Math.random() * (max - min)) + min;

/**
 * @returns {climateData} Un clima al azar
 */
const getRandomClimate = () => {
    const climates = [sunny, cloudy, rainy];
    const n = getRandomIntInRange(0, climates.length);
    return climates[n];
};

/**
 * @argument {string} time
 */
const generateRandomClimateCard = (time) => {
    /**
     * @type HTMLTemplateElement
     */
    const template = document.querySelector("#climate-card-template");

    const timeOfDate = template.content.querySelector("h2");
    const title = template.content.querySelector("h3");
    const image = template.content.querySelector("img");
    const [minTemp, maxTemp] = template.content.querySelectorAll("span");

    const climate = getRandomClimate();
    const midTemp = getRandomIntInRange(10, 26);

    timeOfDate.innerHTML = time;
    title.innerHTML = climate.description;
    image.setAttribute("src", climate.imageUrl);
    image.setAttribute("alt", climate.description);
    minTemp.innerText = (midTemp - 5).toString();
    maxTemp.innerText = (midTemp + 5).toString();

    return template.innerHTML;
};

const results = document.querySelector("#result-cards");

results.innerHTML = generateRandomClimateCard("Mañana")
                    + generateRandomClimateCard("Tarde")
                    + generateRandomClimateCard("Noche");
