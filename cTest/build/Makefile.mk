OUT_DIR = output
OUT_DIR_BIN = output/bin
SOURCE_DIR = src
$(shell mkdir -p $(OUT_DIR))
$(shell mkdir -p $(OUT_DIR_BIN))

test:main.o add.o java
	gcc $(OUT_DIR_BIN)/main.o $(OUT_DIR_BIN)/add.o -o $(OUT_DIR)/test.apk

main.o:
	gcc -c $(SOURCE_DIR)/main.c -o $(OUT_DIR_BIN)/main.o

add.o:
	gcc -c $(SOURCE_DIR)/add.c -o $(OUT_DIR_BIN)/add.o

java:
	javac $(SOURCE_DIR)/Test.java -d $(OUT_DIR_BIN)
clean:
	rm -rf output/
	echo "Entire output dir is removed!"

