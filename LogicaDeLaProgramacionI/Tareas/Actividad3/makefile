ARCHIVOS_MD := $(wildcard *.md)
ARCHIVOS_JS := $(patsubst %.md, %.js, $(ARCHIVOS_MD))
DIAGRAMAS := $(patsubst %.md, %.png, $(ARCHIVOS_MD))
EJERCICIOS  := $(patsubst %.md, %, $(ARCHIVOS_MD))

$(EJERCICIOS): $(ARCHIVOS_JS) $(ARCHIVOS_MD) $(DIAGRAMAS)
	mkdir dist\$@
	pandoc $@.md -t docx -o dist\$@\$@.docx
	copy  $@.js dist\$@\$@.js

.PHONY: clean
clean:
	-rmdir /s /q dist
	mkdir dist
