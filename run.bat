@echo off

TITLE Ignore. This is for reading error messages, and will close automatically after you closed the game

echo this is for reading error messages, and will close automatically after you closed the game
echo(

cd C:\Epic_Game
java -cp lib\mysql-connector-j-8.0.31.jar;classes Game

exit