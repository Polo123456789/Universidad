
# --bibliography biblio.bibtex

actividad3.pdf: actividad3.md template.latex
	pandoc actividad3.md -o actividad3.pdf \
		--top-level-division=chapter \
		--template=template.latex

.PHONY: clean
clean:
	del actividad3.pdf
