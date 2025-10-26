# 🐱 ConsumerCatFactSuaMatricula

Aplicativo Android desenvolvido em **Kotlin** que consome a API pública [CatFact](https://catfact.ninja/fact) e exibe um **fato aleatório sobre gatos** 🐈.

---

## 🎯 Objetivo

Este projeto foi desenvolvido como parte de uma atividade prática de consumo de API REST no Android.  
O aplicativo faz uma requisição HTTP à rota:

~~~
https://catfact.ninja/fact
~~~


e exibe o campo `fact`, que contém uma curiosidade aleatória sobre felinos.

Exemplo de resposta da API:

```json
{
  "fact": "Os gatos são os animais de estimação mais populares do mundo, superando os cães em até três para um.",
  "length": 98
}

