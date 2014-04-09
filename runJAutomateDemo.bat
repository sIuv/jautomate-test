FOR /R "scripts/" %%f IN ("*.txt") DO (
 jre\bin\java.exe -Xmx512m -jar jautomate_xunit.jar localhost:1234 scripts/%~nxf
)