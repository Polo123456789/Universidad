#include <iostream>
#include <fstream>
#include <filesystem>

namespace fs = std::filesystem;

bool directory_has_readme(const fs::path& path) {
    const fs::path readme = path / fs::path("README.md");
    return fs::exists(readme);
}

void create_file_index(const fs::path& path) {
    const bool has_readme = directory_has_readme(path);
    std::ofstream index_file{};
    if (!has_readme) {
        const fs::path readme = path / fs::path("README.md");
        index_file.open(readme.c_str());
        index_file << "# Archivos" << '\n' << '\n';
    }

    for (const auto &entry : fs::directory_iterator(path)) {
        if (!has_readme) {
            const auto file = entry.path();
            index_file << "* [" << file << "](" << file << ")\n";
        }
        if (entry.is_directory()) {
            create_file_index(entry.path());
        }
    }
}

int main(void) {
    fs::path current_dir(".");
    create_file_index(current_dir);
    return 0;
}
