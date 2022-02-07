actividad2.pdf: tarea.md biblio.bibtex template.latex
	pandoc tarea.md -o actividad2.pdf \
		--bibliography biblio.bibtex \
		--top-level-division=chapter \
		--template=template.latex

.PHONY: clean
clean:
	del actividad2.pdf
