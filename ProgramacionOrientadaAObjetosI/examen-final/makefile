CC := javac

SOURCES := $(wildcard *.java)
CLASSES := $(SOURCES:.java=.class)

all: $(CLASSES)

$(CLASSES): %.class: %.java
	$(CC) $<

.PHONY: run
run: $(CLASSES)
	java Main

.PHONY: clean
clean:
	-del *.class
