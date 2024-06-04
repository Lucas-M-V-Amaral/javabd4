
const formulario = document.getElementById('contatos-gerais');

formulario.addEventListener('submit', function(event) {

    const campoNome = document.getElementById('nome').value;
    const campoEmail = document.getElementById('email-form').value;
    const campoMensagem = document.getElementById('msg').value;

    const avisos = document.getElementById('avisos');
    avisos.innerHTML = '';

    if(campoNome.length < 5) {
        avisos.innerHTML += '<p>O Campo NOME deve conter pelo menos 5 letras.<a href="#nome">Ir para?</a></p>';
    }
    
    if(campoNome.length > 40) {
        avisos.innerHTML += '<p>O Campo NOME não pode conter mais de 40 letras.<a href="#nome">Ir para?</a></p>';
    }

    if(!campoNome.match(/^[a-zA-Z ]+$/)) {
        avisos.innerHTML += '<p>O Campo NOME deve conter apenas letras de A a Z.<a href="#nome">Ir para?</a></p>';
    }

    if(!campoEmail.match(/^[A-Za-z0-9_.]{3,20}@([A-Za-z]{3,20}\.)+com$/)) {
        avisos.innerHTML += '<p>O endereço de e-mail não é válido.<a href="#email-form">Ir para?</a></p>';
    }

    if(campoMensagem.length < 5) {
        avisos.innerHTML += '<p>O Campo MENSAGEM deve conter pelo menos 5 caracteres.<a href="#msg">Ir para?</a></p>';
    }

    if(campoMensagem.length >300) {
        avisos.innerHTML +='<p>O Campo MENSAGEM não pode conter mais de 300 caracteres.<a href="#msg">Ir para?</a></p>';
    }
    
    if(avisos.innerHTML !=='') {
        event.preventDefault();window.scrollTo(0, 750);
    }
});
