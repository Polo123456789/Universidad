PSEUDOCODIGOS := $(wildcard *.psc)
ARCHIVOS_JS := $(patsubst %.psc, %.js, $(PSEUDOCODIGOS))
DIAGRAMAS := $(patsubst %.psc, %.png, $(PSEUDOCODIGOS))
EJERCICIOS  := $(patsubst %.psc, %, $(PSEUDOCODIGOS))

$(EJERCICIOS): $(ARCHIVOS_JS) $(PSEUDOCODIGOS) $(DIAGRAMAS)
	mkdir dist\$@
	echo # Pseudocodigo >> $@.md
	echo ~~~ >> $@.md
	type $@.psc >> $@.md
	echo ~~~ >> $@.md
	echo # Diagrama de flujo >> $@.md
	echo ![]($@.png) >> $@.md
	pandoc $@.md -t docx -o dist\$@\$@.docx
	copy  $@.js dist\$@\$@.js

.PHONY: clean
clean:
	-rmdir /s /q dist
	-del *.md
	mkdir dist
