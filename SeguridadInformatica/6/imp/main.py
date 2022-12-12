import os, binascii
from argon2 import PasswordHasher
from Crypto.Cipher import AES
from Crypto.Random import get_random_bytes

password = 'SecurePassword1234!,@cmsldk'


# Descargar base de datos con el siguiente comando:
# curl.exe https://raw.githubusercontent.com/duyet/bruteforce-database/master/1000000-password-seclists.txt -O
PASSWORD_DATABASE = "1000000-password-seclists.txt"

common_passwords = []
with open(PASSWORD_DATABASE, 'r') as file:
    for line in file:
        common_passwords.append(line.rstrip())
assert len(common_passwords) == 1_000_000


if len(password) >= 7:
    print("Longitud segura")
else:
    print("Necesita mas caracteres")


if password in common_passwords:
    print("Encontrada en el diccionario")
else:
    print("No encontrada en el diccionario")

ph = PasswordHasher(time_cost=40)
hsh = ph.hash(password)
print(hsh)

AES_KEY = get_random_bytes(32)
cipher = AES.new(AES_KEY, AES.MODE_EAX)
cipher_text, tag = cipher.encrypt_and_digest(bytes(hsh, encoding='utf-8'))
AES_nonce = cipher.nonce
print(cipher_text)

cipher = AES.new(AES_KEY, AES.MODE_EAX, AES_nonce)
data = cipher.decrypt(cipher_text).decode("utf-8")
if ph.verify(data, password):
    print("Correcto")
else:
    print("Incorrecto")