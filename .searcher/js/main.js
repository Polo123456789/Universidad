const input = document.getElementById("input");
const list = document.getElementById("list");

let resultList = fileList;

const updateList = () => {
    let res = "";
    for (let file of resultList) {
        res += `<li class="list-group-item"><a href="/${file}">${file}</a></li>`
    }
    list.innerHTML = res;
}
updateList();

const options = {
    includeScore: false,
}

const fuse = new Fuse(fileList, options);

input.addEventListener("input", (e) => {
    const result = fuse.search(e.target.value);
    console.table(result);
    resultList = [];
    for (r of result) {
        resultList.push(r.item);
    }
    updateList();
})
