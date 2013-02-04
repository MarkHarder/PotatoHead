JAVAC = javac
sources = $(wildcard src/main/markharder/potatohead/*.java)
classes = $(sources:.java=.class)

default: run

run: all
	java -cp src/main markharder/potatohead/PotatoHead

all: $(classes)

clean:
	$(RM) *.class

%.class: %.java
	$(JAVAC) $<
