# Contador

**Aluno:** Rafael Rodrigues de Almeida
**Disciplina:** Programação Mobile — UNASP

Aplicativo Android de tela única, feito em Jetpack Compose, que funciona como um contador com botões de somar, subtrair e zerar.

## Como o estado funciona

O valor do contador é guardado em `rememberSaveable { mutableStateOf(0) }`. Quando um botão altera esse valor, o Compose percebe a mudança no estado e executa novamente (recompõe) só os composables que leem esse valor, redesenhando o número na tela automaticamente. Por isso não é preciso mandar "atualizar o texto" manualmente. Como foi usado `rememberSaveable`, o valor também é preservado quando a tela é rotacionada.

## Desafios opcionais implementados

- **D1** — O contador não fica negativo: o botão "Subtrair" é desabilitado quando o valor é 0.
- **D2** — Botão "Zerar" com estilo secundário (`TextButton`).
- **D3** — O valor é preservado na rotação de tela (`rememberSaveable`).
- **D4** — A cor do número muda conforme a faixa de valor: 0 em `onSurfaceVariant`, de 1 a 9 em `primary` e 10 ou mais em `tertiary`.

## Captura de tela

![App rodando](screenshot.png)
