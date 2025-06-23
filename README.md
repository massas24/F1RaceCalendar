# 🏁 F1RaceCalendar

Uma aplicação Android em Jetpack Compose que apresenta o calendário oficial de corridas de Fórmula 1 de 2025. Permite ao utilizador consultar detalhes das corridas, adicionar eventos ao calendário do dispositivo e abrir o circuito no mapa.

Funcionalidades

- Lista de todas as corridas da temporada de 2025.
- Visualização de detalhes: nome, data, hora, país e localização.
- Botão para adicionar a corrida ao calendário.
- Botão para abrir o mapa com o circuito.
- Suporte para modo escuro, com preferência guardada (via DataStore).

Tecnologias Utilizadas

- Kotlin
- Jetpack Compose
- Navigation Compose
- Material 3
- DataStore Preferences
- CalendarContract API
- Intent API (para mapa e calendário)

Instalação e Execução

1. Clona o repositório:
   ```bash
   git clone https://github.com/seu-usuario/F1RaceCalendar.git
2. Abre o projeto no Android Studio.

3. Certifica-te que tens o SDK mínimo configurado:
  Min SDK: 26
  Target SDK: 34

4. Executa o projeto num emulador ou dispositivo físico.

Estrutura Do Projeto
F1RaceCalendar/
├── data/
│   ├── modelo/           # Modelo de dados da Corrida
│   ├── preferencias/     # Gestão do modo escuro com DataStore
│   └── repositorio/      # Lista das corridas (mock)
├── ui/
│   ├── componentes/      # Cartão de corrida reutilizável
│   ├── ecras/            # Ecrãs principais: Home, Detalhes
│   └── theme/            # Definições visuais (Material3)
├── MainActivity.kt       # Navegação e setup do tema
└── README.md             # Este ficheiro

Notas
Todas as corridas são carregadas localmente (mock).

O URL do mapa é aberto no navegador ou Google Maps, se disponível.

O modo escuro é armazenado de forma persistente com DataStore.
