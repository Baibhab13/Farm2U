# 🤝 Contributing to Farm2U

Welcome to *Farm2U, an open-source Android app that connects **farmers directly with consumers* to ensure fair pricing, transparency, and fresh product delivery.  
We’re so glad you’re here! This guide will help you contribute effectively and make a real impact on sustainable agriculture 🌱.

---

## 📑 Table of Contents

- [Getting Started](#-getting-started)
- [How to Contribute](#-how-to-contribute)
- [Coding Guidelines](#-coding-guidelines)
- [Testing](#-testing)
- [Code Review Process](#-code-review-process)
- [Documentation](#-documentation)
- [Reporting Bugs & Requesting Features](#-reporting-bugs--requesting-features)
- [Good First Issues](#-good-first-issues)
- [Code of Conduct](#-code-of-conduct)
- [Need Help?](#-need-help)
- [Recognition](#-recognition)

---

## 🌟 Getting Started

### Prerequisites

Before contributing, ensure you have:
- Git  
- Android Studio 
- Java JDK 11+  
- Kotlin plugin (latest version)  
- Firebase account  

### Tech Stack

- *Language:* Kotlin  
- *Local Database:* RoomDB  
- *Backend & Auth:* Firebase (Authentication & Firestore)  
- *Networking:* Retrofit  
- *Image Loading:* Coil  
- *Architecture:* MVVM (Model–View–ViewModel)


---

## 🧑‍💻 Development Setup

1. *Clone Your Fork*
   ```bash
   git clone https://github.com/YOUR_USERNAME/Farm2U.git
   cd Farm2U
   ```
2. *Open in Android Studio*
   - Open Android Studio .  
   - Click *File → Open → Select the Farm2U folder*.  
   - Let Gradle sync automatically (this might take a few minutes).  
   - Ensure that all dependencies are downloaded successfully.  

3. *Set Up Firebase*
   - Go to [Firebase Console](https://console.firebase.google.com/) and create a new project.  
   - Add an Android app with your package name.  
   - Download google-services.json and place it in the app/ directory.  
   - Enable *Authentication* and *Cloud Firestore* from Firebase Console.  

4. *Run Locally*
   - Connect a  device or start an emulator.  
   - Click *Run ▶* in Android Studio.  
   - The app should launch successfully on your device.

---

## 🔄 How to Contribute

1. *Pick an Issue*  
   - Browse open issues in the Farm2U repo.  
   - Comment on the issue you'd like to work on and wait for the issue to get assigned to you.

2. *Create a New Branch*
   ```bash
   git checkout main
   git pull origin main
   git checkout -b feature/your-feature-name

3. *Make Changes*  
   - Implement your feature or fix.  
   - Test it thoroughly.

4. *Commit Your Work*
   ```bash
   git add .
   git commit -m "feat: add farmer product filtering"

5. *Push the Branch*
   ```bash
   git push origin feature/your-feature-name

6. *Open a Pull Request (PR)*
   - Go to your fork on GitHub.  
   - Click *Compare & pull request*.  
   - Add a descriptive title and details of your contribution.

---

## 📝 Coding Guidelines

To keep Farm2U’s code clean, readable, and maintainable, please follow these general guidelines:

- *Write Clear and Readable Code*  
  - Use *meaningful names* for variables, functions, and classes.  
  - Keep functions *short and focused*.  
  - Add comments for *complex or non-obvious logic*.

- *Follow Kotlin Best Practices*  
  - Prefer **immutable variables (val)** over mutable (var) when possible.  
  - Use *extension functions* and helper methods to avoid repeating code.  
  - Avoid long chains of nested logic; break them into smaller parts.

- *UI & Layout*  
  - Avoid hard-coded strings, colors, or dimensions; use *resources* instead.  
  - Design layouts to work on *different screen sizes*.  
  - Keep UI logic separate from data and business logic.

- *Data & Networking*  
  - Handle *network responses and errors* safely; the app should not crash.  
  - Store data locally only when necessary, and avoid storing sensitive information in plain text.  

- *Security & Privacy*  
  - Never expose API keys or sensitive information in the code.  
  - Handle user data responsibly and ensure privacy is protected.

- *Testing & Debugging*  
  - Test your changes on multiple devices.  
  - Ensure features work as intended and fix any crashes or warnings.  
  - Double-check Firebase or network operations if used.

- *Version Control & Commits*  
  - Create a *separate branch* for each feature or bug fix.  
  - Write *descriptive commit messages* explaining your changes.  
  - Push only tested and working code to your branch.

> By following these simple guidelines, we can keep Farm2U easy to maintain, secure, and welcoming for all contributors, beginners and experts alike.

## 🧪 Testing

Before submitting a PR:
- Ensure the app builds successfully.  
- Verify Firebase read/write operations.  
- Check UI responsiveness across screen sizes.  

---

## 🔍 Code Review Process

All pull requests undergo review by maintainers. Feedback may include:
- Code readability and performance.  
- Security and Firebase rules compliance.  
- Consistency with architecture patterns.  

> Push fixes to the same branch — no need to open a new PR.

---

## 📖 Documentation

- Update README.md if your feature adds new functionality.  
- Add inline comments for complex code blocks.  
- Include screenshots or screen recordings (if UI-related).  

---

## 💡 Reporting Bugs & Requesting Features

Use *GitHub Issues*:
- For bugs → label: bug  
- For feature requests → label: enhancement  

Describe the issue clearly with steps.

---

## 🚀 Good First Issues

If you’re new, start with issues labeled **good first issue**.  
They include:
- UI polish tasks  
- Minor code refactors  
- Documentation improvements  

---

## 📜 Code of Conduct

All contributors must follow the [Code of Conduct](CODE_OF_CONDUCT.md) to ensure a respectful and inclusive environment for everyone involved in the Farm2U community.

---

## ❓ Need Help?

If you get stuck:
- Check existing docs and issues.  
- Ask in the GitHub Discussions tab (if available).  
- Or open a “question” issue clearly describing your problem.

---

## 🌾 Recognition

We deeply appreciate every contribution! Contributors will receive:
* *Leaderboard Recognition*: Your name and contributions will be displayed on the project leaderboard.
* *Contributors List*: Added to the official  contributors list.
* *Community Shout-outs*: Highlighted in  community channels for outstanding contributions.


---

Thank you for contributing to *Farm2U* — together, we’re empowering farmers, ensuring fairness, and bringing products straight from the field to every home.
