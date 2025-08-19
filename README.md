This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.


Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

**Screenshots**

<img width="240" height="480" alt="Screenshot_20250819_175733" src="https://github.com/user-attachments/assets/5bb8a711-1dca-494e-ab9f-1218497b3136" />
<img width="240" height="480" alt="Screenshot_20250819_175751" src="https://github.com/user-attachments/assets/adeca8ad-5b2b-4b13-9ae0-cdebb73ec8dc" />
<img width="240" height="480" alt="Screenshot_20250819_175759" src="https://github.com/user-attachments/assets/b49c18c3-53a2-4a79-81d0-94426664268e" />
<img width="240" height="480" alt="Screenshot_20250819_175806" src="https://github.com/user-attachments/assets/00eb5b0e-0a57-4581-b834-2f3e53d8f187" />
<img width="240" height="480" alt="Screenshot_20250819_175817" src="https://github.com/user-attachments/assets/8ed1acf3-958d-4493-bee8-22d9f8e3aa9c" />
<img width="240" height="480" alt="Screenshot_20250819_175824" src="https://github.com/user-attachments/assets/2ae23974-72f8-4059-837c-09b27779d4ff" />

