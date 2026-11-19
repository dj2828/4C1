pozzo = ['###', '===', '---', '...'] # <-- cima del pozzo
carrello = []

while pozzo:
    print(f"Il pozzo è: {pozzo}")
    strato = pozzo.pop()
    blocchi = [i for i in strato]
    print(f"Trivello lo strato '{strato}' e lo divido nei blocchi {blocchi}\n")
    carrello.extend(blocchi)

print(f"Il pozzo è: {pozzo}")
print(f"Il carrello finale è: {carrello}")