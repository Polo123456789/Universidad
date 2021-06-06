ARCHIVOS_JS := $(wildcard *.js)
ARCHIVOS_DOCX := $(patsubst %.js, %.docx, ${ARCHIVOS_JS})

all: $(ARCHIVOS_DOCX)

$(ARCHIVOS_DOCX): %.docx: %.psc %.png
	echo # Pseudocodigo: > temp.md
	echo ~~~ >> temp.md
	cat $< >> temp.md
	echo ~~~ >> temp.md
	echo # Diagrama de flujo >> temp.md
	echo ![]($(patsubst %.psc, %.png, $<)) >> temp.md
	pandoc -t docx -o $@ temp.md
	del temp.md
