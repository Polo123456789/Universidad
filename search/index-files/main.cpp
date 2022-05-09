#include <iostream>
#include <memory>
#include <cstdio>
#include <array>
#include <vector>
#include <string>
#include <cstdio>

struct PipeDeleter {
    void operator()(FILE* pipe) {
        _pclose(pipe);
    }
};

using Pipe = std::unique_ptr<FILE, PipeDeleter>;

int main(void) {
    try {
        Pipe gitFiles(_popen("git ls-tree -r gh-pages", "r"));
        std::array<char, 512> buffer;
        std::vector<std::string> fileList;
        while(std::fscanf(gitFiles.get(), "%*s %*s %*s %s", buffer.data()) == 1) {
            fileList.emplace_back(buffer.data());
        }

        std::cout << "const fileList = [\n";
        for (const auto& file : fileList) {
            std::cout << "\t'" << file << "',\n";
        }
        std::cout << "];";
    } catch (const std::exception& e) {
        std::clog << e.what() << '\n';
    }
    return 0;
}
