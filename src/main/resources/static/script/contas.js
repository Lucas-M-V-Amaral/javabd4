const dados = document.getElementById('form-dados');
const main = document.querySelector('main');
const comprar = document.querySelector('.botao-comprar');

comprar.addEventListener('click', (event) => {
  event.target.parentElement.parentElement.remove();
})

dados.addEventListener('submit', (event) => {

  event.preventDefault(); // Evita recarregamento da página ao submeter o form

  //------OBTENÇÃO DE VALORES DOS INPUTS------//
  const valor = document.getElementById('valor').value;
  const level = document.getElementById('level').value;
  const clan = document.getElementById('clan-select').value;
  const gender = document.getElementById('gender-select').value;
  const role = document.getElementById('prof-select').value;
  const server = document.getElementById('server-select').value;
  const itensAdicionais = document.querySelectorAll('[name="adicional"]');

  //------CRIAÇÃO DO CARD PARA A CONTA ANUNCIADA------//
  const contaContainer = document.createElement('div');
  contaContainer.classList.add('conta-container');

  contaContainer.innerHTML = `
    <section class="campo-info">
      <span class="info-conta">Clã: <p class="info-char">${clan}</p> | </span>
      <span class="info-conta">Level: <p class="info-char">${level}</p> | </span>
      <span class="info-conta">Profissão: <p class="info-char">${role}</p> | </span>
      <span class="info-conta">${gender} | </span>
      <span class="info-conta">Server: <p class="info-char">${server}</p></span>
    </section>
    <div class="outfit-container"><img src="imagens/outfits/${clan}_${gender}.png" alt="Outfit ${clan} ${gender}"></div>
    <div class="itemSet-container">
      <div class="item-container"><img src="imagens/itens/Hightechchip.png" alt="" class="item-pxg"></div>
      <div class="item-container"><img src="imagens/itens/Lorelei_Artefact.png" alt="" class="item-pxg"></div>
      <div class="item-container"><img src="imagens/itens/Giant_Electric_Fang.png" alt="" class="item-pxg"></div>
      <div class="item-container"><img src="imagens/itens/Iron_Mask.png" alt="" class="item-pxg"></div>
    </div>
    <div class="infos-adicionais">
      <ul class="lista-info">
        
      </ul>
    </div>
    <section class="campo-preco">
      <p>valor</p>
      <p><span class="preco-item">R$ ${valor}</span><span class="centavos">,00</span></p>
      <button class="botao-comprar">Comprar</button>
    </section>
  `;

  main.appendChild(contaContainer);

  //------CASO EXISTAM INFORMAÇÕES ADICIONAIS, INCLUI NO CARD CRIADO------//
  const listaAdicionais = contaContainer.querySelector('.lista-info');

  itensAdicionais.forEach(function(item) {
    if (item.value != "") {
      const info = document.createElement('li');
      
      info.textContent = item.value;
      
      listaAdicionais.appendChild(info);
    }
  });

  //------CRIAÇÃO DO BOTÃO DE COMPRA PARA A CONTA ANUNCIADA------//
  const comprar = contaContainer.querySelector('.botao-comprar');

  comprar.addEventListener('click', (event) => {
    event.target.parentElement.parentElement.remove();
  })

  dados.reset(); // Limpa os dados do formulário
});