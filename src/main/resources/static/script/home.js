document.addEventListener("DOMContentLoaded", function() {

    let scrollContainer = document.querySelector(".container2");
    let setaEsquerda = document.querySelector(".seta-esquerda");
    let setaDireita = document.querySelector(".seta-direita");

    scrollContainer.addEventListener("wheel", (evt) => {
        evt.preventDefault();
        scrollContainer.scrollLeft += evt.deltaY;
    });

    setaDireita.addEventListener("click", () => {
        scrollContainer.style.scrollBehavior = "smooth";
        scrollContainer.scrollLeft += 330;
    });

    setaEsquerda.addEventListener("click", () => {
        scrollContainer.style.scrollBehavior = "smooth";
        scrollContainer.scrollLeft -= 330;
    });
});