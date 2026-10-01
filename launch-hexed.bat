@echo off
REM Hexed launcher for Windows
REM Opens the local Hexed client page from this folder.

cd /d "%~dp0"
start "" "index.html"
exit /b 0
