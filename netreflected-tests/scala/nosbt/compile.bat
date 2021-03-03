@echo off
mkdir output

scalac -toolcp "../../../bin/net5.0/*" -d output ./mscorlib/*
IF %ERRORLEVEL% NEQ 0 PAUSE