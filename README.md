# Expense & Budget Manager

A clean and distraction-free Android app to **track expenses, manage budgets, and view financial insights**.  
Designed for **quick entry and clarity**, with optional authentication for secure data syncing in the future.

---

## ✨ Features

### 🔐 Authentication

- Create Account (username, email, password)
- Login for returning users
- Future-ready: Google/Apple login, biometric unlock, email verification

### 💸 Manage Your Money Easily

- Add **income or expense** with category, date, and notes
- Edit / delete transactions
- View monthly spending and remaining budget
- Set your monthly budget and monitor usage via simple visuals

### 📊 Insights & Analytics

- Dashboard with **total spent**, **total income**, and **budget progress**
- **Category breakdown charts**
- Spending trends (by day/week/month)
- Filter / search by date, category, or amount

### ⚙️ Customization & Settings

- Light / Dark mode
- Custom categories (create / edit / remove)
- Currency support
- Export transactions (CSV, PDF)
- Optional future features: cloud backup, receipt attachments, reminders

---

## 🔄 Screens

### 🔐 Authentication

- **Splash / Launch**
- **Welcome (Sign In / Create Account)**
- **Sign Up**
- **Login**
- _(optional)_ Email verification / onboarding

### 📱 Main App (After Login)

- **Dashboard / Home**
- **Add Transaction**
- **Transaction History**
- **Analytics / Insights**
- **Budget Settings**
- **Categories Management**
- **Settings**

---

## 🧭 Navigation Flow

```

Splash →
If logged in → Dashboard
Else → Welcome
├─ Sign Up → Dashboard
└─ Login → Dashboard

Inside App (Bottom Navigation / Drawer):
Dashboard
├── Add Transaction
├── History
├── Analytics
├── Budget
├── Categories
└── Settings

```

---

## 🏗️ Architecture

- **Jetpack Compose UI**
- **MVVM (ViewModel + Repository + Use Cases)**
- **Room Database** for offline-first data
- **Kotlin Coroutines + Flow / StateFlow** for reactive UI
- **Jetpack Navigation** for screens
- Modular and scalable for cloud sync later

---

## 🗄 Data Models (Core)

- `User`: id, username, email, auth token (future)
- `Category`: id, name, icon, color
- `Transaction`: id, type (income/expense), amount, categoryId, date, note
- `Budget`: id, month, limit, spent

---

## 🚀 Roadmap

### v1.0 (MVP)

- Auth (Sign up / Login)
- Add/Manage expenses
- Dashboard overview
- Transaction history
- Budget setup
- Basic settings

### v1.1

- Custom categories
- Filters & search
- Basic analytics

### v1.2

- Recurring expenses
- Export / backup (CSV/PDF)

### v2.0

- Cloud sync
- Biometrics
- Notifications / reminders
- Widget support
- Receipt attachments

### v2.x

- Advanced analytics
- Smart budget recommendations
- Household or shared budgeting

---

## 🚧 Tech Stack

- **Kotlin**
- **Jetpack Compose**
- **Room**
- **Coroutines / Flow**
- **Navigation Component**
- _(Future)_ Firebase / Cloud backend

---

## 🤝 Contributing

Contributions, ideas, and suggestions are welcome.
Open an issue or submit a pull request.

---

## 📄 License

MIT / Apache 2.0 (choose one based on your preference)

---

# File Tree: Expense Budget Manager

**Generated:** 11/30/2025, 5:17:36 PM
**Root Path:** `e:\Full-Stack Mobile App Development\Android Apps\Expense Budget Manager`

```
├── 📁 .kotlin
│   └── 📁 sessions
├── 📁 app
│   ├── 📁 src
│   │   ├── 📁 androidTest
│   │   │   └── 📁 java
│   │   │       └── 📁 com
│   │   │           └── 📁 example
│   │   │               └── 📁 expensebudgetmanager
│   │   │                   └── ☕ ExampleInstrumentedTest.kt
│   │   ├── 📁 main
│   │   │   ├── 📁 java
│   │   │   │   └── 📁 com
│   │   │   │       └── 📁 example
│   │   │   │           └── 📁 expensebudgetmanager
│   │   │   │               ├── 📁 data
│   │   │   │               │   ├── 📁 datastore
│   │   │   │               │   ├── 📁 local
│   │   │   │               │   └── 📁 repository
│   │   │   │               ├── 📁 di
│   │   │   │               ├── 📁 domain
│   │   │   │               │   ├── 📁 model
│   │   │   │               │   └── 📁 usecase
│   │   │   │               ├── 📁 navigation
│   │   │   │               │   └── ☕ AppNavGraph.kt
│   │   │   │               ├── 📁 ui
│   │   │   │               │   ├── 📁 components
│   │   │   │               │   ├── 📁 screens
│   │   │   │               │   │   ├── ☕ DashboardScreen.kt
│   │   │   │               │   │   ├── ☕ LoginScreen.kt
│   │   │   │               │   │   ├── ☕ SignUpScreen.kt
│   │   │   │               │   │   ├── ☕ SplashScreen.kt
│   │   │   │               │   │   └── ☕ WelcomeScreen.kt
│   │   │   │               │   └── 📁 theme
│   │   │   │               └── ☕ MainActivity.kt
│   │   │   ├── 📁 res
│   │   │   │   ├── 📁 drawable
│   │   │   │   │   ├── ⚙️ ic_launcher_background.xml
│   │   │   │   │   └── ⚙️ ic_launcher_foreground.xml
│   │   │   │   ├── 📁 layout
│   │   │   │   │   └── ⚙️ activity_main.xml
│   │   │   │   ├── 📁 mipmap-anydpi-v26
│   │   │   │   │   ├── ⚙️ ic_launcher.xml
│   │   │   │   │   └── ⚙️ ic_launcher_round.xml
│   │   │   │   ├── 📁 mipmap-hdpi
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   ├── 📁 mipmap-mdpi
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   ├── 📁 mipmap-xhdpi
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   ├── 📁 mipmap-xxhdpi
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   ├── 📁 mipmap-xxxhdpi
│   │   │   │   │   ├── 🖼️ ic_launcher.webp
│   │   │   │   │   └── 🖼️ ic_launcher_round.webp
│   │   │   │   ├── 📁 values
│   │   │   │   │   ├── ⚙️ colors.xml
│   │   │   │   │   ├── ⚙️ strings.xml
│   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   ├── 📁 values-night
│   │   │   │   │   └── ⚙️ themes.xml
│   │   │   │   └── 📁 xml
│   │   │   │       ├── ⚙️ backup_rules.xml
│   │   │   │       └── ⚙️ data_extraction_rules.xml
│   │   │   └── ⚙️ AndroidManifest.xml
│   │   └── 📁 test
│   │       └── 📁 java
│   │           └── 📁 com
│   │               └── 📁 example
│   │                   └── 📁 expensebudgetmanager
│   │                       └── ☕ ExampleUnitTest.kt
│   ├── ⚙️ .gitignore
│   └── 📄 proguard-rules.pro
├── 📁 gradle
│   ├── 📁 wrapper
│   │   ├── 📄 gradle-wrapper.jar
│   │   └── 📄 gradle-wrapper.properties
│   └── ⚙️ libs.versions.toml
├── ⚙️ .gitignore
├── 📝 README.md
├── 📄 gradle.properties
├── 📄 gradlew
├── 📄 gradlew.bat
└── 📄 settings.gradle.kts
```

---

_Generated by FileTree Pro Extension_

## 📬 Contact

If you want help or improvements, reach out or create an issue.
