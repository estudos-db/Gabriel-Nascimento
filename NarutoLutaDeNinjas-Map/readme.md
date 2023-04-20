<h1>Exercício de Programação Orientada a Objetos (POO) em Java - Anime Naruto</h1>
<p>Neste desafio, vamos continuar apraticar nossas habilidades em programação orientada a objetos utilizando o anime Naruto como exemplo. Agora vamos criar batalhas emocionanetes, onde ninjas poderão competir entre si.</p>
<h2>Requisitos</h2>
<h3>Atributos do Personagem:</h3>
<ul>
  <li>Nome (String)</li>
  <li>Jutsus (Map - String, Integer)</li>
  <li>Chakra (int = 100)</li>
  <li>Vida (int)</li>
</ul>
<h3>Métodos:</h3>
<ul>
  <li>Um método que permita adicionar um novo jutsu ao Map de jutsus, preste atenção, deve utilizar a Interface "Map" que tem como chave o nome do jutso e o dano máximo que ele pode causar</li>
</ul>
<h3>Interface Ninja:</h3>
<h4>Métodos:</h4>
<ul>
  <li><code>usarJutsu()</code>: exibe uma mensagem na tela indicando que o personagem está usando um jutsu, infere um jutso contra o inimigo para causar danos ao mesmo e desconta 1o pontos de chakra de quem usa o jutsu.</li>
  <li><code>desviar()</code>: exibe uma mensagem na tela indicando que o personagem está desviando de um ataque, caso ele tenha sucesso ao desviar ele não perde vida, caso contrário, ele perde vida, o dano causado será o equivalente ao dano do jutso recebido.</li>
</ul>
<h3>Classes:</h3>
<ul>
  <li>NinjaDeTaijutsu: classe que representa um personagem especializado em Taijutsu.</li>
  <ul>
    <li>Métodos:</li>
    <li><code>usarJutsu()</code></li>
    <li><code>desviar()</code></li>
  </ul>
  <li>NinjaDeNinjutsu: classe que representa um personagem especializado em Ninjutsu.</li>
  <ul>
    <li>Métodos:</li>
    <li><code>usarJutsu()</code></li>
    <li><code>desviar()</code></li>
  </ul>
<h2>Instruções</h2>
<ol>
<li>Crie uma classe <code>Personagem</code> que atenda aos requisitos acima.</li>
<li>Crie uma interface <code>Ninja</code> que defina os métodos <code>usarJutsu()</code> e <code>desviar()</code>.</li>
<li>Crie as classes <code>NinjaDeTaijutsu</code>, <code>NinjaDeNinjutsu</code>   que estendem a classe <code>Personagem</code> e implementam a interface <code>Ninja</code>, cada uma com seus próprios métodos <code>usarJutsu()</code> e <code>desviar()</code>.</li>
<li> Ninja só pode atacar enquanto tenha chakra, a cada golpe ele deve perder uma quantidade de chakra </li>
<li> Se o ninja zerar a vida ou não puder mais atacar ele perde </li>
<li> Você pode definir regras de dano causado e defesa conforme achar melhor </li>
</ol>

<h2>Desafio</h2>
<h3>Crie uma Classe <code>Jutso</code> com os atributos minimos</h3>
<ul>
  <li>Dano (int)</li>
  <li>ConsumoDeChakra (ind)</li>
</ul>
Agora use esta classe para atacar seus oponentes, mas com uma observação, não deixe de usar a interface Map! Ao invés do Map conter apenas o nome e dano do jutsu, agora ela irá conter um nome e uma instância da classe Jutsu!
Faça uma manipulação para quando você usar um jutsu!