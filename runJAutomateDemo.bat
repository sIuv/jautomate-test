FOR /R "scripts/examples" %%f IN ("*.txt") DO (
 jre\bin\java.exe -Xmx512m -jar JAutomate.jar scripts\examples\%%~nxf 
)