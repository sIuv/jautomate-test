REM This file executes all .txt files in scripts/examples/

FOR /R "scripts/examples/" %%f IN ("*.txt") DO (
 java -Xmx512m -jar jautomate_xunit.jar localhost:1234 scripts/examples/%%~nxf
)
