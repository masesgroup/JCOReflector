@echo off

git config user.name "%1"
git config user.email "%2"
git add --all
git commit -m %3

exit /b 0