# Padroes_Telefone

## Antonio Mario Jesus Vidal Leite e Lucas Matheus Elias Silva Teixeira dos Santos

# Resposta da I.A.

Prompt 1:

Tenho uma atividade da cadeira de padrões de projeto de software e quero que vc me ajude. a questão é sobre o padrão observer em java. vou te mandar os arquivos das classes e vc vai analisar eles. quero que a UI screen observe o phonemodel e que o phonemodel nao saiba da existencia da UI. NÂO ME DE A SOLUÇÂO. quero que vc aja como um tutor e me de o passo a passo em vez de uma solução pronta, para eu ir implementando e fazendo os commits. qual deve ser o primeiro passo?

Resposta 1:

Olá! Excelente iniciativa. Usar o padrão Observer é a escolha perfeita para resolver esse problema de acoplamento, garantindo que os dados (PhoneModel) avisem a interface gráfica (Screen) sem precisarem saber da existência dela.
Como você pediu, atuarei estritamente como seu tutor. Não vou escrever o código por você, mas vou guiar sua arquitetura.
O Primeiro Passo (Para o seu 1º Commit)
O grande segredo do padrão Observer para evitar o acoplamento é a abstração. O PhoneModel não pode ter uma variável do tipo Screen dentro dele. Em vez disso, ele deve interagir com um "contrato" genérico.
Sua tarefa para o primeiro passo é criar esse contrato:
Crie um novo arquivo no seu projeto para abrigar uma Interface (você pode chamá-la de Observer ou PhoneObserver, por exemplo).
Dentro dessa interface, defina a assinatura de apenas um método genérico (por exemplo, update ou onDigitAdded).
Pense no seguinte: Quando o modelo for avisar os observadores que algo mudou, que tipo de informação ele precisa enviar? Defina o parâmetro desse método com base na informação que o observador precisará receber (no caso, o dígito que acabou de ser pressionado).
Vá para a sua IDE, crie essa interface de forma simples e faça o seu primeiro commit (sugestão de mensagem: "feat: cria interface Observer para desacoplamento").

prompt 2:

Criei a interface PhoneObserver. agora vamos adaptar o PhoneModel para um observador. como eu estruturo a classe para que ela aceite o observador e faça os prints sempre que um novo digito for adicionado?

Resposta 2:

Excelente progresso! Mas antes de falar da estrutura, vamos fazer uma pausa super importante para um alinhamento conceitual, pois você mencionou "faça os prints sempre que um novo dígito for adicionado".
Cuidado com a responsabilidade! O PhoneModel é a nossa camada de regra de negócios/dados. Ele não deve fazer nenhum print no console. A responsabilidade dele é apenas guardar os números e "gritar" (notificar) que algo mudou. Quem vai de fato imprimir as coisas na tela será a Screen, quando formos mexer nela no próximo passo.
Dito isso, vamos ao passo a passo de como estruturar o PhoneModel.
O Segundo Passo (Para o seu 2º Commit): O Subject (Observável)
No padrão Observer, a classe que está sendo observada (o Subject) precisa atuar como um "Canal de YouTube": ela precisa ter uma lista de inscritos e precisa avisá-los quando há novidades.
Sua tarefa agora no PhoneModel é:
A Lista de Inscritos: Adicione um novo atributo na sua classe. Esse atributo deve ser uma Coleção (como um List ou ArrayList) que guarde objetos do tipo da interface que você criou no passo 1 (PhoneObserver).
O Botão de Inscrever-se: Crie um método público (por exemplo, addObserver) que receba um PhoneObserver como parâmetro e simplesmente adicione esse objeto à lista que você acabou de criar.
Disparando a Notificação: Vá até o método que já existe na classe responsável por inserir o dígito (provavelmente se chama addDigit). Imediatamente após adicionar o dígito na lista interna de números do telefone, você deve avisar a galera.
Crie um laço de repetição (for ou foreach) que percorra a sua lista de observadores.
Para cada observador na lista, chame aquele método que você definiu na interface (ex: update), passando o novo dígito como parâmetro.
Faça essas alterações na sua IDE. Perceba que o PhoneModel não vai importar a Screen em momento algum, mantendo o desacoplamento!
Quando terminar e testar a compilação, faça seu segundo commit (sugestão: "feat: transforma PhoneModel em Subject implementando notificacoes") e me avise para irmos ao Passo 3!
