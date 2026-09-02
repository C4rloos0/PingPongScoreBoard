## 4. Quadro comparativo

| Abordagem                        | Rotação de tela | Morte do processo |
|-----------------------------------|-----------------|-------------------|
| remember                          | Não Sobrevive   | Não Sobrevive     |
| ViewModel + mutableStateOf        | Sobrevive       | Não Sobrevive     |
| ViewModel + StateFlow              | Sobrevive       | Não Sobrevive     |
| ViewModel + SavedStateHandle       | Sobrevive       | Sobrevive         |

## 5. Perguntas
1. **Por que o ViewModel sozinho (etapas 2 e 3) não é suficiente para sobreviver à morte do
   processo, mesmo sobrevivendo à rotação de tela?**
    Resposta: ViewModel sozinho não é suficiente para sobreviver a morte do processo pois, diferente do savedStateHandle,
    ele não persiste os dados antes do processo morrer. Os dados existem apenas em memória, e quando o sistema mata, todos os dados são perdidos.
2. **Qual a diferença prática entre usar mutableStateOf e StateFlow dentro do ViewModel
     nesta aplicação? Em algum momento essa diferença foi perceptível nos testes?**
    Resposta: Não tem diferença prática
3. **Se este placar precisasse ser salvo permanentemente (mesmo após o usuário fechar o
   app e abrir dias depois), qual das quatro abordagens ainda seria insuficiente, e o que
   seria necessário adicionar?**
    Resposta: As quatro abordagens seriam insuficientes. Seria necessário armazenar os dados em disco, que independe do ciclo de vida do processo
    
4. **Na sua opinião, qual abordagem você usaria em produção para este placar e por quê?**
     Resposta: Mesmo sendo um placar simples, ele é utilizado durante uma partida inteira, 
     e nesse meio-tempo alguns imprevistos podem acontecer. O usuário que está marcando pode precisar sair rapidamente do app (atender uma ligação, checar uma notificação) e voltar depois. 
     Se o sistema decidir matar o processo nesse intervalo, sem o SavedStateHandle o placar zeraria, o que não seria nada legal no meio de uma partida real. Por isso, na minha opinião, a melhor abordagem é o SavedStateHandle.