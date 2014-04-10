REM This file executes all .txt files in scripts/examples/

FOR /R "scripts/JenkinsScript" %%f IN ("*.txt") DO (
 java -Xmx512m -jar jautomate_xunit.jar localhost:1234 scripts/JenkinsScript/%%~nxf
)
