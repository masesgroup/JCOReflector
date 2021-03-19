@echo off
mkdir output

scalac -toolcp "../../bin/net5.0/*" -d output ./src/main/scala/mscorlib/* ./src/main/scala/hierarchy/* ./src/main/scala/nettest/*
IF %ERRORLEVEL% NEQ 0 PAUSE