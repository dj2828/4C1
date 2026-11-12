# Commento
print("Hello world!")

if True:
    print('skibidi')

num = 5
num: int = 5

print(type(num))

print(f"{num}, {num}")

print("Skibidi " + str(num))

skibidi = 'skibidi'
print(skibidi[:3]) # da 0 a 3
print(skibidi[3:5]) # da 3 a 5
print(skibidi[-2:]) # dal penultimo alla fine
print(skibidi[0::2]) # dal primo (0) al ultimo (vuoto) prendendo ogni 2, (anche ::2)
print(skibidi[::-1]) # inverso

print("\nskibidi\nsotto")

print("""
skibidi
toilet
""")

print(skibidi.upper())
print(skibidi.capitalize())
print(skibidi.endswith("i"))
print(skibidi.startswith("w"))

print()

file = "skibidi.py"
print(file.split('.')[0])
print(file.split('.')[1])

print()

lista = [1, 3, "sasso"]
print(lista)
lista.append("skibidi")
print(lista)
lista.pop(2)
print(lista)
lista.remove('skibidi')
print(lista)
lista.extend([2, 3])
print(lista)
lista.insert(1, "skibidi")
print(lista)