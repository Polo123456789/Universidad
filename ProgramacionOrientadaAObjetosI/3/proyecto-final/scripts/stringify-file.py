import sys

def main():
    if len(sys.argv) != 2:
        print("Uso: python3 stringify-file.py [Archivo]")

    nombre_archivo: str = sys.argv[1]

    resultado: str = f'// Este codigo fue creado utilizando una herramienta a base del archivo "{nombre_archivo}"\n'
    resultado += '// Si quiere cambiarlo, modifique el archivo original y vuelva a correr la herramienta\n'
    resultado += 'String nombre_variable = '
    with open(nombre_archivo) as archivo:
        for linea in archivo:
            linea = linea[:-1]
            resultado += f'\t"{linea}\\n" +\n';

    print(resultado)

if __name__ == "__main__":
    main()
