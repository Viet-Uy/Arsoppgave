@echo off

TITLE Ignore

echo downloading game. This will close automatically after downloading all files
echo(

javac -d classes *.java

if not exist "C:\Epic_Game" mkdir C:\Epic_Game
if exist "C:\Epic_Game\classes" rmdir /s /q C:\Epic_Game\classes
xcopy classes C:\Epic_Game\classes /E/C/I

if exist "C:\Epic_Game\lib" rmdir /s /q C:\Epic_Game\lib
xcopy lib C:\Epic_Game\lib /I

del C:\Epic_Game\run.bat
xcopy run.bat C:\Epic_Game
del %USERPROFILE%\Desktop\Epic_Game.lnk
xcopy Epic_Game.lnk %USERPROFILE%\Desktop