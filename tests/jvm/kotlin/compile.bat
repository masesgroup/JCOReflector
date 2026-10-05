@echo off
mkdir output

kotlinc -cp "../../bin/net8.0/*" -d out ./src/main/kotlin/generics/* ./src/main/kotlin/hierarchy/* ./src/main/kotlin/mscorlib/*  ./src/main/kotlin/nettest/* ./src/main/kotlin/refout/*
IF %ERRORLEVEL% NEQ 0 PAUSE