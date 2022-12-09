OUT := actividad5.21001135.pdf
IN := document.rst


# IMAGES := $(wildcard img/*)


GIT_ROOT := $(shell git rev-parse --show-toplevel)
GIT_CWD := $(shell git rev-parse --show-prefix)


default: gh-pages-url $(OUT)


$(OUT): $(IN) template.latex
	@echo Building $(OUT) ...
	@pandoc -o $@ $<\
		--template=template.latex\
		--metadata-file metadata.json\
		--top-level-division=chapter

.PHONY: gh-pages-url
gh-pages-url:
	@echo Github Pages url: https://polo123456789.github.io/Universidad/$(GIT_CWD)$(OUT)

.PHONY: git-root
git-root:
	@echo $(GIT_ROOT)


.PHONY: clean
clean:
	@-del $(OUT)
