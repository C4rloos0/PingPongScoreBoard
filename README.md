## 4. Quadro comparativo

| Abordagem                        | Rotação de tela | Morte do processo |
|-----------------------------------|-----------------|-------------------|
| remember                          | Não Sobrevive   | Não Sobrevive     |
| ViewModel + mutableStateOf        | Sobrevive       | Não Sobrevive     |
| ViewModel + StateFlow              |                 |                   |
| ViewModel + SavedStateHandle       |                 |                   |