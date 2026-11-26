frutti = {}

frutti = {
    "mele": 4,
    "limoni": 2
}
print(frutti)

frutti["skibidi"] = 1
print(frutti)

frutti["limoni"] = 4
print(frutti)

del frutti["limoni"]
print(frutti)

for key, value in frutti.items():
    print(f"frutto {key} cè {value}")

for key in frutti.keys():
    print(key)

for value in frutti.values():
    print(value)