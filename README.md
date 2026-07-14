# VisionFit - Sistema de Navegação para Pessoas com Deficiência Visual

VisionFit é um aplicativo completo desenvolvido em **Kotlin** que oferece navegação acessível dentro de academias utilizando **Wear OS** em smartwatches e **Android** em smartphones. O sistema utiliza sensores, voz e vibração para guiar usuários com deficiência visual.

## 🎯 Objetivo

Criar um sistema de navegação para pessoas com deficiência visual dentro de academias utilizando:
- Smartwatch com Wear OS
- Smartphone Android
- Inteligência Artificial
- Acessibilidade avançada

## 📱 Tecnologias Utilizadas

### Linguagem & Framework
- **Kotlin** - Linguagem principal
- **Android Studio** - IDE de desenvolvimento
- **Jetpack Compose** - UI moderna e reativa

### Plataformas
- **Android** (minSdk: 26, targetSdk: 34)
- **Wear OS** - Para smartwatches

### Arquitetura & Design
- **MVVM** - Model-View-ViewModel
- **Clean Architecture** - Separação de responsabilidades
- **Material Design 3** - Design system

### Banco de Dados & Cloud
- **Room Database** - SQLite local
- **Firebase Authentication** - Autenticação
- **Firebase Firestore** - Sincronização em nuvem

### APIs & Serviços
- **Google Maps Indoor** - Mapas internos
- **Google Play Services** - Localização e mapas
- **Google ML Kit** - Visão computacional

### Inteligência Artificial
- **TensorFlow Lite** - Modelos de IA locais
- **Google ML Kit** - OCR e visão

### Hardware & Sensores
- **Acelerômetro** - Detectar movimento
- **Giroscópio** - Detectar rotação
- **Bússola** - Orientação
- **Bluetooth** - Comunicação relógio-celular

### Bibliotecas Adicionais
- **Hilt** - Injeção de dependências
- **Coroutines** - Programação assíncrona
- **Timber** - Logging
- **Retrofit & OkHttp** - HTTP Client
- **Gson** - Serialização JSON

## 🏗️ Estrutura do Projeto

```
VisionFit/
├── app/                              # Módulo principal (Android)
│   ├── src/main/java/com/visionfit/app/
│   │   ├── data/                    # Camada de dados
│   │   │   ├── local/               # Banco de dados local
│   │   │   │   ├── dao/             # Data Access Objects
│   │   │   │   ├── entity/          # Entidades Room
│   │   │   │   ├── converter/       # Type Converters
│   │   │   │   └── database/        # Configuração Room
│   │   │   ├── remote/              # Firebase
│   │   │   └── repository/          # Repositórios
│   │   ├── domain/                  # Lógica de negócio
│   │   │   ├── model/               # Modelos de domínio
│   │   │   ├── repository/          # Interfaces de repositório
│   │   │   └── usecase/             # Casos de uso
│   │   ├── presentation/            # Camada de apresentação
│   │   │   ├── ui/                  # Telas em Compose
│   │   │   │   ├── screens/         # Composables das telas
│   │   │   │   └── components/      # Componentes reutilizáveis
│   │   │   ├── viewmodel/           # ViewModels
│   │   │   ├── navigation/          # Navegação
│   │   │   ├── theme/               # Tema Material 3
│   │   │   └── state/               # Estados UI
│   │   ├── services/                # Serviços
│   │   │   ├── LocationService.kt
│   │   │   ├── SensorService.kt
│   │   │   ├── BluetoothService.kt
│   │   │   └── NavigationService.kt
│   │   ├── utils/                   # Utilitários
│   │   ├── di/                      # Injeção de dependências (Hilt)
│   │   ├── MainActivity.kt
│   │   └── VisionFitApplication.kt
│   ├── src/main/res/
│   │   ├── values/strings.xml       # Strings
│   │   └── drawable/                # Drawables
│   ├── build.gradle.kts
│   └── AndroidManifest.xml
├── wear/                            # Módulo Wear OS (em desenvolvimento)
├── build.gradle.kts                 # Build raiz
├── settings.gradle.kts              # Configuração de módulos
└── README.md
```

## ✨ Funcionalidades

### ✅ Implementadas na Sprint 1
1. **Estrutura do Projeto** - Configuração completa do Android Studio
2. **Banco de Dados** - Room com todas as entidades
3. **Tema e Design** - Material Design 3 com cores e tipografia acessível
4. **Injeção de Dependências** - Hilt configurado

### 📋 Próximas Funcionalidades
4. Login e cadastro (Firebase Auth)
5. Cadastro da academia
6. Cadastro dos equipamentos
7. Mapa interno da academia
8. Seleção de equipamento por voz
9. Cálculo de rota
10. Navegação por voz e vibração
11. Detecção de obstáculos
12. Botão SOS
13. Histórico de treinos
14. Perfil do usuário
15. Configurações de acessibilidade
16. Modo administrador

## 🎨 Design & Acessibilidade

### Cores
- **Azul Escuro** (#1E3A8A) - Cor primária
- **Azul Claro** (#3B82F6) - Cor secundária
- **Branco** (#FFFFFF) - Fundo

### Acessibilidade
- ✅ Fontes **maiores** que o padrão (14-32sp)
- ✅ Botões **grandes** (mínimo 48x48 dp)
- ✅ Compatibilidade com **leitores de tela**
- ✅ Alto contraste entre cores
- ✅ Navegação por **voz**
- ✅ Feedback háptico (**vibração**)
- ✅ Descrições semânticas em todos os componentes

## 🚀 Como Executar o Projeto

### Pré-requisitos
- Android Studio Flamingo ou superior
- JDK 17
- SDK Android 34
- Gradle 8.x
- Git

### Passos

1. **Clonar o repositório**
```bash
git clone https://github.com/geovannajesus-lang/VisionFit.git
cd VisionFit
```

2. **Abrir no Android Studio**
   - Abra o Android Studio
   - Clique em "Open"
   - Selecione a pasta VisionFit
   - Deixe sincronizar o Gradle

3. **Conectar um dispositivo ou emulador**
   - Conecte um smartphone Android (API 26+) via USB
   - Ou inicie um emulador Android

4. **Executar a aplicação**
```bash
./gradlew installDebug
```

Ou clique no botão "Run" no Android Studio (Shift + F10)

5. **Acessar a aplicação**
   - Vá para Settings > Accessibility > VisionFit
   - Ative as funcionalidades de acessibilidade desejadas
   - Inicie o aplicativo

## 📚 Documentação de Arquivos

### data/local/database/
- **VisionFitDatabase.kt** - Configuração principal do Room Database

### data/local/entity/
- **UserEntity.kt** - Entidade de usuário
- **GymEntity.kt** - Entidade de academia
- **EquipmentEntity.kt** - Entidade de equipamento
- **TrainingEntity.kt** - Entidade de treino
- **RouteEntity.kt** - Entidade de rota
- **MapEntity.kt** - Entidade de mapa
- **ObstacleEntity.kt** - Entidade de obstáculo

### data/local/dao/
- **UserDao.kt** - Operações com usuários
- **GymDao.kt** - Operações com academias
- **EquipmentDao.kt** - Operações com equipamentos
- **TrainingDao.kt** - Operações com treinos
- **RouteDao.kt** - Operações com rotas
- **MapDao.kt** - Operações com mapas
- **ObstacleDao.kt** - Operações com obstáculos

### di/
- **DatabaseModule.kt** - Injeção do banco de dados
- **FirebaseModule.kt** - Injeção do Firebase

### presentation/theme/
- **Color.kt** - Definição de cores
- **Type.kt** - Tipografia acessível
- **Theme.kt** - Tema Material 3

### presentation/navigation/
- **Screen.kt** - Definição de rotas
- **RootNavigation.kt** - Navegação raiz

### presentation/ui/screens/
- **SplashScreen.kt** - Tela inicial

## 🔐 Permissões Necessárias

```xml
<!-- Localização -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />

<!-- Bluetooth -->
<uses-permission android:name="android.permission.BLUETOOTH" />
<uses-permission android:name="android.permission.BLUETOOTH_ADMIN" />
<uses-permission android:name="android.permission.BLUETOOTH_SCAN" />
<uses-permission android:name="android.permission.BLUETOOTH_CONNECT" />

<!-- Áudio -->
<uses-permission android:name="android.permission.RECORD_AUDIO" />

<!-- Câmera -->
<uses-permission android:name="android.permission.CAMERA" />

<!-- Outros -->
<uses-permission android:name="android.permission.VIBRATE" />
<uses-permission android:name="android.permission.INTERNET" />
```

## 📦 Publicar na Play Store

### 1. Preparar o aplicativo

```bash
# Build de release
./gradlew bundleRelease
```

### 2. Criar conta de desenvolvedor
- Acesse https://play.google.com/console
- Pague a taxa de inscrição ($25)
- Crie um novo aplicativo

### 3. Preencher informações
- Nome do aplicativo
- Descrição breve
- Descrição completa
- Screenshots
- Ícone do aplicativo (512x512)
- Banner de recurso (1024x500)

### 4. Configurar classificação
- Responda o questionário de classificação
- Escolha categoria (Health & Fitness)

### 5. Upload do build
- Vá para "Release > Production"
- Upload do arquivo AAB gerado em `app/build/outputs/bundle/release/`

### 6. Revisar e publicar
- Complete todos os itens obrigatórios
- Clique em "Publish"
- Aguarde aprovação (24-48 horas)

## 🤝 Contribuindo

Este é um projeto acadêmico/comercial. Para contribuir:

1. Fork o projeto
2. Crie uma branch (`git checkout -b feature/feature-name`)
3. Commit suas mudanças (`git commit -am 'Add feature'`)
4. Push para a branch (`git push origin feature/feature-name`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Equipe

**Desenvolvido por:** Geovanna Jesus Lang  
**Especialização:** Android, Wear OS, Kotlin, Jetpack Compose, IA e Acessibilidade

## 📞 Suporte

Para suporte, abra uma issue no repositório ou entre em contato através do email.

## 🎓 Aprendizados

Este projeto implementa:
- ✅ Arquitetura limpa (Clean Architecture)
- ✅ Padrão MVVM
- ✅ Injeção de dependências (Hilt)
- ✅ Room Database com relacionamentos
- ✅ Firebase Integration
- ✅ Jetpack Compose
- ✅ Acessibilidade completa
- ✅ Wear OS Development
- ✅ Sensores do smartphone
- ✅ Comunicação Bluetooth

---

**Versão:** 1.0.0  
**Status:** Em desenvolvimento  
**Última atualização:** Julho de 2026