def inverti_capitalizzazione(testo: str):
    return "".join([i.upper() if i.islower() else i.lower() for i in testo])

def raddrizza_testo(testo: str):
    return testo[0].upper() + testo[1:].lower()

frase = "CiAo QuEsTo E' uN TeStO sToRto"

print(inverti_capitalizzazione(frase)) # cIaO qUeStO e' Un tEsTo StOrTO
print(raddrizza_testo(frase)) # Ciao questo e' un testo storto