const del_n_al_20 = (n) => {
    if (n != 21) {
        alert(n)
        del_n_al_20(n + 1);
    }
}

del_n_al_20(1)
