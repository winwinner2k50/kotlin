# kotlin
## установка на wsl
```bash
sudo apt --fix-broken install
sudo apt-get install zip
sudo curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```
## компиляция
``` 
kotlinc q.kt -include-runtime -d q.jar
java -jar q.jar
```
