@echo off
color 0a
echo ================================
echo   SAVED WIFI PASSWORD VIEWER
echo ================================
echo.

netsh wlan show profiles

echo.
set /p wifi=Enter WiFi Name exactly as shown above: 

echo.
netsh wlan show profile name="%wifi%" key=clear

echo.
pause