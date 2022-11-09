@ECHO OFF

rem curl https://moodle.pucrs.br/mod/folder/view.php?id=2410676 -o textoscifrados.zip

SET "root=%~dp0"
SET "binPath=%root%bin"
if NOT exist "%binPath%" MKDIR "%binPath%"

javac src\*.java -d "%binPath%" -Xlint:unchecked -Xdiags:verbose 

if ["%ERRORLEVEL%"]==["0"] (
	java -cp "%binPath%" Main
)
