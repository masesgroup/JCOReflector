@echo off
mkdir output

kotlinc -cp "../../bin/net5.0/*" -d out ./src/main/kotlin/mscorlib/* ./src/main/kotlin/hierarchy/* ./src/main/kotlin/nettest/*
IF %ERRORLEVEL% NEQ 0 PAUSE