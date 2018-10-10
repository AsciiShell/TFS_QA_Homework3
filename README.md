# TFS_QA_Homework3

DataSetGenerator class создает excel файл со случайными данными пользователей

Испльзована JDK 10.0.2

- Код для компиляции:

`
"C:\Program Files\Java\jdk-10.0.2\bin\java.exe" -Dmaven.multiModuleProjectDirectory=D:\Projects\TFS_QA_Homework3 "-Dmaven.home=C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\plugins\maven\lib\maven3" "-Dclassworlds.conf=C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\plugins\maven\lib\maven3\bin\m2.conf" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\lib\idea_rt.jar=20393:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\plugins\maven\lib\maven3\boot\plexus-classworlds-2.5.2.jar" org.codehaus.classworlds.Launcher -Didea.version=2018.2.4 compile
`

- Код для запуска:

`
"C:\Program Files\Java\jdk-10.0.2\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\lib\idea_rt.jar=20634:C:\Program Files\JetBrains\IntelliJ IDEA 2018.2.2\bin" -Dfile.encoding=UTF-8 -classpath D:\Projects\TFS_QA_Homework3\target\classes;C:\Users\alex1\.m2\repository\org\apache\poi\poi-ooxml\3.12\poi-ooxml-3.12.jar;C:\Users\alex1\.m2\repository\org\apache\poi\poi\3.12\poi-3.12.jar;C:\Users\alex1\.m2\repository\commons-codec\commons-codec\1.9\commons-codec-1.9.jar;C:\Users\alex1\.m2\repository\org\apache\poi\poi-ooxml-schemas\3.12\poi-ooxml-schemas-3.12.jar;C:\Users\alex1\.m2\repository\org\apache\xmlbeans\xmlbeans\2.6.0\xmlbeans-2.6.0.jar;C:\Users\alex1\.m2\repository\stax\stax-api\1.0.1\stax-api-1.0.1.jar DataSetGenerator
`