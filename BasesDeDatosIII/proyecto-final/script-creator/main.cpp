#include <iostream>
#include <regex>
#include "table.hpp"
#include "result_template.hpp"

#define DISPLAY_VARIABLE(v) std::cout << "\t " #v " = \"" << v << "\"\n"
#define REPLACE(v) \
    std::regex regex_##v("<\\{" #v "\\}>");\
    result = std::regex_replace(result, regex_##v, v)

/*

* table_name
* param_list_typed
* param_list
* field_names
* id_field
* id_param_typed
* id_param
* set_values

*/

constexpr const char* parameter_prefix = "p_";
constexpr const char* parameter_posfix = "";

static std::string decorate_param(const std::string& param) {
    static const std::string prefix = parameter_prefix;
    static const std::string posfix = parameter_posfix;

    return prefix + param + posfix;
}

static std::string get_param_list_typed(const table& t) {
    std::string res;

    for (const auto& f : t.get_fields()) {
        res.append(decorate_param(f.name));
        res.append(" ");
        res.append(f.type);
        res.append(", ");
    }

    res.resize(res.size() - 2); // Remove trailing ', '

    return res;
}

static std::string get_param_list(const table& t) {
    std::string res;

    for (const auto& f : t.get_fields()) {
        res.append(decorate_param(f.name));
        res.append(", ");
    }

    res.resize(res.size() - 2); // Remove trailing ', '

    return res;
}

static std::string get_field_names(const table& t) {
    std::string res;

    for (const auto& f : t.get_fields()) {
        res.append(f.name);
        res.append(", ");
    }

    res.resize(res.size() - 2); // Remove trailing ', '

    return res;
}

static std::string get_set_values(const table& t) {
    std::string res;

    auto fields = t.get_fields();
    fields.erase(fields.begin());

    for (const auto& f : fields) {
        res.append(f.name);
        res.append(" = ");
        res.append(decorate_param(f.name));
        res.append(", ");
    }

    res.resize(res.size() - 2); // Remove trailing ', '

    return res;
}

int main(int /*argc*/, char * /*argv*/[]) {
    try {
        table t = read_table();
        std::cout << t << '\n';

        const std::string& table_name = t.get_name();
        std::string param_list_typed = get_param_list_typed(t);
        std::string param_list = get_param_list(t);
        std::string field_names = get_field_names(t);
        std::string id_field = "id";
        std::string id_param = decorate_param(id_field);
        std::string id_param_typed = id_param + " int";
        std::string set_values = get_set_values(t);

        std::cout << "Data to be replaced:\n";
        DISPLAY_VARIABLE(table_name);
        DISPLAY_VARIABLE(param_list_typed);
        DISPLAY_VARIABLE(param_list);
        DISPLAY_VARIABLE(field_names);
        DISPLAY_VARIABLE(id_field);
        DISPLAY_VARIABLE(id_param);
        DISPLAY_VARIABLE(id_param_typed);
        DISPLAY_VARIABLE(set_values);
        std::cout << '\n';

        std::string result = result_template;

        REPLACE(table_name);
        REPLACE(param_list_typed);
        REPLACE(param_list);
        REPLACE(field_names);
        REPLACE(id_field);
        REPLACE(id_param);
        REPLACE(id_param_typed);
        REPLACE(set_values);

        std::cout << result << '\n';
    } catch (const std::exception& e) {
        std::cout << e.what() << '\n';
    }

    return 0;
}
