CC := javac

SOURCES := $(wildcard src/*.java)
CLASSES := $(SOURCES:.java=.class)

DOC_FILES := $(wildcard docs/*)

all: $(CLASSES) doc

$(CLASSES): %.class: %.java
	$(CC) $<

.PHONY: run
run: $(CLASSES)
	@cls
	@-java -cp src Main

.PHONY: doc
doc: actividad1.docx

actividad1.docx: $(DOC_FILES)
	@echo Intentando crear $@ (Requiere pandoc https://pandoc.org/)
	-pandoc docs/actividad1.md -o $@

.PHONY: clean
clean:
	@-del src\*.class actividad1.docx actividad1.pdf

.PHONY: package
package: actividad1-21001135.tar.gz

actividad1-21001135.tar.gz:
	git ls-files | tar -czvf $@ --files-from=-
