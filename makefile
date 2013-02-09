JAVAC = javac
sources = $(wildcard src/main/markharder/potatohead/*.java)
classes = $(sources:.java=.class)

default: run

run: all
	java -cp bin markharder/potatohead/PotatoHead

all: $(classes)

clean:
	$(RM) src/main/markharder/potatohead/*.class

%.class: %.java
	$(JAVAC) -d bin/ -cp src/main $<

jar: all
	jar cfm PotatoHead.jar MANIFEST.MF -C bin . res; java -jar PotatoHead.jar
