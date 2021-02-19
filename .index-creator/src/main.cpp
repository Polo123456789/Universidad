#include <algorithm>
#include <filesystem>
#include <fstream>
#include <iostream>
#include <cstring>

constexpr const char * const help = R"(
Index creator
Copyright (c) 2020 Pablo Sanchez

Uso: index-creator [-r]

Crea un README.md enlistando todos los archivos de el directorio.

Flags:
    -h    Muestra este mensaje de ayuda
    -r    Esta indica si la creacion de los indices tiene que ser recursiva.
)";

namespace fs = std::filesystem;

bool directory_has_readme(const fs::path &path) {
    const fs::path readme = path / fs::path("README.md");
    return fs::exists(readme);
}

void create_file_index(const fs::path &path, bool recursive) {
    const bool has_readme = directory_has_readme(path);
    if (!has_readme) {
        #ifdef _WIN32
            std::wofstream index_file;
        #else
            std::ofstream index_file{};
        #endif

        const fs::path readme = path / fs::path("README.md");

        index_file.open(readme.c_str());
        index_file << "# Archivos" << '\n' << '\n';

        for (const auto &entry : fs::directory_iterator(path)) {
            auto file = entry.path().native();

            #ifdef _WIN32
                std::replace(file.begin(), file.end(), L'\\', L'/');
            #endif

            index_file << "* [" << file << "](" << file << ")\n";
            if (entry.is_directory() && recursive) {
                create_file_index(entry.path(), recursive);
            }
        }
    }
}

int main(int argc, char *argv[]) {
    bool recursive = false;
    if (argc == 2) {
        switch(argv[1][1]) {
            case 'r':
                recursive = true;
                break;
            case 'h':
                std::cout << help;
                return 0;
            default:
                break;
        }
    }

    fs::path current_dir(".");
    create_file_index(current_dir, true);
    return 0;
}
