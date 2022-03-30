#ifndef TABLE_HPP
#define TABLE_HPP

#include <iostream>
#include <string>
#include <vector>

class table {
   public:
    struct field {
        std::string name;
        std::string type;
    };

    [[nodiscard]] const std::string &get_name(void) const;

    [[nodiscard]] const std::vector<field> &get_fields(void) const;
    std::vector<field> &                    get_fields(void);

    table &set_name(std::string name);
    table &add_field(field f);

   private:
    std::string        m_name;
    std::vector<field> m_fields;
};

table read_table(void);

std::ostream& operator<<(std::ostream& o, const table& t);

#endif
