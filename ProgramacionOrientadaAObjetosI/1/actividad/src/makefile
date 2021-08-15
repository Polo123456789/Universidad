CC := javac

SOURCES := $(wildcard *.java)
CLASSES := $(SOURCES:.java=.class)

all: $(CLASSES)

$(CLASSES): %.class: %.java
	$(CC) $<

.PHONY: clean
clean:
	-del $(CLASSES)
