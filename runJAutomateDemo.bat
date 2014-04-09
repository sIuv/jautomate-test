FOR /R "scripts/" %%f IN ("*.txt") DO (
 jre\bin\java.exe -Xmx512m -jar JAutomate.jar scripts\%%~nxf 
)