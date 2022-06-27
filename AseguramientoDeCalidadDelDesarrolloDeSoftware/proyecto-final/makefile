OUT := 21001135-acs-proyecto-final.docx
DIAGRAMAS := $(wildcard diagramas/*)
GIT_ROOT := $(shell git rev-parse --show-toplevel)

default: $(OUT)

$(OUT): plan-de-pruebas.md template.latex $(DIAGRAMAS)
	pandoc -o $@ $<\
		--template=template.latex\
		--top-level-division=chapter

.PHONY: git-root-test
git-root-test:
	echo Git root is: $(GIT_ROOT)

.PHONY: clean
clean:
	@-del $(OUT)
