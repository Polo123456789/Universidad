IMAGENES := $(wildcard *.png)
FUENTES  := $(wildcard *.rst)

CasoAnalisis_21001135.pdf: $(IMAGENES) $(FUENTES)
	pandoc -o CasoAnalisis_21001135.pdf propuesta.rst\
	    --toc\
	    --toc-depth 4\
	    -M author="Pablo Sanchez Galdamez (21001135)"\
	    -M toc-title="Contenidos"

clean:
	del CasoAnalisis_21001135.pdf
