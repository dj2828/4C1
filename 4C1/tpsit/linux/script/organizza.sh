#!/bin/bash

echo "Ciao"

mkdir Progetto

mkdir Progetto/Appunti
mkdir Progetto/Archivio

cd Progetto

echo "Sto imparando a utilizzare gli script Bash" >Appunti/lezione.txt

cp Appunti/lezione.txt Archivio/copia_lezione.txt

cat Archivio/copia_lezione.txt

tree
