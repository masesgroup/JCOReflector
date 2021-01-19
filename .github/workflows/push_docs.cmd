@echo off

cd %1
git push https://%SUPER_SECRET%@github.com/%2.git
cd ..\..\..