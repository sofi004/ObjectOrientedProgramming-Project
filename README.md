Projeto de Grupo de PO 23-24
Comandos para correr:
javac -cp po-uilib.jar:. `find xxl -name "*.java"`
java -cp po-uilib.jar:. xxl.app.App
chmod +x runtests.sh
./runtests.sh
java -cp po-uilib.jar:. -Dimport=ex.in xxl.app.App

