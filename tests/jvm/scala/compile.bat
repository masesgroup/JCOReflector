@echo off
mkdir output

scalac -toolcp "../../bin/net8.0/*" -d output ./src/main/scala/generics/* ./src/main/scala/hierarchy/* ./src/main/scala/mscorlib/* ./src/main/scala/nettest/* ./src/main/scala/refout/*
IF %ERRORLEVEL% NEQ 0 PAUSE