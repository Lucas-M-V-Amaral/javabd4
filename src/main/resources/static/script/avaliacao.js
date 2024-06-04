
document.addEventListener("DOMContentLoaded", function() {

    let scrollContainerDois = document.querySelector(".caixa-comentarios");
    let setaEsquerdaDois = document.querySelector(".seta-esquerda-av");
    let setaDireitaDois = document.querySelector(".seta-direita-av");

    scrollContainerDois.addEventListener("wheel", (evt) => {
        evt.preventDefault();
        scrollContainerDois.scrollLeft += evt.deltaY;
    });

    setaDireitaDois.addEventListener("click", () => {
        scrollContainerDois.style.scrollBehavior = "smooth";
        scrollContainerDois.scrollLeft += 370;
    });

    setaEsquerdaDois.addEventListener("click", () => {
        scrollContainerDois.style.scrollBehavior = "smooth";
        scrollContainerDois.scrollLeft -= 370;
    });

});