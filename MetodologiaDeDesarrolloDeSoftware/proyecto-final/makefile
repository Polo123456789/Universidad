OUT := proyecto-final-21001135.pdf
DIAGRAMAS := $(wildcard diagramas/*.jpg)

$(OUT): pf.md template.latex diagramas/diagramas.drawio $(DIAGRAMAS)
	pandoc $< -o $@\
		--top-level-division=chapter\
		--template=template.latex

.PHONY: clean
clean:
	del $(OUT)
