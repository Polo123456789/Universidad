#include <algorithm>
#include <filesystem>
#include <fstream>
#include <iostream>
#include <cstring>
#include <string>

namespace fs = std::filesystem;

constexpr const char * const help = R"(
Index creator
Copyright (c) 2020 Pablo Sanchez

Uso: index-creator [-r, -h]

Crea un README.md enlistando todos los archivos de el directorio.

Flags:
    -h    Muestra este mensaje de ayuda
    -r    Esta indica si la creacion de los indices tiene que ser recursiva.
)";

#ifdef _WIN32
    constexpr const wchar_t* const machine_generated_note =
       L"Este documento fue generado automaticamente, porfavor no modificar";
#else
    constexpr const char* const machine_generated_note =
        "Este documento fue generado automaticamente, porfavor no modificar";
#endif

bool readme_is_machine_generated(const fs::path& r);
void create_file_index_checked(const fs::path& path, bool recursive);
void create_file_index(const fs::path &path, bool recursive);

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
    create_file_index_checked(current_dir, true);
    return 0;
}

bool readme_is_machine_generated(const fs::path& r) {
        #ifdef _WIN32
            std::wifstream readme(r);
            std::wstring first_line;
        #else
            std::ifstream readme(r);
            std::string first_line;
        #endif

        std::getline(readme, first_line);

        #ifdef _WIN32
            return (std::wcscmp(machine_generated_note,
                                first_line.c_str()) == 0);
        #else
            return (std::strcmp(machine_generated_note,
                                first_line.c_str()) == 0);
        #endif
}

void create_file_index(const fs::path &path, bool recursive) {
    #ifdef _WIN32
        std::wofstream index_file;
    #else
        std::ofstream index_file{};
    #endif

    const fs::path readme = path / fs::path("README.md");

    index_file.open(readme.c_str());
    index_file << machine_generated_note << '\n' << '\n';
    index_file << "# Archivos" << '\n' << '\n';

    for (const auto &entry : fs::directory_iterator(path)) {
        auto file = entry.path().native();

        #ifdef _WIN32
            std::replace(file.begin(), file.end(), L'\\', L'/');
        #endif

        index_file << "* [" << file << "](" << file << ")\n";
        if (entry.is_directory() && recursive) {
            create_file_index_checked(entry.path(), recursive);
        }
    }
}

void create_file_index_checked(const fs::path& path, bool recursive) {
    const fs::path readme = path / fs::path("README.md");
    const bool has_readme = fs::exists(readme);
    if (!has_readme || (has_readme && readme_is_machine_generated(readme))) {
        create_file_index(path, recursive);
    }
}
