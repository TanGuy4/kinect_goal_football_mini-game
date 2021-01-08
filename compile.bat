mkdir bin

javac -cp ./lib/org.OpenNI.jar;./lib/com.primesense.NITE.jar;./lib/junit-4.13.1.jar; -d bin ./src/*.java -source 8 -target 8
