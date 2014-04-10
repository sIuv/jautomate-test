REM This file executes all .txt files in scripts/examples/

FOR /R "scripts/" %%f IN ("*.txt") DO (
 java -Xmx512m -jar jautomate_xunit.jar localhost:1234 scripts/%%~nxf
)
