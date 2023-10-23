# Selenium Intensiv-Training
##Anleitung:
 1. Browser aus dem Internet installieren, falls nicht schon auf dem PC vorhanden (Chrome, Firefox und Edge)
 2. Maven Settings anpassen
    1. Gehe im IntelliJ auf File
    2. Settings
    3. Gib im Suchfeld "Maven" ein und klick links auf den Eintrag "Maven"
    4. Maven-Home sollte "Bundled (Maven 3)" sein (Ausser du hast eine Installation von Maven, welche du Fix verwendest)
    5. Bitte bei "User settings file" auf dieses "Projekt/maven/settings.xml" referenzieren
    6. Bitte bei "Local repository file" auf dieses "Projekt/maven/repo" referenzieren
    7. Auf "Apply" drücken
 3. Java im Projekt einrichten
    1. Gehe im IntelliJ auf File
    2. Project Structure...
    3. Auf der Linken Seite Project auswählen 
    4. Rechts bei "Project SDK" im Dropdown auf "Add SDK" gehen und dann auf "JDK"
    5. Wähle innerhalb des Projektes den Folder "java\openjdk-1.8.0_windows-x64_bin"
    6. Klick auf Ok 
    7. Apply
 4. Maven clean compile test ausführen
 5. Alle Tests sollten erfolgreich sein (Manchmal wird der Firefox beim erstenmal Rot, dann 5.1)
    1. Falls nicht, bitte in die Klasse Allgemein gehen und alle Tests starten (TestNG-Tests)
 6. **Bitte eine Email an "info@selenium-consulting.ch" senden mit:**
    1. **Der Bestätigung, dass bei Dir alles funktioniert**
    2. **oder**
    3. **Einer Nachricht, dass es bei dir nicht geht inkl. Fehlermeldung und Screenshot**