#include "table.hpp"

const std::string& table::get_name(void) const {
    return m_name;
}

auto table::get_fields(void) const -> const std::vector<field>& {
    return m_fields;
}

auto table::get_fields(void) -> std::vector<field>& {
    return m_fields;
}

table& table::set_name(std::string name) {
    m_name = std::move(name);
    return *this;
}

table& table::add_field(field f) {
    m_fields.push_back(std::move(f));
    return *this;
}

table read_table(void) {
    table t;

    std::string name;
    std::cout << "Table name: ";
    std::cin >> name;

    t.set_name(name);

    std::string f_name;
    std::string f_type;
    std::cout << "Enter fields: [field] [type]\n";
    while (std::cin >> f_name && std::cin >> f_type) {
        table::field f = {
            f_name,
            f_type
        };

        t.add_field(f);
    }

    return t;
}

std::ostream& operator<<(std::ostream& o, const table& t) {
    const auto& fields = t.get_fields();
    o << t.get_name() << " {\n";
    for (const auto& f : fields) {
        o << '\t' << f.name << ' ' << f.type << '\n';
    }
    o << '}';
    return o;
}
