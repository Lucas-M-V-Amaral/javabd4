const formLogin = document.getElementById('login-form')


formLogin.addEventListener('submit', async (e) => {
    e.preventDefault()
    const loginBox = document.querySelector('.email-senha');

    const email = document.querySelector('[name="email"]');
    const pw = document.querySelector('[name="senha"]');

    const response = await fetch('./json/usuarios.json')
    const users = await response.json()

    const user = users.find((user) => user.email == email.value.trim().toLowerCase())

    if(user === undefined) {
        loginBox.insertBefore(elementMessage('Usuario não encontrado', 'red'), formLogin)
        return
    }

    if(user.senha != pw.value) {
        loginBox.insertBefore(elementMessage('Email ou senha invalidas!','red'), formLogin)
        return
    }

    formLogin.style.display = 'none';
    const imageLoading = document.querySelector('.loading-gif')
    imageLoading.style.display = 'block';
    const sucesso = elementMessage("Login efetuado com sucesso!", 'green');
    loginBox.insertBefore(sucesso, formLogin)

    setTimeout(() => {
        formLogin.style.display = 'block';
        imageLoading.style.display = 'none';
        sucesso.style.display = 'none';
        document.querySelector('.sair').dispatchEvent(new Event('click'));
    }, 3000)
})


function elementMessage(message, colorText) {
    const error = document.createElement('p')
    error.style.color = colorText;
    error.style.textAlign = 'center';

    const texto = document.createTextNode(message);
    error.appendChild(texto);
    return error;
}