actividad4.pdf: actividad4.md template.latex
	pandoc $< -o $@\
		--top-level-division=chapter\
		--template=template.latex

.PHONY: clean
clean:
	del actividad4.pdf
