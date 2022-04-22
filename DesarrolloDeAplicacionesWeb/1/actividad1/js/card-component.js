customElements.define("display-card", class extends HTMLElement {
    constructor() {
        super();

        const card = document.getElementById("card-template");
        const content = card.content;

        const shadowRoot = this.attachShadow({
            mode: "open"
        });
        shadowRoot.appendChild(content.cloneNode(true));

        const imgSource = this.getAttribute("img");
        if (imgSource) {
            const imageDiv = shadowRoot.getElementById("image");
            const img = document.createElement("img");
            img.setAttribute("src", imgSource);
            img.setAttribute("class", "card-img-top");
            imageDiv.appendChild(img);
            const imgTitle = this.getAttribute("img-title");
            if (imgTitle) {
                img.setAttribute("title", imgTitle);
            }
        }
    }
});
