# Sobre

O PSO (Particle Swarm Optimization) é um algoritmo que simula os movimentos de
enxames, seja de peixes, aves ou outros animais. Nos enxames em geral podemos observar
comportamentos parecidos, os quais nos permitem desenvolver técnicas para melhorar as
buscas em ambientes abertos das mais variadas formas. Neste trabalho foram utilizadas 3 
fórmulas que representam tipos de relevo de um ambiente, são elas: Esfera, Rosenbrock e Rastrigin.

Dentre as diversas propriedades desse algoritmo podem ser destacadas a constante de
inércia (W) e as constantes cognitiva (C1) e social (C2). Quando o valor da
constante cognitiva (C1) é aumentado, as partículas são impelidas a voltar ao melhor ponto o qual já
passaram, ou seja seu pBest. Quando o valor da constante social (C2) é aumentado, as partículas
tendem a ir ao melhor lugar que já foi encontrado dentre todos os que o enxame já passou, ou
seja, o gBest. E por fim a inércia (W) é a constante que controla a tendência da partícula a
permanecer onde está, ou seja, quanto maior o valor da constante de inércia menor será a
“velocidade” ou “vontade” com que as partículas se movem em direção ao ponto ideal.

Quanto ao número de partículas, foi possível concluir que, quanto maior o número de
partículas dispostas aleatoriamente em um ambiente, maior será a chance de que uma delas
encontre o ponto ideal buscado, que no caso deste trabalho foram as coordenadas centrais de
cada tipo de terreno (esfera = [0, 0], rosenbrock = [1, 1], rastrigin = [0, 0]). As iterações são
as sequências de cálculos que determinam qual será a próxima posição de uma partícula,
então pode-se concluir que, quanto maior o número de iterações, ou seja, quanto mais vezes
as partículas se movimentarem, mais perto elas chegarão de encontrar o ponto ideal buscado.

# About

PSO (Particle Swarm Optimization) is an algorithm that simulates the movements of swarms, whether 
they are fish, birds, or other animals. In swarms in general, we can observe similar behaviors, 
which allow us to develop techniques to improve searches in various open environments. In this work, 
three formulas representing types of terrain in an environment were used: Sphere, Rosenbrock, and Rastrigin.

Among the various properties of this algorithm, the inertia constant (W) and the cognitive (C1) and social 
(C2) constants can be highlighted. When the value of the cognitive constant (C1) is increased, the particles 
are compelled to return to the best point they have passed, their pBest. When the value of the social 
constant (C2) is increased, the particles tend to go to the best place that has been found among all the swarm 
has passed, the gBest. Lastly, inertia (W) is the constant that controls the particle's tendency to stay where 
it is, meaning that the higher the value of the inertia constant, the lower the "velocity" or "desire" with 
which the particles move towards the ideal point.

Regarding the number of particles, it was possible to conclude that the larger the number of randomly placed 
particles in an environment, the greater the chance that one of them will find the sought-after ideal point, 
which in this case were the central coordinates of each type of terrain (sphere = [0, 0], rosenbrock = [1, 1], 
rastrigin = [0, 0]). Iterations are the sequences of calculations that determine the next position of a particle, 
so it can be concluded that the higher the number of iterations, or in other words, the more times the particles move, 
the closer they will get to finding the sought-after ideal point.

# Como usar?

* Baixe o projeto ou faça um clone do repositório em sua máquina
* Utilizando uma IDE ou o terminal, execute o arquivo **Main.java** para iniciar a aplicação
* A aplicação será iniciada, basta configurar os parâmetros na interface e clicar no botão **Play!**

Desenvolvido por: Carlos Willian Silva Camargos e [Vitor Daniel Leal](https://github.com/VitorDan).