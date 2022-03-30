#ifndef RESULT_TEMPLATE_HPP
#define RESULT_TEMPLATE_HPP

constexpr const char* result_template =
R"--(-- Procedimientos para <{table_name}>

CREATE PROCEDURE insertar_<{table_name}> (<{param_list_typed}>)
BEGIN
    INSERT INTO <{table_name}> (<{field_names}>) VALUES (<{param_list}>);
END//

CREATE PROCEDURE seleccionar_<{table_name}> ()
BEGIN
    SELECT * FROM <{table_name}>;
END//

CREATE PROCEDURE borrar_<{table_name}> (<{id_param_typed}>)
BEGIN
    DELETE FROM <{table_name}> WHERE <{id_field}> = <{id_param}>;
END//

CREATE PROCEDURE actualizar_<{table_name}> (<{param_list_typed}>)
BEGIN
    UPDATE <{table_name}> SET <{set_values}> WHERE <{id_field}> = <{id_param}>;
END//

-- Triggers para <{table_name}>

CREATE TRIGGER t_<{table_name}>_before_insert BEFORE INSERT ON <{table_name}>
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("<{table_name}>", "insert", CURDATE());
END//

CREATE TRIGGER t_<{table_name}>_before_update BEFORE UPDATE ON <{table_name}>
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("<{table_name}>", "update", CURDATE());
END//

CREATE TRIGGER t_<{table_name}>_before_delete BEFORE DELETE ON <{table_name}>
FOR EACH ROW
BEGIN
    INSERT INTO bitacora (tabla, operacion, fecha)
    VALUES ("<{table_name}>", "delete", CURDATE());
END//)--";

#endif
